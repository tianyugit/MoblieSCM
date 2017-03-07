package com.sise.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.org.json.JSONArray;
import com.org.json.JSONObject;
import com.sise.dao.cust.CustMobsaleDao;
import com.sise.dao.sup.MobstockDao;
import com.sise.pojo.JsonBean_data;

/**
 * ========================================================================
 * 
 * �汾:1.0
 *
 *��������:2016��11��7�� ����11:10:46
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
@SuppressWarnings("deprecation")
public class HomeAction extends BasicAction{
	
	private static final long serialVersionUID = 3297641209674244272L;

	private List<JsonBean_data> dataList;
	private MobstockDao mobstockDao;
	private CustMobsaleDao custMobsaleDao;
	public String execute(){
		/*//�ж��û��Ƿ��¼
		User user = (User) ActionContext.getContext().getSession().get("loginUser");
		
		if(user == null){
			return LOGIN;
		}*/
		return SUCCESS;
	}
	
	public String dataShow() throws Exception {
		return "left";
	}
	public String dataShow_right() throws Exception {
		return "right";
	}
	
	
	public void getMobStockData() throws Exception {
		dataList = mobstockDao.getSRFormData();
		//Map map = new HashMap();
		
		//map.put("type", "pie");
		JSONArray jsonArray = new JSONArray(dataList);
		//map.put("data", jsonArray);
		
		
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("type", "pie");
		jsonObject2.put("data", jsonArray); 
		
		JSONArray jsonArray2 = new JSONArray();
		jsonArray2.put(jsonObject2);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("datasets", jsonArray2); 
		
		JSONObject jsonObject3 = new JSONObject();
		jsonObject3.put("JSChart", jsonObject);
			
		 response.setCharacterEncoding("utf-8");
		 response.getWriter().print(jsonObject3.toString());
		
		 System.out.println(jsonObject3.toString());
		 String path = request.getRealPath("/")+"data.json";
		 File file = new File(path);
		 FileOutputStream out = new FileOutputStream(file);
		 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
		 BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		 bufferedWriter.write(jsonObject3.toString());
		 bufferedWriter.close();
		// System.out.println(file==null);
	}
	
	public void getMobStockData_right() throws Exception {
		List<JsonBean_data> dataList = new ArrayList<JsonBean_data>();
		dataList =custMobsaleDao.getSRFormData();
		JSONArray jsonArray = new JSONArray(dataList);
		//map.put("data", jsonArray);
		
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("type", "bar");
		jsonObject2.put("data", jsonArray); 
		
		JSONArray jsonArray2 = new JSONArray();
		jsonArray2.put(jsonObject2);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("datasets", jsonArray2); 
		
		JSONObject jsonObject3 = new JSONObject();
		jsonObject3.put("JSChart", jsonObject);
			
		 response.setCharacterEncoding("utf-8");
		 response.getWriter().print(jsonObject3.toString());
		
		 System.out.println(jsonObject3.toString());
		 String path = request.getRealPath("/")+"data_right.json";
		 File file = new File(path);
		 FileOutputStream out = new FileOutputStream(file);
		 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
		 BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		 bufferedWriter.write(jsonObject3.toString());
		 bufferedWriter.close();
	}
	

	public void setMobstockDao(MobstockDao mobstockDao) {
		this.mobstockDao = mobstockDao;
	}

	public void setCustMobsaleDao(CustMobsaleDao custMobsaleDao) {
		this.custMobsaleDao = custMobsaleDao;
	}

}
