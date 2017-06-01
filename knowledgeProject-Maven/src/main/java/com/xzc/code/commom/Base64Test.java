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
 * @Description:base64ת��
 * @author:xiaozhichao
 * @date:2017��6��1��
 **************************************************
 */
public class Base64Test {
	/**
	 * 
	 * @Description:ͼƬת��Ϊbase64�ַ���
	 * @param:@param path ͼƬ��ַ
	 * @param:@return
	 * @return:String
	 * @throws
	 * @author:xiaozhichao 
	 * @date:2017��6��1��
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
	 * @Description:base64תͼƬ
	 * @param:@param imgStr ͼƬbase64�ַ���
	 * @param:@param path ������ͼƬ��Ŀ¼��ַ
	 * @param:@return
	 * @return:boolean
	 * @throws
	 * @author:xiaozhichao 
	 * @date:2017��6��1��
	 */
	public static boolean GenerateImage(String imgStr,String path){
		if (imgStr == null) //ͼ������Ϊ��  
            return false;  
        BASE64Decoder decoder = new BASE64Decoder();  
        try	{  
            //Base64����  
            byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i)
            {  
                if(b[i]<0)  
                {//�����쳣����  
                    b[i]+=256;  
                }  
            }  
            //����jpegͼƬ  
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

	