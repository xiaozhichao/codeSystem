package com.xzc.code.concurrent;

import org.junit.Test;

public class UnsafeSequenceTest {
	@Test
	public void test1(){
		Thread u1 = new UnsafeSequenceThread();
		Thread u2 = new UnsafeSequenceThread();
		u1.start();
		u2.start();
	}
}

	