/**
 * 
 */
var surface_dispatcher_View=function(){
	/**
	 * 数据初始化，进入页面则执行此方法
	 */
	var initData=function(){
		var data = $("#list_form")//.serialize();
		var parseData={};
		  
	    var o = {};    
	    var a = data.serializeArray();    
	    $.each(a, function() {    
	       if (o[this.name]) {    
	           if (!o[this.name].push) {    
	               o[this.name] = [o[this.name]];    
	           }    
	           o[this.name].push(this.value || '');    
	       } else {    
	           o[this.name] = this.value || '';    
	       }    
	    });    
		var url = $("#surface_url").val();
		var businessCode = $("#surface_businessCode").val();
		EshopAjax.dataAjax( url + '?businessCode=' + businessCode, { method:"post",datatype:'json',contentType:"application/json"}, JSON.stringify(o), function(html) {
			var pHtml='',thead='',tbody='';
			if(!html){
				pHtml +=
				'<table	class="table table-hover table-striped table-bordered table-advanced tablesorter">' +
					'<thead>' +
						'<tr>' +
							'<th style="width: 100%;">' + '</th>' +
						'</tr>' +
					'<thead>';
				pHtml +=
					'<tbody>' + 
						'<tr>' +
							'<td colspan="10" align="center"><div>没有相关数据！</div></td>' +
						'</tr>' + 
					'<tbody>' ;
			}else{
				pHtml += 
					'<table class="demo-tbl">' 
							;
				thead += 
						'<thead>' + 
                			'<tr>' +
                				'<th>参数名</th>' +
                				
                				'<th>参数值</th>' +
                			'</tr>' +
						'</thead>';
				tbody += 
						'<tbody>';
							;
				var cishu = 0;
				for(var k in html){
					cishu ++ ;
					if(cishu%2 == 0){
						tbody +=//odd
							'<tr class="tbl-item even">'
					}else{
						tbody +=//odd
							'<tr class="tbl-item odd">'
					}
					
					if( html[k] instanceof Object){
						tbody += 	'<td class="td-block"><p class="title" >'  + (k) + '</p></td>';
						tbody +=    '<td class="td-block >';
						for(var ki in html[k]){
							tbody +=    '<p class="desc" style="word-break: break-all;word-wrap: break-word;">' + ki + '&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp' + html[k][ki]  + '</p>';
						}
						tbody +=    '</td >';
					}else{
						var js = JSON.stringify(html[k])
						if(js.indexOf('{') != -1
								&& js.indexOf('}') != -1
								&& js.indexOf(':') != -1){
							tbody += 	'<td class="td-block"><p class="title" >'  + (k) + '</p></td>';
							tbody +=    '<td class="td-block>';
							var jp =  JSON.parse(html[k]);
							for(var ki in jp){
								tbody +=    '<p class="desc" style="word-break: break-all;word-wrap: break-word;">' + ki + '&nbsp&nbsp&nbsp&nbsp:&nbsp&nbsp&nbsp&nbsp' + jp[ki]  + '</p>';
							}
							tbody +=    '</td >';
						}else{
							tbody += 	'<td class="td-block"><p class="title" >'  + (k) + '</p></td>';
							tbody +=    '<td class="td-block><p class="desc" style="word-break: break-all;word-wrap: break-word;">' + html[k] + '</p></td >';
						}
					}
					tbody +=
						'</tr>';
				}
				tbody += 
						'</tbody>';
			}
			pHtml = pHtml + thead + tbody + '</table>';
			$("#list_data").html(pHtml);
			
			
			
		});
	};
	
	/**
	 * 进入页面加载完成后执行事件绑定
	 */
	var bindEvent_page=function(){
		//查询
		$("#btn_search").click(function(){
			
			initData();
			return false;
		});
		//blur事件
		
	};
	
	
	/**
	 * 对外的方法，只能调用return的，相当于public
	 */
	return {
		init:function(page,takeSize){
			bindEvent_page();
		}
	};
}();