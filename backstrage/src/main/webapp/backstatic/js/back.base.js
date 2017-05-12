/**
 * Ajax
 */
var EshopAjax = function() {
	/**
	 * 加载调用方法
	 * 
	 * @param {Object}
	 *            action 接口action，url路径
	 * @param {Object}
	 *            config 配置参数 config={ method:"GET",//请求类型，GET、POST，不传则默认GET
	 *            async:true,//是否异步,不传则默认为true
	 *            datatype:'html',//返回的类型，json、html、text，不传则默认为html
	 *            timeout:10000,//每次ajax的请求超时时间，不传则默认60s
	 *            isLoading:false,//是否显示加载等待框，不传则默认加载
	 *            loadMsg:'加载时显示的提示信息'，不传则默认加载中 }
	 * @param {Object}
	 *            data:传至后台的数据，可以json也可以是序列化后的字符串等
	 * @param {Function}
	 *            successFunc 成功回调
	 * @param {Function}
	 *            errorFunc 异常回调
	 */
	var baseAjax = function(action, config, data, successFunc, errorFunc) {
		var method = 'POST';// HTTP请求类型
		var async = true; // 默认为异步
		var datatype = "html";// 服务器返回json格式数据
		var timeout = 60000;// 超时时间
		var isLoading = true;// 是否需要弹框
		var loadMsg = MsgManager.layer.loading;// 页面加载
		var contentType = "application/x-www-form-urlencoded";// 发送信息至服务器时内容编码类型 
		if (config != null) {
			if (config.method != null && config.method != undefined) {
				method = config.method;
			}
			if (config.async != null && config.async != undefined) {
				async = config.async;
			}
			if (config.datatype != null && config.datatype != undefined) {
				datatype = config.datatype;
			}
			if (config.timeout != null && config.timeout != undefined) {
				timeout = config.timeout;
			}
			if (config.isLoading != null && config.isLoading != undefined) {
				isLoading = config.isLoading;
			}
			if (config.loadMsg != null && config.loadMsg != undefined) {
				loadMsg = config.loadMsg;
			}
			if (config.contentType != null && config.contentType != undefined) {
				contentType = config.contentType;
			}
		}
		var load_layer = null;

		$.ajax({
			url : action,
			data : data,
			contentType : contentType,
			dataType : datatype,
			type : method,
			async : async,
			timeout : timeout, // 超时时间设置为60秒
			beforeSend : function() {
				isLoading && (load_layer = layer.msg(loadMsg, {
					time : 0,
					shade : [ 0.3, '#393D49' ]
				}));
			},
			success : function(response) {
				if (response != null)
					successFunc && successFunc(response);
				else
					errorFunc && errorFunc();
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				layer.msg(MsgManager.website_error, {
					shade : [ 0.3, '#000' ],
					icon : 2
				});
				errorFunc && errorFunc();
			},
			complete : function(XMLHttpRequest, textStatus) {
				load_layer && layer.close(load_layer);
			}
		});
	};

	var pageAjax = function(action, config, data, successFunc, errorFunc) {
		if (config == null || config == undefined)
			config = {};
		config.loadMsg = MsgManager.layer.page_loading;// 页面加载
		config.datatype = "html";
		config.method = "GET";
		baseAjax(action, config, data, successFunc, errorFunc);
	};

	var dataAjax = function(action, config, data, successFunc, errorFunc) {
		if (config == null || config == undefined)
			config = {};
		config.loadMsg = MsgManager.layer.data_loading;// 数据加载
		baseAjax(action, config, data, successFunc, errorFunc);
	};

	var opAjax = function(action, config, data, successFunc, errorFunc) {
		if (config == null || config == undefined)
			config = {};
		config.loadMsg = MsgManager.layer.op_loading;// 操作中
		baseAjax(action, config, data, successFunc, errorFunc);
	};

	return {
		/**
		 * 页面加载调用方法
		 * 
		 * @param {Object}
		 *            action 接口action，url路径
		 * @param {Object}
		 *            config 接口参数 config={ method:"GET",//请求类型，GET、POST，不传则默认GET
		 *            async:true,//是否异步,不传则默认为true
		 *            datatype:'html',//返回的类型，json、html、text，不传则默认为html
		 *            timeout:10000,//每次ajax的请求超时时间，不传则默认60s
		 *            isLoading:false,//是否显示加载等待框，不传则默认加载 }
		 * @param {Object}
		 *            data:传至后台的数据，可以json也可以是序列化后的字符串等
		 * @param {Function}
		 *            successFunc 成功回调
		 * @param {Function}
		 *            errorFunc 异常回调
		 */
		pageAjax : function(action, config, data, successFunc, errorFunc) {
			pageAjax(action, config, data, successFunc, errorFunc);
		},
		/**
		 * 数据加载调用方法
		 * 
		 * @param {Object}
		 *            action 接口action，url路径
		 * @param {Object}
		 *            config 接口参数 config={ method:"GET",//请求类型，GET、POST，不传则默认GET
		 *            async:true,//是否异步,不传则默认为true
		 *            datatype:'html',//返回的类型，json、html、text，不传则默认为html
		 *            timeout:10000,//每次ajax的请求超时时间，不传则默认60s
		 *            isLoading:false,//是否显示加载等待框，不传则默认加载 }
		 * @param {Object}
		 *            data:传至后台的数据，可以json也可以是序列化后的字符串等
		 * @param {Function}
		 *            successFunc 成功回调
		 * @param {Function}
		 *            errorFunc 异常回调
		 */
		dataAjax : function(action, config, data, successFunc, errorFunc) {
			dataAjax(action, config, data, successFunc, errorFunc);
		},
		/**
		 * 操作（比如add，update，delete等）调用方法
		 * 
		 * @param {Object}
		 *            action 接口action，url路径
		 * @param {Object}
		 *            config 接口参数 config={ method:"GET",//请求类型，GET、POST，不传则默认GET
		 *            async:true,//是否异步,不传则默认为true
		 *            datatype:'html',//返回的类型，json、html、text，不传则默认为html
		 *            timeout:10000,//每次ajax的请求超时时间，不传则默认60s
		 *            isLoading:false,//是否显示加载等待框，不传则默认加载 }
		 * @param {Object}
		 *            data:传至后台的数据，可以json也可以是序列化后的字符串等
		 * @param {Function}
		 *            successFunc 成功回调
		 * @param {Function}
		 *            errorFunc 异常回调
		 */
		opAjax : function(action, config, data, successFunc, errorFunc) {
			opAjax(action, config, data, successFunc, errorFunc);
		},
		/**
		 * 加载调用方法
		 * 
		 * @param {Object}
		 *            action 接口action，url路径
		 * @param {Object}
		 *            config 接口参数 config={ method:"GET",//请求类型，GET、POST，不传则默认GET
		 *            async:true,//是否异步,不传则默认为true
		 *            datatype:'html',//返回的类型，json、html、text，不传则默认为html
		 *            timeout:10000,//每次ajax的请求超时时间，不传则默认60s
		 *            isLoading:false,//是否显示加载等待框，不传则默认加载
		 *            loadMsg:'加载时显示的提示信息'，不传则默认加载中 }
		 * @param {Object}
		 *            data:传至后台的数据，可以json也可以是序列化后的字符串等
		 * @param {Function}
		 *            successFunc 成功回调
		 * @param {Function}
		 *            errorFunc 异常回调
		 */
		diyAjax : function(action, config, data, successFunc, errorFunc) {
			baseAjax(action, config, data, successFunc, errorFunc);
		}
	};
}();

