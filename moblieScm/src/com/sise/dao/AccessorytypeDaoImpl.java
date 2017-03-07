package com.sise.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.Accessorytype;

public class AccessorytypeDaoImpl extends SqlSessionDaoSupport implements AccessorytypeDao{

	public int deleteByPrimaryKey(String accessorytypeid) {
		SqlSession sqlsession = this.getSqlSession();	
		sqlsession.delete("accessorytypeMapper.deleteByPrimaryKey", accessorytypeid);
		return 0;
	}

	public int insert(Accessorytype record) {
		SqlSession sqlsession = this.getSqlSession();	
		sqlsession.insert("accessorytypeMapper.insert", record);
		return 1;
	}

	public int insertSelective(Accessorytype record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Accessorytype selectByPrimaryKey(String accessorytypeid) {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectOne("accessorytypeMapper.selectByPrimaryKey", accessorytypeid);
	}

	public int updateByPrimaryKeySelective(Accessorytype record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Accessorytype record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.update("accessorytypeMapper.updateByPrimaryKey",record);
		return 0;
	}

	public List<Accessorytype> getTypeList() {
		SqlSession sqlsession = this.getSqlSession();
		
		return sqlsession.selectList("accessorytypeMapper.getTypeList");
	}

	public List<Accessorytype> findAccessoryType(Map<String, String> map) {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectList("accessorytypeMapper.findAccessoryType", map);
	}

	public List<Accessorytype> findAccTypeByBrand(String brand) {
		SqlSession sqlsession = this.getSqlSession();
		Map<String,String> map = new HashMap<String, String>();
		map.put("brand", brand);
		return sqlsession.selectList("accessorytypeMapper.findAccTypeByBrand", map);
	}

	public List<Accessorytype> findaccTypeByselected(Map<String, String> map) {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectList("accessorytypeMapper.findaccTypeByselected", map);
	}

}
