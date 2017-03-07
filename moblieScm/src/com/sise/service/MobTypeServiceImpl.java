package com.sise.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sise.dao.BonustypeDao;
import com.sise.dao.MobtonusDao;
import com.sise.dao.MobtypeDao;
import com.sise.pojo.Bonustype;
import com.sise.pojo.MobTonus;
import com.sise.pojo.Mobtype;
import com.sise.utils.StringUtils;

public class MobTypeServiceImpl implements MobTypeService {
	
	private MobtypeDao mobtypeDao;
	private MobtonusDao mobtonusDao;
	private BonustypeDao bonusTypeDao;
	private List<MobTonus> bonusPriceList;

    public void addType(Mobtype mobType) throws Exception {

    /*    dao.addObj("mobType.addType", mobType);
        dao.batchInsert("mobType.addBonusPrice", getBonusPriceList(mobType));*/
    	//System.out.println(mobType);
    	
    	mobtypeDao.insert(mobType);
    	getBonusPriceList(mobType);
    	/*ListIterator lit = bonusPriceList.listIterator();
    	MobTonus bonusPrice = new MobTonus();
    	while(lit.hasNext()){
    		bonusPrice = (MobTonus) lit.next();
    		System.out.println(bonusPrice);
    		
    	}*/
    }

    public void editType(Mobtype mobType) throws Exception {

       /* dao.editObj("mobType.editType", mobType);

        dao.del("mobType.delBonusPrice", mobType.getMobtypeid());

        dao.batchInsert("mobType.addBonusPrice", getBonusPriceList(mobType));*/
    	
    	mobtypeDao.updateByPrimaryKeySelective(mobType);
    	mobtonusDao.deleteByMobtypeid(mobType.getMobtypeid());
    	getBonusPriceList(mobType);

    }

    public void delType(String mobtypeid) throws SQLException {
      /*  dao.del("mobType.delType", mobtypeid);
        dao.del("mobType.delBonusPrice", mobtypeid);*/
    	mobtonusDao.deleteByMobtypeid(mobtypeid);
    	mobtypeDao.deleteByPrimaryKey(mobtypeid);
    }
    
    

    @SuppressWarnings("unused")
	private void updaeteBonusPriceList(Mobtype mobType) throws Exception {
    	List<MobTonus> bonusPriceList = new ArrayList<MobTonus>();
    	// String[] bonusList = mobType.getBonusList();
    	
    	System.out.println("+++0");
    	for (String  ee : mobType.getBonusList()) {
    		MobTonus bonusPrice = new MobTonus();
    		String str[] = ee.split("\\,");
    		//	System.out.println(ee);
    		//System.out.println("++当时的时代+++"+str[0]);
    		//System.out.println("money:"+Double.valueOf(str[1]));
    		Bonustype bonusType = bonusTypeDao.findBonustypeByName(str[0]);
    		bonusPrice.setId(StringUtils.uniqueKey());
    		bonusPrice.setMobTypeId(mobType.getMobtypeid());
    		bonusPrice.setBonusTypeId(bonusType.getBonustypeid());
    		bonusPrice.setMoney(Double.valueOf(str[1]));
    		mobtonusDao.updateByPrimaryKeySelective(bonusPrice);
    	}
    	/*for (String strBonus : bonusList) {
            JSONObject js = JSONObject.fromObject(strBonus);
            BonusPrice bonusPrice = (BonusPrice) JSONObject.toBean(js,
                    BonusPrice.class);
            bonusPrice.setId(StringUtils.uniqueKey());
            bonusPrice.setMobTypeId(mobType.getMobtypeid());
            bonusPriceList.add(bonusPrice);
        }*/
    	return ;
    }
   @SuppressWarnings("unused")
private void getBonusPriceList(Mobtype mobType) throws Exception {
        List<MobTonus> bonusPriceList = new ArrayList<MobTonus>();
       // String[] bonusList = mobType.getBonusList();
        
        System.out.println("+++0");
        if(mobType.getBonusList() != null)
        for (String  ee : mobType.getBonusList()) {
        	MobTonus bonusPrice = new MobTonus();
        	String str[] = ee.split("\\,");
        //	System.out.println(ee);
        	//System.out.println("++当时的时代+++"+str[0]);
        	//System.out.println("money:"+Double.valueOf(str[1]));
        	Bonustype bonusType = bonusTypeDao.findBonustypeByName(str[0]);
        	bonusPrice.setId(StringUtils.uniqueKey());
        	bonusPrice.setMobTypeId(mobType.getMobtypeid());
        	bonusPrice.setBonusTypeId(bonusType.getBonustypeid());
        	bonusPrice.setMoney(Double.valueOf(str[1]));
        	mobtonusDao.insert(bonusPrice);
		}
        /*for (String strBonus : bonusList) {
            JSONObject js = JSONObject.fromObject(strBonus);
            BonusPrice bonusPrice = (BonusPrice) JSONObject.toBean(js,
                    BonusPrice.class);
            bonusPrice.setId(StringUtils.uniqueKey());
            bonusPrice.setMobTypeId(mobType.getMobtypeid());
            bonusPriceList.add(bonusPrice);
        }*/
    return ;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map> getBonus(String mobTypeId) throws Exception {
    	List<MobTonus> mobTonusList = mobtonusDao.queryList(mobTypeId);
    	
    	List<Map> mapList = new ArrayList<Map>();
    	Iterator it = mobTonusList.iterator();
		while (it.hasNext()) {
			Map map = new HashMap();
			MobTonus mobTonus = (MobTonus) it.next();
			Bonustype bonustype = new Bonustype();
			bonustype = bonusTypeDao.selectByPrimaryKey(mobTonus.getBonusTypeId());
			map.put("bonusTypeId", bonustype.getBonustypeid());
			map.put("bonusname", bonustype.getTyoename());
			map.put("money", mobTonus.getMoney());
			mapList.add(map);
		}
    	return mapList;
    }

	@SuppressWarnings("rawtypes")
	public List queryList(String... strings) {
		
		return mobtypeDao.queryList(strings[0]);
	}
	
	public List<Mobtype> findMobTypeByBrand(String brand) {
		// TODO Auto-generated method stub
		return mobtypeDao.findMobTypeByBrand(brand);
	}
	
	/* (non-Javadoc)
	 * @see com.sise.service.MobTypeService#findMobtypeBySelected(java.util.Map)
	 */
	public List findMobtypeBySelected(Map<String, String> map) {
		// TODO Auto-generated method stub
		return mobtypeDao.findMobtypeBySelected(map);
	}
	
	public Mobtype selectMobTypeByMobtypeid(String mobtypeid) {
		// TODO Auto-generated method stub
		return mobtypeDao.selectByPrimaryKey(mobtypeid);
	}

	public void setMobtypeDao(MobtypeDao mobtypeDao) {
		this.mobtypeDao = mobtypeDao;
	}

	public void setMobtonusDao(MobtonusDao mobtonusDao) {
		this.mobtonusDao = mobtonusDao;
	}

	public BonustypeDao getBonusTypeDao() {
		return bonusTypeDao;
	}

	public void setBonusTypeDao(BonustypeDao bonusTypeDao) {
		this.bonusTypeDao = bonusTypeDao;
	}

	public List<MobTonus> getBonusPriceList() {
		return bonusPriceList;
	}

	public void setBonusPriceList(List<MobTonus> bonusPriceList) {
		this.bonusPriceList = bonusPriceList;
	}


	
	
}
