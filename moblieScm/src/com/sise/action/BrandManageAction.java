package com.sise.action;

import java.util.List;
import com.sise.dao.BrandDao;
import com.sise.pojo.Brand;

/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年11月15日 上午11:10:46
 *
 *作者:马天宇
 *
 *描述:
 *
 *
 *版权:T世界版权所有(c) 2016
 *
 *==========================================================================
 */
@SuppressWarnings({ "rawtypes" })
public class BrandManageAction extends BasicAction{
	
	 private static final long serialVersionUID = 7127254389350822834L;
	    private List brandList;
	    private Brand brand;
	    private BrandDao brandDao;

	    /**
		 * 跳转至列表界面
		 * @return
		 * @throws Exception
		 */
	    public String list() throws Exception {
	        brandList = brandDao.queryList();
	        return "list";
	    }

	    /**
	     * 添加品牌
	     * @return
	     * @throws Exception
	     */
	    public String addBrand() throws Exception {
	        if (brandDao.findBrandByPrimaryKey(brand.getBrand()) != null) {
	            errMap.put("dupBrand", "品牌名称已存在");
	            brandList = brandDao.queryList();
	            return "list";
	        } else {
	        	brandDao.insert(brand);
	        	response.sendRedirect("brand_list.do"); 
	            return null;
	        }
	    }

	    /**
	     * 删除品牌
	     * @return
	     * @throws Exception
	     */
	    public String delBrand() throws Exception {
	       // dao.del("brand.delBrand", new String(brand.getBytes("iso8859-1"),
	       //         "utf-8"));
	    	System.out.println(brand.getBrand());
	    	brandDao.deleteByPrimaryKey(brand.getBrand());
	    	response.sendRedirect("brand_list.do"); 
	        return null;
	    }

	    public List getBrandList() {
	        return brandList;
	    }

		public Brand getBrand() {
			return brand;
		}

		public void setBrand(Brand brand) {
			this.brand = brand;
		}

		public void setBrandDao(BrandDao brandDao) {
			this.brandDao = brandDao;
		}
	    
	    

}
