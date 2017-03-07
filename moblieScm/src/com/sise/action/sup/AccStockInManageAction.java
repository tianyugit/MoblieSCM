package com.sise.action.sup;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.org.json.JSONArray;
import com.sise.action.BasicAction;
import com.sise.dao.BrandDao;
import com.sise.dao.sup.AccstockDao;
import com.sise.dao.sup.AccstockinDao;
import com.sise.dao.sup.SnstockDao;
import com.sise.dao.sup.SupTradedetailDao;
import com.sise.pojo.AccStock;
import com.sise.pojo.Accessorytype;
import com.sise.pojo.Accstockin;
import com.sise.pojo.Brand;
import com.sise.pojo.Mobstock;
import com.sise.pojo.Mobstockin;
import com.sise.pojo.Pagination;
import com.sise.pojo.SnStock;
import com.sise.pojo.SupTradedetail;
import com.sise.pojo.Supplier;
import com.sise.pojo.SupplierType;
import com.sise.pojo.User;
import com.sise.service.AccessoryTypeService;
import com.sise.service.AccstockinService;
import com.sise.service.SupplierService;
import com.sise.service.SupplierTypeService;
import com.sise.service.UserManageService;
import com.sise.utils.DateUtils;
import com.sise.utils.StringUtils;

/**
 * ========================================================================
 * 
 * �汾:1.0
 *
 *��������:2016��11��27�� ����11:31:21
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
public class AccStockInManageAction extends BasicAction{

	private static final long serialVersionUID = 535970496919133537L;
    private Date startDate;
    private Date endDate;
    private List<Brand> brandList;
    private List<SupplierType> supTypeList;
    private List<Accstockin> accStockInList;
    private List<Accessorytype> accessorytypeList;
    private List<Supplier> supList;
    private List<User> userList;
    private List<SnStock> detailList;
    private SupplierType supplierType;
    private Accstockin asi = new Accstockin();
    private String[] sns;
    private BigDecimal buyprice;
    private String acctypeid;
    private String brand;
    private Long amount;
    private BigDecimal totalmoney;
    private BrandDao brandDao;
    private AccstockDao accstockDao;
    private AccstockinDao accstockinDao;
    private SnstockDao snstockDao;
    private AccessoryTypeService accessoryTypeService;
    private SupplierTypeService supplierTypeService;
    private SupplierService supplierService;
    private AccstockinService accstockinService;
    private UserManageService userManageService;
    private SupTradedetailDao supTradedetailDao;
    
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
	 
	 
	 /**
	  * ɸѡ�����Ϣ
	  * @return
	  * @throws Exception
	  */
	 public String findaccTypeByselected() throws Exception {
		 Map<String,String> map = new LinkedHashMap<String,String>();
	    	
	    	map.put("brand", "%" + brand + "%");
	    	map.put("accessoryTypeId", "%" + acctypeid + "%");
	    	System.out.println(map);
	    	 //�������б�
	        accStockInList = accstockinService.getaccType(map);
	    	 //��������б�
	        accessorytypeList = accessoryTypeService.getTypeList();
	    	//��������б�
	       // accessorytypeList = accessoryTypeService.findaccTypeByselected(map);
	    	 //�������б�
	       // accStockInList = accstockinService.getList();
	        //��Ӧ��
	        supList = supplierService.getSupplierList("");

			// Ʒ���б�
			brandList = brandDao.queryList();

			userList = userManageService.getList();
		 return "list";
	 }
	 
	 /**
	  * ajax�����������
	  * @throws Exception
	  */
	 public void findaccType() throws Exception {
		// System.out.println("<String, String>" + supplierType.getSuptypeid());
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("brand", asi.getBrand());
			accessorytypeList = accessoryTypeService.findAccTypeByBrand(asi.getBrand());

			JSONArray jsonArray = new JSONArray(accessorytypeList);
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(jsonArray.toString());
	 }
	 /**
	  * ��ʾϸ���б�
	  * @return
	  * @throws Exception
	  */
	 public String showDetail() throws Exception {
		 //countList = mobstockDao.countMobtype();
		 detailList = snstockDao.getSnStockinByInvoiceId(asi.getInvoiceid());
		 
		 return "detail";
	 }
	 
	 /**+
	  * ���sn�Ƿ����
	  * @throws Exception
	  */
	 public void dupSn() throws Exception {
	        String sn1 = request.getParameter("sn1");
	        String method = request.getParameter("method");
	        PrintWriter out = response.getWriter();

	     //  Integer cnt = Integer.valueOf(mobstockDao.selectByPrimaryKey(sn1).getSn1()) ;
	        if (accstockDao.selectByPrimaryKey(sn1) != null) {
	            out.print("dup");
	            return;
	        }
	        out.print("succ");

	    }
	 /**
	  * ���
	  * @return
	  * @throws Exception
	  */
	 public String check() throws Exception {
	        asi.getInvoiceid();
	        
	        //--�������, service�����
	        
	        //ȡ����ǰ��¼�û�ID,��õ�ǰʱ��
	        User user = new User();
	        user = (User) session.get("loginUser");
	        
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");//�������ڸ�ʽ
	        //checkUserId, checkDate
	        asi.setCheckuserid(user.getUserid());
	        asi.setCheckdate(df.format(new Date()));
	        //����״̬ status = ����  
	        asi.setStatus(Mobstockin.STAT_CHECKED);
	        System.out.println(asi);
	        // --����asi���������ֶ�
	        
	        //������ϸ��status\ checkUserId \ checkDateͬ������
	        SupTradedetail suptradedetail = new SupTradedetail();
	       // BeanUtils.copyProperties(suptradedetail, asi);
	        suptradedetail.setInvoiceid(asi.getInvoiceid());
	        suptradedetail.setStatus(Mobstockin.STAT_CHECKED);
	        suptradedetail.setCheckdate(asi.getCheckdate());
	        suptradedetail.setCheckuserid(asi.getCheckuserid());
	        System.out.println(suptradedetail);
	        //���� ״̬ ���³� ����
	        Mobstock mobstock = new Mobstock();
	      //  SupStockinsn supStockinsn = new SupStockinsn();
	       
	        //supStockinsn = supStockinsnDao.getSupStockinsnByInvoiceId(asi.getInvoiceid());
	        List<SnStock> accStockList = new ArrayList<SnStock>();
	        accStockList = snstockDao.getSnStockinByInvoiceId(asi.getInvoiceid());
	        accstockinService.updateCheck(asi,suptradedetail,accStockList);
	        response.sendRedirect("accessoryStockIn_list.do");
	        return "list";
	  }
	 /**
	  * ����������
	  * @throws Exception
	  */
	 public void findAccType() throws Exception {
		 /* System.out.println("<String, String>" + supplierType.getSuptypeid());
		  Map<String, String> map = new HashMap<String, String>();
		  map.put("suptypeid", supplierType.getSuptypeid());
		  supList= supplierService.findSupplierAjax(map);*/
		  String brand = asi.getBrand();
		  //System.out.println("kllkjlkkljlkjlkjl"+brand);
		  //���������𷵻�json����
		  List<Accessorytype> accTypeList1 = new ArrayList<Accessorytype>(); 
		  accTypeList1 = accessoryTypeService.findAccTypeByBrand(brand);
		  JSONArray jsonArray = new JSONArray(accTypeList1);
		  response.setCharacterEncoding("utf-8");
		  response.getWriter().print(jsonArray.toString());
		  // return "list";
	  }
	 
	 /**
	  * ���ҹ�Ӧ��
	  * @throws Exception
	  */
	 public void findSupplier() throws Exception {
		  System.out.println("<String, String>" + supplierType.getSuptypeid());
		  Map<String, String> map = new HashMap<String, String>();
		  map.put("suptypeid", supplierType.getSuptypeid());
		  supList= supplierService.findSupplierAjax(map);
		  
		  JSONArray jsonArray = new JSONArray(supList);
		  response.setCharacterEncoding("utf-8");
		  response.getWriter().print(jsonArray.toString());
	       // return "list";
	    }
	 
	 /**
	  * ת����ӽ���
	  * @return
	  * @throws Exception
	  */
	 public String toAdd() throws Exception {
	        getLists();
	        return "add";
	    }
	 
	 /**
	  * �����������Ϣ
	  * @throws Exception
	  */
	 public void add() throws Exception {

	        asi.setInvoiceid("MIS-"
	                + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");//�������ڸ�ʽ
	        
	        asi.setInputdate(df.format(new Date()));
	        String userId = ((User) session.get("loginUser")).getUserid();
	        asi.setInputuserid(userId);
	        asi.setStatus(Accstockin.STAT_NOTCHECK);
	        asi.setAmount(amount);
	        asi.setTotalmoney(totalmoney);
	        asi.setBuyprice(buyprice);
	      //  asi.setOrgid((String) dao.queryObject("user.getOrgIdByUserId", userId));
	        // ������ϸ
	        SupTradedetail suptradedetail = new SupTradedetail();
	        BeanUtils.copyProperties(suptradedetail, asi);
	        suptradedetail.setTradetype(SupTradedetail.TRADETYPE_MOBSTOCKIN);
	        suptradedetail.setType(asi.getAccessorytypeid());
	        suptradedetail.setUnitprice(asi.getBuyprice());
	        suptradedetail.setSupplierid(asi.getSupplierid());
	        List<Map> snList = new ArrayList<Map>();
	        List<AccStock> mobStockList = new ArrayList<AccStock>();
	      //System.out.println(sns);
	        if (sns != null && sns.length > 0) {
	            for (int i = 0; i < sns.length; i++) {
	                // ���ű�
	                String sn = sns[i];
	                
	                Map<String,String> snMap = new HashMap<String,String>();
	                snMap.put("id", StringUtils.uniqueKey());
	                snMap.put("invoiceid", asi.getInvoiceid());
	                snMap.put("sn", sn);
	                System.out.println("fafaf�ķ�"+snMap.get("invoiceid"));
	                //supStockinsnDao.insertByMap(snMap);
	                snList.add(snMap);
	                // ����
	                AccStock accstock = new AccStock();
	               
	                accstock.setSn(sn);
	                
	               
	                BeanUtils.copyProperties(accstock, asi);
	                accstock.setFirstintime(asi.getInputdate());
	                accstock.setFristsupplierid(asi.getSupplierid());
	                
	                accstock.setCost(asi.getBuyprice());
	                accstock.setLossamount(new BigDecimal(0));
	                accstockDao.insertSelective(accstock);
	                //mobStockList.add(mobstock);
	            }
	        }
	        System.out.println(asi);
	      //  supTradedetailDao.insertSelective(suptradedetail);
	       // mobstockinDao.insertSelective(asi);
	        accstockinService.addInvoice(asi, suptradedetail, snList);
	        response.sendRedirect("accessoryStockIn_list.do");
	    }
	 
	 public String delete()  throws Exception {
		 accstockinService.delete(asi.getInvoiceid());
		 response.sendRedirect("accessoryStockIn_list.do");
		 return "list";
	 }
	 
	    private void getLists() throws Exception {
	        
	        // Ʒ���б�
	        brandList = brandDao.queryList();
	        // ��Ӧ������б�
	        supTypeList = supplierTypeService.getTypeList();
	        //�������б�
	       // accStockInList = accstockinService.getList();
	        //��Ӧ��
	        supList = supplierService.getSupplierList("");
	        //�û��б�
	        userList = userManageService.getList();
	        //��������б�
	        accessorytypeList = accessoryTypeService.getTypeList();
	        
	        pagination = new Pagination();
			// paginatedQuery("mobStockIn.getMobStockIn");
			int pageLong = accstockinDao.getPageLong();
			//Pagination<Mobstockin> pb = new Pagination<Mobstockin>();
			
			pagination.setPageIndex(pageIndex== null ? 1 : pageIndex );
			pagination.setPageSize(15);
			pagination.setTotalRecordCnt(pageLong);
			pagination.setUrl("accessoryStockIn_list.do?");
			accStockInList = accstockinDao.findAllWithFy(((pageIndex== null ? 1 : pageIndex) - 1) * 15, 15);
			pagination.setDataList(accStockInList);
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

	public List<Brand> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<Brand> brandList) {
		this.brandList = brandList;
	}

	public void setBrandDao(BrandDao brandDao) {
		this.brandDao = brandDao;
	}

	public void setAccstockDao(AccstockDao accstockDao) {
		this.accstockDao = accstockDao;
	}

	public void setAccessoryTypeService(AccessoryTypeService accessoryTypeService) {
		this.accessoryTypeService = accessoryTypeService;
	}

	public Accstockin getAsi() {
		return asi;
	}

	public void setAsi(Accstockin asi) {
		this.asi = asi;
	}

	public BigDecimal getBuyprice() {
		return buyprice;
	}

	public void setBuyprice(BigDecimal buyprice) {
		this.buyprice = buyprice;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	} 

	public BigDecimal getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(BigDecimal totalmoney) {
		this.totalmoney = totalmoney;
	}

	public String[] getSns() {
		return sns;
	}

	public void setSns(String[] sns) {
		this.sns = sns;
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

	public SupplierType getSupplierType() {
		return supplierType;
	}

	public void setSupplierType(SupplierType supplierType) {
		this.supplierType = supplierType;
	}

	public void setSupplierTypeService(SupplierTypeService supplierTypeService) {
		this.supplierTypeService = supplierTypeService;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public void setAccstockinService(AccstockinService accstockinService) {
		this.accstockinService = accstockinService;
	}

	public void setSupTradedetailDao(SupTradedetailDao supTradedetailDao) {
		this.supTradedetailDao = supTradedetailDao;
	}

	public List<Accstockin> getAccStockInList() {
		return accStockInList;
	}

	public void setAccStockInList(List<Accstockin> accStockInList) {
		this.accStockInList = accStockInList;
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

	public List<Accessorytype> getAccessorytypeList() {
		return accessorytypeList;
	}

	public void setAccessorytypeList(List<Accessorytype> accessorytypeList) {
		this.accessorytypeList = accessorytypeList;
	}

	public void setSnstockDao(SnstockDao snstockDao) {
		this.snstockDao = snstockDao;
	}

	public List<SnStock> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<SnStock> detailList) {
		this.detailList = detailList;
	}

	public String getAcctypeid() {
		return acctypeid;
	}


	public void setAcctypeid(String acctypeid) {
		this.acctypeid = acctypeid;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public void setAccstockinDao(AccstockinDao accstockinDao) {
		this.accstockinDao = accstockinDao;
	}
	
}
