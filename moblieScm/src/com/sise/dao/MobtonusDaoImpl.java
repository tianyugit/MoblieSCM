package com.sise.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.MobTonus;

public class MobtonusDaoImpl extends SqlSessionDaoSupport implements MobtonusDao{

	public int deleteByPrimaryKey(String id) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("mobtonusMapper.insert", id);
		return 0;
	}

	public int insert(MobTonus record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("mobtonusMapper.insert", record);
		return 0;
	}

	public int insertSelective(MobTonus record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("mobtonusMapper.insertSelective", record);
		return 0;
	}

	public MobTonus selectByPrimaryKey(String id) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("mobtonusMapper.selectByPrimaryKey", id);
	}

	public int updateByPrimaryKeySelective(MobTonus record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("mobtonusMapper.updateByPrimaryKeySelective", record);
		return 0;
	}

	public int updateByPrimaryKey(MobTonus record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("mobtonusMapper.updateByPrimaryKey", record);
		return 0;
	}

	public List<MobTonus> queryList(String mobTypeId) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("mobtonusMapper.queryList", mobTypeId);
	}

	public void deleteByMobtypeid(String mobtypeid) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.delete("mobtonusMapper.deleteByMobtypeid", mobtypeid);
	}



}
