package com.sise.action.sup;

import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.apache.commons.beanutils.BeanUtils;

import com.org.json.JSONObject;
import com.sise.action.BasicAction;
import com.sise.dao.BrandDao;
import com.sise.dao.sup.MobreturnDao;
import com.sise.dao.sup.MobstockDao;
import com.sise.dao.sup.MobstocksnoutDao;
import com.sise.pojo.Mobstock;
import com.sise.pojo.Mobstockin;
import com.sise.pojo.Mobtype;
import com.sise.pojo.Pagination;
import com.sise.pojo.SupMobreturn;
import com.sise.pojo.SupMobstocksnout;
import com.sise.pojo.SupTradedetail;
import com.sise.pojo.SupplierType;
import com.sise.pojo.User;
import com.sise.service.MobReturnService;
import com.sise.service.MobTypeService;
import com.sise.service.SupplierTypeService;
import com.sise.service.UserManageService;
import com.sise.supplier.SupplierServiceImpl;
import com.sise.utils.DateUtils;
import com.sise.utils.StringUtils;
/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年11月27日 上午11:31:35
 *
 *作者:马天宇
 *
 *描述:
 *
 *
 *版权:T世界版权所有(c) 2016
 *
 *==========================================================================
 */
@SuppressWarnings({ "unchecked", "rawtypes","unused" })
public class MobReturnManageAction extends BasicAction{
	
	private static final long serialVersionUID = -3740162701971833659L;
	private List<SupplierType> supTypeList;
    private List<com.sise.supplier.Supplier> supList;
    private List<String> brandList;
    private List<Mobtype> mobTypeList;
    private List<SupMobreturn> mobreturnList;
    private List<User> userList;

    private Date startDate;
    private Date endDate;

 //   private MobReturn mobReturn = new MobReturn();

    private Mobstock mobstock = null;
    private SupMobreturn mobreturn;

    private List<SupMobstocksnout> detailList;
    private String[] sns;
    private Long amount;
    private double totalmoney;
    private BigDecimal returnprice;
  //  private MobReturnService mobReturnService;
    private BrandDao brandDao;
    private MobstockDao mobstockDao;
    private MobreturnDao mobreturnDao;
    private MobstocksnoutDao mobstocksnoutDao;
    private SupplierTypeService supplierTypeService;
   // private SupplierService supplierService;
    private MobTypeService mobTypeService;
	private MobReturnService mobReturnService;
	private UserManageService userManageService;
	
	public SupplierServiceImpl getConFromSupplier() throws Exception{
		
		//wsdl的路径
		URL wsdlDocumentLocation = new URL("http://127.0.0.1:12344/supplier?wsdl");
		//从wsdl中找到服务视图
		//第一个参数：wsdl的命名空间
		//第二个参数：服务视图名称
		QName serviceName = new QName("http://supplier.sise.com/", "SupplierService");
		
		//第一步使用Service创建服务视图
		Service service =Service.create(wsdlDocumentLocation, serviceName);
		
		//从服务视图得到portType对象
		//参数：portType
		SupplierServiceImpl supplierServiceImpl = service.getPort(SupplierServiceImpl.class);
		
		return supplierServiceImpl;
	}
	
	/**
	 * 跳转至列表界面
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
        getLists(); // 获取各个列表
        // 起止时间（一周以前到本周）
        if (endDate == null) {
            endDate = new Date();
        }
        if (startDate == null) {
            startDate = new Date(endDate.getTime() - 7 * 24 * 60 * 60 * 1000);
        }
        endDate = DateUtils.toDayEnd(endDate);
        startDate = DateUtils.toDayStart(startDate);

        // 查询最新的入库单
//	        SysUsers loginUser = (SysUsers) session.get("loginUser");
//	        String queryScope = loginUser.getQueryScope();
//	        orgScope = queryScope.split(",");
//
//	        paginatedQuery("mobStockIn.getMobStockIn");
        return "list";
    }
	
	/*
     * 转到添加界面
     */
	 public String toAdd() throws Exception {
		 getLists();
		 return "add";
	 }
	 
