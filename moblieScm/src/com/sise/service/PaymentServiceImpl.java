package com.sise.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sise.dao.AccountDao;
import com.sise.dao.sup.PaymentDao;
import com.sise.pojo.Account;
import com.sise.pojo.Payment;

public class PaymentServiceImpl implements PaymentService{
	
	private PaymentDao paymentDao;
	private AccountDao accountDao;
	private Account account;
	
	public void insert(Payment payment) {
		payment.setInvoiceid("MIS-"
	                + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");//设置日期格式
        payment.setStatus(Payment.STAT_NOTCHECK);
        payment.setInputdate(df.format(new Date()));
        paymentDao.insert(payment);
       
	}

	public void check(Payment payment) {
		int num = paymentDao.updateByPrimaryKeySelective(payment);
		if(num == 1){
			 account = new Account();
		     account = accountDao.selectByPrimaryKey(payment.getAccountid());
		     account.setBalance(account.getBalance().subtract(payment.getPaymoney()));
		     accountDao.updateByPrimaryKeySelective(account);
		}
	}
	
	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}


}
