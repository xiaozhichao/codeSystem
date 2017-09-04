package com.xzc.code.commom;

import org.junit.Test;

public class NullEquals {
	@Test
	public void testNullEqualsString(){
		String nulls = null;//ddss
		System.out.println(nulls.equals("null"));
		
		
		
	}
	@Test
	public void testStringEqualsNull(){
		String nulls = null;
		System.out.println("null".equals(nulls));
	}
}

	