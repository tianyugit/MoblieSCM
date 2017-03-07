package com.sise.action;

import java.util.List;

import com.sise.dao.ConfigDao;
import com.sise.pojo.Config;

/**
 * ========================================================================
 * 
 * �汾:1.0
 *
 *��������:2016��12��1�� ����11:14:32
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
public class ConfigManageAction extends BasicAction{
	

	private static final long serialVersionUID = -6315692842938090764L;
	private List configList;
    private Config config;
    private ConfigDao configDao;
    
    /**
	 * ��ת���б����
	 * @return
	 * @throws Exception
	 */
    public String list() throws Exception {
        configList = configDao.queryList("");
        return "list";
    }

    /**
     * �������
     * @return
     * @throws Exception
     */
    public String addConfig() throws Exception {
        if (configDao.queryList(config.getConfig()).size() > 0) {
            errMap.put("dupCfg", "�Ѵ���");
            configList = configDao.queryList("");
            return "list";
        } else {
        	configDao.insert(config);
        	response.sendRedirect("config_list.do");
            return null;
        }
    }

    /**
     * ɾ������
     * @return
     * @throws Exception
     */
    public String delConfig() throws Exception {
      /*   dao
                .del("config.del", new String(config.getBytes("iso8859-1"),
                       "utf-8"));*/
    	configDao.deleteByPrimaryKey(config.getConfig());
    	response.sendRedirect("config_list.do");
        return null;
    }

	public List getConfigList() {
		return configList;
	}

	public void setConfigList(List configList) {
		this.configList = configList;
	}


	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public void setConfigDao(ConfigDao configDao) {
		this.configDao = configDao;
	}

    

}
