package com.xzc.code.concurrent;
public class RaceConditionTest {
	private Object instance = null;
	/**
	 * �ȼ���ִ��
	 * A��B�߳�ִ��ʱ����Ϊʱ������⣬��ʱ�жϻ�����
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

	