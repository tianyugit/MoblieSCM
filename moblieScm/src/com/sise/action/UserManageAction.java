package com.sise.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sise.dao.UserDao;
import com.sise.pojo.PageBean;
import com.sise.pojo.Pagination;
import com.sise.pojo.User;
import com.sise.service.UserManageService;
/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年11月1日 上午11:16:11
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
public class UserManageAction extends BasicAction{
	
	private List<User> userList;
	private User user;
	private PageBean<User> pb = new PageBean<User>();//分页bean
	private Integer offSet;//当前页
	private UserManageService userManageService;
	private UserDao userDao;
	/**
	 * 跳转至列表界面
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		User loginUser = (User) session.get("loginUser");
		//System.out.println(loginName);
		if("admin".equals(loginUser.getRole()) != true){
			response.sendRedirect("warn.do"); 
			return null;
		}
	/*	int n = userDao.getLong();
		pb.setTr(n);//设置分页总长度
		//userList = userManageService.getList();
		userList = userManageService.findAllWithFy(((offSet == null ? 1 : offSet) - 1) * 15, 15);//分页
		
		pb.setBeanList(userList);
		pb.setPc((offSet == null ? 1 : offSet));//设置当前页
		pb.setPs(15);//设置总长度
*/		//System.out.println(userList);
		Map map = new HashMap();
	    pagination = new Pagination();
		int pageLong = userDao.getLong();
		
		pagination.setPageIndex(pageIndex== null ? 1 : pageIndex );
		pagination.setPageSize(15);
		pagination.setTotalRecordCnt(pageLong);
		pagination.setUrl("user_list.do?");
		userList = userDao.findAllWithFy(((pageIndex== null ? 1 : pageIndex) - 1) * 15, 15);
		pagination.setDataList(userList);
		return "list";
	}
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception{
		User loginUser = (User) session.get("loginUser");
		if("admin".equals(loginUser.getRole()) != true){
			response.sendRedirect("warn.do"); 
			return null;
		}
		System.out.println(user.getUserid());
		user = userManageService.findUserById(user.getUserid());
		return "edit";
	}
	
	/**
	 * 更新用户
	 * @return
	 * @throws Exception
	 */
	public String updateUser() throws Exception{
		System.out.println(user);
		userManageService.updateUser(user);
		response.sendRedirect("user_list.do");
		return "list";
	}
	
	/**
	 * 查找用户
	 * @return
	 * @throws Exception
	 */
	public String findUser() throws Exception{
		System.out.println(user);
		userList = userManageService.findUser(user);
		System.out.println(userList);
		return "list";
	}
	/**
	 * 转至添加用户界面
	 * @return
	 * @throws Exception
	 */
	public String toAddUser() throws Exception{	
		User loginUser = (User) session.get("loginUser");
		//System.out.println(loginName);
		if("admin".equals(loginUser.getRole()) != true){
			response.sendRedirect("warn.do"); 
			return null;
		}
		//System.out.println(userManageService.findAllWithFy(0, 3));
		return "add";
	}
	
	/**
	 * 添加用户
	 * @return
	 * @throws Exception
	 */
	public String addUser() throws Exception{
		
		userManageService.addUser(user);
		userList = userManageService.getList();
		response.sendRedirect("user_list.do");
		return null;
	}
	
	/**
	 * 删除用户
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		userManageService.deleteUser(user.getUserid());
		response.sendRedirect("user_list.do");
		return "list";
	}

	public List<User> getUserList() {
		return userList;
	}
	
	public String findAllWithFy() throws Exception{
		
		
		
		return null;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
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

	public PageBean<User> getPb() {
		return pb;
	}

	public void setPb(PageBean<User> pb) {
		this.pb = pb;
	}

	public int getOffSet() {
		return offSet;
	}

	public void setOffSet(int offSet) {
		this.offSet = offSet;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
