package com.sise.service.cust;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sise.dao.AccountDao;
import com.sise.dao.cust.CustPayeeDao;
import com.sise.pojo.Account;
import com.sise.pojo.CustPayee;
import com.sise.pojo.Payment;

public class PayeeServiceImpl implements PayeeService{
	
	private CustPayeeDao custPayeeDao;
	private AccountDao accountDao;
	private Account account;
	
	public void insert(CustPayee custPayee) {
		custPayee.setInvoiceid("MIS-"
	                + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");//设置日期格式
        custPayee.setStatus(Payment.STAT_NOTCHECK);
        custPayee.setInputdate(df.format(new Date()));
        custPayeeDao.insert(custPayee);
       
	}

	public void check(CustPayee custPayee) {
		int num = custPayeeDao.updateByPrimaryKeySelective(custPayee);
		if(num == 1){
			 account = new Account();
		     account = accountDao.selectByPrimaryKey(custPayee.getPayaccount());
		     account.setBalance(account.getBalance().add(custPayee.getIncomemoney()));
		     accountDao.updateByPrimaryKeySelective(account);
		}
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setCustPayeeDao(CustPayeeDao custPayeeDao) {
		this.custPayeeDao = custPayeeDao;
	}


}
