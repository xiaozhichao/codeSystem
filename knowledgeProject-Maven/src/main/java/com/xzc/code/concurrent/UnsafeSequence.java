package com.xzc.code.concurrent;

/**
 * 非线程安全类
 **************************************************
 * ClassName:UnsafeSequence
 * @Description:TODO
 * @author:xiaozhichao
 * @date:2017-5-4
 **************************************************
 */
<<<<<<< HEAD
public class UnsafeSequence{
	private int value;
	
	public int getNext(){
		return ++ value;
	}
}

=======
@NotThreadSafe
public class UnsafeSequence {
	private int value;
	
	public int getNext(){
		return value ++;
	}
}
>>>>>>> branch 'master' of https://github.com/xiaozhichao/codeSystem.git

	