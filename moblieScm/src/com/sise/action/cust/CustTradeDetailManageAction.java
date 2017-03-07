package com.sise.action.cust;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.org.json.JSONArray;
import com.sise.action.BasicAction;
import com.sise.dao.BrandDao;
import com.sise.dao.cust.CustTradedetailDao;
import com.sise.dao.sup.SupTradedetailDao;
import com.sise.pojo.CustTradedetail;
import com.sise.pojo.Mobtype;
import com.sise.pojo.Pagination;
import com.sise.pojo.SupTradedetail;
import com.sise.pojo.Supplier;
import com.sise.pojo.SupplierType;
import com.sise.pojo.User;
import com.sise.service.MobTypeService;
import com.sise.service.SupplierService;
import com.sise.service.SupplierTypeService;
import com.sise.service.UserManageService;
import com.sise.utils.DateUtils;
/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年12月02日 上午11:30:43
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
@SuppressWarnings({ "unchecked", "unused" })
public class CustTradeDetailManageAction extends BasicAction{
	
	private static final long serialVersionUID = 1207148666624477212L;
	private List<SupplierType> supTypeList;
    private List<Supplier> supList;
    private List<String> brandList;
    private List<Mobtype> mobTypeList;
    private List<CustTradedetail> custTradedetailList;
    private List<User> userList;
  //  private List<String> configList;
   // private List<String> colorList;
   // private SupplierType supplierType;
    private Date startDate;
    private Date endDate;
    private String brand;
    private String invoiceid;
    private SupplierTypeService supplierTypeService;
    private SupplierService supplierService;
    private MobTypeService mobTypeService;
    private CustTradedetailDao custTradedetailDao;
  //  private ConfigDao configDao;
    private BrandDao brandDao;
   // private ColorDao colorDao;
   // private MobstockDao mobstockDao;	
    private UserManageService userManageService;
    
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
        Map map = new HashMap();
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        // 查询最新的入库单
//	        SysUsers loginUser = (SysUsers) session.get("loginUser");
//	        String queryScope = loginUser.getQueryScope();
//	        orgScope = queryScope.split(",");
//
//	        paginatedQuery("mobStockIn.getMobStockIn");
        pagination = new Pagination();
		int pageLong = custTradedetailDao.getPageLong();
		
		pagination.setPageIndex(pageIndex== null ? 1 : pageIndex );
		pagination.setPageSize(15);
		pagination.setTotalRecordCnt(pageLong);
		pagination.setUrl("custTradeDetail_list.do?");
		custTradedetailList = custTradedetailDao.findAllWithFy(map,((pageIndex== null ? 1 : pageIndex) - 1) * 15, 15);
		pagination.setDataList(custTradedetailList);
        
        return "list";
    }
	 
	 /**
	  * 获取列表
	  * @throws Exception
	  */
	    private void getLists() throws Exception {
	        // 供应商类别列表
	        supTypeList = supplierTypeService.getTypeList();
	        // 供应商列表
	        supList = supplierService.getSupplierList("");
	        // 品牌列表
	        brandList = brandDao.queryList();
	        // 手机型号列表
	       /* mobTypeList = mobTypeService.queryList("");*/
	        // 配置列表
	        //configList = configDao.queryList("");
	        // 颜色列表
	       // colorList = colorDao.queryList();
	        //custTradedetailList = custTradedetailDao.queryList();
	        //用户列表
	        userList = userManageService.getList();
	    }
	 
	 /**
	  * 查找手机列表
	  * @throws Exception
	  */
	 public void findMobType() throws Exception {
		 /* System.out.println("<String, String>" + supplierType.getSuptypeid());
		  Map<String, String> map = new HashMap<String, String>();
		  map.put("suptypeid", supplierType.getSuptypeid());
		  supList= supplierService.findSupplierAjax(map);*/
		 
		 // System.out.println("kllkjlkkljlkjlkjl"+brand);
		 //查找手机类别返回json
		  List<Mobtype> mobTypeList1 = new ArrayList<Mobtype>(); 
		  mobTypeList1 = mobTypeService.findMobTypeByBrand(brand);
		  JSONArray jsonArray = new JSONArray(mobTypeList1);
		  response.setCharacterEncoding("utf-8");
		  response.getWriter().print(jsonArray.toString());
		  // return "list";
	  }

	 public String delete() throws Exception {
		 custTradedetailDao.deleteByPrimaryKey(invoiceid);
		 response.sendRedirect("custTradeDetail_list.do");
		 return null;
	 }
	public List<SupplierType> getSupTypeList() {
		return supTypeList;
	}

	public void setSupTypeList(List<SupplierType> supTypeList) {
		this.supTypeList = supTypeList;
	}

	public List<Supplier> getSupList() {
		return supList;
	}

	public void setSupList(List<Supplier> supList) {
		this.supList = supList;
	}

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

	public void setSupplierTypeService(SupplierTypeService supplierTypeService) {
		this.supplierTypeService = supplierTypeService;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public void setMobTypeService(MobTypeService mobTypeService) {
		this.mobTypeService = mobTypeService;
	}

	public void setBrandDao(BrandDao brandDao) {
		this.brandDao = brandDao;
	}

	public List<CustTradedetail> getCustTradedetailList() {
		return custTradedetailList;
	}

	public void setCustTradedetailList(List<CustTradedetail> custTradedetailList) {
		this.custTradedetailList = custTradedetailList;
	}

	public void setCustTradedetailDao(CustTradedetailDao custTradedetailDao) {
		this.custTradedetailDao = custTradedetailDao;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setUserManageService(UserManageService userManageService) {
		this.userManageService = userManageService;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void setInvoiceid(String invoiceid) {
		this.invoiceid = invoiceid;
	}
	
	 
}
