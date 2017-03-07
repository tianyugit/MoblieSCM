package com.sise.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.Brand;

public class BrandDaoImpl extends SqlSessionDaoSupport implements BrandDao{

	public int deleteByPrimaryKey(String brand) {
		SqlSession sqlSession = this.getSqlSession();
		Map<String,String> map = new HashMap<String,String>();
		map.put("brand", brand);
		System.out.println(map);
		sqlSession.delete("brand.deleteByPrimaryKey", map);
		return 0;
	}

	public int insert(Brand record) {
		SqlSession sqlSession = this.getSqlSession();
		
		sqlSession.insert("brand.insert",record);
		return 0;
	}

	public int insertSelective(Brand record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Brand findBrandByPrimaryKey(String brand) throws Exception{
		SqlSession sqlSession = this.getSqlSession();
		Map<String,String> map = new HashMap<String,String>();
		map.put("brand", brand);
		return sqlSession.selectOne("brand.findBrandByPrimaryKey", map);
	}
	public List queryList() throws Exception{
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("brand.queryList");
	}

}
