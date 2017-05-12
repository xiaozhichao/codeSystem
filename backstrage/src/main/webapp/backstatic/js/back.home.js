/**
 * 首页页面
 */
var HomeView = function() {
	/**
	 * 初始化数据
	 */
	var initData = function() {
		goPage(UrlManager.weclome);
	};
	/**
	 * 绑定事情
	 */
	var bindEvent = function() {
		$("#side-menu li>ul>li,.breadcrumb li").click(function() {

			var url = $(this).attr("data-url");
			var data = $(this).find("form") ? $(this).find("form").serialize() : null;
			// 配置一个透明的询问框
			if (url != undefined && url != null && url != ""
					&& url.length > 0) {
				$("#side-menu li>ul>li").each(function() {
					$(this).removeClass("active");
				});
				$(this).addClass("active");
				if(data){
					goPage(url, true,data);
				}else{
					goPage(url, true);
				}
				
			}
		});
		//退出系统操作
		$("#logout").click(function(){
			var _self=$(this);
			layer.confirm("确定退出系统！",{title:MsgManager.op_title,icon:3,closeBtn:0},function(){
				window.location.href=_self.attr("data-url");
				layer.closeAll();
			},function(){});
		});
		// 字符验证 
	    jQuery.validator.addMethod("stringCheck", function(value, element) { 
	        return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value); 
	    }, "只能包括中文字、英文字母、数字和下划线."); 
	    
	    // 中文字两个字节 
	    jQuery.validator.addMethod("byteRangeLength", function(value, element, param) { 
	        var length = value.length; 
	        for(var i = 0; i < value.length; i++){ 
	            if(value.charCodeAt(i) > 127){ 
	                length++; 
	            } 
	        } 
	        return this.optional(element) || ( length >= param[0] && length <= param[1] ); 
	    }, "请确保输入的值在3-15个字节之间(一个中文字算2个字节)."); 
	 
	    // 身份证号码验证 
	    jQuery.validator.addMethod("isIdCardNo", function(value, element) { 
	        return this.optional(element) || idCardNoUtil.checkIdCardNo(value);     
	    }, "请正确输入您的身份证号码."); 
	    
	    //护照编号验证
	    jQuery.validator.addMethod("passport", function(value, element) { 
	        return this.optional(element) || checknumber(value);     
	    }, "请正确输入您的护照编号."); 
	   
	    // 手机号码验证 
	    jQuery.validator.addMethod("isMobile", function(value, element) { 
	        var length = value.length; 
	        var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/; 
	        return this.optional(element) || (length == 11 && mobile.test(value)); 
	    }, "请正确填写您的手机号码."); 
	  
	    // 电话号码验证 
	    jQuery.validator.addMethod("isTel", function(value, element) { 
	        var tel = /^\d{3,4}-?\d{7,9}$/; //电话号码格式010-12345678 
	        return this.optional(element) || (tel.test(value)); 
	    }, "请正确填写您的电话号码."); 
	 
	    // 联系电话(手机/电话皆可)验证 
	    jQuery.validator.addMethod("isPhone", function(value,element) { 
	        var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/; 
	        var tel = /^\d{3,4}-?\d{7,9}$/; 
	        return this.optional(element) || (tel.test(value) || mobile.test(value)); 
	    }, "请正确填写您的联系方式."); 
	  
	    // 邮政编码验证 
	    jQuery.validator.addMethod("isZipCode", function(value, element) { 
	        var tel = /^[0-9]{6}$/; 
	        return this.optional(element) || (tel.test(value)); 
	    }, "请正确填写您的邮政编码.");
	    //只有汉字
	    jQuery.validator.addMethod("isChar", function(value, element) { 
	        var tel = /^\u4E00-\u9FA5$/; 
	        return this.optional(element) || (tel.test(value)); 
	    }, "请输入汉字");
	    //两位小数验证
	    jQuery.validator.addMethod("isDouble", function(value, element) { 
	        var tel =  /^([1-9]\d{1,4}|0)(\.\d{0,2})?$/; 
	        return this.optional(element) || (tel.test(value)); 
	    }, "请输入汉字");
	};
	/**
	 * 只加载index页面，此时没有内容，内容放到各自的init方法添加
	 */
	var goPage = function(url, isClick,data) {
		EshopAjax.pageAjax(url, null, data, function(response) {
			$("#page-wrapper").html(response);
			if (url.indexOf("welcome") != -1 && isClick) {
				HomeView.init();
			}else if(url.indexOf("surface/dispatcher")!=-1){
				surface_dispatcher_View.init();
			}
		});
	};

	return {
		init : function() {
			initData();
			bindEvent();
		}
	};
}();