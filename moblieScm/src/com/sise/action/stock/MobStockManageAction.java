package com.sise.action.stock;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import com.sise.action.BasicAction;
import com.sise.dao.sup.MobstockDao;
import com.sise.pojo.Mobstock;
import com.sise.pojo.Mobtype;
import com.sise.pojo.StoCount;
import com.sise.service.MobTypeService;

/**
 * ========================================================================
 * 
 * �汾:1.0
 *
 *��������:2016��12��01�� ����11:31:10
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
@SuppressWarnings({ "unchecked" })
public class MobStockManageAction extends BasicAction{
	
	private static final long serialVersionUID = -4308514620781959646L;
	private List<StoCount> countList;
	 private List<Mobstock> detailList;
	 private List<Mobtype> mobTypeList;
	 private String mobtypeid;
	 private String detailType;
	 private MobTypeService mobTypeService;
	 private MobstockDao mobstockDao;
	 /**
	 * ��ת���б����
	 * @return
	 * @throws Exception
	 */
	 public String list() throws Exception {
		 countList = mobstockDao.countMobtype();
		// �ֻ��ͺ��б�
		mobTypeList = mobTypeService.queryList("");
	        return "list";
	  }
	 /**
	  * ת����ʾ�����б�
	  * @return
	  * @throws Exception
	  */
	 public String showDetail() throws Exception {
		 countList = mobstockDao.countMobtype();
		 detailList = mobstockDao.findmobStockBymobTypeId(mobtypeid);
		 
		 return "detail";
	 }
	 
	 @SuppressWarnings("deprecation")
	public void downloadExcel() throws Exception {
		 detailList = mobstockDao.findmobStockBymobTypeId(mobtypeid);
		//2.�����۰���Ϣ��֯��csv��ʽ������
		StringBuffer buffer = new StringBuffer();
		String str = "���ͱ��,����һ,���Ŷ�,����\r\n";
		///str = new String(str.getBytes("UTF-8"),"GBK");
		buffer.append(str);
		for (Mobstock si : detailList) {
			buffer.append(si.getMobtypeid() + "," + si.getSn1() + "," + si.getSn2() + "," + si.getBuyprice()+"\r\n");
		}
		String data = buffer.toString();
		
		//3.�ṩ����
		String filename = "�ֻ������ϸ_"+new Date().toLocaleString()+".csv";
		response.setCharacterEncoding("GBK");
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename,"GBK"));
		response.setContentType(application.getMimeType(filename));
		response.getWriter().write(data);
	 }

	public List<StoCount> getCountList() {
		return countList;
	}

	public void setCountList(List<StoCount> countList) {
		this.countList = countList;
	}

	public List<Mobstock> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<Mobstock> detailList) {
		this.detailList = detailList;
	}

	public String getMobtypeid() {
		return mobtypeid;
	}

	public void setMobtypeid(String mobtypeid) {
		this.mobtypeid = mobtypeid;
	}

	public String getDetailType() {
		return detailType;
	}

	public void setDetailType(String detailType) {
		this.detailType = detailType;
	}

	public void setMobstockDao(MobstockDao mobstockDao) {
		this.mobstockDao = mobstockDao;
	}
	public List<Mobtype> getMobTypeList() {
		return mobTypeList;
	}
	public void setMobTypeList(List<Mobtype> mobTypeList) {
		this.mobTypeList = mobTypeList;
	}
	public void setMobTypeService(MobTypeService mobTypeService) {
		this.mobTypeService = mobTypeService;
	}
	 
}
