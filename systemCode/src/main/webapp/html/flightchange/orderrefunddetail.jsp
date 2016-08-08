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
<title>退票详情</title>
<link rel="stylesheet" href="../css/g-base.css">
<link rel="stylesheet" href="../css/c-order.css">
</head>

<script src="/js/sea-wechat.js"></script>
<script language="JavaScript" type="text/javascript">
seajs.use(['/js/sea-module/lib/jquery-2.1.0.min'], function(){
$(".u-btn-default").click(function(){
$.ajax({
url:"/order.do?action=SubmitReturnTicket",
type:"post",
data:$("#refundform").serialize(),
dataType:"json",
success:function(ret){
	if(ret.statusCode=="Y")
	{
	alert("您的退票申请已经提交!");
	window.location.href("/order.do?action=querychangelist&payFlag=1&viewtype=2");
	}
	else
	{
	alert(ret.statusDescription);
	}
}
})
})
});
</script>
<body>


<!-- 登录模块 -->
<article class="container" id="m-refund-detail">

	<header class="g-hd">
		<h1>退票详情</h1>
		<a href="javascript:;" class="back"></a>
		<a href="javascript:;" class="call"></a>
	</header>

	<section class="g-bd">

		<div class="m-refund-detail">
			
			<!-- 航班信息 -->
			<ul class="flight-info">
			<c:forEach items="${ticketlist}" var="info" varStatus="i">
				<li class="item f-cb">
					<dl class="f-db">
						<dt>航班类型：</dt>
						<dd>${info.ticketOrderType}</dd>
					</dl>
					<dl class="f-db">
						<dt>航班号：</dt>
						<dd>${info.flightNo}</dd>
					</dl>
					<dl class="f-db">
						<dt>乘机人：</dt>
						<dd>${info.familyName}</dd>
					</dl>
					<dl class="f-db">
						<dt>舱位：</dt>
						<dd>${info.seatName}</dd>
					</dl>
					<dl class="f-db">
						<dt>起抵时间：</dt>
						<dd>${info.oriDate} ${info.oriTime}/${info.destDate} ${info.destTime}</dd>
					</dl>
					<dl class="f-db">
						<dt>起抵机场：</dt>
						<dd>
							<p>${info.originAirport}</p>
							<p>${info.destAirport}</p>
						</dd>
					</dl>
				</li>
			</c:forEach>
			</ul>
			<!-- 航班信息end -->
			<div class="check-bar">请仔细核对您的退票金额</div>


			<!-- 乘机人信息 -->
			<ul class="passenger-info">

				<li class="item f-cb">
					<dl class="f-db">
						<dt>票价：</dt>
						<dd>${RefundPay.retTktMoney}</dd>
					</dl>
					<dl class="f-db">
						<dt>保险费：</dt>
						<dd>${RefundPay.retInsMoney}</dd>
					</dl>
					<dl class="f-db">
						<dt>机建费：</dt>
						<dd>${RefundPay.retPortMoney}</dd>
					</dl>
					<dl class="f-db">
						<dt>商品费：</dt>
						<dd>${RefundPay.retXFee}</dd>
					</dl>
					<dl class="f-db">
						<dt>燃油费：</dt>
						<dd>${RefundPay.retFuelMoney}</dd>
					</dl>
				</li>
			</ul>
			<!-- 乘机人信息end -->

			<div class="handler">
				
				<div class="total f-cb">
					<div class="f-fl">扣除手续费：<b>${RefundPay.returnFy}</b></div>
					<div class="f-fr">实退金额：<b>${RefundPay.retNetMoney}</b></div>
				</div>

				<div class="clause">
					<p>国内卡退款在30工作日内退回银行账户。</p>
					<p><a href="#" class="link">查看退票条件和规则</a></p>
				</div>
				<form id="refundform" action="order.do?action=SubmitReturnTicket" method="post">
				<input type="hidden" name="orderno" value="${map.orderNo}" />
				<input type="hidden" name="orderheadId" value="${map.orderheadId}" />
				</form>
				<a href="javascript:;" class="u-btn-default">同意退票</a>
			</div>
		</div>
	</section>
	
</article>

<script src="../js/sea-wechat.js"></script>
 <%@ include file="/cheque/base.html" %>
</body>
</html>
