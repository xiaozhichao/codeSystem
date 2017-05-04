package com.xzc.code.concurrent;

import org.junit.Test;

/**
 * 
 **************************************************
 * ClassName:VolatileTest
 * @Description:volatile 测试类
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
		 * 实际运算结果每次可能都不一样
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
		System.out.println("运行结果 0：" + VolatileTest.count0);
	}
	@Test
	public void test1(){
		/**
		 * 用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最的值。
		 * 用来进行原子性操作
		 * 
		 * 本次测试结果也是每次不一样
		 */
		for(int i = 0;i<1000;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					VolatileTest.inc(1);
					
				}
			}).start();
		}
		System.out.println("运行结果 1 ：" + VolatileTest.count1);
	}
	
	/**
	 * jvm线程访问原理
	 * 当线程访问某一个对象时候值的时候，首先通过对象的引用找到对应在堆内存的变量的值，然后把堆内存
	 * 变量的具体值load到线程本地内存中，建立一个变量副本，之后线程就不再和对象在堆内存变量值有任何关系，而是直接修改副本变量的值，
	 * 在修改完之后的某一个时刻（线程退出之前），自动把线程变量副本的值回写到对象在堆中变量。这样在堆中的对象的值就产生变化了
	 * 
	 * 线程中变量流程 Read - load(加载) - use（使用） - asign（赋值） - store（写内存） - write
	 * read and load 从主存复制变量到当前工作内存
	 * use and assign  执行代码，改变共享变量值 
	 * store and write 用工作内存数据刷新主存相关内容
	 * 其中use and assign 可以多次出现
	 * 但是这一些操作并不是原子性，也就是 在read load之后，如果主内存count变量发生修改之后，线程工作内存中的值由于已经加载，不会产生对应的变化，所以计算出来的结果会和预期不一样
	 * 对于volatile修饰的变量，jvm虚拟机只是保证从主内存加载到线程工作内存的值是最新的
	 * 例如假如线程1，线程2 在进行read,load 操作中，发现主内存中count的值都是5，那么都会加载这个最新的值
	 * 在线程1堆count进行修改之后，会write到主内存中，主内存中的count变量就会变为6
	 * 线程2由于已经进行read,load操作，在进行运算之后，也会更新主内存count的变量值为6
	 * 导致两个线程及时用volatile关键字修改之后，还是会存在并发的情况
	 */
}

	