package com.xzc.code.concurrent;

import org.junit.Test;

/**
 * 
 **************************************************
 * ClassName:VolatileTest
 * @Description:volatile ������
 * @author:xiaozhichao
 * @date:2017-5-4
 **************************************************
 */
public class VolatileTest {
	private static int count0 = 0;
	private volatile static int count1 = 0;
	public static void inc(int type){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
				
		}
		if(0 == type){
			count0 ++ ;
		}else{
			count1 ++ ;
		}
		
	}
	@Test
	public void test0(){
		/**
		 * ʵ��������ÿ�ο��ܶ���һ��
		 * 
		 */
		for(int i = 0;i<1000;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					VolatileTest.inc(0);
					
				}
			}).start();
		}
		System.out.println("���н�� 0��" + VolatileTest.count0);
	}
	@Test
	public void test1(){
		/**
		 * ��volatile���εı������߳���ÿ��ʹ�ñ�����ʱ�򣬶����ȡ�����޸ĺ�����ֵ��
		 * ��������ԭ���Բ���
		 * 
		 * ���β��Խ��Ҳ��ÿ�β�һ��
		 */
		for(int i = 0;i<1000;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					VolatileTest.inc(1);
					
				}
			}).start();
		}
		System.out.println("���н�� 1 ��" + VolatileTest.count1);
	}
	
	/**
	 * jvm�̷߳���ԭ��
	 * ���̷߳���ĳһ������ʱ��ֵ��ʱ������ͨ������������ҵ���Ӧ�ڶ��ڴ�ı�����ֵ��Ȼ��Ѷ��ڴ�
	 * �����ľ���ֵload���̱߳����ڴ��У�����һ������������֮���߳̾Ͳ��ٺͶ����ڶ��ڴ����ֵ���κι�ϵ������ֱ���޸ĸ���������ֵ��
	 * ���޸���֮���ĳһ��ʱ�̣��߳��˳�֮ǰ�����Զ����̱߳���������ֵ��д�������ڶ��б����������ڶ��еĶ����ֵ�Ͳ����仯��
	 * 
	 * �߳��б������� Read - load(����) - use��ʹ�ã� - asign����ֵ�� - store��д�ڴ棩 - write
	 * read and load �����渴�Ʊ�������ǰ�����ڴ�
	 * use and assign  ִ�д��룬�ı乲�����ֵ 
	 * store and write �ù����ڴ�����ˢ�������������
	 * ����use and assign ���Զ�γ���
	 * ������һЩ����������ԭ���ԣ�Ҳ���� ��read load֮��������ڴ�count���������޸�֮���̹߳����ڴ��е�ֵ�����Ѿ����أ����������Ӧ�ı仯�����Լ�������Ľ�����Ԥ�ڲ�һ��
	 * ����volatile���εı�����jvm�����ֻ�Ǳ�֤�����ڴ���ص��̹߳����ڴ��ֵ�����µ�
	 * ��������߳�1���߳�2 �ڽ���read,load �����У��������ڴ���count��ֵ����5����ô�������������µ�ֵ
	 * ���߳�1��count�����޸�֮�󣬻�write�����ڴ��У����ڴ��е�count�����ͻ��Ϊ6
	 * �߳�2�����Ѿ�����read,load�������ڽ�������֮��Ҳ��������ڴ�count�ı���ֵΪ6
	 * ���������̼߳�ʱ��volatile�ؼ����޸�֮�󣬻��ǻ���ڲ��������
	 */
}

	