	 /**
	 * 转至详情列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showDetail() throws Exception {
		// countList = mobstockDao.countMobtype();
		detailList = mobstocksnoutDao.getSnByInvoiceid(mobreturn);
		return "detail";
	}
	 /**
	  * 删除
	  * @return
	  * @throws Exception
	  */
	 public String delete() throws Exception {
		 mobReturnService.delete(mobreturn);
		 response.sendRedirect("mobReturn_list.do");
		 return "list";
	 }
	 /**
	  * 检查串号是否存在
	  * @throws Exception
	  */
	 public void snExist() throws Exception {
	        String sn1 = request.getParameter("sn1");

	        User loginUser = (User) session.get("loginUser");
	       /* String orgId = (String) dao.queryObject("user.getOrgIdByUserId",
	                loginUser.getUserId());*/

	       // Map map = new HashMap();
	       // map.put("orgId", orgId);
	       // map.put("status", 1);
	      //  map.put("sn1", sn1);

	       /* mobstock = (Mobstock) dao.queryObject("mobStock.findStockByPk", map);*/
	        mobstock = mobstockDao.selectByPrimaryKey(sn1);
	        if(mobstock == null){
	        	 String str = "no";
	        	 response.getWriter().print(str);
	        }else{
	        JSONObject jsonArray = new JSONObject(mobstock);
			  response.setCharacterEncoding("utf-8");
			  response.getWriter().print(jsonArray.toString());
	        }
	        
	    }
	 /**
	  * 添加手机退货单
	  * @throws Exception
	  */
	public void add() throws Exception {
		/* String sn22 =  request.getParameter("q");
		 System.out.println("如果是所表现出宣传宣传促销宣传宣传"+sn22);*/
	        User loginUser = (User) session.get("loginUser");

	        // 退机单
	        mobreturn.setInvoiceid("MR-"
	                + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
	        mobreturn.setStatus(0);
	        mobreturn.setInputuserid(loginUser.getUserid());
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");//设置日期格式
	        mobreturn.setInputdate(df.format(new Date()));
	        mobreturn.setAmount(amount);
	        mobreturn.setMoney(totalmoney);
	        mobreturn.setReturnprice(returnprice);
	       /* mobreturn.setOrgid((String) dao.queryObject("user.getOrgIdByUserId",
	                loginUser.getUserid()));*/

	        // 交易明细
	        SupTradedetail suptradedetail = new SupTradedetail();
	        BeanUtils.copyProperties(suptradedetail, mobreturn);
	        suptradedetail.setTradetype(SupTradedetail.TRADETYPE_MOBRETURN);

	        suptradedetail.setType(mobreturn.getMobtypeid());
	        suptradedetail.setUnitprice(mobreturn.getReturnprice());

	        // 串号
	        List<Map> snList = new ArrayList<Map>();
	        for (String strSn : sns) {
	            String[] tmp = strSn.split(",");
				Map map = new HashMap();
	            map.put("sn1", tmp[0]);
	            if (tmp.length > 1) {
	                map.put("sn2", tmp[1]);
	            }
	            map.put("id", StringUtils.uniqueKey());
	            map.put("invoiceid", mobreturn.getInvoiceid());  
	           /// map.put("stat ", 3);
	            snList.add(map);
	        }

	        mobReturnService.add(mobreturn, suptradedetail, snList);
	        response.sendRedirect("mobReturn_list.do");
	        //response.getWriter().print("mobReturn_list.do");
	    }
	 
	 /**
		 * 审核退货单
		 * @return
		 * @throws Exception
		 */
		public String check() throws Exception {
			mobreturn.getInvoiceid();

			// --事务管理, service里完成

			// 取出当前登录用户ID,获得当前时间
			User user = new User();
			user = (User) session.get("loginUser");

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");// 设置日期格式
			// checkUserId, checkDate
			mobreturn.setCheckuserid(user.getUserid());
			mobreturn.setCheckdate(df.format(new Date()));
			// 更新状态 status = 已审
			mobreturn.setStatus(Mobstockin.STAT_CHECKED);
			System.out.println(mobreturn);
			// --更新msi以上三个字段

			// 交易明细表status\ checkUserId \ checkDate同步更新
			SupTradedetail suptradedetail = new SupTradedetail();
			// BeanUtils.copyProperties(suptradedetail, msi);
			suptradedetail.setInvoiceid(mobreturn.getInvoiceid());
			suptradedetail.setStatus(Mobstockin.STAT_CHECKED);
			suptradedetail.setCheckdate(mobreturn.getCheckdate());
			suptradedetail.setCheckuserid(mobreturn.getCheckuserid());
			System.out.println(suptradedetail);
			// 库存表 状态 更新成 已审
			//Mobstock mobstock = new Mobstock();
			// SupStockinsn supStockinsn = new SupStockinsn();

			// supStockinsn =
			// supStockinsnDao.getSupStockinsnByInvoiceId(msi.getInvoiceid());
			List<SupMobstocksnout> mobStocksnoutList = new ArrayList<SupMobstocksnout>();
			mobStocksnoutList = mobstocksnoutDao.getSnByInvoiceid(mobreturn);
			mobReturnService.updateCheck(mobreturn, suptradedetail, mobStocksnoutList);
			response.sendRedirect("mobReturn_list.do");
			return "list";
		}
	 
	 /**
	  * 获取列表
	  * @throws Exception
	  */
	    private void getLists() throws Exception {
		 ;
	      // 供应商类别列表
	        supTypeList = supplierTypeService.getTypeList();
	        // 供应商列表
	       // supList = supplierService.getSupplierList("");
		 supList = getConFromSupplier().getSupplierList("");
	        // 品牌列表
	        brandList = brandDao.queryList();
	        // 手机型号列表
	        mobTypeList = mobTypeService.queryList("");
	        //手机退货列表
	       // mobreturnList = mobReturnService.queryList("");
	       //用户列表
	        userList = userManageService.getList();
	        pagination = new Pagination();
			// paginatedQuery("mobStockIn.getMobStockIn");
			int pageLong = mobreturnDao.getPageLong();
			//Pagination<Mobstockin> pb = new Pagination<Mobstockin>();
			
			pagination.setPageIndex(pageIndex== null ? 1 : pageIndex );
			pagination.setPageSize(15);
			pagination.setTotalRecordCnt(pageLong);
			pagination.setUrl("mobReturn_list.do?");
			mobreturnList = mobreturnDao.findAllWithFy(((pageIndex== null ? 1 : pageIndex) - 1) * 15, 15);
			pagination.setDataList(mobreturnList);
	    }
	public List<SupplierType> getSupTypeList() {
		return supTypeList;
	}
	public void setSupTypeList(List<SupplierType> supTypeList) {
		this.supTypeList = supTypeList;
	}
/*	public List<Supplier> getSupList() {
		return supList;
	}
	public void setSupList(List<Supplier> supList) {
		this.supList = supList;
	}*/
	public List<String> getBrandList() {
		return brandList;
	}
	public void setBrandList(List<String> brandList) {
		this.brandList = brandList;
	}
	public List<Mobtype> getMobTypeList() {
		return mobTypeList;
	}
	public void setMobTypeList(List<Mobtype> mobTypeList) {
		this.mobTypeList = mobTypeList;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Mobstock getMobstock() {
		return mobstock;
	}
	public void setMobstock(Mobstock mobstock) {
		this.mobstock = mobstock;
	}
	public String[] getSns() {
		return sns;
	}
	public void setSns(String[] sns) {
		this.sns = sns;
	}
	public void setBrandDao(BrandDao brandDao) {
		this.brandDao = brandDao;
	}
	public void setSupplierTypeService(SupplierTypeService supplierTypeService) {
		this.supplierTypeService = supplierTypeService;
	}
/*	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}*/
	public void setMobTypeService(MobTypeService mobTypeService) {
		this.mobTypeService = mobTypeService;
	}
	public void setMobstockDao(MobstockDao mobstockDao) {
		this.mobstockDao = mobstockDao;
	}
	public SupMobreturn getMobreturn() {
		return mobreturn;
	}
	public void setMobreturn(SupMobreturn mobreturn) {
		this.mobreturn = mobreturn;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public double getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(double totalmoney) {
		this.totalmoney = totalmoney;
	}
	public BigDecimal getReturnprice() {
		return returnprice;
	}
	public void setReturnprice(BigDecimal returnprice) {
		this.returnprice = returnprice;
	}
/*	public SupplierTypeService getSupplierTypeService() {
		return supplierTypeService;
	}*/
	public void setMobReturnService(MobReturnService mobReturnService) {
		this.mobReturnService = mobReturnService;
	}
	public List<SupMobreturn> getMobreturnList() {
		return mobreturnList;
	}
	public void setMobreturnList(List<SupMobreturn> mobreturnList) {
		this.mobreturnList = mobreturnList;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public void setUserManageService(UserManageService userManageService) {
		this.userManageService = userManageService;
	}

	public void setMobstocksnoutDao(MobstocksnoutDao mobstocksnoutDao) {
		this.mobstocksnoutDao = mobstocksnoutDao;
	}

	public List<SupMobstocksnout> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<SupMobstocksnout> detailList) {
		this.detailList = detailList;
	}

	public List<com.sise.supplier.Supplier> getSupList() {
		return supList;
	}

	public void setSupList(List<com.sise.supplier.Supplier> supList) {
		this.supList = supList;
	}

	public void setMobreturnDao(MobreturnDao mobreturnDao) {
		this.mobreturnDao = mobreturnDao;
	}
	 
}
