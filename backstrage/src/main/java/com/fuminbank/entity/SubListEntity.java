package com.fuminbank.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 **************************************************
 * ClassName:SubListEntity
 * @Description:子列表实体类
 * @author:xiaozhichao
 * @date:2017年5月10日
 **************************************************
 */
public class SubListEntity implements Serializable{
	
	/**
	 * @Fields serialVersionUID:TODO
	 */
		
	private static final long serialVersionUID = -9109977959943719014L;
	private Integer id;
	private String subName;
	private String businessCode;
	private List<ParamsEntity> params;
	
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

	