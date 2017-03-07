package com.sise.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.Config;

public class ConfigDaoImpl  extends SqlSessionDaoSupport implements ConfigDao {

	public int deleteByPrimaryKey(String config) {
		SqlSession sqlSession = this.getSqlSession();
		Map<String,String> map = new HashMap<String,String>();
		map.put("config", config);
		System.out.println(map);
		sqlSession.delete("configMapper.deleteByPrimaryKey", map);
		return 0;
	}

	public int insert(Config record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("configMapper.insert",record);
		return 0;
	}

	public int insertSelective(Config record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List queryList(String... strings) {
		SqlSession sqlsession = this.getSqlSession();
		String config = strings[0];
		Map<String, String> map = new HashMap<String, String>();
		map.put("config", config);
		return sqlsession.selectList("configMapper.queryList",map);
	}

}
