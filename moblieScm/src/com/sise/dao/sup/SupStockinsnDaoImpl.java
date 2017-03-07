package com.sise.dao.sup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sise.pojo.Mobstock;
import com.sise.pojo.SupStockinsn;

public class SupStockinsnDaoImpl extends SqlSessionDaoSupport implements SupStockinsnDao{

	public int deleteByPrimaryKey(String id) {
		SqlSession sqlSesion = this.getSqlSession();
		sqlSesion.delete("supStockinsnMapper.insert", id);
		return 0;
	}

	public int insert(SupStockinsn record) {
		SqlSession sqlSesion = this.getSqlSession();
		sqlSesion.insert("supStockinsnMapper.insert", record);
		return 0;
	}

	public int insertSelective(SupStockinsn record) {
		SqlSession sqlSesion = this.getSqlSession();
		sqlSesion.insert("supStockinsnMapper.insertSelective", record);
		return 0;
	}

	public SupStockinsn selectByPrimaryKey(String id) {
		SqlSession sqlSesion = this.getSqlSession();
		
		return sqlSesion.selectOne("supStockinsnMapper.selectByPrimaryKey", id);
	}

	public int updateByPrimaryKeySelective(SupStockinsn record) {
		SqlSession sqlSesion = this.getSqlSession();
		sqlSesion.update("supStockinsnMapper.updateByPrimaryKeySelective", record);
		return 0;
	}

	public int updateByPrimaryKey(SupStockinsn record) {
		SqlSession sqlSesion = this.getSqlSession();
		sqlSesion.update("supStockinsnMapper.updateByPrimaryKey", record);
		return 0;
	}

	public void insertByMap(Map<String, String> snMap) {
		SqlSession sqlSesion = this.getSqlSession();
		sqlSesion.insert("supStockinsnMapper.insertByMap", snMap);
		
	}

	public List<SupStockinsn> getSupStockinsnByInvoiceId(String invoiceid) {
		SqlSession sqlSesion = this.getSqlSession();
		Map<String,String> map = new HashMap<String, String>();
		System.out.println("srfasffass" + invoiceid);
		map.put("invoiceid", invoiceid);
		return sqlSesion.selectList("supStockinsnMapper.getSupStockinsnByInvoiceId", map);
	}

	/* (non-Javadoc)
	 * @see com.sise.dao.sup.SupStockinsnDao#deleteByInvoiceid(java.lang.String)
	 */
	public void deleteByInvoiceid(String invoiceid) {
		SqlSession sqlSesion = this.getSqlSession();
		sqlSesion.delete("supStockinsnMapper.deleteByInvoiceid", invoiceid);
	}



}
