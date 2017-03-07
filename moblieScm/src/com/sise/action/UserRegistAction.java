package com.sise.action;

import com.sise.pojo.User;
import com.sise.service.UserManageService;


/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年11月1日 上午11:16:32
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
public class UserRegistAction extends BasicAction{
	
	private static final long serialVersionUID = -5540272703578233677L;
 
	private UserManageService userManageService;
	private User user;
	
	/**
	 * 添加用户
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
		//1.校验用户名是否已经存在
		if(userManageService.findUserByName(user.getAccount())!=null){
			System.out.println(user.getRemark());
			request.setAttribute("msg", "<font color='red' size='3'>用户名已存在!</font>");
			//request.getRequestDispatcher("/regist.jsp").forward(request, response);
			///throw new RuntimeException("用户名已经存在!!");
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
