package com.sise.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.Brand;
import com.sise.pojo.Color;

public class ColorDaoImpl extends SqlSessionDaoSupport implements ColorDao{

	public int deleteByPrimaryKey(String color) {
		SqlSession sqlSession = this.getSqlSession();
		Map<String,String> map = new HashMap<String,String>();
		map.put("color", color);
		System.out.println(map);
		sqlSession.delete("color.deleteByPrimaryKey", map);
		return 0;
	}

	public int insert(Color record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("color.insert",record);
		return 0;
	}

	public int insertSelective(Color record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Color findColorByPrimaryKey(String color) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		Map<String,String> map = new HashMap<String,String>();
		map.put("color", color);
		return sqlSession.selectOne("color.findColorByPrimaryKey", map);
	}

	public List queryList() throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("color.queryList");
	}

}
