package com.fuminbank.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class CommonUtil {
	
	/**
	 * 处理输出<br/>
	 * 注意:流关闭需要自行处理
	 * @param out
	 * @param data
	 * @param len
	 * @throws IOException
	 */
	public static void doOutput(OutputStream outputStream, byte[] data, int len)
			throws IOException {
		int dataLen = data.length;
		int off = 0;
		while (off < data.length) {
			if (len >= dataLen) {
				outputStream.write(data, off, dataLen);
				off += dataLen;
			} else {
				outputStream.write(data, off, len);
				off += len;
				dataLen -= len;
			}

			// 刷新缓冲区
			outputStream.flush();
		}

	}
	
	/**
	 * 处理输入<br/>
	 * 注意:流关闭需要自行处理
	 * @param out
	 * @param data
	 * @param len
	 * @throws IOException
	 */
	public static String doInput(InputStream inputStream, byte[] bytes,String charset)
			throws IOException {
		StringBuffer buffer = new StringBuffer();
		int size = 0;
		while ((size = inputStream.read(bytes)) > 0) {
			String str = new String(bytes, 0, size, charset);
			buffer.append(str);
		}
		String data = buffer.toString();
		return data;
		
	}
	
	/**
	 * Http get/post 请求方法
	 * @Description:TODO
	 * @param:@param requestUrl 请求地址
	 * @param:@param requestMethod get/post
	 * @param:@param outputStr 请求参数
	 * @param:@param charset 编码方式
	 * @param:@return
	 * @return:String
	 * @throws
	 * @author:xiaozhichao
	 * @date:2016年10月17日
	 */
	public static String httpRequest(String requestUrl, String requestMethod, String outputStr,String charset,Integer timeout) {
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url
					.openConnection();
			// 以post方式通信
			conn.setRequestMethod(requestMethod);
			//不使用缓存
			conn.setUseCaches(false);
			//允许输入输出
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			conn.setConnectTimeout(timeout);
			// 当outputStr不为null时向输出流写数据
			if (null != outputStr) {
				byte[] postData = outputStr.getBytes(charset);
				
				OutputStream outputStream = conn.getOutputStream();
				//输出
				if(postData.length % 1024 == 0){
					doOutput(outputStream,postData,1024 * (postData.length / 1024));
				}else{
					doOutput(outputStream,postData,1024 * (postData.length / 1024) + 1);
				}
				// 注意编码格式
				outputStream.close();
				outputStream = null;
			}
			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			byte[] bytes = new byte[4096];
			String data = doInput(inputStream,bytes,charset);
			inputStream.close();
			
			// 释放资源
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			return data;
		} catch (ConnectException ce) {
			
		} catch (Exception e) {
			
		}
		return null;
	}
	
	public static String httpClientMethod(String requestUrl, String requestMethod, String outputStr,String charset,Integer timeout) {
	    String info = null;
	    try {
	      HttpClient httpclient = new HttpClient();
	      PostMethod post = new PostMethod(requestUrl);
	      post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, charset);
	      post.addParameter("id", outputStr);
	      
	      httpclient.executeMethod(post);
	      info = new String(post.getResponseBody(), charset);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		return info;

	  }
}

	