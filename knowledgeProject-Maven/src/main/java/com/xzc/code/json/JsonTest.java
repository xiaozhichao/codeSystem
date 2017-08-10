package com.xzc.code.json;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class JsonTest {
	@Test
	public void test1(){
		JSONBean bean = new JSONBean();
		bean.setId(1);
		bean.setName("张三");
		bean.setDetail(null);
		System.out.println();
		JSONObject json = JSONObject.parseObject(JSONObject.toJSON(bean).toString());
		
		List<JSONBeanDetail> details = new ArrayList<JSONBeanDetail>();
		JSONBeanDetail detail1 = new JSONBeanDetail();
		detail1.setId(11);
		detail1.setName("张三详情");
		
		JSONBeanDetail detail2 = new JSONBeanDetail();
		detail2.setId(12);
		detail2.setName("张三详情");
		
		details.add(detail1);
		details.add(detail2);
		
		json.put("details", details);
		System.out.println(json);
		
		
		
		
		
		
	}
}
