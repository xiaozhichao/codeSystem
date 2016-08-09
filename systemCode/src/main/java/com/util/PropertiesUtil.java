package com.util;

import java.util.ResourceBundle;
/**
 * ��ȡ�����ļ�
 * @author thinkpad
 *
 */
public class PropertiesUtil {
	private static ResourceBundle resourceBundle = null;
	
	static{
		try{
			resourceBundle = ResourceBundle.getBundle("config");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ��ȡ�����ļ�keyֵ
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		String value = resourceBundle.getString(key);
		return null == value ? "" : value.trim();
	}
	public static void main(String[] args) {
		System.out.println(PropertiesUtil.getValue( "RSB_KEY_SIZE"));
	}
}