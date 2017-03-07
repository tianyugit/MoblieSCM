package com.sise.action.stock;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import com.sise.action.BasicAction;
import com.sise.dao.sup.AccstockDao;
import com.sise.pojo.AccStock;
import com.sise.pojo.Accessorytype;
import com.sise.pojo.Mobstock;
import com.sise.pojo.Mobtype;
import com.sise.pojo.StoCount;
import com.sise.service.AccessoryTypeService;
import com.sise.service.MobTypeService;

/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年12月01日 上午11:30:57
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
@SuppressWarnings({ "unused" })
public class AccStockManageAction extends BasicAction{


	private static final long serialVersionUID = 5582016571376892349L;
	private List<StoCount> countList;
	private List<AccStock> detailList;
	private List<Accessorytype> accessorytypeList;
	private String accessorytypeid;
	private String detailType;
	private AccstockDao accstockDao;
	private AccessoryTypeService accessoryTypeService;
	/**
	 * 跳转至列表界面
	 * @return
	 * @throws Exception
	 */
	 public String list() throws Exception {
		// countList = mobstockDao.countMobtype();
		 countList = accstockDao.countAccType();
		 
		// 配件型号列表
		 accessorytypeList = accessoryTypeService.getTypeList();
	        return "list";
	  }
	 /**
	  * 显示细节
	  * @return
	  * @throws Exception
	  */
	 public String showDetail() throws Exception {
		// countList = mobstockDao.countMobtype();
		// detailList = mobstockDao.findmobStockBymobTypeId(mobtypeid);
		 countList = accstockDao.countAccType();
		 detailList = accstockDao.findmobStockByaccTypeId(accessorytypeid);
		 return "detail";
	 }
	 
	 @SuppressWarnings("deprecation")
	public void downloadExcel() throws Exception {
		 detailList = accstockDao.findmobStockByaccTypeId(accessorytypeid);
		//2.将销售榜单信息组织称csv格式的数据
		StringBuffer buffer = new StringBuffer();
		String str = "机型编号,SN码,进价\r\n";
		///str = new String(str.getBytes("UTF-8"),"GBK");
		buffer.append(str);
		for (AccStock si : detailList) {
			buffer.append(si.getAccessorytypeid() + "," + si.getSn() +  "," + si.getBuyprice()+"\r\n");
		}
		String data = buffer.toString();
		
		//3.提供下载
		String filename = "配件库存详细_"+new Date().toLocaleString()+".csv";
		response.setCharacterEncoding("GBK");
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename,"GBK"));
		response.setContentType(application.getMimeType(filename));
		response.getWriter().write(data);
	 }
	 
	public void setAccstockDao(AccstockDao accstockDao) {
		this.accstockDao = accstockDao;
	}
	public List<StoCount> getCountList() {
		return countList;
	}
	public void setCountList(List<StoCount> countList) {
		this.countList = countList;
	}
	public List<AccStock> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<AccStock> detailList) {
		this.detailList = detailList;
	}
	public String getAccessorytypeid() {
		return accessorytypeid;
	}
	public void setAccessorytypeid(String accessorytypeid) {
		this.accessorytypeid = accessorytypeid;
	}
	public String getDetailType() {
		return detailType;
	}
	public void setDetailType(String detailType) {
		this.detailType = detailType;
	}
	public List<Accessorytype> getAccessorytypeList() {
		return accessorytypeList;
	}
	public void setAccessorytypeList(List<Accessorytype> accessorytypeList) {
		this.accessorytypeList = accessorytypeList;
	}
	public void setAccessoryTypeService(AccessoryTypeService accessoryTypeService) {
		this.accessoryTypeService = accessoryTypeService;
	} 

}
