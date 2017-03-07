package com.sise.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.org.json.JSONObject;

public abstract class Test {

	public static void main(String[] args) throws IOException {
		//String data = "[{'unit':'Unit_1','value':'20'},{'unit':'Unit_2','value':'10'}, {'unit':'Unit_3','value':'30'},{'unit':'Unit_4','value':'10'}]";
		File file = new File("H:\\F\\大四课件\\毕设\\mobsvn\\moblieScm\\WebRoot\\data.csv");
		FileInputStream fos = new FileInputStream(file);
		int length = 0;
		byte[] buf = new byte[1024];
		String str = null;
		while((length = fos.read(buf))!= -1){
			 str = new String(buf,0,length);
			 System.out.println(str);
		}
		/*JSONObject jsonObject = new JSONObject();
		JSONObject jsonObject2 = new JSONObject();
		JSONObject jsonObject3 = new JSONObject();
		//System.out.println(jsonObject.get("JSChart"));
		 jsonObject.put("data", data);
		jsonObject.put("type", "pie");
		jsonObject2.put("datasets", jsonObject);
		jsonObject3.put("JSChart", jsonObject2.put("datasets", jsonObject));
		//String[] ss = jsonObject.getNames('data');
		System.out.println(jsonObject3.put("JSChart", jsonObject2.put("datasets", jsonObject)));*/
	}

}
