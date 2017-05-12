/**
 * 登录页面
 */
var LoginView = function () {
    /**
     * 绑定事情
     */
   var bindEvent=function(){
	   validate();
	   $(".btn-success").on("click",function(){
		   login();
	   });
	   $("#imgVeryCode").click(function () {
		   var t = new Date();
		   var src = $("#imgVeryCode").attr("src");
		   $("#imgVeryCode").attr("src", src + "?t=" + t);
	   });
   };
   var login=function(){
   	   if(!$('#validation-loginForm').valid()) 
   			return false;

   	   var loginID=$.trim($("#loginID").val());
   	   var loginPwd=$.trim($("#loginPwd").val());
   	   var verifyCode=$.trim($("#verifyCode").val());
   	   
   	   //配置一个透明的询问框
   	   var loading=layer.msg('<div style="line-height:32px;padding-left: 40px;background:url('+ctx+'/plugin/layer/skin/default/loading-2.gif) no-repeat;">正在努力登录中...</div>',{time:0,shade: [0.3, '#393D49']});
   	   
   	   $.ajax({
      		url : LoginView.url,
      		type : "post",
      		dataType : "json",
      		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
      		data : {
      			"loginID" : loginID,
      			"loginPwd" : loginPwd,
      			"verifyCode" : verifyCode
      		},
      		success : function(response) {
      			if(response.messageCode=="SUCCESS"){
      				layer.msg("恭喜您登录成功，页面跳转中...", {icon: 1,shade: [0.3,'#000'] },function(){
                     		window.location.href = LoginView.home_url;
                     });
      			}else{
      				$("#imgVeryCode").trigger('click');
      				layer.msg(response.messageDescription, {icon: 2,shade: [0.3,'#000']});
      			}
      		},
   			error : function(data) {
   				layer.msg("登录失败，请稍后尝试！", {icon: 2,shade: [0.3,'#000']});
   			},complete:function(){
   				layer.close(loading);	   				
   			}
      	});
   };
   
	var validate=function(){
		$('#validation-loginForm').validate({
			errorElement: 'div',
			errorClass: 'help-block',
			focusInvalid: false,
			rules: {
				loginPwd: {
					required: true,
					minlength: 1
				},
				loginID: {
					required: true
				},
				verifyCode:{
					required:true
				}
			},
	
			messages: {
				loginID: {
					required: "请输入用户名."
				},
				loginPwd: {
					required: "请输入登录密码.",
					minlength: "登录密码不能长度不能少于1."
				},
				verifyCode:{
					required:"请输入验证码."
				}
			},
			invalidHandler: function (event, validator) { //display error alert on form submit   
				$('.alert-danger', $('.login-form')).show();
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
		url:"",
		home_url:"",
		loading:"",
		success_msg:"",
		init:function(){
			bindEvent();
		}
	};
}();