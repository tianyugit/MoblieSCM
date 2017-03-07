package com.sise.Interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.sise.pojo.User;


public class LoginInterceptor implements Interceptor {

	private static final long serialVersionUID = -4032819380131621209L;
	String allowAction;
	
	public String getAllowAction() {
		return allowAction;
	}

	public void setAllowAction(String allowAction) {
		this.allowAction = allowAction;
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}

	public String intercept(ActionInvocation invocation) throws Exception {
		
	
		String currentActionName = invocation.getInvocationContext().getName();
		System.out.println("À¹½Ø³É¹¦  "+currentActionName);
		for(String name : allowAction.split(",")){
			
			if(name.equals(currentActionName)){
			//    System.out.println("111111111");
				return invocation.invoke();
			}
		}
		
		User user = (User) ActionContext.getContext().getSession().get("loginUser");
	//	System.out.println("userId="+userId);
		if(user == null){
		
			return Action.LOGIN;
		}else {
			return invocation.invoke();
		}
	}

}
