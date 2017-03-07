package com.sise.action.cust;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;













import com.sise.action.BasicAction;
import com.sise.dao.AccountDao;
import com.sise.dao.cust.CustPayeeDao;
import com.sise.dao.sup.PaymentDao;
import com.sise.pojo.Account;
import com.sise.pojo.CustPayee;
import com.sise.pojo.Customer;
import com.sise.pojo.Customertype;
import com.sise.pojo.Mobstockin;
import com.sise.pojo.Payment;
import com.sise.pojo.Supplier;
import com.sise.pojo.SupplierType;
import com.sise.pojo.User;
import com.sise.service.CustomerService;
import com.sise.service.CustomertypeService;
import com.sise.service.PaymentService;
import com.sise.service.SupplierService;
import com.sise.service.SupplierTypeService;
import com.sise.service.UserManageService;
import com.sise.service.cust.PayeeService;

/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年12月8日 下午1:06:04
 *
 *作者:马天宇
 *
 *描述:客户收款类
 *
 *
 *版权:T世界版权所有(c) 2016
 *
 *==========================================================================
 */
public class PayeeManageAction extends BasicAction{
	
	private static final long serialVersionUID = 7921385919351615113L;
	private List<CustPayee> custPayeeList;
	private List<Customer> customerList;
	private List<Customertype> customertypeList;
	private List<Account> accountList;
	private List<User> userList;
	//private List<Supplier> supList;
	private CustPayee custPayee;
	private String custid;
	private CustomerService customerService;
	private CustPayeeDao custPayeeDao;
	private AccountDao accountDao;
	
	private PayeeService payeeService;
	private UserManageService userManageService;
	private CustomertypeService customertypeService;
	
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
		 customerList = customerService.queryList();
		 accountList = accountDao.getList();
		 return "add";
	 }
	 
	 /**
	  * 添加付款单
	  * @throws Exception
	  */
	 public void add() throws Exception {
		
	        String userId = ((User) session.get("loginUser")).getUserid();
	        custPayee.setInputuserid(userId);

	        payeeService.insert(custPayee);
	        
	        response.sendRedirect("payee_list.do"); 
	 }
	 
	 /**
	  * 通过供应商查找账户
	  * @return
	  * @throws Exception
	  */
	 public String findPaymentByCust() throws Exception {
		// System.out.println("wafgafccccccccccccccccccccccccccccccccccccccccc"+supplierid);
		 custPayeeList = custPayeeDao.findPaymentByCust(custid);
		// 客户列表
		 customerList = customerService.queryList();
		// 客户类别列表列表
		 customertypeList = customertypeService.getTypeList();
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
		 custPayee = custPayeeDao.selectByPrimaryKey(custPayee.getInvoiceid());
		 
		// 取出当前登录用户ID,获得当前时间
		User user = new User();
		user = (User) session.get("loginUser");

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");// 设置日期格式
		// checkUserId, checkDate
		custPayee.setCheckuserid(user.getUserid());
		custPayee.setCheckdate(df.format(new Date()));
		// 更新状态 status = 已审
		custPayee.setStatus(Mobstockin.STAT_CHECKED);
		payeeService.check(custPayee);
		 getLists();
		 return "list";
	 }
	 
	 /**
	  * 跳转至修改界面
	  * @return
	  * @throws Exception
	  */
	 public String toEdit() throws Exception {
		
		 getLists();
		 custPayee = custPayeeDao.selectByPrimaryKey(custPayee.getInvoiceid());
		 return "edit";
	 }

	 /**
	  * 修改付款
	  * @return
	  * @throws Exception
	  */
	 public String editPay() throws Exception {
		 
		 custPayeeDao.updateByPrimaryKeySelective(custPayee);
		 getLists();
		 return "list";
	 }
	 
	 /**
	  * 删除
	  * @return
	  * @throws Exception
	  */
	 public String delete() throws Exception {
		 custPayeeDao.deleteByPrimaryKey(custPayee.getInvoiceid());
		 getLists();
		 return "list";
	 }
	 
	 /**
	  * 获取列表
	  * @throws Exception
	  */
	 private void getLists() throws Exception {
		 custPayeeList = custPayeeDao.getList();
		 
		// 客户列表
		 customerList = customerService.queryList();
		 //供应商
	    // supList = supplierService.getSupplierList("");
		//用户列表
	     userList = userManageService.getList();
	     //账户列表
	     accountList = accountDao.getList();
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

	public List<CustPayee> getCustPayeeList() {
		return custPayeeList;
	}

	public void setCustPayeeList(List<CustPayee> custPayeeList) {
		this.custPayeeList = custPayeeList;
	}

	public CustPayee getCustPayee() {
		return custPayee;
	}

	public void setCustPayee(CustPayee custPayee) {
		this.custPayee = custPayee;
	}

	public void setCustPayeeDao(CustPayeeDao custPayeeDao) {
		this.custPayeeDao = custPayeeDao;
	}

	public void setPayeeService(PayeeService payeeService) {
		this.payeeService = payeeService;
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

	
	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public List<Customertype> getCustomertypeList() {
		return customertypeList;
	}

	public void setCustomertypeList(List<Customertype> customertypeList) {
		this.customertypeList = customertypeList;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setCustomertypeService(CustomertypeService customertypeService) {
		this.customertypeService = customertypeService;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

}
