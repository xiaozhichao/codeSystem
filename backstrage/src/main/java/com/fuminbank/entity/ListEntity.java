package com.fuminbank.entity;

import java.util.List;

/**
 * 
 **************************************************
 * ClassName:ListEntity 列表展示实体
 * @Description:TODO
 * @author:xiaozhichao
 * @date:2017年5月10日
 **************************************************
 */
public class ListEntity {
	private Integer id;
	private String name;
	private String url;
	private String params;
	private List<SubListEntity> subList;
	
	
	
	public Integer getId() {
	
		return id;
	}
	public void setId(Integer id) {
	
		this.id = id;
	}
	public String getName() {
	
		return name;
	}
	public void setName(String name) {
	
		this.name = name;
	}
	public String getUrl() {
	
		return url;
	}
	public void setUrl(String url) {
	
		this.url = url;
	}
	public String getParams() {
	
		return params;
	}
	public void setParams(String params) {
	
		this.params = params;
	}
	public List<SubListEntity> getSubList() {
	
		return subList;
	}
	public void setSubList(List<SubListEntity> subList) {
	
		this.subList = subList;
	}
	
	
	
	
}
