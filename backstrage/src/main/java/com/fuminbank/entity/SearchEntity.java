package com.fuminbank.entity;

import java.io.Serializable;

/**
 * 
 **************************************************
 * ClassName:SearchEntity
 * @Description:前端页面查询条件实体类
 * @author:xiaozhichao
 * @date:2017年5月10日
 **************************************************
 */
public class SearchEntity implements Serializable{
	
	/**
	 * @Fields serialVersionUID:TODO
	 */
		
	private static final long serialVersionUID = -3129521464970172941L;
	private String field;//字段名
	private String name;//字段名称
	private String type;//类型
	private Integer length;//长度
	public String getField() {
	
		return field;
	}
	public void setField(String field) {
	
		this.field = field;
	}
	public String getName() {
	
		return name;
	}
	public void setName(String name) {
	
		this.name = name;
	}
	public String getType() {
	
		return type;
	}
	public void setType(String type) {
	
		this.type = type;
	}
	public Integer getLength() {
	
		return length;
	}
	public void setLength(Integer length) {
	
		this.length = length;
	}
	
	
}

	