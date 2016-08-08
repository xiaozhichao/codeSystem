<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.bean.order.*" %>
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
<title>用户订单列表</title>
<link rel="stylesheet" href="/css/g-base.css">
<link rel="stylesheet" href="/css/c-order.css">
</head>
<script src="/js/sea-wechat.js"></script>
<script language="JavaScript" type="text/javascript">
seajs.use(['/js/sea-module/lib/jquery-2.1.0.min'], function(){
$("#pay").click(function(){
window.location.href="/order/querychangelist&payFlag=1&viewtype=2";
});
$("#notpay").click(function(){
window.location.href="/order.do?action=querychangelist&payFlag=0&viewtype=2";
});
//详情按钮
$(".btn-red").click(function(){
//var info = $(this).parent().prev();
$(this).prev(".formorder").attr("action","order.do?action=queryorderdetail");
$(this).prev(".formorder").children(".viewtp").attr("value",2);
$(this).prev(".formorder").submit();
});
//变更按钮
$(".btn-green").click(function(){
if($(this).attr("class")=='btn btn-green f-bf-1')
{
	$(this).prev().prev(".formorder").attr("action","order.do?action=getorderdetailStr");
	$(this).prev().prev(".formorder").submit();
}
return false;
});
//退票操作
$(".btn-yellow").click(function(){
if($(this).attr("class")=='btn btn-yellow f-bf-1')
{
$(this).parent().find(".formorder").attr("action","order.do?action=queryorderdetail");
$(this).parent().find(".formorder").children(".viewtp").attr("value",4);
$(this).parent().find(".formorder").submit();
}
})
});
</script>
<body>


<!-- 登录模块 -->
<article class="container" id="m-orderlist">

	<header class="g-hd">
		<h1>用户订单列表</h1>
		<a href="tel:95524" class="call"></a>
	</header>

	<section class="g-bd">
		<ul class="g-tabs f-db">
				<li class="f-bf-1 <c:if test="${payFlag eq '1'}">active</c:if>" id="pay">已支付</li>
				<li class="f-bf-1 <c:if test="${payFlag eq '0'}">active</c:if>" id="notpay">未支付</li>
		</ul>

		<div class="m-userorder">

			<ul>
			<c:forEach items="${orderList}" var="info" varStatus="i">
				<li class="item">
					<dl class="f-db">
						<dt>订单号：</dt>
						<dd>${info.orderNo}</dd>
					</dl>
					<dl class="f-db">
						<dt>状态：</dt>
						<dd class="status-1">${info.orderStatusDescript}</dd>
					</dl>
					<dl class="f-db">
						<dt>预订日期：</dt>
						<dd>${info.orderDate}</dd>
					</dl>
					<dl class="f-db">
						<dt>行程：</dt>
						<dd>${info.originDestCity}</dd>
					</dl>								
					<div class="btn-group f-db">
						<form class="formorder" action="order.do?action=queryorderdetail" method="post">
						<input type="hidden" name="orderId" value="${info.orderNo}"/>
						<input type="hidden" name="queryType" value="0"/>
						<input type="hidden" name="viewtype" value="2" class="viewtp"/>
						<input type="hidden" name="payFlag" value="${payFlag}" class="flagpay"/>
						
						</form>		
						<a href="javascript:;" class="btn btn-red f-bf-1">详情</a>
						<a <c:choose><c:when test="${info.canChangeFlight eq 'false'}"> class="btn btn-green f-bf-1 disabled" href="#" </c:when><c:otherwise>class="btn btn-green f-bf-1" href="#" </c:otherwise></c:choose>>航班变更</a>
						<a <c:choose><c:when test="${info.canRefund eq 'false'}"> class="btn btn-yellow f-bf-1 disabled" href="#" </c:when><c:otherwise>class="btn btn-yellow f-bf-1" href="#" </c:otherwise></c:choose>>退票</a>
					</div>
				</li>
		</c:forEach>
				</ul>
		</div>
	</section>
</article>
<script src="/js/sea-wechat.js"></script>
 <%@ include file="/cheque/base.html" %>
</body>
</html>
