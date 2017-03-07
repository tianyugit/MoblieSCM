package com.sise.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.sise.pojo.Mobtype;


public interface MobTypeService {

    void addType(Mobtype mobType) throws Exception;

    List<Map> getBonus(String mobTypeId) throws SQLException, Exception;

    void editType(Mobtype mobType) throws Exception;

    void delType(String mobtypeid) throws SQLException;

	List queryList(String... strings);

	List<Mobtype> findMobTypeByBrand(String brand);

	Mobtype selectMobTypeByMobtypeid(String mobtypeid);

	/**
	 * @param map
	 * @return
	 */
	List findMobtypeBySelected(Map<String, String> map);

}
