package com.xzc.code.concurrent;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class StatelessFactorizer implements Servlet {
	
	private long count= 0;
	public void init(ServletConfig config) throws ServletException {

		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {

		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		/**
		 * StatelessFactorizer此时是无状态的
		 * 不汉堡任何域，也不包含任何对其他类中域的引用
		 * 访问该类的线程不会影响另一个访问同一个他的线程的计算结果，两个线程无共享状态
		 * 因此无状态对象是线程安全的
		 * 
		 * 大多数servlet都是无状态的
		 * 只有当servlet在请求处理时需要保存一些信息，线程安全才会成为一个问题
		 */
		/*BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factory(i);
		encodeIntoResponse(res,factors);*/
		
		/**
		 * ++ count不是一个原子操作 读取 - 修改 - 写入 此时，是非线程安全的
		 */
		++ count;
	}

	@Override
	public String getServletInfo() {

		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public void destroy() {

		// TODO Auto-generated method stub

	}

}

	