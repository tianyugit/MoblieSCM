package com.sise.action;

import java.util.List;
import com.sise.dao.BrandDao;
import com.sise.pojo.Brand;

/**
 * ========================================================================
 * 
 * �汾:1.0
 *
 *��������:2016��11��15�� ����11:10:46
 *
 *����:������
 *
 *����:
 *
 *
 *��Ȩ:T�����Ȩ����(c) 2016
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
		 * ��ת���б����
		 * @return
		 * @throws Exception
		 */
	    public String list() throws Exception {
	        brandList = brandDao.queryList();
	        return "list";
	    }

	    /**
	     * ���Ʒ��
	     * @return
	     * @throws Exception
	     */
	    public String addBrand() throws Exception {
	        if (brandDao.findBrandByPrimaryKey(brand.getBrand()) != null) {
	            errMap.put("dupBrand", "Ʒ�������Ѵ���");
	            brandList = brandDao.queryList();
	            return "list";
	        } else {
	        	brandDao.insert(brand);
	        	response.sendRedirect("brand_list.do"); 
	            return null;
	        }
	    }

	    /**
	     * ɾ��Ʒ��
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
