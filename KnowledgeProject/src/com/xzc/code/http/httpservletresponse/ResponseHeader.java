package com.xzc.code.http.httpservletresponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

/**
 * http头信息
 **************************************************
 * ClassName:ResponseHeader
 * @Description:TODO
 * @author:xiaozhichao
 * @date:2017年4月28日
 **************************************************
 */
public class ResponseHeader {
    private HttpServletResponse response;
    /**
     * Excel以流的形式导出
     * @Description:TODO
     * @param:
     * @return:void
     * @throws
     * @author:xiaozhichao
     * @date:2017年4月28日
     */
	public void responseExcel(){
		/**
		 * Content-disposition：MIME 的扩展协议
		 */
		response.setHeader("Content-disposition", "attachment; filename=" + "filename.xls");
		response.setContentType("application/ms-excel;");
		try {
			ServletOutputStream out = response.getOutputStream();
		} catch (IOException e) {
			
					// TODO Auto-generated catch block
					e.printStackTrace();
				
		}
	}
	/**
	 * HttpServletResponse对象
	 * @Description:TODO
	 * @param:
	 * @return:void
	 * @throws IOException 
	 * @throws
	 * @author:xiaozhichao 
	 * @date:2017年4月28日
	 */
	public void HttpServletResponseObject() throws IOException{
		/**
		 * Web服务器收到客户端的http请求，
		 * 会针对每一次请求，分别创建一个用于代表请求的request对象、和代表响应的response对象。
		 * 
		 * 获取客户机提交过来的数据，找request对象
		 * 向客户机输出数据，找response对象。
		 */
		HttpServletResponse res = null;
		/**
		 * 向客户端(浏览器)发送数据   输出流/字符流
		 */
		ServletOutputStream out = res.getOutputStream();
		PrintWriter pw = res.getWriter();
		/**
		 * 向客户端(浏览器)发送响应头
		 */
		res.addHeader("", "");
		/**
		 * 向客户端(浏览器)发送响应状态码
		 */
		res.setStatus(200);
	}
	
	/**
	 * 输出编码问题
	 * @Description:TODO
	 * @param:
	 * @return:void
	 * @throws IOException 
	 * @throws
	 * @author:xiaozhichao 
	 * @date:2017年4月28日
	 */
	public void HttpServletResponseEncode(HttpServletResponse res) throws IOException{
		/**
		 * 使用OutputStream流向客户端浏览器输出
		 * 在服务器端，数据是以哪个码表输出的，那么就要控制客户端浏览器以相应的码表打开
		 * 通过设置响应头控制浏览器的行为控制浏览器打开方式
		 */
		ServletOutputStream out = res.getOutputStream();
		response.setHeader("content-type", "text/html;charset=UTF-8");
		byte[] dataByteArr = "中国".getBytes("UTF-8");//将字符转换成字节数组，指定以UTF-8编码进行转换
		out.write(dataByteArr);//使用OutputStream流向客户端输出字节数组
		
		/**
		 * 使用PrintWriter流向客户端浏览器输出
		 * 设置编码输出放前面才有用
		 */
		res.setCharacterEncoding("utf-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
		PrintWriter pw = res.getWriter();//获取PrintWriter输出流
		//通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
		//还可以response.getWriter().write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
		response.setHeader("content-type", "text/html;charset=UTF-8");
	}
}

	