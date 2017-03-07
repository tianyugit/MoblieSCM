package com.sise.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.Bonustype;
import com.sise.utils.StringUtils;
@SuppressWarnings({ "rawtypes" })
public class BonustypeDaoImpl  extends SqlSessionDaoSupport implements BonustypeDao{

	public int deleteByPrimaryKey(String bonustypeid) throws Exception{
		SqlSession sqlSession = this.getSqlSession();
		Map<String,String> map = new HashMap<String,String>();
		map.put("bonustypeid", bonustypeid);
		sqlSession.delete("bonustypeMapper.deleteByPrimaryKey", bonustypeid);
		return 0;
	}

	public int insert(Bonustype record) throws Exception{
		SqlSession sqlSession = this.getSqlSession();
		record.setBonustypeid(StringUtils.uniqueKey());
		System.out.println(record);
		sqlSession.insert("bonustypeMapper.insert",record);
		return 0;
	}

	public int insertSelective(Bonustype record) throws Exception{
		// TODO Auto-generated method stub
		return 0;
	}

	public Bonustype selectByPrimaryKey(String bonustypeid) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		Map<String,String> map = new HashMap<String,String>();
		map.put("bonustypeid", bonustypeid);
		return sqlSession.selectOne("bonustypeMapper.selectByPrimaryKey", map);
	}

	public int updateByPrimaryKeySelective(Bonustype record) throws Exception{
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(Bonustype record) throws Exception{
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("bonustypeMapper.updateByPrimaryKey", record);
		return 0;
	}

	public List queryList() throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("bonustypeMapper.queryList");
	}

	public Bonustype findBonustypeByName(String string) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		System.out.println("fdsfddsdsffsdgsgdsg"+string);
		return sqlSession.selectOne("bonustypeMapper.findIdByName",string);
	}

	public List<Map> getBonus(String mobTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
