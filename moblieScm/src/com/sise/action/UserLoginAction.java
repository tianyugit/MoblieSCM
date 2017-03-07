package com.sise.action;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.sise.pojo.User;
import com.sise.service.UserManageService;

/**
 * ========================================================================
 * 
 * �汾:1.0
 *
 *��������:2016��11��1�� ����11:15:56
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
@SuppressWarnings("serial")
public class UserLoginAction extends BasicAction{
	
	private User user;
	String msg;
	private UserManageService userManageService;
	
	public String execute() throws IOException{
		//System.out.println(user.getAccount());
		//1.У����֤��
		String valistr1 = user.getCvode();
		System.out.println(valistr1);
		String valistr2 = (String) ServletActionContext.getContext().getSession().get("valistr");
		if(valistr1 == null || valistr2 == null || !valistr1.equalsIgnoreCase(valistr2)){
			setMsg("<font color='red' size='3'>��֤�벻��ȷ!</font>");
		//request.setAttribute("msg", "<font color='red'>��֤�벻��ȷ!</font>");
		//request.getRequestDispatcher("/regist.jsp").forward(request, response);
		return LOGIN;
		}
		//System.out.println(user.getAccount());
		System.out.println(user.getStatus());
		String str = userManageService.finUserByNameAndPsw(user);
		//�ж��Ƿ�Ϊ��
		if(str != null ){
			if(str == "warn")//�ж��Ƿ���Ȩ��
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
	 * ע��
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
