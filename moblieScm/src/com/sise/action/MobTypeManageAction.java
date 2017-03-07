package com.sise.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sise.dao.BonustypeDao;
import com.sise.dao.BrandDao;
import com.sise.pojo.Mobtype;
import com.sise.service.MobTypeService;

/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年11月20日 上午11:15:16
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
@SuppressWarnings({ "unchecked", "rawtypes" })
public class MobTypeManageAction extends BasicAction{

	private static final long serialVersionUID = 3864898428065070881L;
	private Mobtype mobType;
    private List brandList;
    private List bonusTypeList;
    private List mobTypeList;
    private BrandDao brandDao;
    private List<Map> mobBonusList;
    private BonustypeDao bonustypeDao;
    private MobTypeService mobTypeService;

    /**
	 * 跳转至列表界面
	 * @return
	 * @throws Exception
	 */
    public String list() throws Exception {
        getLists();
        return "list";
    }

    /**
     * 获取需要的列表
     * @throws Exception
     */
	private void getLists() throws Exception {
		//手机品牌列表
		brandList = brandDao.queryList();
		//手机型号列表
        mobTypeList = mobTypeService.queryList("");
	}

    /*
     * 转到添加界面
     */
    public String toAdd() throws Exception {
    	//手机品牌列表
    	brandList = brandDao.queryList();
    	//返价类型列表
    	bonusTypeList = bonustypeDao.queryList();

        return "add";
    }

    /**
     * 转至修改界面
     * @return
     * @throws Exception
     */
    
	public String toEdit() throws Exception {

        // 型号详情
        Map paraMap = new HashMap();
        paraMap.put("mobType", mobType);
        //获取要修改的手机型号
        mobType = mobTypeService.selectMobTypeByMobtypeid(mobType.getMobtypeid());
        // 已设返利价格
        mobBonusList = mobTypeService.getBonus(mobType.getMobtypeid());
       
      //返价类型列表
        bonusTypeList = bonustypeDao.queryList();
        getLists();
        return "edit";
        
    }
    
    /**
     * 添加
     * @return
     * @throws Exception
     */
    public String addType() throws Exception {
    	System.out.println(mobType);
        mobTypeService.addType(mobType);
      
        return "list";
    }

    /**
     * 编辑类型
     * @throws Exception
     */
    public void editType() throws Exception {
        mobTypeService.editType(mobType);
        response.sendRedirect("mobType_list.do");
    }

    /**
     * 删除类别
     * @return
     * @throws Exception
     */
    public String delType() throws Exception {
        mobTypeService.delType(mobType.getMobtypeid());
        getLists();
        return "list";
    }

    /**
     * 显示返利详细数据
     * @return
     * @throws Exception
     */
    public String viewBonus() throws Exception {
        mobBonusList = mobTypeService.getBonus(mobType.getMobtypeid());
        return "viewBonus";
    }
    
    /**
     * 显示返利详细数据
     * @return
     * @throws Exception
     */
    public String findMobtypeBySelected() throws Exception {
    	Map<String,String> map = new LinkedHashMap<String,String>();
    	map.put("brand", "%" + mobType.getBrand() + "%");
    	map.put("mobtypename", "%" + mobType.getMobtypename() + "%");
    	mobTypeList = mobTypeService.findMobtypeBySelected(map);
    	//手机品牌列表
		brandList = brandDao.queryList();
    	
    	return "list";
    }
    
    

    public List getBrandList() {
        return brandList;
    }

    public void setBrandList(List brandList) {
		this.brandList = brandList;
	}

	public List getBonusTypeList() {
        return bonusTypeList;
    }
	
    public void setBonusTypeList(List bonusTypeList) {
		this.bonusTypeList = bonusTypeList;
	}

	public void setMobTypeService(MobTypeService mobTypeService) {
        this.mobTypeService = mobTypeService;
    }

    public List<Map> getMobBonusList() {
        return mobBonusList;
    }

	public void setBrandDao(BrandDao brandDao) {
		this.brandDao = brandDao;
	}


	public void setBonustypeDao(BonustypeDao bonustypeDao) {
		this.bonustypeDao = bonustypeDao;
	}

	public List getMobTypeList() {
		return mobTypeList;
	}

	public void setMobTypeList(List mobTypeList) {
		this.mobTypeList = mobTypeList;
	}
	public Mobtype getMobType() {
		return mobType;
	}
	
	public void setMobType(Mobtype mobType) {
		this.mobType = mobType;
	}

}
