package com.fuminbank.service;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.fuminbank.common.CommonUtil;
import com.fuminbank.entity.SurfaceParamsEntity;
import com.fuminbank.entity.SurfaceResultEntity;

@Service
public class SurfaceDispatcherService {
	@Value("${surface.list.url}")  
    private String surface_list_url; 
	
	@Value("${surface.params.url}")  
    private String surface_params_url;
	
	@Value("${surface.http.timeout}")
	private Integer timeOut;
	
	private static final String POST = "POST";
	private static final String GET = "GET";
	private static final String DEFAUT_CHARTSET = "UTF-8";
	/**
	 * 
	 * @Description:获取列表
	 * @param:@return
	 * @return:List<ListEntity>
	 * @throws
	 * @author:xiaozhichao 
	 * @date:2017年5月10日
	 */
	public SurfaceResultEntity getList(){
		SurfaceResultEntity result = new SurfaceResultEntity();
		String resultStr = CommonUtil.httpRequest(surface_list_url, GET, null, DEFAUT_CHARTSET,timeOut);
		result = JSON.parseObject(resultStr, SurfaceResultEntity.class);
		return result;
		//{"state":true,"msg":"获取列表成功!","count":2,"result":[{"id":1,"name":"芝麻信用","url":"http://139.196.125.230:8082/connect-platform/zmxy?businessCode=","subList":[{"id":1,"subName":"反欺诈信息验证 ","businessCode":"003"},{"id":2,"subName":"申请欺诈评分","businessCode":"004"},{"id":3,"subName":"欺诈关注清单","businessCode":"006"}]},{"id":2,"name":"云从科技","url":"http://139.196.125.230:8082/connect-platform/cloudwalk?businessCode=","subList":[{"id":4,"subName":"银行卡OCR","businessCode":"001"},{"id":5,"subName":"身份证OCR","businessCode":"002"},{"id":6,"subName":"简单人像对比","businessCode":"003"},{"id":7,"subName":"联网核查人像比对,不返图片","businessCode":"004"},{"id":8,"subName":"联网身份核查,不返回照片","businessCode":"005"},{"id":9,"subName":"人、证、公安三像比对，不返回图片","businessCode":"006"}]}]}
	}
	
	/**
	 * 
	 * @Description:获取子列表查询参数
	 * @param:@param id
	 * @param:@return
	 * @return:List<ParamsEntity>
	 * @throws
	 * @author:xiaozhichao 
	 * @date:2017年5月10日
	 */
	public SurfaceParamsEntity getParams(Integer id){
		SurfaceParamsEntity result = new SurfaceParamsEntity();
		try {
	    	HttpClient httpclient = new HttpClient();
		    PostMethod post = new PostMethod(surface_params_url);
		    post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, DEFAUT_CHARTSET);
		    post.addParameter("id", String.valueOf(id));
			httpclient.executeMethod(post);
			String info = new String(post.getResponseBody(), DEFAUT_CHARTSET);
			result = JSON.parseObject(info, SurfaceParamsEntity.class);
			//{"state":true,"msg":"获取列表成功!","count":10,"result":[{"id":13,"type":"String","name":"身份证","field":"certNo","notNull":true},{"id":14,"type":"String","name":"证件类型","field":"certType","notNull":true},{"id":15,"type":"String","name":"姓名","field":"name","notNull":true},{"id":16,"type":"String","name":"手机","field":"mobile","notNull":true},{"id":17,"type":"String","name":"银行卡","field":"bankCard","notNull":true},{"id":18,"type":"String","name":"地址","field":"address","notNull":true},{"id":19,"type":"String","name":"ip地址","field":"ip","notNull":true},{"id":20,"type":"String","name":"物理地址","field":"mac","notNull":true},{"id":21,"type":"String","name":"wifi的物理地址","field":"wifimac","notNull":true},{"id":22,"type":"String","name":"国际移动设备标志","field":"imei","notNull":true}]}
		} catch (Exception e) {
			
		} 
	    return result;
	}
}

	