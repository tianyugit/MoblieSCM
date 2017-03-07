package com.sise.action;

import com.sise.pojo.User;
import com.sise.service.UserManageService;


/**
 * ========================================================================
 * 
 * �汾:1.0
 *
 *��������:2016��11��1�� ����11:16:32
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
public class UserRegistAction extends BasicAction{
	
	private static final long serialVersionUID = -5540272703578233677L;
 
	private UserManageService userManageService;
	private User user;
	
	/**
	 * ����û�
	 * @return
	 * @throws Exception
	 */
	public String addUser() throws Exception {
		//String ss = request.getAttribute("user.account");
		/*String ss =request.getParameter("user.account");
		System.out.println(ss);*/
		System.out.println(user.getAccount());
		System.out.println(user.getPasswd());
		System.out.println(user.getRemark());
		//1.У���û����Ƿ��Ѿ�����
		if(userManageService.findUserByName(user.getAccount())!=null){
			System.out.println(user.getRemark());
			request.setAttribute("msg", "<font color='red' size='3'>�û����Ѵ���!</font>");
			//request.getRequestDispatcher("/regist.jsp").forward(request, response);
			///throw new RuntimeException("�û����Ѿ�����!!");
			return "regist";
		}
		userManageService.regist(user);
		//session.put("loginUser", user);
        return SUCCESS;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserManageService(UserManageService userManageService) {
		this.userManageService = userManageService;
	}

}
