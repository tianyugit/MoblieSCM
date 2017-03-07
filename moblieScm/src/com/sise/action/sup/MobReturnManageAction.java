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
 * �汾:1.0
 *
 *��������:2016��11��27�� ����11:31:35
 *
 *����:������
 *
 *����:
 *
 *
 *��Ȩ:T�����Ȩ����(c) 2016
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
		
		//wsdl��·��
		URL wsdlDocumentLocation = new URL("http://127.0.0.1:12344/supplier?wsdl");
		//��wsdl���ҵ�������ͼ
		//��һ��������wsdl�������ռ�
		//�ڶ���������������ͼ����
		QName serviceName = new QName("http://supplier.sise.com/", "SupplierService");
		
		//��һ��ʹ��Service����������ͼ
		Service service =Service.create(wsdlDocumentLocation, serviceName);
		
		//�ӷ�����ͼ�õ�portType����
		//������portType
		SupplierServiceImpl supplierServiceImpl = service.getPort(SupplierServiceImpl.class);
		
		return supplierServiceImpl;
	}
	
	/**
	 * ��ת���б����
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
        getLists(); // ��ȡ�����б�
        // ��ֹʱ�䣨һ����ǰ�����ܣ�
        if (endDate == null) {
            endDate = new Date();
        }
        if (startDate == null) {
            startDate = new Date(endDate.getTime() - 7 * 24 * 60 * 60 * 1000);
        }
        endDate = DateUtils.toDayEnd(endDate);
        startDate = DateUtils.toDayStart(startDate);

        // ��ѯ���µ���ⵥ
//	        SysUsers loginUser = (SysUsers) session.get("loginUser");
//	        String queryScope = loginUser.getQueryScope();
//	        orgScope = queryScope.split(",");
//
//	        paginatedQuery("mobStockIn.getMobStockIn");
        return "list";
    }
	
	/*
     * ת����ӽ���
     */
	 public String toAdd() throws Exception {
		 getLists();
		 return "add";
	 }
	 
	 /**
	 * ת�������б�
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
	  * ɾ��
	  * @return
	  * @throws Exception
	  */
	 public String delete() throws Exception {
		 mobReturnService.delete(mobreturn);
		 response.sendRedirect("mobReturn_list.do");
		 return "list";
	 }
	 /**
	  * ��鴮���Ƿ����
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
	  * ����ֻ��˻���
	  * @throws Exception
	  */
	public void add() throws Exception {
		/* String sn22 =  request.getParameter("q");
		 System.out.println("����������ֳ���������������������"+sn22);*/
	        User loginUser = (User) session.get("loginUser");

	        // �˻���
	        mobreturn.setInvoiceid("MR-"
	                + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
	        mobreturn.setStatus(0);
	        mobreturn.setInputuserid(loginUser.getUserid());
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");//�������ڸ�ʽ
	        mobreturn.setInputdate(df.format(new Date()));
	        mobreturn.setAmount(amount);
	        mobreturn.setMoney(totalmoney);
	        mobreturn.setReturnprice(returnprice);
	       /* mobreturn.setOrgid((String) dao.queryObject("user.getOrgIdByUserId",
	                loginUser.getUserid()));*/

	        // ������ϸ
	        SupTradedetail suptradedetail = new SupTradedetail();
	        BeanUtils.copyProperties(suptradedetail, mobreturn);
	        suptradedetail.setTradetype(SupTradedetail.TRADETYPE_MOBRETURN);

	        suptradedetail.setType(mobreturn.getMobtypeid());
	        suptradedetail.setUnitprice(mobreturn.getReturnprice());

	        // ����
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
		 * ����˻���
		 * @return
		 * @throws Exception
		 */
		public String check() throws Exception {
			mobreturn.getInvoiceid();

			// --�������, service�����

			// ȡ����ǰ��¼�û�ID,��õ�ǰʱ��
			User user = new User();
			user = (User) session.get("loginUser");

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");// �������ڸ�ʽ
			// checkUserId, checkDate
			mobreturn.setCheckuserid(user.getUserid());
			mobreturn.setCheckdate(df.format(new Date()));
			// ����״̬ status = ����
			mobreturn.setStatus(Mobstockin.STAT_CHECKED);
			System.out.println(mobreturn);
			// --����msi���������ֶ�

			// ������ϸ��status\ checkUserId \ checkDateͬ������
			SupTradedetail suptradedetail = new SupTradedetail();
			// BeanUtils.copyProperties(suptradedetail, msi);
			suptradedetail.setInvoiceid(mobreturn.getInvoiceid());
			suptradedetail.setStatus(Mobstockin.STAT_CHECKED);
			suptradedetail.setCheckdate(mobreturn.getCheckdate());
			suptradedetail.setCheckuserid(mobreturn.getCheckuserid());
			System.out.println(suptradedetail);
			// ���� ״̬ ���³� ����
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
	  * ��ȡ�б�
	  * @throws Exception
	  */
	    private void getLists() throws Exception {
		 ;
	      // ��Ӧ������б�
	        supTypeList = supplierTypeService.getTypeList();
	        // ��Ӧ���б�
	       // supList = supplierService.getSupplierList("");
		 supList = getConFromSupplier().getSupplierList("");
	        // Ʒ���б�
	        brandList = brandDao.queryList();
	        // �ֻ��ͺ��б�
	        mobTypeList = mobTypeService.queryList("");
	        //�ֻ��˻��б�
	       // mobreturnList = mobReturnService.queryList("");
	       //�û��б�
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
