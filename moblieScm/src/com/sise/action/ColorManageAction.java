package com.sise.action;

import java.util.List;

import com.sise.dao.ColorDao;
import com.sise.pojo.Color;

/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年12月7日 上午11:14:22
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
public class ColorManageAction extends BasicAction{
	
	 private static final long serialVersionUID = 7127254389350822834L;
	    private List colorList;
	    private Color color;
	    private ColorDao colorDao;

	    /**
		 * 跳转至列表界面
		 * @return
		 * @throws Exception
		 */
	    public String list() throws Exception {
	        colorList = colorDao.queryList();
	        System.out.println(colorList);
	        return "list";
	    }

	    /**
	     * 添加颜色
	     * @return
	     * @throws Exception
	     */
	    public String addColor() throws Exception {
	        if (colorDao.findColorByPrimaryKey(color.getColor()) != null) {
	            errMap.put("dupClr", "颜色名称已存在");
	            colorList = colorDao.queryList();
	            return "list";
	        } else {
	        	colorDao.insert(color);
	        	response.sendRedirect("color_list.do"); 
	            return null;
	        }
	    }

	    /**
	     * 删除颜色
	     * @return
	     * @throws Exception
	     */
	    public String delColor() throws Exception {
	       // dao.del("brand.delBrand", new String(brand.getBytes("iso8859-1"),
	       //         "utf-8"));
	    	System.out.println(color.getColor());
	    	colorDao.deleteByPrimaryKey(color.getColor());
	    	response.sendRedirect("color_list.do"); 
	        return null;
	    }

		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}

		public void setColorList(List colorList) {
			this.colorList = colorList;
		}

		public List getColorList() {
			return colorList;
		}

		public void setColorDao(ColorDao colorDao) {
			this.colorDao = colorDao;
		}
}
