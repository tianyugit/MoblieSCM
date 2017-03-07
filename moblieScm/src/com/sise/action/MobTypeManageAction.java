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
 * �汾:1.0
 *
 *��������:2016��11��20�� ����11:15:16
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
	 * ��ת���б����
	 * @return
	 * @throws Exception
	 */
    public String list() throws Exception {
        getLists();
        return "list";
    }

    /**
     * ��ȡ��Ҫ���б�
     * @throws Exception
     */
	private void getLists() throws Exception {
		//�ֻ�Ʒ���б�
		brandList = brandDao.queryList();
		//�ֻ��ͺ��б�
        mobTypeList = mobTypeService.queryList("");
	}

    /*
     * ת����ӽ���
     */
    public String toAdd() throws Exception {
    	//�ֻ�Ʒ���б�
    	brandList = brandDao.queryList();
    	//���������б�
    	bonusTypeList = bonustypeDao.queryList();

        return "add";
    }

    /**
     * ת���޸Ľ���
     * @return
     * @throws Exception
     */
    
	public String toEdit() throws Exception {

        // �ͺ�����
        Map paraMap = new HashMap();
        paraMap.put("mobType", mobType);
        //��ȡҪ�޸ĵ��ֻ��ͺ�
        mobType = mobTypeService.selectMobTypeByMobtypeid(mobType.getMobtypeid());
        // ���践���۸�
        mobBonusList = mobTypeService.getBonus(mobType.getMobtypeid());
       
      //���������б�
        bonusTypeList = bonustypeDao.queryList();
        getLists();
        return "edit";
        
    }
    
    /**
     * ���
     * @return
     * @throws Exception
     */
    public String addType() throws Exception {
    	System.out.println(mobType);
        mobTypeService.addType(mobType);
      
        return "list";
    }

    /**
     * �༭����
     * @throws Exception
     */
    public void editType() throws Exception {
        mobTypeService.editType(mobType);
        response.sendRedirect("mobType_list.do");
    }

    /**
     * ɾ�����
     * @return
     * @throws Exception
     */
    public String delType() throws Exception {
        mobTypeService.delType(mobType.getMobtypeid());
        getLists();
        return "list";
    }

    /**
     * ��ʾ������ϸ����
     * @return
     * @throws Exception
     */
    public String viewBonus() throws Exception {
        mobBonusList = mobTypeService.getBonus(mobType.getMobtypeid());
        return "viewBonus";
    }
    
    /**
     * ��ʾ������ϸ����
     * @return
     * @throws Exception
     */
    public String findMobtypeBySelected() throws Exception {
    	Map<String,String> map = new LinkedHashMap<String,String>();
    	map.put("brand", "%" + mobType.getBrand() + "%");
    	map.put("mobtypename", "%" + mobType.getMobtypename() + "%");
    	mobTypeList = mobTypeService.findMobtypeBySelected(map);
    	//�ֻ�Ʒ���б�
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
