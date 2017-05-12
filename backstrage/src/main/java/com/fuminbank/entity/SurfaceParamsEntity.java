package com.fuminbank.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 **************************************************
 * ClassName:SurfaceResultEntity
 * @Description:TODO
 * @author:xiaozhichao
 * @date:2017年5月11日
 **************************************************
 */
public class SurfaceParamsEntity implements Serializable{
	
	
	/**
	 * @Fields serialVersionUID:TODO
	 */
		
	private static final long serialVersionUID = 3684601858135195915L;
	private boolean state = true;
	private String msg;
	private Integer count;
	private List<ParamsEntity> result;
	public boolean isState() {
	
		return state;
	}
	public void setState(boolean state) {
	
		this.state = state;
	}
	public String getMsg() {
	
		return msg;
	}
	public void setMsg(String msg) {
	
		this.msg = msg;
	}
	public Integer getCount() {
	
		return count;
	}
	public void setCount(Integer count) {
	
		this.count = count;
	}
	public List<ParamsEntity> getResult() {
	
		return result;
	}
	public void setResult(List<ParamsEntity> result) {
	
		this.result = result;
	}
	
	
	
}

	