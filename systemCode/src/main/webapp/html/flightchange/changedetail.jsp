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
<title>订单详情</title>
<link rel="stylesheet" href="/css/g-base.css">
<link rel="stylesheet" href="/css/c-order.css">
</head>
<body>


<!-- 登录模块 -->
<article class="container" id="m-orderdetail">

	<header class="g-hd">
		<h1>订单详情</h1>
		<a href="/order.do?action=querychangelist&payFlag=1&viewtype=2" class="back"></a>
		<a href="tel:95524" class="call"></a>
	</header>

	<section class="g-bd">

		<div class="m-orderdetail">
 			<c:forEach items="${tickets}" var="info" varStatus="i">
			<div class="item">
			
				<h2>${info.familyName}：${info.cardNo}</h2>
				<dl class="f-db">
					<dt>航班号</dt>
					<dd>${info.flightNo}</dd>
				</dl>
				<dl class="f-db">
					<dt>航班日期</dt>
					<dd>${info.oriDate}</dd>
				</dl>
				<dl class="f-db">
					<dt>航班状态</dt>
					<dd>${info.flightStatusDescript}</dd>
				</dl>
				<dl class="f-db">
					<dt>起飞时间</dt>
					<dd>${info.oriTime}</dd>
				</dl>
				<dl class="f-db">
					<dt>降落时间</dt>
					<dd>${info.destTime}</dd>
				</dl>
				<dl class="f-db">
					<dt>起飞地</dt>
					<dd>${info.originAirport}</dd>
				</dl>
				<dl class="f-db">
					<dt>目的地</dt>
					<dd>${info.destAirport}</dd>
				</dl>
				<dl class="f-db">
					<dt>舱位</dt>
					<dd>${info.seatName}</dd>
				</dl>
				<dl class="f-db">
					<dt>座位</dt>
					<dd>${info.seatNo}</dd>
				</dl>
				<dl class="f-db show-more">
					<dt>金额</dt>
					<dd>${info.ticketMoneyDisplay}</dd>
				</dl>
				<div class="more-cont">
				<c:forEach items="${info.extralist}" var="more" varStatus="j">
					<dl class="f-db">
						<dt>${more.name}</dt>
						<dd>${more.price}</dd>
					</dl>
				</c:forEach>
				</div>
				<dl class="f-db">
					<dt>状态</dt>
					<dd>${info.ticketStatusDescript}</dd>
				</dl>
				
			</div>	
			</c:forEach>
			<div class="total f-cb">
				<span class="f-fl">总金额</span>
				<span class="f-fr">${order.orderMoneyDisplay}</span>
			</div>

		</div>


	</section>
	

</article>
<!-- 登录模块 -->

<script src="../js/sea-wechat.js"></script>
<script>
	seajs.use(['jquery'], function(){
		$('.show-more').click(function(){
			var $dl = $(this).closest('dl');
			if(!$dl.hasClass('active')){
				$dl.addClass('active').next('.more-cont').slideDown();
			}else{
				$dl.removeClass('active').next('.more-cont').slideUp();

			}
		});
	});
</script>
 <%@ include file="/cheque/base.html" %>
</body>
</html>
