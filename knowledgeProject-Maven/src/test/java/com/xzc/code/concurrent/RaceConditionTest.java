package com.xzc.code.concurrent;
public class RaceConditionTest {
	private Object instance = null;
	/**
	 * 先检查后执行
	 * A、B线程执行时，因为时序的问题，此时判断会有误
	 * @Description:TODO
	 * @param:@return
	 * @return:Object
	 * @throws
	 * @author:xiaozhichao 
	 * @date:2017-5-5
	 */
	public Object getInstance(){
		if(instance == null)
			instance = new Object();
		return instance;
	}
}

	