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
 * �汾:1.0
 *
 *��������:2016��11��1�� ����11:16:11
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
public class UserManageAction extends BasicAction{
	
	private List<User> userList;
	private User user;
	private PageBean<User> pb = new PageBean<User>();//��ҳbean
	private Integer offSet;//��ǰҳ
	private UserManageService userManageService;
	private UserDao userDao;
	/**
	 * ��ת���б����
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
		pb.setTr(n);//���÷�ҳ�ܳ���
		//userList = userManageService.getList();
		userList = userManageService.findAllWithFy(((offSet == null ? 1 : offSet) - 1) * 15, 15);//��ҳ
		
		pb.setBeanList(userList);
		pb.setPc((offSet == null ? 1 : offSet));//���õ�ǰҳ
		pb.setPs(15);//�����ܳ���
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
	 * �޸�
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
	 * �����û�
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
	 * �����û�
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
	 * ת������û�����
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
	 * ����û�
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
	 * ɾ���û�
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
