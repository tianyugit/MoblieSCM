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
 * �汾:1.0
 *
 *��������:2016��11��25�� ����11:17:53
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
@SuppressWarnings({ "unchecked" })
public class AccessoryTypeManageAction extends BasicAction {

	private static final long serialVersionUID = -5681423474236055440L;
	
	private List<Accessorytype> accessorytypeList;
	private List<Brand> brandList;
	private Accessorytype accessoryType;
	
	private AccessoryTypeService accessoryTypeService;
	private BrandDao brandDao;
	/**
	 * ��ת���б����
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {	
		getLists();
        return "list";
    }
	private void getLists() throws Exception {
		//��ȡ����б�
		accessorytypeList = accessoryTypeService.getTypeList();
		//��ȡƷ���б�
		brandList = brandDao.queryList();
	}
    /*
     * ת����ӽ���
     */
    public String toAdd() throws Exception {
    	//��ȡƷ���б�
    	brandList = brandDao.queryList();
        return "add";
    }
    /**
     * �����ݿ������ӵ����
     * @return
     * @throws Exception
     */
    public String addType() throws Exception {
    	//�ж��Ƿ���ڸñ��
        if (accessoryTypeService.addType(accessoryType)) {
        	getLists();
            return "list";
        } else {
        	//������ʾ��Ϣ
            errMap.put("typeId", "�������Ѵ���,��ָ���������");
            return "add";
        }
    }
    /**
     * ת�����༭����
     * @return
     * @throws Exception
     */
    public String toEdit() throws Exception {
    	//��ȡ����б�
    	accessoryType =  accessoryTypeService.getType(accessoryType);
    	//��ȡƷ���б�
    	brandList = brandDao.queryList();
        return "edit";
    }

    /**
     * �༭���
     * @return
     * @throws Exception
     */
    public String editType() throws Exception {
    	accessoryTypeService.editType(accessoryType);
    	getLists();
        return "list";
    }
    /**
     * ɾ�����
     * @return
     * @throws Exception
     */
    public String delType() throws Exception {
    	accessoryTypeService.delType(accessoryType);
    	getLists();
    	  return "list";
    }
   
    /**
     * �����������
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
     * ��ȡ�������б�
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
