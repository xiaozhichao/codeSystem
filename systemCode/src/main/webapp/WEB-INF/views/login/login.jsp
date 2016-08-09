
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="/WEB-INF/views/common.jsp"%>

<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Paper Stack</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/login/login.css" />
<script type="text/javascript" src="<%=basePath %>js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/rsa/Barrett.js"></script>
<script type="text/javascript" src="<%=basePath %>js/rsa/BigInt.js"></script>
<script type="text/javascript" src="<%=basePath %>js/rsa/RSA.js"></script>
<script type="text/javascript">  
function rsalogin()  
{  
   if($("#password").val().trim() == "" || $("#Username").val().trim() == ""){
	   $(".error").html("账号密码不能为空");
	   $(".error").show();
	   return false;
   }
   bodyRSA();  
   var result = encryptedString(key, $("#password").val().trim());  
   //alert(result);  
   loginForm.action="login.do?result="+result;  
   loginForm.submit();  
}  
var key ;  
function bodyRSA()  
{  
    setMaxDigits(130);  
    key = new RSAKeyPair("10001","","8c1cd09a04ed01aafe70dc84c5f32ae23a16fe8fc8898aba6797c5a9c708720de4f08dbf086af429fc51c0636208f56de20a8ab5686affd9bdfb643ae1e90d5617155c4867eef06b0884ba8ecd187907c7069ae3eed4f0155eeca6573411864035ae803ad8fd91a0cc479f27e41b19c13465ab30f3cfbfd14de56f49cbd09481");   
    
}  
  
</script>  
</head>
<body>
<div class="container">
	<section id="content">
		<form action="DEFAULT">
			<h1>Login Form</h1>
			<div>
				<input type="text" placeholder="Username" required="" id="username" />
			</div>
			<div>
				<input type="password" placeholder="Password" required="" id="password" />
			</div>
			<div>
				<span class="error">dddd</span>
			</div>
			<div>
				<input type="submit" value="Log in" />
				<a href="#">Lost your password?</a>
				<a href="#">Register</a>
			</div>
		</form><!-- form -->
		<div class="button">
			<a href="#">Download source file</a>
		</div><!-- button -->
	</section><!-- content -->
</div><!-- container -->
</body>
</html>
