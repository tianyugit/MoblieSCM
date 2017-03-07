package com.sise.dao.sup;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.JsonBean_data;
import com.sise.pojo.Mobstock;
import com.sise.pojo.StoCount;

public class MobstockDaoImpl extends SqlSessionDaoSupport implements MobstockDao{

	public int deleteByPrimaryKey(String sn1) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.selectOne("stoMobstockMapper.deleteByPrimaryKey", sn1);
		return 0;
	}

	public int insert(Mobstock record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("stoMobstockMapper.insert", record);
		return 0;
	}

	public int insertSelective(Mobstock record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("stoMobstockMapper.insertSelective", record);
		return 0;
	}

	public Mobstock selectByPrimaryKey(String sn1) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("stoMobstockMapper.selectByPrimaryKey", sn1);
	}

	public int updateByPrimaryKeySelective(Mobstock record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("stoMobstockMapper.updateByPrimaryKeySelective", record);
		return 0;
	}

	public int updateByPrimaryKey(Mobstock record) {
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.update("stoMobstockMapper.updateByPrimaryKey", record);
		return 0;
	}

	public Mobstock selectByPrimaryKey2(String sn2) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectOne("stoMobstockMapper.selectByPrimaryKey2", sn2);
	}

	public List<StoCount> countMobtype() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("stoMobstockMapper.countMobtype");
	}

	public List<Mobstock> findmobStockBymobTypeId(String mobtypeid) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("stoMobstockMapper.findmobStockBymobTypeId",mobtypeid);
	}

	public List<JsonBean_data> getSRFormData() {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("stoMobstockMapper.getSRFormData");
	}

	/*public List<Mobstock> findmobStockByInvoiceId(String invoiceid) {
		SqlSession sqlSession = this.getSqlSession();
		return sqlSession.selectList("stoMobstockMapper.findmobStockByInvoiceId",invoiceid);
	}*/

	

}
