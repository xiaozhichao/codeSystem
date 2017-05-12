package com.fuminbank.entity;

import java.util.List;

public class SurFaceListEntity {
	private boolean state;
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
	
}

	