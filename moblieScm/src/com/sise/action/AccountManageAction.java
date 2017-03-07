package com.sise.action;

import java.util.List;

import com.sise.dao.AccountDao;
import com.sise.pojo.Account;

/**
 * ========================================================================
 * 
 * �汾:1.0
 *
 *��������:2016��11��25�� ����11:17:06
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
public class AccountManageAction extends BasicAction{

	private static final long serialVersionUID = -4802646373108714484L;
	private Account account;
	private List<Account> accountList;
	private AccountDao accountDao;
	
	/**
	 * ��ת���б����
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		accountList = accountDao.getList();
	        return "list";
    }

	/*
     * ת����ӽ���
     */
    public String toAdd() throws Exception {
	        return "add";
    }
    
    /**
     * ����˻�
     * @return
     * @throws Exception
     */
    public String addAcc() throws Exception {
	     //   bonustype.setBonustypeid(StringUtils.uniqueKey());
	     //   dao.addObj("bonusType.addType", bonustype);
    	accountDao.insert(account);
	    response.sendRedirect("account_list.do");
	        return null;
	    }

    /**
     * ת���޸Ľ���
     * @return
     * @throws Exception
     */
    public String toEdit() throws Exception {
     //   bonustype = (Bonustype) dao.queryObject("bonusType.getTypeById",
      //          bonustype.getBonustypeid());
    	account = accountDao.selectByPrimaryKey(account.getAccountid());
        return "edit";
    }

    public String editAcc() throws Exception {
      //  dao.editObj("bonusType.editType", bonustype);
    	accountDao.updateByPrimaryKey(account);
    	response.sendRedirect("account_list.do");
        return null;
    }

    /**
     * ɾ���ʻ�
     * @return
     * @throws Exception
     */
    public String delAcc() throws Exception {
       // dao.del("bonusType.delType", bonustype.getBonustypeid());
    	accountDao.deleteByPrimaryKey(account.getAccountid());
    	response.sendRedirect("account_list.do");
        return null;
    }

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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
	    
	    
	    

}
