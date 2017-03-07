package com.sise.action.sup;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;






import com.sise.action.BasicAction;
import com.sise.dao.AccountDao;
import com.sise.dao.sup.PaymentDao;
import com.sise.pojo.Account;
import com.sise.pojo.Mobstockin;
import com.sise.pojo.Payment;
import com.sise.pojo.Supplier;
import com.sise.pojo.SupplierType;
import com.sise.pojo.User;
import com.sise.service.PaymentService;
import com.sise.service.SupplierService;
import com.sise.service.SupplierTypeService;
import com.sise.service.UserManageService;

/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年11月10日 上午11:32:00
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
public class PayManageAction extends BasicAction{
	
	private static final long serialVersionUID = 7921385919351615113L;
	private List<Payment> paymentList;
	private List<Supplier> supplierList;
	private List<SupplierType> supTypeList;
	private List<Account> accountList;
	private List<User> userList;
	private List<Supplier> supList;
	private Payment payment;
	private String supplierid;
	private SupplierService supplierService;
	private PaymentDao paymentDao;
	private AccountDao accountDao;
	
	private PaymentService paymentService;
	private UserManageService userManageService;
	private SupplierTypeService supplierTypeService;
	
	/**
	 * 跳转至列表界面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		getLists();
	    return "list";
	}
	
	/**
	 * 跳转至添加界面
	 * 
	 * @return
	 * @throws Exception
	 */
	 public String toAdd() throws Exception {
		// payment = paymentDao.selectByPrimaryKey(payment.getInvoiceid());
		 supplierList = supplierService.getSupplierList("");
		 accountList = accountDao.getList();
		 return "add";
	 }
	 
	 /**
	  * 添加付款单
	  * @throws Exception
	  */
	 public void add() throws Exception {
		
	        String userId = ((User) session.get("loginUser")).getUserid();
	        payment.setInputuserid(userId);

	        paymentService.insert(payment);
	        
	        response.sendRedirect("pay_list.do"); 
	 }
	 
	 /**
	  * 通过供应商查找账户
	  * @return
	  * @throws Exception
	  */
	 public String findPaymentBySupplier() throws Exception {
		// System.out.println("wafgafccccccccccccccccccccccccccccccccccccccccc"+supplierid);
		 paymentList = paymentDao.findPaymentBySupplier(supplierid);
		// 供应商类别列表1
		supTypeList = supplierTypeService.getTypeList();
		// 供应商列表
		supList = supplierService.getSupplierList("");
		//用戶列表
		userList = userManageService.getList();
		 return "list";
	 }
	 
	 /**
	  * 审核付款单
	  * @return
	  * @throws Exception
	  */
	 public String check() throws Exception {
		 payment = paymentDao.selectByPrimaryKey(payment.getInvoiceid());
		 
		// 取出当前登录用户ID,获得当前时间
		User user = new User();
		user = (User) session.get("loginUser");

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");// 设置日期格式
		// checkUserId, checkDate
		payment.setCheckuserid(user.getUserid());
		payment.setCheckdate(df.format(new Date()));
		// 更新状态 status = 已审
		payment.setStatus(Mobstockin.STAT_CHECKED);
		 paymentService.check(payment);
		 getLists();
		 return "list";
	 }
	 
	 /**
	  * 跳转至修改界面
	  * @return
	  * @throws Exception
	  */
	 public String toEdit() throws Exception {
		 // payment = paymentDao.selectByPrimaryKey(payment.getInvoiceid());
		 getLists();
		 payment = paymentDao.selectByPrimaryKey(payment.getInvoiceid());
		 return "edit";
	 }

	 /**
	  * 修改付款
	  * @return
	  * @throws Exception
	  */
	 public String editPay() throws Exception {
		 
		 paymentDao.updateByPrimaryKeySelective(payment);
		 getLists();
		 return "list";
	 }
	 
	 /**
	  * 删除
	  * @return
	  * @throws Exception
	  */
	 public String delete() throws Exception {
		 paymentDao.deleteByPrimaryKey(payment.getInvoiceid());
		 getLists();
		 return "list";
	 }
	 
	 /**
	  * 获取列表
	  * @throws Exception
	  */
	 private void getLists() throws Exception {
		 paymentList = paymentDao.getList();
		 
		// 供应商类别列表
		supTypeList = supplierTypeService.getTypeList();
		 //供应商
	     supList = supplierService.getSupplierList("");
		//用户列表
	     userList = userManageService.getList();
	     //账户列表
	     accountList = accountDao.getList();
	 } 
	 
	public List<Payment> getPaymentList() {
		return paymentList;
	}
	
	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

	public List<Supplier> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<Supplier> supplierList) {
		this.supplierList = supplierList;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
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

	public List<Supplier> getSupList() {
		return supList;
	}

	public void setSupList(List<Supplier> supList) {
		this.supList = supList;
	}

	public List<SupplierType> getSupTypeList() {
		return supTypeList;
	}

	public void setSupTypeList(List<SupplierType> supTypeList) {
		this.supTypeList = supTypeList;
	}

	public void setSupplierTypeService(SupplierTypeService supplierTypeService) {
		this.supplierTypeService = supplierTypeService;
	}

	public String getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}

}
