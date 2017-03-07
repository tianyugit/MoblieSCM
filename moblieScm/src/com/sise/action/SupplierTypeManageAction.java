package com.sise.action;

import java.util.List;

import com.sise.pojo.Supplier;
import com.sise.pojo.SupplierType;
import com.sise.service.SupplierService;
import com.sise.service.SupplierTypeService;

/**
 * ========================================================================
 * 
 * �汾:1.0
 *
 *��������:2016��11��8�� ����11:15:45
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
@SuppressWarnings("serial")
public class SupplierTypeManageAction extends BasicAction{
	
	private SupplierType supplierType;
	private SupplierTypeService supplierTypeService;
    private SupplierService supplierService;
    @SuppressWarnings("rawtypes")
	private List supplierTypeList;
    
    /**
     * ת���б����
     * @return
     * @throws Exception
     */
    public String list() throws Exception {	
    	supplierTypeList = supplierTypeService.getTypeList();
        return "list";
    }
    /*
     * ת����ӽ���
     */
    public String toAdd() throws Exception {
        return "add";
    }
    /**
     * �����ݿ������ӵ����
     * @return
     * @throws Exception
     */
    public String addType() throws Exception {
        if (supplierTypeService.addType(supplierType)) {
        	supplierTypeList = supplierTypeService.getTypeList();
            return "list";
        } else {
            errMap.put("typeId", "��Ӧ�̱���Ѵ���,��ָ���������");
            return "add";
        }
    }
    /**
     * ת�����༭����
     * @return
     * @throws Exception
     */
    public String toEdit() throws Exception {
        supplierType =  supplierTypeService.getType(supplierType);
        return "edit";
    }

    /**
     * �޸����
     * @return
     * @throws Exception
     */
    public String editType() throws Exception {
        supplierTypeService.editType(supplierType);
        supplierTypeList = supplierTypeService.getTypeList();
        return "list";
    }
    /**
     * ɾ�����
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
