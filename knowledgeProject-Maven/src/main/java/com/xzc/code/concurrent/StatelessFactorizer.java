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
		 * StatelessFactorizer��ʱ����״̬��
		 * �������κ���Ҳ�������κζ����������������
		 * ���ʸ�����̲߳���Ӱ����һ������ͬһ�������̵߳ļ������������߳��޹���״̬
		 * �����״̬�������̰߳�ȫ��
		 * 
		 * �����servlet������״̬��
		 * ֻ�е�servlet��������ʱ��Ҫ����һЩ��Ϣ���̰߳�ȫ�Ż��Ϊһ������
		 */
		/*BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factory(i);
		encodeIntoResponse(res,factors);*/
		
		/**
		 * ++ count����һ��ԭ�Ӳ��� ��ȡ - �޸� - д�� ��ʱ���Ƿ��̰߳�ȫ��
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

	