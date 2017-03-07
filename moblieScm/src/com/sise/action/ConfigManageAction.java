package com.sise.action;

import java.util.List;

import com.sise.dao.ConfigDao;
import com.sise.pojo.Config;

/**
 * ========================================================================
 * 
 * 版本:1.0
 *
 *创建日期:2016年12月1日 上午11:14:32
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
public class ConfigManageAction extends BasicAction{
	

	private static final long serialVersionUID = -6315692842938090764L;
	private List configList;
    private Config config;
    private ConfigDao configDao;
    
    /**
	 * 跳转至列表界面
	 * @return
	 * @throws Exception
	 */
    public String list() throws Exception {
        configList = configDao.queryList("");
        return "list";
    }

    /**
     * 添加配置
     * @return
     * @throws Exception
     */
    public String addConfig() throws Exception {
        if (configDao.queryList(config.getConfig()).size() > 0) {
            errMap.put("dupCfg", "已存在");
            configList = configDao.queryList("");
            return "list";
        } else {
        	configDao.insert(config);
        	response.sendRedirect("config_list.do");
            return null;
        }
    }

    /**
     * 删除配置
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
