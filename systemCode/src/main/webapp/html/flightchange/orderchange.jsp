<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>选择变更航班日期</title>
<link rel="stylesheet" href="../css/g-base.css">
<link rel="stylesheet" href="../css/c-order.css">
</head>
<body>
<article class="container" id="m-change">

	<header class="g-hd">
		<h1>选择变更航班日期</h1>
		<a href="/order.do?action=querychangelist&payFlag=1&viewtype=2" class="back"></a>
		<a href="tel:95524" class="call"></a>
	</header>

	<section class="g-bd">
		<div class="m-change"></div>
	</section>
	
</article>

<script src="../js/sea-wechat.js"></script>
<script>
	seajs.use('change');
	var OrderInfo =${result};
</script>
 <%@ include file="/cheque/base.html" %>
</body>
</html>
