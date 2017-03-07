package com.sise.action;

import java.util.List;

/**
 * ========================================================================
 * 
 * �汾:1.0
 *
 *��������:2016��11��12�� ����11:10:46
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
import com.sise.dao.BonustypeDao;
import com.sise.pojo.Bonustype;

/**
 * ========================================================================
 * 
 * �汾:1.0
 *
 *��������:2016��11��13�� ����11:10:46
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
@SuppressWarnings({ "rawtypes" })
public class BonusTypeManageAction extends BasicAction{
	
	 private static final long serialVersionUID = -6250938161354629258L;
	 private Bonustype bonustype;
	 private BonustypeDao bonustypeDao;
	 private List bonustypeList;
	 
	 /**
		 * ��ת���б����
		 * @return
		 * @throws Exception
		 */
	 public String list() throws Exception {
		 bonustypeList = bonustypeDao.queryList();
		 System.out.println(bonustypeList);
	        return "list";
	    }

	 	/*
	     * ת����ӽ���
	     */
	    public String toAdd() throws Exception {
	        return "add";
	    }

	    /**
	     * �������
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
	     * ת���޸Ľ���
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
	     * �޸�����
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
	     * ɾ�����
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
