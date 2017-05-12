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
public class SurfaceResultEntity implements Serializable{
	
	/**
	 * @Fields serialVersionUID:TODO
	 */
		
	private static final long serialVersionUID = 2461699077045016504L;
	private boolean state = true;
	private String msg;
	private Integer count;
	private List<ListEntity> result;
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
	public List<ListEntity> getResult() {
	
		return result;
	}
	public void setResult(List<ListEntity> result) {
	
		this.result = result;
	}
	@Override
	public String toString() {
		return "SurfaceResultEntity [state=" + state + ", msg=" + msg + ", count=" + count + ", result=" + result + "]";
	}
	
	
	
}

	