/**
 * 通用辅助类
 */
var EshopUtils = function() {
	/**
	 * 时间对比，实现几天前的效果
	 * 
	 * @param {Object}
	 *            time1
	 */
	var jsDateDiff = function(time1, time2) {
		var d_minutes, d_hours, d_days;
		// var timeNow = parseInt(new Date().getTime() / 1000);
		var d;
		d = parseInt(getDateTimeStamp(time2) / 1000)
				- parseInt(getDateTimeStamp(time1) / 1000);
		d_days = parseInt(d / 86400);
		d_hours = parseInt(d / 3600);
		d_minutes = parseInt(d / 60);
		var result = "";
		
		if (d_days > 0) { 
			result += d_days + '天'; 
		} if (d_hours > 0) { 
			result += d_hours + '小时'; 
		}
		
		if (d_minutes > 0) {
			result += d_minutes + '分钟';
		}
		return result;
	};
	/**
	 * 字符串转换为时间戳
	 * 
	 * @param {Object}
	 *            dateStr
	 */
	var getDateTimeStamp = function(dateStr) {
		return Date.parse(dateStr.replace(/-/gi, '/'));
	};
	/**
	 * 日期转换
	 * 
	 * @param {Object}
	 *            format
	 */
	var dateFormat = function(date, format) {
		var o = {
			"M+" : date.getMonth() + 1, // month
			"d+" : date.getDate(), // day
			"h+" : date.getHours(), // hour
			"m+" : date.getMinutes(), // minute
			"s+" : date.getSeconds(), // second
			"q+" : Math.floor((date.getMonth() + 3) / 3), // quarter
			"S" : date.getMilliseconds()
		};
		if (/(y+)/.test(format))
			format = format.replace(RegExp.$1, (date.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		for ( var k in o)
			if (new RegExp("(" + k + ")").test(format))
				format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
						: ("00" + o[k]).substr(("" + o[k]).length));
		return format;
	};
	/**
	 * 格式化为日期
	 * 
	 * @param {Date|Number}
	 *            value 日期对象或时间戳
	 * @param {Object}
	 *            format 目标格式，默认为yyyy-MM-dd
	 */
	var covertToDate = function(value, format) {
		format = typeof (format) == "string" ? format : "yyyy-MM-dd";
		if (value instanceof Date) {
			// do nothing
		} else if (!isNaN(value) && value != "") {
			value = new Date(value * 1000);
		} else {
			return value;
		}
		return this.dateFormat(value, format);
	};
	 
	return {
		/**
		 * 时间对比，实现几天前的效果
		 * 
		 * @param {Object}
		 *            time1
		 */
		jsDateDiff : function(time1, time2) {
			return jsDateDiff(time1, time2);
		},
		covertToDate : function(value, format) {
			return covertToDate(value, format);
		},pointContains:function(points, p){
			return pointContains(points, p);
		}
	};
}();
/**
 * tips帮助类，调用方式 FskjTips.auto('.linchuang', '.linchuang', 'xxx');
 */
var EshopTips = function() {
	/**
	 * 自动显示和隐藏tips，实现滑入显示，滑出隐藏效果
	 * 
	 * @param el
	 *            需要滑过的元素
	 * @param targetEl
	 *            tips显示依附的元素
	 * @param msg
	 *            显示内容 如果msg为空则取data-msg属性值
	 * @param color
	 *            显示背景色
	 */
	var auto = function(el, targetEl, msg, color) {
		var linchuang_tips=null;

		color = (color == undefined || color == '' || color == null) ? '#3595CC'
				: color;

		$(el).hover(
				function() {
					// 如果msg为空则取data-msg属性值
					msg = (msg == undefined || msg == "") ? $(this).attr(
							"data-msg") : msg;
					if (el == targetEl) {
						linchuang_tips = layer.tips(msg, this, {
							tips : [ 1, color ],
							time : 0
						});
					} else {
						linchuang_tips = layer.tips(msg, targetEl, {
							tips : [ 1, color ],
							time : 0
						});
					}
				}, function() {
					layer.close(linchuang_tips);
				});
	};
	return {
		auto : function(el, targetEl, msg, color) {
			auto(el, targetEl, msg, color);
		}
	};
}();
/**
 * 验证插件封装
 */
var EshopValidate=function(){
	/**
	 * 执行验证
	 */
	var excute=function(frmEl,rules,messages){
		frmEl.validate({
			errorElement: 'div',
			errorClass: 'help-block',
			focusInvalid: false,
			rules: rules,
			messages: messages,
			invalidHandler: function (event, validator) { //display error alert on form submit   
				$('.alert-danger').show();
			},
			highlight: function (e) {
				$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
			},
			success: function (e) {
				$(e).closest('.form-group').removeClass('has-error').addClass('has-info');
				$(e).remove();
			},
			errorPlacement: function (error, element) {
				error.insertAfter(element.parent());
			},
			submitHandler: function (form) {
			},
			invalidHandler: function (form) {
			}
		});
	};
	return {
		excute:function(frmEl,rules,messages){
			excute(frmEl,rules,messages);
		}
	};
}();
// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function(fmt) { // author: meizz
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
};
/**
 * 对Date的扩展，将 Date 转化为指定格式的String 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q)
 * 可以用 1-2 个占位符 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) eg: (new
 * Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 (new
 * Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04 (new
 * Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04 (new
 * Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04 (new
 * Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
 */
Date.prototype.pattern = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, // 小时
		"H+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	var week = {
		"0" : "/u65e5",
		"1" : "/u4e00",
		"2" : "/u4e8c",
		"3" : "/u4e09",
		"4" : "/u56db",
		"5" : "/u4e94",
		"6" : "/u516d"
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	if (/(E+)/.test(fmt)) {
		fmt = fmt
				.replace(
						RegExp.$1,
						((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f"
								: "/u5468")
								: "")
								+ week[this.getDay() + ""]);
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
};