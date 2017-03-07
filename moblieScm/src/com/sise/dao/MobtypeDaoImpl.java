package com.sise.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.Mobtype;

public class MobtypeDaoImpl extends SqlSessionDaoSupport implements MobtypeDao {

	public int deleteByPrimaryKey(String mobtypeid) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.delete("mobtypeMapper.deleteByPrimaryKey", mobtypeid);
		return 0;
	}

	public int insert(Mobtype record) {
		SqlSession sqlsession = this.getSqlSession();	
		sqlsession.insert("mobtypeMapper.insert", record);
		return 0;
	}

	public int insertSelective(Mobtype record) {
		SqlSession sqlsession = this.getSqlSession();	
		sqlsession.insert("mobtypeMapper.insertSelective", record);
		return 0;
	}

	public Mobtype selectByPrimaryKey(String mobtypeid) {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectOne("mobtypeMapper.selectByPrimaryKey", mobtypeid);
	}

	public int updateByPrimaryKeySelective(Mobtype record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.update("mobtypeMapper.updateByPrimaryKeySelective",record);
		return 0;
	}

	public int updateByPrimaryKey(Mobtype record) {
		SqlSession sqlsession = this.getSqlSession();
		sqlsession.update("mobtypeMapper.updateByPrimaryKey",record);
		return 0;
	}
	
	public List queryList(String... strings) {
		SqlSession sqlsession = this.getSqlSession();
		String mobtypeid = strings[0];
		Map<String, String> map = new HashMap<String, String>();
		map.put("mobtypeid", mobtypeid);
		return sqlsession.selectList("mobtypeMapper.queryList",map);
	}

	public List<Mobtype> findMobTypeByBrand(String brand) {
		SqlSession sqlsession = this.getSqlSession();
		Map<String, String> map = new HashMap<String, String>();
		map.put("brand", brand);
		return sqlsession.selectList("mobtypeMapper.findMobTypeByBrand",map);
	}

	/* (non-Javadoc)
	 * @see com.sise.dao.MobtypeDao#findMobtypeBySelected(java.util.Map)
	 */
	public List findMobtypeBySelected(Map<String, String> map) {
		SqlSession sqlsession = this.getSqlSession();
		return sqlsession.selectList("mobtypeMapper.findMobtypeBySelected",map);
	}

}
