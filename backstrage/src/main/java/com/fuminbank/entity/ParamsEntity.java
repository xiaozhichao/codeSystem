package com.fuminbank.entity;

import java.io.Serializable;

/**
 * 
 **************************************************
 * ClassName:ParamsEntity
 * @Description:参数实体类
 * @author:xiaozhichao
 * @date:2017年5月10日
 **************************************************
 */
public class ParamsEntity implements Serializable{
	
	/**
	 * @Fields serialVersionUID:TODO
	 */
		
	private static final long serialVersionUID = 5001136834750320647L;
	private Integer id;
	private String type;
	private String name;
	private String field;
	private boolean notNull;
	
	public String getField() {
	
		return field;
	}
	public void setField(String field) {
	
		this.field = field;
	}
	public Integer getId() {
	
		return id;
	}
	public void setId(Integer id) {
	
		this.id = id;
	}
	public String getType() {
	
		return type;
	}
	public void setType(String type) {
	
		this.type = type;
	}
	public String getName() {
	
		return name;
	}
	public void setName(String name) {
	
		this.name = name;
	}
	public boolean isNotNull() {
	
		return notNull;
	}
	public void setNotNull(boolean notNull) {
	
		this.notNull = notNull;
	}
	
	
	
}

	