package com.sise.action;

import java.util.List;

/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年11月12日 上午11:10:46
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
import com.sise.dao.BonustypeDao;
import com.sise.pojo.Bonustype;

/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年11月13日 上午11:10:46
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
@SuppressWarnings({ "rawtypes" })
public class BonusTypeManageAction extends BasicAction{
	
	 private static final long serialVersionUID = -6250938161354629258L;
	 private Bonustype bonustype;
	 private BonustypeDao bonustypeDao;
	 private List bonustypeList;
	 
	 /**
		 * 跳转至列表界面
		 * @return
		 * @throws Exception
		 */
	 public String list() throws Exception {
		 bonustypeList = bonustypeDao.queryList();
		 System.out.println(bonustypeList);
	        return "list";
	    }

	 	/*
	     * 转到添加界面
	     */
	    public String toAdd() throws Exception {
	        return "add";
	    }

	    /**
	     * 添加类型
	     * @return
	     * @throws Exception
	     */
	    public String addType() throws Exception {
	     //   bonustype.setBonustypeid(StringUtils.uniqueKey());
	     //   dao.addObj("bonusType.addType", bonustype);
	    	bonustypeDao.insert(bonustype);
	    	response.sendRedirect("bonusType_list.do");
	        return null;
	    }

	    /**
	     * 转到修改界面
	     * @return
	     * @throws Exception
	     */
	    public String toEdit() throws Exception {
	     //   bonustype = (Bonustype) dao.queryObject("bonusType.getTypeById",
	      //          bonustype.getBonustypeid());
	    	bonustype = bonustypeDao.selectByPrimaryKey(bonustype.getBonustypeid());
	        return "edit";
	    }

	    /**
	     * 修改类型
	     * @return
	     * @throws Exception
	     */
	    public String editType() throws Exception {
	      //  dao.editObj("bonusType.editType", bonustype);
	    	bonustypeDao.updateByPrimaryKey(bonustype);
	    	response.sendRedirect("bonusType_list.do");
	        return null;
	    }

	    /**
	     * 删除类别
	     * @return
	     * @throws Exception
	     */
	    public String delType() throws Exception {
	       // dao.del("bonusType.delType", bonustype.getBonustypeid());
	    	bonustypeDao.deleteByPrimaryKey(bonustype.getBonustypeid());
	    	response.sendRedirect("bonusType_list.do");
	        return null;
	    }

		public Bonustype getBonustype() {
			return bonustype;
		}

		public void setBonustype(Bonustype bonustype) {
			this.bonustype = bonustype;
		}

		public void setBonustypeDao(BonustypeDao bonustypeDao) {
			this.bonustypeDao = bonustypeDao;
		}

		public List getBonustypeList() {
			return bonustypeList;
		}

		public void setBonustypeList(List bonustypeList) {
			this.bonustypeList = bonustypeList;
		}

	   

}
