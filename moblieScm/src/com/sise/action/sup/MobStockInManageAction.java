package com.sise.action.sup;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.apache.commons.beanutils.BeanUtils;

import com.org.json.JSONArray;
import com.sise.action.BasicAction;
import com.sise.dao.BrandDao;
import com.sise.dao.ColorDao;
import com.sise.dao.ConfigDao;
import com.sise.dao.sup.MobstockDao;
import com.sise.dao.sup.MobstockinDao;
import com.sise.dao.sup.SupStockinsnDao;
import com.sise.pojo.Mobstockin;
import com.sise.pojo.Mobtype;
import com.sise.pojo.Mobstock;
import com.sise.pojo.Pagination;
import com.sise.pojo.StoCount;
import com.sise.pojo.SupStockinsn;
import com.sise.pojo.SupTradedetail;
import com.sise.pojo.User;
import com.sise.service.MobStockInService;
import com.sise.service.MobTypeService;
import com.sise.service.SupplierService;
import com.sise.service.SupplierTypeService;
import com.sise.service.UserManageService;
import com.sise.supplier.Supplier;
import com.sise.supplier.SupplierServiceImpl;
import com.sise.suppliertype.SupplierType;
import com.sise.suppliertype.SupplierTypeServiceImpl;
import com.sise.utils.DateUtils;
import com.sise.utils.StringUtils;
/**
 * ========================================================================
 * 
 * �汾:1.0
 *
 *��������:2016��11��25�� ����11:31:48
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
public class MobStockInManageAction extends BasicAction {

	private static final long serialVersionUID = -4099701381957046269L;

	private List<SupplierType> supTypeList;
	private List<Supplier> supList;
	private List<String> brandList;
	private List<Mobtype> mobTypeList;
	private List<String> configList;
	private List<String> colorList;
	private List<User> userList;
	private List<Mobstockin> mobStockInList;
	private List<StoCount> countList;
	private List<SupStockinsn> detailList;
	private SupplierType supplierType;
	private String supplierid;
	private Date startDate;
	private Date endDate;

	private SupplierTypeService supplierTypeService;
	private SupplierService supplierService;
	private MobTypeService mobTypeService;

	private ConfigDao configDao;
	private BrandDao brandDao;
	private ColorDao colorDao;
	private MobstockDao mobstockDao;
	private Mobstockin msi = new Mobstockin();
	private MobstockinDao mobstockinDao;
	private SupStockinsnDao supStockinsnDao;
	private String[] sns;
	private BigDecimal buyprice;
	private String mobtypeid;
	private Long amount;
	private Double totalmoney;
	private MobStockInService mobStockInService;
	private UserManageService userManageService;

	//private Integer offSet ;
	// private SupTradedetailDao supTradedetailDao;
	/**
	 * ��Զ���ṩ�Ĺ�Ӧ�̻�ȡ���
	 * @return
	 * @throws Exception
	 */
	public SupplierTypeServiceImpl getConnFromSupplierType() throws Exception {
		//wsdl��·��
		URL wsdlDocumentLocation = new URL("http://127.0.0.1:12345/supplierType?wsdl");
		//��wsdl���ҵ�������ͼ
		//��һ��������wsdl�������ռ�
		//�ڶ���������������ͼ����
		QName serviceName = new QName("http://supplierType.sise.com/", "SupplierTypeService");
		
		//��һ��ʹ��Service����������ͼ
		Service service =Service.create(wsdlDocumentLocation, serviceName);
		
		//�ӷ�����ͼ�õ�portType����
		//������portType
		SupplierTypeServiceImpl supplierTypeService = service.getPort(SupplierTypeServiceImpl.class);
		return supplierTypeService;
	}
	/**
	 * ��Զ�̻�ȡ��Ӧ���б�
	 * @return
	 * @throws Exception
	 */
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
	 * 
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
		// SysUsers loginUser = (SysUsers) session.get("loginUser");
		// String queryScope = loginUser.getQueryScope();
		// orgScope = queryScope.split(",");
		pagination = new Pagination();
		// paginatedQuery("mobStockIn.getMobStockIn");
		int pageLong = mobstockinDao.getPageLong();
		//Pagination<Mobstockin> pb = new Pagination<Mobstockin>();
		
		pagination.setPageIndex(pageIndex== null ? 1 : pageIndex );
		pagination.setPageSize(15);
		pagination.setTotalRecordCnt(pageLong);
		pagination.setUrl("mobStockIn_list.do?");
		mobStockInList = mobstockinDao.findAllWithFy(((pageIndex== null ? 1 : pageIndex) - 1) * 15, 15);
		pagination.setDataList(mobStockInList);
		return "list";
	}

	/**
	 * ת����ӽ���
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toAdd() throws Exception {
		getLists();
		return "add";
	}
	
	/**
	 * ��ѯ�ֻ����
	 * @return
	 * @throws Exception
	 */
	public String findMobStockIn() throws Exception {
		
		Map<String,String> map = new LinkedHashMap<String,String>();
    	
    	map.put("supplierid", "%" + supplierid + "%");
    	map.put("mobtypeid", "%" + mobtypeid + "%");
    	System.out.println(map);
    	// �ֻ�����б�
		mobStockInList = mobStockInService.findMobStockIn(map); 
    	// ��Ӧ������б�
		supTypeList = getConnFromSupplierType().getTypeList();
		// ��Ӧ���б�
		supList = getConFromSupplier().getSupplierList("");

		// Ʒ���б�
		brandList = brandDao.queryList();
		// �ֻ��ͺ��б�
		mobTypeList = mobTypeService.queryList("");
		// �����б�
		configList = configDao.queryList("");
		// ��ɫ�б�
		colorList = colorDao.queryList();
		

		userList = userManageService.getList();
		return "list";
	}
	
	

	/**
	 * ת�������б�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showDetail() throws Exception {
		// countList = mobstockDao.countMobtype();
		detailList = supStockinsnDao.getSupStockinsnByInvoiceId(msi
				.getInvoiceid());

		return "detail";
	}

	private void getLists() throws Exception {
		// ��Ӧ������б�
		//supTypeList = supplierTypeService.getTypeList();
		supTypeList = getConnFromSupplierType().getTypeList();
		// ��Ӧ���б�
		supList = getConFromSupplier().getSupplierList("");

		// Ʒ���б�
		brandList = brandDao.queryList();
		// �ֻ��ͺ��б�
		mobTypeList = mobTypeService.queryList("");
		// �����б�
		configList = configDao.queryList("");
		// ��ɫ�б�
		colorList = colorDao.queryList();
		// �ֻ�����б�
		mobStockInList = mobStockInService.queryList();

		userList = userManageService.getList();
	}
	
	public String delete() throws Exception {
		mobStockInService.delete(msi);
		response.sendRedirect("mobStockIn_list.do");
		return "list";
	}

	/**
	 * ����ֻ���ⵥ
	 * 
	 * @throws Exception
	 */
	public void add() throws Exception {

		msi.setInvoiceid("MIS-"
				+ new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");// �������ڸ�ʽ

		msi.setInputdate(df.format(new Date()));
		String userId = ((User) session.get("loginUser")).getUserid();
		msi.setInputuserid(userId);
		msi.setStatus(Mobstockin.STAT_NOTCHECK);
		msi.setAmount(amount);
		msi.setTotalmoney(totalmoney);
		msi.setBuyprice(buyprice);
		msi.setMobtypeid(mobtypeid);
		// msi.setOrgid((String) dao.queryObject("user.getOrgIdByUserId",
		// userId));

		// ������ϸ
		SupTradedetail suptradedetail = new SupTradedetail();
		BeanUtils.copyProperties(suptradedetail, msi);
		suptradedetail.setTradetype(SupTradedetail.TRADETYPE_MOBSTOCKIN);
		suptradedetail.setType(msi.getMobtypeid());
		suptradedetail.setUnitprice(msi.getBuyprice());
		suptradedetail.setSupplierid(msi.getSupplierid());
		List<Map> snList = new ArrayList<Map>();
		List<Mobstock> mobStockList = new ArrayList<Mobstock>();
		// System.out.println(sns);
		if (sns != null && sns.length > 0) {
			for (int i = 0; i < sns.length; i++) {
				// ���ű�
				String[] sn = sns[i].split(",");

				Map<String, String> snMap = new HashMap<String, String>();
				snMap.put("id", StringUtils.uniqueKey());
				snMap.put("invoiceid", msi.getInvoiceid());
				if (sn.length > 1) {
					snMap.put("sn1", sn[0]);
					snMap.put("sn2", sn[1]);
				} else {
					snMap.put("sn1", sn[0]);

				}
				System.out.println("fafaf�ķ��˰�Ѹĸ�" + snMap.get("invoiceid"));
				// supStockinsnDao.insertByMap(snMap);
				snList.add(snMap);
				// ����
				Mobstock mobstock = new Mobstock();
				if (sn.length > 1) {
					mobstock.setSn1(sn[0]);
					mobstock.setSn2(sn[1]);
				} else {
					mobstock.setSn1(sn[0]);
				}

				BeanUtils.copyProperties(mobstock, msi);
				mobstock.setFristsupplierid(msi.getSupplierid());
				mobstock.setFirstintime(msi.getInputdate());
				mobstock.setCost(msi.getBuyprice());
				mobstock.setLossamount(new BigDecimal(0));
				mobstockDao.insertSelective(mobstock);
				// mobStockList.add(mobstock);
			}
		}
		System.out.println(msi);
		// supTradedetailDao.insertSelective(suptradedetail);
		// mobstockinDao.insertSelective(msi);
		mobStockInService.addInvoice(msi, suptradedetail, snList);
		//getLists();
		response.sendRedirect("mobStockIn_list.do");
	}

	/**
	 * ��鴮���Ƿ����
	 * @throws Exception
	 */
	public void dupSn() throws Exception {
		String sn1 = request.getParameter("sn1");
		String sn2 = request.getParameter("sn2");
		String method = request.getParameter("method");

		PrintWriter out = response.getWriter();

		// Integer cnt =
		// Integer.valueOf(mobstockDao.selectByPrimaryKey(sn1).getSn1()) ;
		if (mobstockDao.selectByPrimaryKey(sn1) != null) {
			out.print("dup");
			return;
		}

		if (method.equals("double")) {
			// cnt = (Integer) dao.queryObject("mobStock.findDupSn2", sn2);
			if (mobstockDao.selectByPrimaryKey2(sn2) != null) {
				out.print("dup");
				return;
			}
		}
		out.print("succ");
	}

	/**
	 * ���ҹ�Ӧ��
	 * @throws Exception
	 */
	public void findSupplier() throws Exception {
		System.out.println("<String, String>" + supplierType.getSuptypeid());
		Map<String, String> map = new HashMap<String, String>();
		map.put("suptypeid", supplierType.getSuptypeid());
		supList = getConFromSupplier().findSupplierAjax(supplierType.getSuptypeid());

		JSONArray jsonArray = new JSONArray(supList);
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(jsonArray.toString());
		// return "list";
	}

	/**
	 * �����ⵥ
	 * @return
	 * @throws Exception
	 */
	public String check() throws Exception {
		msi.getInvoiceid();

		// --�������, service�����

		// ȡ����ǰ��¼�û�ID,��õ�ǰʱ��
		User user = new User();
		user = (User) session.get("loginUser");

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");// �������ڸ�ʽ
		// checkUserId, checkDate
		msi.setCheckuserid(user.getUserid());
		msi.setCheckdated(df.format(new Date()));
		// ����״̬ status = ����
		msi.setStatus(Mobstockin.STAT_CHECKED);
		System.out.println(msi);
		// --����msi���������ֶ�

		// ������ϸ��status\ checkUserId \ checkDateͬ������
		SupTradedetail suptradedetail = new SupTradedetail();
		// BeanUtils.copyProperties(suptradedetail, msi);
		suptradedetail.setInvoiceid(msi.getInvoiceid());
		suptradedetail.setStatus(Mobstockin.STAT_CHECKED);
		suptradedetail.setCheckdate(msi.getCheckdated());
		suptradedetail.setCheckuserid(msi.getCheckuserid());
		System.out.println(suptradedetail);
		// ���� ״̬ ���³� ����
		Mobstock mobstock = new Mobstock();
		// SupStockinsn supStockinsn = new SupStockinsn();

		// supStockinsn =
		// supStockinsnDao.getSupStockinsnByInvoiceId(msi.getInvoiceid());
		List<SupStockinsn> mobStockList = new ArrayList<SupStockinsn>();
		mobStockList = supStockinsnDao.getSupStockinsnByInvoiceId(msi
				.getInvoiceid());
		mobStockInService.updateCheck(msi, suptradedetail, mobStockList);
		response.sendRedirect("mobStockIn_list.do");
		return "list";
	}

	/**
	 * �����ֻ��ͺ�
	 * @throws Exception
	 */
	public void findMobType() throws Exception {
		/*
		 * System.out.println("<String, String>" + supplierType.getSuptypeid());
		 * Map<String, String> map = new HashMap<String, String>();
		 * map.put("suptypeid", supplierType.getSuptypeid()); supList=
		 * supplierService.findSupplierAjax(map);
		 */
		String brand = msi.getBrand();
		System.out.println("kllkjlkkljlkjlkjl" + brand);
		List<Mobtype> mobTypeList1 = new ArrayList<Mobtype>();
		mobTypeList1 = mobTypeService.findMobTypeByBrand(brand);
		JSONArray jsonArray = new JSONArray(mobTypeList1);
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(jsonArray.toString());
		// return "list";
	}

	/**
	 * ���Ҽ۸�
	 * @throws Exception
	 */
	public void findRefPrice() throws Exception {
		String typeid = msi.getMobtypeid();
		Map paraMap = new HashMap();
		Mobtype mobtype = new Mobtype();
		mobtype.setMobtypeid(typeid);
		paraMap.put("mobType", mobtype);
		mobtype = (Mobtype) mobTypeService.queryList(mobtype.getMobtypeid())
				.get(0);

		PrintWriter out = response.getWriter();
		if (mobtype == null || mobtype.getBuyprice() == null) {
			out.print("");
		} else {
			out.print(mobtype.getBuyprice());
		}
	}

	public String toEdit() throws Exception {
		msi = mobStockInService.getmobStockInByid(msi.getInvoiceid());
		detailList = supStockinsnDao.getSupStockinsnByInvoiceId(msi.getInvoiceid());
		getLists();
		return "edit";
	}
	
	public void edit()throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");// �������ڸ�ʽ
		msi.setInputdate(df.format(new Date()));
		String userId = ((User) session.get("loginUser")).getUserid();
		msi.setInputuserid(userId);
		msi.setAmount(amount);
		msi.setStatus(Mobstockin.STAT_NOTCHECK);
		msi.setTotalmoney(totalmoney);
		msi.setBuyprice(buyprice);
		msi.setMobtypeid(mobtypeid);
		// ������ϸ
		SupTradedetail suptradedetail = new SupTradedetail();
		BeanUtils.copyProperties(suptradedetail, msi);
		suptradedetail.setTradetype(SupTradedetail.TRADETYPE_MOBSTOCKIN);
		suptradedetail.setType(msi.getMobtypeid());
		suptradedetail.setUnitprice(msi.getBuyprice());
		suptradedetail.setSupplierid(msi.getSupplierid());
		List<Map> snList = new ArrayList<Map>();
		List<Mobstock> mobStockList = new ArrayList<Mobstock>();
		// System.out.println(sns);
		if (sns != null && sns.length > 0) {
			for (int i = 0; i < sns.length; i++) {
				// ���ű�
				String[] sn = sns[i].split(",");

				Map<String, String> snMap = new HashMap<String, String>();
				snMap.put("id", StringUtils.uniqueKey());
				snMap.put("invoiceid", msi.getInvoiceid());
				if (sn.length > 1) {
					snMap.put("sn1", sn[0]);
					snMap.put("sn2", sn[1]);
				} else {
					snMap.put("sn1", sn[0]);

				}
				System.out.println("fafaf�ķ��˰�Ѹĸ�" + snMap.get("invoiceid"));
				// supStockinsnDao.insertByMap(snMap);
				snList.add(snMap);
				// ����
				Mobstock mobstock = new Mobstock();
				if (sn.length > 1) {
					mobstock.setSn1(sn[0]);
					mobstock.setSn2(sn[1]);
				} else {
					mobstock.setSn1(sn[0]);
				}

				BeanUtils.copyProperties(mobstock, msi);
				mobstock.setFristsupplierid(msi.getSupplierid());
				mobstock.setFirstintime(msi.getInputdate());
				mobstock.setCost(msi.getBuyprice());
				mobstock.setLossamount(new BigDecimal(0));
				mobstockDao.deleteByPrimaryKey(mobstock.getSn1());
				mobstockDao.insertSelective(mobstock);
				// mobStockList.add(mobstock);
			}
		}
		mobStockInService.update(msi,suptradedetail,snList);
		response.sendRedirect("mobStockIn_list.do");
	}
	public BigDecimal getBuyprice() {
		return buyprice;
	}

	public void setBuyprice(BigDecimal buyprice) {
		this.buyprice = buyprice;
	}

	public String getMobtypeid() {
		return mobtypeid;
	}

	public void setMobtypeid(String mobtypeid) {
		this.mobtypeid = mobtypeid;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Double getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(Double totalmoney) {
		this.totalmoney = totalmoney;
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

	public List<String> getConfigList() {
		return configList;
	}

	public void setConfigList(List<String> configList) {
		this.configList = configList;
	}

	public List<String> getColorList() {
		return colorList;
	}

	public void setColorList(List<String> colorList) {
		this.colorList = colorList;
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

	public void setConfigDao(ConfigDao configDao) {
		this.configDao = configDao;
	}

	public void setBrandDao(BrandDao brandDao) {
		this.brandDao = brandDao;
	}

	public void setColorDao(ColorDao colorDao) {
		this.colorDao = colorDao;
	}

	public Mobstockin getMsi() {
		return msi;
	}

	public void setMsi(Mobstockin msi) {
		this.msi = msi;
	}

	public String[] getSns() {
		return sns;
	}

	public void setSns(String[] sns) {
		this.sns = sns;
	}

	public void setMobStockInService(MobStockInService mobStockInService) {
		this.mobStockInService = mobStockInService;
	}

	public SupplierType getSupplierType() {
		return supplierType;
	}

	public void setSupplierType(SupplierType supplierType) {
		this.supplierType = supplierType;
	}

	public void setMobstockDao(MobstockDao mobstockDao) {
		this.mobstockDao = mobstockDao;
	}

	public List<Mobstockin> getMobStockInList() {
		return mobStockInList;
	}

	public void setMobStockInList(List<Mobstockin> mobStockInList) {
		this.mobStockInList = mobStockInList;
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

	public void setSupStockinsnDao(SupStockinsnDao supStockinsnDao) {
		this.supStockinsnDao = supStockinsnDao;
	}

	public List<StoCount> getCountList() {
		return countList;
	}

	public void setCountList(List<StoCount> countList) {
		this.countList = countList;
	}

	public List<SupStockinsn> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<SupStockinsn> detailList) {
		this.detailList = detailList;
	}

	public String getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	public void setMobstockinDao(MobstockinDao mobstockinDao) {
		this.mobstockinDao = mobstockinDao;
	}

}
