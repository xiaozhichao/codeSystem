<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>退票</title>
<link rel="stylesheet" href="../css/g-base.css">
<link rel="stylesheet" href="../css/c-order.css">
</head>
<script src="/js/sea-wechat.js"></script>
<script language="JavaScript" type="text/javascript">
seajs.use(['/js/sea-module/lib/jquery-2.1.0.min'], function(){

$(".allselect").click(function(){
//全选
if($(this).attr("data-selected")=="false")
{
$(this).attr("data-selected","true");
$(".selectinfo").each(function(){
	$(this).attr("data-selected","true");
})
}
else if($(this).attr("data-selected")=="true")
{
	$(this).attr("data-selected","false");
	$(".selectinfo").each(function(){
		$(this).attr("data-selected","false");
	})
}
});
//选择
$(".selectinfo").click(function(){
if($(this).attr("data-selected")=="true")
{
	$(this).attr("data-selected","false");
}
else if($(this).attr("data-selected")=="false")
{
	$(this).attr("data-selected","true");
}
});
//提交时获取所有的订单明细id
$(".btn-group").click(function(){
var orderHeadId="";
$(".selectinfo").each(function(){
//如果选中了则相加
if($(this).attr("data-selected")=="true")
 orderHeadId = orderHeadId + $(this).prev().val()+"/";
})
if(orderHeadId=="")
{
alert("请选择乘机人!");
return;
}
$("#allheadno").val(orderHeadId);
$("#refundfm").submit();
});
});
</script>
<body>

<article class="container" id="m-refund">

	<header class="g-hd">
		<h1>退票</h1>
		<a href="/order.do?action=querychangelist&payFlag=1&viewtype=2" class="back"></a>
		<a href="tel:95524" class="call"></a>
	</header>

	<section class="g-bd">
		<form id="refundfm" action="order.do?action=CalcRetTktFee" method="post">
		<input type="hidden" name="orderNo" id="orderno" value="${order.orderNo}"/>
		<input type="hidden" name="allheadNo" id="allheadno" value="" />
		</form>
				<div class="m-change">		
					<ul>
						<c:forEach items="${tickets}" var="info" varStatus="i">						
							<li class="item">
								<h2>
								<!--获取每一个订单明细ID-->
								<input  type="hidden" class="orderHeadId" value=${info.orderHeadId} />
									<span class="u-radio selectinfo" data-selected="true"></span>
									<span>${info.familyName}：${info.cardNo}</span>
								</h2>
								<dl class="f-db">
									<dt>航班号：</dt>
									<dd>${info.flightNo}</dd>
								</dl>
								<dl class="f-db">
									<dt>起飞时间：</dt>
									<dd>${info.oriDate} ${info.oriTime}</dd>
								</dl>
							</li>
						</c:forEach>				
					</ul>
					<div class="all-select">
						<span class="u-radio allselect" data-selected="false"></span>
						<label>全选</label>
					</div>
		
					<div class="btn-group">
						<a href="javascript:;" class="u-btn-default">退 票</a>
					</div>
		
				</div>
	</section>
</article>
<!-- 登录模块 -->
<script src="../js/sea-wechat.js"></script>
 <%@ include file="/cheque/base.html" %>
</body>
</html>
