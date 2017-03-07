package com.sise.action;

import java.util.List;

import com.sise.dao.ColorDao;
import com.sise.pojo.Color;

/**
 * ========================================================================
 * 
 * �汾:1.0
 *
 *��������:2016��12��7�� ����11:14:22
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
public class ColorManageAction extends BasicAction{
	
	 private static final long serialVersionUID = 7127254389350822834L;
	    private List colorList;
	    private Color color;
	    private ColorDao colorDao;

	    /**
		 * ��ת���б����
		 * @return
		 * @throws Exception
		 */
	    public String list() throws Exception {
	        colorList = colorDao.queryList();
	        System.out.println(colorList);
	        return "list";
	    }

	    /**
	     * �����ɫ
	     * @return
	     * @throws Exception
	     */
	    public String addColor() throws Exception {
	        if (colorDao.findColorByPrimaryKey(color.getColor()) != null) {
	            errMap.put("dupClr", "��ɫ�����Ѵ���");
	            colorList = colorDao.queryList();
	            return "list";
	        } else {
	        	colorDao.insert(color);
	        	response.sendRedirect("color_list.do"); 
	            return null;
	        }
	    }

	    /**
	     * ɾ����ɫ
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
