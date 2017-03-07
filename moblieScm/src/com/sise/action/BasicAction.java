package com.sise.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sise.pojo.Pagination;

/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年11月7日 上午11:12:46
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
public class BasicAction extends ActionSupport implements ServletResponseAware,
        ServletRequestAware, ServletContextAware {

    private static final long serialVersionUID = -7493241864514155959L;

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext application;
    protected Map<String, Object> session = ActionContext.getContext()
            .getSession();

   //保存的错误map
    protected Map<String, String> errMap = new HashMap<String, String>();

    protected Integer pageIndex;
    protected Pagination pagination;
    
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setServletContext(ServletContext application) {
        this.application = application;
    }

   
    public Map<String, String> getErrMap() {
        return errMap;
    }

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

}
