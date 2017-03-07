package com.sise.action;

import java.util.List;

import com.sise.pojo.Supplier;
import com.sise.pojo.SupplierType;
import com.sise.service.SupplierService;
import com.sise.service.SupplierTypeService;

/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年11月8日 上午11:15:45
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
@SuppressWarnings("serial")
public class SupplierTypeManageAction extends BasicAction{
	
	private SupplierType supplierType;
	private SupplierTypeService supplierTypeService;
    private SupplierService supplierService;
    @SuppressWarnings("rawtypes")
	private List supplierTypeList;
    
    /**
     * 转至列表界面
     * @return
     * @throws Exception
     */
    public String list() throws Exception {	
    	supplierTypeList = supplierTypeService.getTypeList();
        return "list";
    }
    /*
     * 转到添加界面
     */
    public String toAdd() throws Exception {
        return "add";
    }
    /**
     * 向数据库插入添加的类别
     * @return
     * @throws Exception
     */
    public String addType() throws Exception {
        if (supplierTypeService.addType(supplierType)) {
        	supplierTypeList = supplierTypeService.getTypeList();
            return "list";
        } else {
            errMap.put("typeId", "供应商编号已存在,请指定其它编号");
            return "add";
        }
    }
    /**
     * 转到类别编辑界面
     * @return
     * @throws Exception
     */
    public String toEdit() throws Exception {
        supplierType =  supplierTypeService.getType(supplierType);
        return "edit";
    }

    /**
     * 修改类别
     * @return
     * @throws Exception
     */
    public String editType() throws Exception {
        supplierTypeService.editType(supplierType);
        supplierTypeList = supplierTypeService.getTypeList();
        return "list";
    }
    /**
     * 删除类别
     * @return
     * @throws Exception
     */
    public String delType() throws Exception {
        
        Supplier para = new Supplier();
        para.setSupplierType(supplierType);
      if (supplierService.getSupplierList2(para.getSupplierType().getSuptypeid()).size() > 0) {
    	 // System.out.println("sgfdgdfgdgdgs");
    	  
    	  session.put("message", "OK");
    	  response.sendRedirect("supplierType_list.do"); 
    	  return null;
        }
        
        supplierTypeService.delType(supplierType);
        supplierTypeList = supplierTypeService.getTypeList();
        return "list";
    }

	public SupplierType getSupplierType() {
		return supplierType;
	}
	public void setSupplierType(SupplierType supplierType) {
		this.supplierType = supplierType;
	}
	public void setSupplierTypeService(SupplierTypeService supplierTypeService) {
		this.supplierTypeService = supplierTypeService;
	}
	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	@SuppressWarnings("unchecked")
	public List<SupplierType> getSupplierTypeList() {
		return supplierTypeList;
	}

	public void setSupplierTypeList(List<SupplierType> supplierTypeList) {
		this.supplierTypeList = supplierTypeList;
	}
	
}
