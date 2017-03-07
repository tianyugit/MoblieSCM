package com.sise.action.sup;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.org.json.JSONArray;
import com.sise.action.BasicAction;
import com.sise.dao.BrandDao;
import com.sise.dao.sup.SupTradedetailDao;
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
 * �汾:1.0
 *
 *��������:2016��11��14�� ����11:32:20
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
public class TradeDetailManageAction extends BasicAction{
	
	private static final long serialVersionUID = 1207148666624477212L;
	private List<SupplierType> supTypeList;
    private List<Supplier> supList;
    private List<String> brandList;
    private List<Mobtype> mobTypeList;
    private List<SupTradedetail> supTradedetailList;
    private List<User> userList;

    private SupTradedetail msi;
    private Date startDate;
    private Date endDate;
    private String brand;
    private SupplierTypeService supplierTypeService;
    private SupplierService supplierService;
    private MobTypeService mobTypeService;
    private SupTradedetailDao supTradedetailDao;
  //  private ConfigDao configDao;
    private BrandDao brandDao;
   // private ColorDao colorDao;
   // private MobstockDao mobstockDao;	
    private UserManageService userManageService;
    
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
	        Map map = new HashMap();
	        map.put("startDate", startDate);
	        map.put("endDate", endDate);
	       // supTradedetailList = supTradedetailDao.queryListLimitDate(map);
	        // ��ѯ���µ���ⵥ
//	        SysUsers loginUser = (SysUsers) session.get("loginUser");
//	        String queryScope = loginUser.getQueryScope();
//	        orgScope = queryScope.split(",");
//
//	        paginatedQuery("mobStockIn.getMobStockIn");
	        
	        pagination = new Pagination();
			int pageLong = supTradedetailDao.getPageLong();
			
			pagination.setPageIndex(pageIndex== null ? 1 : pageIndex );
			pagination.setPageSize(15);
			pagination.setTotalRecordCnt(pageLong);
			pagination.setUrl("tradeDetail_list.do?");
			supTradedetailList = supTradedetailDao.findAllWithFy(map,((pageIndex== null ? 1 : pageIndex) - 1) * 15, 15);
			pagination.setDataList(supTradedetailList);
	        return "list";
	    }
	 
	 @SuppressWarnings("unchecked")
	    private void getLists() throws Exception {
	        // ��Ӧ������б�
	        supTypeList = supplierTypeService.getTypeList();
	        // ��Ӧ���б�
	        supList = supplierService.getSupplierList("");
	        // Ʒ���б�
	        brandList = brandDao.queryList();
	        // �ֻ��ͺ��б�
	       mobTypeList = mobTypeService.queryList("");
	        // �����б�
	        //configList = configDao.queryList("");
	        // ��ɫ�б�
	       // colorList = colorDao.queryList();
	       
	        //�û��б�
	        userList = userManageService.getList();
	        
	       
	    }
	 
	 public String delete() throws Exception {
		 supTradedetailDao.deleteByPrimaryKey(msi.getInvoiceid());
		 response.sendRedirect("tradeDetail_list.do");
		 return null;
	 }
	 
	 public void findMobType() throws Exception {
		 /* System.out.println("<String, String>" + supplierType.getSuptypeid());
		  Map<String, String> map = new HashMap<String, String>();
		  map.put("suptypeid", supplierType.getSuptypeid());
		  supList= supplierService.findSupplierAjax(map);*/
		 
		  System.out.println("kllkjlkkljlkjlkjl"+brand);
		  List<Mobtype> mobTypeList1 = new ArrayList<Mobtype>(); 
		  mobTypeList1 = mobTypeService.findMobTypeByBrand(brand);
		  JSONArray jsonArray = new JSONArray(mobTypeList1);
		  response.setCharacterEncoding("utf-8");
		  response.getWriter().print(jsonArray.toString());
		  // return "list";
	  }
	 
	 public String findTDlBySelected()  throws Exception {
		 Map<String,String> map = new HashMap<String,String>();
		 map.put("supplierid", msi.getSupplierid());
		 map.put("type", msi.getType());
		 supTradedetailList = supTradedetailDao.findTDlBySelected(map);
		 getLists();
		 return "list";
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

	public void setSupTradedetailDao(SupTradedetailDao supTradedetailDao) {
		this.supTradedetailDao = supTradedetailDao;
	}

	public List<SupTradedetail> getSupTradedetailList() {
		return supTradedetailList;
	}

	public void setSupTradedetailList(List<SupTradedetail> supTradedetailList) {
		this.supTradedetailList = supTradedetailList;
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

	public SupTradedetail getMsi() {
		return msi;
	}

	public void setMsi(SupTradedetail msi) {
		this.msi = msi;
	}
	
	 
}