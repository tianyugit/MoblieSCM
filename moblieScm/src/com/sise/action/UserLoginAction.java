package com.sise.action;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.sise.pojo.User;
import com.sise.service.UserManageService;

/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年11月1日 上午11:15:56
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
@SuppressWarnings("serial")
public class UserLoginAction extends BasicAction{
	
	private User user;
	String msg;
	private UserManageService userManageService;
	
	public String execute() throws IOException{
		//System.out.println(user.getAccount());
		//1.校验验证码
		String valistr1 = user.getCvode();
		System.out.println(valistr1);
		String valistr2 = (String) ServletActionContext.getContext().getSession().get("valistr");
		if(valistr1 == null || valistr2 == null || !valistr1.equalsIgnoreCase(valistr2)){
			setMsg("<font color='red' size='3'>验证码不正确!</font>");
		//request.setAttribute("msg", "<font color='red'>验证码不正确!</font>");
		//request.getRequestDispatcher("/regist.jsp").forward(request, response);
		return LOGIN;
		}
		//System.out.println(user.getAccount());
		System.out.println(user.getStatus());
		String str = userManageService.finUserByNameAndPsw(user);
		//判断是否为空
		if(str != null ){
			if(str == "warn")//判断是否有权限
			{
				response.sendRedirect("warn2.do"); 
				return null;
			}else{
				setMsg(str);
				return LOGIN;
			}
		}
			session.remove("cvode");
			/*if("admin".equals(user.getAccount())){
				String str = userManageService.findAdminByNameAndPsw(user);
				if(str != null)
				{
					setMsg(str);
					return LOGIN;
				}
			session.put("loginUser", user);
			}else{
			session.put("loginUser", user.getAccount());
			}*/
			user = userManageService.findUserByName(user.getAccount());
			session.put("loginUser", user);
			System.out.println(user);
			userManageService.updateLoginTime(user.getAccount());
			response.sendRedirect("home.do"); 
		return null;
	}

	/**
	 * 注销
	 * @throws Exception
	 */
	 public void logout() throws Exception {
	        request.getSession().invalidate();
	        PrintWriter out = response.getWriter();
	        out.print("<script type='text/javascript'>top.location='start.do'</script>");
	        out.close();
	    }
	 
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setUserManageService(UserManageService userManageService) {
		this.userManageService = userManageService;
	}

	
}
