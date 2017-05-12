package com.fuminbank.entity;

import java.io.Serializable;


/**
 * 返回查询对象基类，包含错误码和错误提示
 * 
 * @author erlinshy
 * 
 */
public class QueryResult<T> implements Serializable {

	
	/**
	 * @Fields serialVersionUID:TODO
	 */
		
	private static final long serialVersionUID = 4364651202411308845L;
	T resultObject;
	private boolean isSuccess = true;
	private String messageCode;
	private String message;
	public T getResultObject() {
	
		return resultObject;
	}
	public void setResultObject(T resultObject) {
	
		this.resultObject = resultObject;
	}
	public boolean isSuccess() {
	
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
	
		this.isSuccess = isSuccess;
	}
	public String getMessageCode() {
	
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
	
		this.messageCode = messageCode;
	}
	public String getMessage() {
	
		return message;
	}
	public void setMessage(String message) {
	
		this.message = message;
	}
	public static long getSerialversionuid() {
	
		return serialVersionUID;
	}
	
	
}
