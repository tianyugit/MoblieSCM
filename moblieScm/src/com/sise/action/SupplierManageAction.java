package com.sise.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sise.pojo.Supplier;
import com.sise.pojo.SupplierType;
import com.sise.service.SupplierService;
import com.sise.service.SupplierTypeService;

/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年11月8日 上午11:15:31
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
@SuppressWarnings("unused")
public class SupplierManageAction extends BasicAction{
	
	private static final long serialVersionUID = 5097414135096661553L;
	private Supplier supplier;
	
	private SupplierType supplierType;
    private List<SupplierType> supplierTypeList;
    private List<Supplier> supplierList;

    private SupplierTypeService supplierTypeService;
    private SupplierService supplierService;

    /**
     * 查询供应商，返回列表页
     * 
     * @return
     * @throws Exception
     */
    public String list() throws Exception {
    	
        //supplierTypeList = supplierTypeService.getType(null);
        //paginatedQuery("supplier.getSupplier");
    	supplierList = supplierService.getSupplierList("");
    	//System.out.println("dfdfdf" + supplierList);
    	supplierTypeList = supplierTypeService.getTypeList();
    	
        return "list";
    }

    /**
     * 转到新增页
     * 
     * @return
     * @throws Exception
     */
    public String toAdd() throws Exception {
        supplierTypeList = supplierTypeService.getTypeList();
        System.out.println(supplierTypeList);
        return "add";
    }

    /**
     * 新增供应商
     * 
     * @return
     * @throws Exception
     */
    public String addSupplier() throws Exception {
    	/*  if (supplierTypeService.addType(supplierType)) {
          	supplierTypeList = supplierTypeService.getTypeList();
              return "list";
          } else {
              errMap.put("typeId", "供应商编号已存在,请指定其它编号");
              return "add";
          }*/
        // ID是否重复
        Supplier para = new Supplier();
        para.setSupid(supplier.getSupid());
        if (supplierService.getSupplier(para) != null ) {
            supplierTypeList = supplierTypeService.getTypeList();
            errMap.put("supplierId", "这个编号已存在");
            return "add";
        }
        System.out.println(supplier);
        supplierService.addSupplier(supplier);
        supplierList = supplierService.getSupplierList("");
    	supplierTypeList = supplierTypeService.getTypeList();
        return "list";
    }

    /**
     * 转到编辑页
     * 
     * @return
     * @throws Exception
     */
    public String toEdit() throws Exception {
        supplier = supplierService.getSupplier(supplier);
        supplierTypeList = supplierTypeService.getTypeList();
        return "edit";
    }

    /**
     * 修改供应商
     * 
     * @return
     * @throws Exception
     */
    public String editSupplier() throws Exception {
        supplierService.editSupplier(supplier);
        supplierList = supplierService.getSupplierList("");
        supplierTypeList = supplierTypeService.getTypeList();
        return "list";
    }

    /**
     * 删除供应商
     * 
     * @return
     * @throws Exception
     */
    
    public String delSupplier() throws Exception {
        supplierService.delSupplier(supplier);
        
        supplierList = supplierService.getSupplierList("");
        supplierTypeList = supplierTypeService.getTypeList();
        return "list";
    }
    
    public String findSupplier() throws Exception{
    	//System.out.println("dfsdsdfggg"+supplierType.getSuptypeid());
    	request.getAttribute("");
    	//supplierType = supplierTypeService.getType(supplierType);
    	Map<String,String> map = new LinkedHashMap<String,String>();
    	map.put("suptypeid", "%" + supplier.getSupplierType().getSuptypeid() + "%");
    	map.put("supname", "%" + supplier.getSupname() + "%");
    	System.out.println(map);
    	 supplierList = supplierService.findSupplier(map);
    	 supplierTypeList = supplierTypeService.getTypeList();
    	return "list";
    }

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<SupplierType> getSupplierTypeList() {
		return supplierTypeList;
	}

	public void setSupplierTypeList(List<SupplierType> supplierTypeList) {
		this.supplierTypeList = supplierTypeList;
	}

	public List<Supplier> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<Supplier> supplierList) {
		this.supplierList = supplierList;
	}

	public void setSupplierTypeService(SupplierTypeService supplierTypeService) {
		this.supplierTypeService = supplierTypeService;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	
    

}
