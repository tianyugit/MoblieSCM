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
 * �汾:1.0
 *
 *��������:2016��11��7�� ����11:12:46
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
public class BasicAction extends ActionSupport implements ServletResponseAware,
        ServletRequestAware, ServletContextAware {

    private static final long serialVersionUID = -7493241864514155959L;

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext application;
    protected Map<String, Object> session = ActionContext.getContext()
            .getSession();

   //����Ĵ���map
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
