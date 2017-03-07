package com.sise.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sise.dao.BrandDao;
import com.sise.pojo.Accessorytype;
import com.sise.pojo.Brand;
import com.sise.service.AccessoryTypeService;
/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年11月25日 上午11:17:53
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
@SuppressWarnings({ "unchecked" })
public class AccessoryTypeManageAction extends BasicAction {

	private static final long serialVersionUID = -5681423474236055440L;
	
	private List<Accessorytype> accessorytypeList;
	private List<Brand> brandList;
	private Accessorytype accessoryType;
	
	private AccessoryTypeService accessoryTypeService;
	private BrandDao brandDao;
	/**
	 * 跳转至列表界面
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {	
		getLists();
        return "list";
    }
	private void getLists() throws Exception {
		//获取配件列表
		accessorytypeList = accessoryTypeService.getTypeList();
		//获取品牌列表
		brandList = brandDao.queryList();
	}
    /*
     * 转到添加界面
     */
    public String toAdd() throws Exception {
    	//获取品牌列表
    	brandList = brandDao.queryList();
        return "add";
    }
    /**
     * 向数据库插入添加的类别
     * @return
     * @throws Exception
     */
    public String addType() throws Exception {
    	//判断是否存在该编号
        if (accessoryTypeService.addType(accessoryType)) {
        	getLists();
            return "list";
        } else {
        	//返回提示信息
            errMap.put("typeId", "配件编号已存在,请指定其它编号");
            return "add";
        }
    }
    /**
     * 转到类别编辑界面
     * @return
     * @throws Exception
     */
    public String toEdit() throws Exception {
    	//获取配件列表
    	accessoryType =  accessoryTypeService.getType(accessoryType);
    	//获取品牌列表
    	brandList = brandDao.queryList();
        return "edit";
    }

    /**
     * 编辑类别
     * @return
     * @throws Exception
     */
    public String editType() throws Exception {
    	accessoryTypeService.editType(accessoryType);
    	getLists();
        return "list";
    }
    /**
     * 删除类别
     * @return
     * @throws Exception
     */
    public String delType() throws Exception {
    	accessoryTypeService.delType(accessoryType);
    	getLists();
    	  return "list";
    }
   
    /**
     * 查找配件类型
     * @return
     * @throws Exception
     */
    public String findAccessoryType() throws Exception{

    	Map<String,String> map = new LinkedHashMap<String,String>();
    	map.put("brand", "%" + accessoryType.getBrand() + "%");
    	map.put("typename", "%" + accessoryType.getTypename() + "%");
    	System.out.println(map);
    	accessorytypeList = accessoryTypeService.findAccessoryType(map);
    	brandList = brandDao.queryList();
    	return "list";
    }
    /**
     * 获取配件类别列表
     * @return
     */
	public List<Accessorytype> getAccessorytypeList() {
		return accessorytypeList;
	}
	
	public void setAccessorytypeList(List<Accessorytype> accessorytypeList) {
		this.accessorytypeList = accessorytypeList;
	}

	public void setAccessoryTypeService(AccessoryTypeService accessoryTypeService) {
		this.accessoryTypeService = accessoryTypeService;
	}
	public List<Brand> getBrandList() {
		return brandList;
	}
	public void setBrandList(List<Brand> brandList) {
		this.brandList = brandList;
	}
	public void setBrandDao(BrandDao brandDao) {
		this.brandDao = brandDao;
	}
	public Accessorytype getAccessoryType() {
		return accessoryType;
	}
	public void setAccessoryType(Accessorytype accessoryType) {
		this.accessoryType = accessoryType;
	}

}
