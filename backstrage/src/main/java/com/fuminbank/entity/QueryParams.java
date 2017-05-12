package com.fuminbank.entity;

import java.io.Serializable;
import java.util.List;

public class QueryParams implements Serializable{
	
	/**
	 * @Fields serialVersionUID:TODO
	 */
		
	private static final long serialVersionUID = -4997940528142751761L;
	private String url;
	private Integer id;
	private String subName;
	private String businessCode;
	private List<ParamsEntity> params;
	
	private Integer parentId;
	private String parentName;
	
	public Integer getParentId() {
	
		return parentId;
	}
	public void setParentId(Integer parentId) {
	
		this.parentId = parentId;
	}
	public String getParentName() {
	
		return parentName;
	}
	public void setParentName(String parentName) {
	
		this.parentName = parentName;
	}
	public String getUrl() {
	
		return url;
	}
	public void setUrl(String url) {
	
		this.url = url;
	}
	public Integer getId() {
	
		return id;
	}
	public void setId(Integer id) {
	
		this.id = id;
	}
	public String getSubName() {
	
		return subName;
	}
	public void setSubName(String subName) {
	
		this.subName = subName;
	}
	public String getBusinessCode() {
	
		return businessCode;
	}
	public void setBusinessCode(String businessCode) {
	
		this.businessCode = businessCode;
	}
	public List<ParamsEntity> getParams() {
	
		return params;
	}
	public void setParams(List<ParamsEntity> params) {
	
		this.params = params;
	}
	
	
}

	