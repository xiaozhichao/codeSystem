package com.xzc.code.json;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonTest {
	@Test
	public void test1(){
		JSONBean bean = new JSONBean();
		bean.setId(1);
		bean.setName("ÕÅÈý");
		bean.setDetail(null);
		System.out.println();
		JSONObject json = JSONObject.parseObject(JSONObject.toJSON(bean).toString());
		System.out.println(json);
		List<JSONBeanDetail> details = new ArrayList<JSONBeanDetail>();
		JSONBeanDetail detail1 = new JSONBeanDetail();
		detail1.setId(11);
		detail1.setName("[{\"id\":\"1\"}]");
		
		JSONBeanDetail detail2 = new JSONBeanDetail();
		detail2.setId(12);
		detail2.setName("[{\"id\":\"1\"}]");
		
		details.add(detail1);
		details.add(detail2);
		
		json.put("details", JSONArray.toJSON(details));
		System.out.println(json);
		
		JSONArray a = new JSONArray();
		for(JSONBeanDetail detail:details){
			String name = detail.getName();
			JSONObject json1 = JSONObject.parseObject(JSONObject.toJSON(detail).toString());
			json1.put("name", JSONObject.parse(name));
			a.add(json1);
		}
		System.out.println(a);
		
		
	}
}
