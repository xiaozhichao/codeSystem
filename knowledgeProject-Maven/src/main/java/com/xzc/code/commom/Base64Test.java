package com.xzc.code.commom;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 **************************************************
 * ClassName:Base64Test
 * @Description:base64转换
 * @author:xiaozhichao
 * @date:2017年6月1日
 **************************************************
 */
public class Base64Test {
	/**
	 * 
	 * @Description:图片转化为base64字符串
	 * @param:@param path 图片地址
	 * @param:@return
	 * @return:String
	 * @throws
	 * @author:xiaozhichao 
	 * @date:2017年6月1日
	 */
	public static String GetImageStr(String path){
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(path);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		BASE64Encoder be = new BASE64Encoder();
		return be.encode(data);
	}
	/**
	 * 
	 * @Description:base64转图片
	 * @param:@param imgStr 图片base64字符串
	 * @param:@param path 生成新图片根目录地址
	 * @param:@return
	 * @return:boolean
	 * @throws
	 * @author:xiaozhichao 
	 * @date:2017年6月1日
	 */
	public static boolean GenerateImage(String imgStr,String path){
		if (imgStr == null) //图像数据为空  
            return false;  
        BASE64Decoder decoder = new BASE64Decoder();  
        try	{  
            //Base64解码  
            byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i)
            {  
                if(b[i]<0)  
                {//调整异常数据  
                    b[i]+=256;  
                }  
            }  
            //生成jpeg图片  
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
            OutputStream out = new FileOutputStream(path + "//" + sf.format(new Date()) + ".jpg");      
            out.write(b);  
            out.flush();  
            out.close();  
            return true;  
        }   
        catch (Exception e)   
        {  
        return false; 
        }
	}
	public static void main(String[] args) {
		System.out.println(GetImageStr("C://Users//thinkpad//Desktop//2.jpg"));
		System.out.println(GenerateImage(GetImageStr("C://Users//thinkpad//Desktop//2.jpg"),"C://Users//thinkpad//Desktop"));
	}
}

	