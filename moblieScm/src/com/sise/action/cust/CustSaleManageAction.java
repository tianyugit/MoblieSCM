package com.sise.action.cust;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.org.json.JSONArray;
import com.sise.action.BasicAction;
import com.sise.dao.BrandDao;
import com.sise.dao.cust.CustMobsaleDao;
import com.sise.dao.cust.CustMobsalesnDao;
import com.sise.dao.cust.CustSaleDao;
import com.sise.dao.sup.MobstockDao;
import com.sise.pojo.CustMobsale;
import com.sise.pojo.CustMobsalesn;
import com.sise.pojo.CustTradedetail;
import com.sise.pojo.Customer;
import com.sise.pojo.Customertype;
import com.sise.pojo.JsonBean;
import com.sise.pojo.Mobstock;
import com.sise.pojo.Mobstockin;
import com.sise.pojo.Mobtype;
import com.sise.pojo.Pagination;
import com.sise.pojo.Supplier;
import com.sise.pojo.SupplierType;
import com.sise.pojo.User;
import com.sise.service.CustomerService;
import com.sise.service.CustomertypeService;
import com.sise.service.MobTypeService;
import com.sise.service.SupplierService;
import com.sise.service.SupplierTypeService;
import com.sise.service.UserManageService;
import com.sise.service.cust.CustMobsaleService;
import com.sise.utils.StringUtils;
/**
 * ========================================================================
 * 
 * �汾:1.0
 *
 *��������:2016��12��02�� ����11:30:14
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
public class CustSaleManageAction extends BasicAction {

	private static final long serialVersionUID = 5991182514429473034L;
	private List<SupplierType> supTypeList;
	private List<Supplier> supList;
	private List<String> brandList;
	private List<Mobtype> mobTypeList;
	private List<User> userList;
	private List<JsonBean> jsonBeanList;
	private List<CustMobsale> mobSaleList;
	private List<CustMobsalesn> detailList;
	private Date startDate;
	private Date endDate;

	private CustMobsale mobSale = new CustMobsale();

	private String[] sns;
	private Long amount;
	private BigDecimal totalmoney;
	private BigDecimal returnprice;
	private String custName;
	private BrandDao brandDao;
	private MobstockDao mobstockDao;
	private CustMobsalesnDao custMobsalesnDao;
	private CustomertypeService customertypeService;
	private CustSaleDao custSaleDao;
	private CustMobsaleDao custMobsaleDao;
	private SupplierTypeService supplierTypeService;
	private SupplierService supplierService;
	private MobTypeService mobTypeService;
	private UserManageService userManageService;
	private CustMobsaleService custMobsaleService;
	private CustomerService customerService;

	/*
	 * ת����ӽ���
	 */
	public String toAdd() throws Exception {
		getLists();
		return "add";
	}

	/**
	 * ��ת���б����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		getLists();
		
		return "list";
	}
	/**
	  * ��ʾϸ���б�
	  * @return
	  * @throws Exception
	  */
	 public String showDetail() throws Exception {
		 //countList = mobstockDao.countMobtype();
		 detailList = custMobsalesnDao.getSnByInvoiceid(mobSale);
		 // ��Ӧ���б�
	     supList = supplierService.getSupplierList("");
		 return "detail";
	 }

	/**
	 * ������۵�,������ϸ,���ű�
	 * 
	 * @throws Exception
	 */
	
	public void add() throws Exception {
		/*
		 * String sn22 = request.getParameter("q");
		 * System.out.println("����������ֳ���������������������"+sn22);
		 */
		Customer cust = new Customer();
		//cust = customerService.findCustByName(custName);

		User loginUser = (User) session.get("loginUser");

		// ���۵�
		mobSale.setInvoiceid("MR-"
				+ new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		mobSale.setStatus(0);
		mobSale.setInputuserid(loginUser.getUserid());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");// �������ڸ�ʽ
		mobSale.setInputdate(df.format(new Date()));
		mobSale.setAmount(amount);
		mobSale.setTotalmoney(totalmoney);
		mobSale.setCustid(custName);
		cust.setCustid(custName);
		System.out.println("ffdddddddddddddddddddddddddddddddddddd"+custName);
		cust = customerService.getCustomer(cust);
		System.out.println(cust);
		Customertype ctype = new Customertype();
		
		ctype = customertypeService.getType(cust.getCustomerType());
		System.out.println("ffffffffffffffffffffffff" + cust.getCustomerType());
		//���ݿͻ��������ۿ�
		mobSale.setSaleprice(returnprice.multiply(ctype.getDiscount()));
		//mobSale.setCustid(cust.getCustid());
		//System.out.println("gffhfdhdfdgdfgggggggggggggggggggggg"+custName);
		
		/*
		 * mobreturn.setOrgid((String) dao.queryObject("user.getOrgIdByUserId",
		 * loginUser.getUserid()));
		 */

		// ������ϸ
		CustTradedetail custtradedetail = new CustTradedetail();
		BeanUtils.copyProperties(custtradedetail, mobSale);
		custtradedetail.setTradetype(CustTradedetail.TRADETYPE_MOBSALE);

		custtradedetail.setType(mobSale.getMobtypeid());
		custtradedetail.setUnitprice(mobSale.getSaleprice());

		// ����
		List<Map> snList = new ArrayList<Map>();
		for (String strSn : sns) {
			String[] tmp = strSn.split(",");
			Map map = new HashMap();
			map.put("sn1", tmp[0]);
			
			Mobstock mobstock = new Mobstock();
			mobstock = mobstockDao.selectByPrimaryKey(tmp[0]);
			/*mobSale.setSupplierid(mobstock.getFristsupplierid());*/
			mobSale.setMobtypeid(mobstock.getMobtypeid());
			
			/*CustSale custSale = new CustSale();
			BeanUtils.copyProperties(custSale, mobSale);
			custSale.setBuyprice(returnprice);
			custSaleDao.insertSelective(custSale);*/
			
			if (tmp.length > 1) {
				map.put("sn2", tmp[1]);
			}
			map.put("id", StringUtils.uniqueKey());
			map.put("invoiceid", mobSale.getInvoiceid());
			// / map.put("stat ", 3);
			snList.add(map);
		}

		custMobsaleService.add(mobSale, custtradedetail, snList);
		response.sendRedirect("custSale_list.do");
		// response.getWriter().print("mobSale_list.do");
	}
	
	 /**
	 * ������۵�
	 * @return
	 * @throws Exception
	 */
	public String check() throws Exception {
		

		// --�������, service�����

		// ȡ����ǰ��¼�û�ID,��õ�ǰʱ��
		User user = new User();
		user = (User) session.get("loginUser");
		if(user == null){
			response.sendRedirect("start.do");
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");// �������ڸ�ʽ
		// checkUserId, checkDate
		mobSale.setCheckuserid(user.getUserid());
		mobSale.setCheckdate(df.format(new Date()));
		// ����״̬ status = ����
		mobSale.setStatus(Mobstockin.STAT_CHECKED);
		System.out.println(mobSale);
		// --����msi���������ֶ�

		// ������ϸ��status\ checkUserId \ checkDateͬ������
		CustTradedetail custtradedetail = new CustTradedetail();
		// BeanUtils.copyProperties(suptradedetail, msi);
		custtradedetail.setInvoiceid(mobSale.getInvoiceid());
		custtradedetail.setStatus(Mobstockin.STAT_CHECKED);
		custtradedetail.setCheckdate(mobSale.getCheckdate());
		custtradedetail.setCheckuserid(mobSale.getCheckuserid());
		System.out.println(custtradedetail);
		// ���� ״̬ ���³� ����
		//Mobstock mobstock = new Mobstock();
		// SupStockinsn supStockinsn = new SupStockinsn();

		// supStockinsn =
		// supStockinsnDao.getSupStockinsnByInvoiceId(msi.getInvoiceid());
		List<CustMobsalesn> custMobsalesnList = new ArrayList<CustMobsalesn>();
		custMobsalesnList = custMobsalesnDao.getSnByInvoiceid(mobSale);
		custMobsaleService.updateCheck(mobSale, custtradedetail, custMobsalesnList);
		getLists();
		return "list";
	}

	/**
	 * ���ҿͻ�
	 * 
	 * @throws Exception
	 */
	public void findCust() throws Exception {
		String custname = request.getParameter("q");
		// System.out.println("����������ֳ���������������������"+custname);
		Map<String, String> map = new HashMap<String, String>();
		// map.put("%custname%", custname);
		map.put("custname", "%" + custname + "%");
		jsonBeanList = customerService.findCust(map);
		JSONArray jsonArray = new JSONArray(jsonBeanList);
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(jsonArray.toString());
	}

	/**
	 * ��ȡ�б�
	 * 
	 * @throws Exception
	 */
	private void getLists() throws Exception {
		// ��Ӧ������б�
		supTypeList = supplierTypeService.getTypeList();
		// ��Ӧ���б�
		supList = supplierService.getSupplierList("");
		// Ʒ���б�
		brandList = brandDao.queryList();
		// �ֻ��ͺ��б�
		mobTypeList = mobTypeService.queryList("");
		// �û��б�
		userList = userManageService.getList();
		//�ֻ����۵�
		//mobSaleList = custMobsaleService.getList("");
		Map map = new HashMap();
	    pagination = new Pagination();
		int pageLong = custMobsaleDao.getPageLong();
		
		pagination.setPageIndex(pageIndex== null ? 1 : pageIndex );
		pagination.setPageSize(15);
		pagination.setTotalRecordCnt(pageLong);
		pagination.setUrl("custSale_list.do?");
		mobSaleList = custMobsaleDao.findAllWithFy(map,((pageIndex== null ? 1 : pageIndex) - 1) * 15, 15);
		pagination.setDataList(mobSaleList);
	}

	 public String delete()  throws Exception {
		 custMobsaleService.delete(mobSale);
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

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
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

	public String[] getSns() {
		return sns;
	}

	public void setSns(String[] sns) {
		this.sns = sns;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public void setBrandDao(BrandDao brandDao) {
		this.brandDao = brandDao;
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

	public void setUserManageService(UserManageService userManageService) {
		this.userManageService = userManageService;
	}

	public void setCustMobsaleService(CustMobsaleService custMobsaleService) {
		this.custMobsaleService = custMobsaleService;
	}

	public List<JsonBean> getJsonBeanList() {
		return jsonBeanList;
	}

	public void setJsonBeanList(List<JsonBean> jsonBeanList) {
		this.jsonBeanList = jsonBeanList;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public CustMobsale getMobReturn() {
		return mobSale;
	}

	public void setMobReturn(CustMobsale mobSale) {
		this.mobSale = mobSale;
	}

	public BigDecimal getReturnprice() {
		return returnprice;
	}

	public void setReturnprice(BigDecimal returnprice) {
		this.returnprice = returnprice;
	}

	public void setTotalmoney(BigDecimal totalmoney) {
		this.totalmoney = totalmoney;
	}

	public List<CustMobsale> getMobSaleList() {
		return mobSaleList;
	}

	public void setMobSaleList(List<CustMobsale> mobSaleList) {
		this.mobSaleList = mobSaleList;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public CustMobsale getMobSale() {
		return mobSale;
	}

	public void setMobSale(CustMobsale mobSale) {
		this.mobSale = mobSale;
	}

	public BigDecimal getTotalmoney() {
		return totalmoney;
	}

	public void setCustMobsalesnDao(CustMobsalesnDao custMobsalesnDao) {
		this.custMobsalesnDao = custMobsalesnDao;
	}

	public void setMobstockDao(MobstockDao mobstockDao) {
		this.mobstockDao = mobstockDao;
	}

	public void setCustSaleDao(CustSaleDao custSaleDao) {
		this.custSaleDao = custSaleDao;
	}

	public List<CustMobsalesn> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<CustMobsalesn> detailList) {
		this.detailList = detailList;
	}

	public void setCustomertypeService(CustomertypeService customertypeService) {
		this.customertypeService = customertypeService;
	}

	public void setCustMobsaleDao(CustMobsaleDao custMobsaleDao) {
		this.custMobsaleDao = custMobsaleDao;
	}

}
