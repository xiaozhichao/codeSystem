<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<title>首页 | 后台管理平台</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="cache-control" content="no-cache">
<!--Loading bootstrap css-->
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>backstatic/madmin/vendors/font-awesome/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>backstatic/madmin/vendors/bootstrap/css/bootstrap.min.css">
<!--LOADING STYLESHEET FOR PAGE-->
<!--Loading style <%=basePath%>backstatic/madmin/vendors-->
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>backstatic/madmin/vendors/animate/animate.css">
<!--Loading style-->
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>backstatic/madmin/css/themes/style1/orange-blue.css"
	class="default-style">
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>backstatic/madmin/css/style-responsive.css">
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>backstatic/plugin/layer/skin/layer.css">
	<link type="text/css" rel="stylesheet" href="<%=basePath %>backstatic/madmin/vendors/iCheck/skins/all.css">
	<link type="text/css" rel="stylesheet" href="<%=basePath %>backstatic/plugin/zTree/css/zTreeStyle.css">
	<link type="text/css" rel="stylesheet" href="<%=basePath%>backstatic/plugin/paginator/bootstrap-paginator.css">
	<link type="text/css" rel="stylesheet" href="<%=basePath%>backstatic/madmin/vendors/bootstrap-datepicker/css/datepicker.css">
	<link type="text/css" rel="stylesheet" href="<%=basePath%>backstatic/madmin/vendors/bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css">
	<link type="text/css" rel="stylesheet" href="<%=basePath%>backstatic/madmin/vendors/bootstrap-timepicker/css/bootstrap-timepicker.min.css">
	<link type="text/css" rel="stylesheet" href="<%=basePath%>backstatic/madmin/vendors/iCheck/skins/all.css">
</head>

<body class=" ">
<input type="hidden" id="backurl" name="backurl" value="${backurl }"/>
<input type="hidden" id="httpurl" name="httpurl" value="${httpurl }"/>
<input type="hidden" id="imageUrl" name="imageUrl" value="${imageUrl }">
	<div>
		<!--BEGIN BACK TO TOP-->
		<a id="totop" href="#"><i class="fa fa-angle-up"></i></a>
		<!--END BACK TO TOP-->
		<!--BEGIN TOPBAR-->
		<div id="header-topbar-option-demo" class="page-header-topbar">
			<nav id="topbar" role="navigation"
				style="margin-bottom: 0; z-index: 2;"
				class="navbar navbar-default navbar-static-top">
				<div class="navbar-header">
					<button type="button" data-toggle="collapse"
						data-target=".sidebar-collapse" class="navbar-toggle">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<a id="logo" href="<%=basePath %>" class="navbar-brand"><span
						class="fa fa-rocket"></span><span class="logo-text">后台管理平台</span><span
						style="display: none" class="logo-text-icon">es</span></a>
				</div>
				<div class="topbar-main">
					<a id="menu-toggle" href="#" class="hidden-xs"><i
						class="fa fa-bars"></i></a>
				</div>
			</nav>
		</div>
		<!--END TOPBAR-->
		<div id="wrapper">
			<!--BEGIN SIDEBAR MENU-->
			<nav id="sidebar" role="navigation"
				class="navbar-default navbar-static-side">
				<div class="sidebar-collapse menu-scroll">
					<ul id="side-menu" class="nav">
						<li class="user-panel">
							<%-- <div class="info">
								<p>${user.loginId }</p>
								<ul class="list-inline list-unstyled">
									<!-- <li id="logout" data-url="#"><a href="#" data-hover="tooltip"
										title="退出"><i class="fa fa-sign-out"></i></a></li> -->
								</ul>
							</div> --%>
							<div class="clearfix"></div>
						</li>
						<!-- <li class="active"><a href="#"><i
								class="fa fa-home"><div class="icon-bg bg-orange"></div></i><span
								class="menu-title">首页</span></a></li> -->
						
			
					  <c:if test="${!empty surfaceResult && surfaceResult.state eq false}">
					  		<h1>${result.msg}</h1>
					  </c:if>
					  <c:if test="${!empty surfaceResult && surfaceResult.state eq true}">
						<c:if test="${!empty surfaceResult.result}">
							<c:forEach items="${surfaceResult.result}" var="item" varStatus="Status">
								<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i><span class="menu-title">${item.name}</span><span
										class="fa arrow"></span></a>
									<ul class="nav nav-second-level">
										<c:if test="${!empty item.subList}">
											<c:forEach items="${item.subList}" var="subitem"
											varStatus="Status">
												<li data-url="<%=basePath %>surface/dispatcher/index" data-param="{${subitem.businessCode}}"><a href="#"><i
																class="fa fa-align-left"></i><span class="submenu-title">${subitem.subName}</span></a>
													<form action="#" id = "${subitem.id}">
														<input type= "hidden" name="url" value = "${item.url}"/>
														<input type= "hidden" name="id" value = "${subitem.id}"/>
														<input type= "hidden" name="subName" value = "${subitem.subName}"/>
														<input type= "hidden" name="businessCode" value = "${subitem.businessCode}"/>
														<%-- <input type= "hidden" name="params" value = "${subitem.params}"/> --%>
												
														<input type= "hidden" name="parentId" value = "${item.id}"/>
														<input type= "hidden" name="parentName" value = "${item.name}"/>			
													</form>
												</li>
										
											</c:forEach>
										</c:if>
									</ul>
								</li> 
							</c:forEach>	
						</c:if>
					  </c:if>
					</ul>
				</div>
			</nav>
			<!--END SIDEBAR MENU-->
			
			<!--每个页面展示的内容需要放到这个容器里面-->
			<div id="page-wrapper">
				<!--BEGIN TITLE & BREADCRUMB PAGE-->
				<div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
					<ol class="breadcrumb page-breadcrumb pull-left">
						<li><i class="fa fa-home"></i>&nbsp;<a href="#"></a>&nbsp;&nbsp;</li>
					</ol>
					<div class="clearfix"></div>
				</div>
				<!--END TITLE & BREADCRUMB PAGE-->
				<!--BEGIN CONTENT-->
				<div class="page-content">
					<div id="tab-general"></div>
				</div>
				<!--END CONTENT-->
			</div>
		</div>
	</div>
	<div id="myModal"></div>
	<script src="<%=basePath%>backstatic/madmin/js/jquery-1.10.2.min.js"></script>
	<script src="<%=basePath%>backstatic/madmin/js/jquery.form.js"></script>
	<script src="<%=basePath%>backstatic/madmin/js/jquery.easyui.min.js"></script>
	<script
		src="<%=basePath%>backstatic/madmin/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="<%=basePath%>backstatic/madmin/js/jquery-ui.js"></script>
	<!--loading bootstrap js-->
	<script
		src="<%=basePath%>backstatic/madmin/vendors/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="<%=basePath%>backstatic/madmin/vendors/bootstrap-hover-dropdown/bootstrap-hover-dropdown.js"></script>
	<script src="<%=basePath%>backstatic/madmin/js/html5shiv.js"></script>
	
	<script src="<%=basePath%>backstatic/plugin/zTree/jquery.ztree.core.js"></script>
	<script src="<%=basePath%>backstatic/plugin/zTree/jquery.ztree.excheck.js"></script>
	
	<script src="<%=basePath%>backstatic/madmin/js/respond.min.js"></script>
	<script
		src="<%=basePath%>backstatic/madmin/vendors/jquery-validate/jquery.validate.min.js"></script>
	<script
		src="<%=basePath%>backstatic/madmin/vendors/metisMenu/jquery.metisMenu.js"></script>
	<script
		src="<%=basePath%>backstatic/madmin/vendors/slimScroll/jquery.slimscroll.js"></script>
	<script
		src="<%=basePath%>backstatic/madmin/vendors/jquery-cookie/jquery.cookie.js"></script>
	<script src="<%=basePath%>backstatic/madmin/vendors/iCheck/icheck.min.js"></script>
    <script src="<%=basePath%>backstatic/madmin/vendors/iCheck/custom.min.js"></script>
	<script src="<%=basePath%>backstatic/madmin/js/jquery.menu.js"></script>
	<script src="<%=basePath%>backstatic/plugin/layer/layer.js"></script>
	<script src="<%=basePath%>backstatic/plugin/paginator/bootstrap-paginator.min.js"></script>
	<script src="<%=basePath%>backstatic/madmin/vendors/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script src="<%=basePath%>backstatic/madmin/vendors/bootstrap-datepicker/js/bootstrap-datepicker.zh-CN.min.js"></script>
	<script src="<%=basePath%>backstatic/madmin/vendors/moment/moment.js"></script>
	<script src="<%=basePath%>backstatic/madmin/vendors/bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
	<script src="<%=basePath%>backstatic/madmin/vendors/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
	<script src="<%=basePath%>backstatic/plugin/xheditor/xheditor-1.2.2.min.js"></script>
	<script src="<%=basePath%>backstatic/plugin/xheditor/xheditor_lang/zh-cn.js"></script>
	
	<!--CORE JAVASCRIPT-->
	<script src="<%=basePath%>backstatic/madmin/js/main.js"></script>
	<script src="<%=basePath%>backstatic/js/back.base.js"></script>
	<script src="<%=basePath%>backstatic/js/back.home.js"></script>
	
	
	<script src="<%=basePath%>backstatic/js/back.surface.dispatcher.js"></script>

	
	<script type="text/javascript">
		var ctx="<%=basePath%>";
		/**
		 *路由统一管理
		 */
		var UrlManager = {
			ctx : ctx,
			weclome : ctx + "welcome",
			surface : {
				dispatcher : {
					url		 : ctx + "surface/dispatcher/index",
					url_list : ctx + "surface/dispatcher/list",
				}
			}
		
		};
		/**
		 * 信息管理
		 */
		var MsgManager = {
			website_error : "网络异常，请稍后尝试！",
			not_have_data : "没有相关数据！",
			op_success : "操作成功！",
			op_failure : "操作失败！",
			op_title : "温馨提示",
			layer : {
				loading : "<div style=\"line-height:32px;padding-left: 40px;background:url("
						+ ctx
						+ "backstatic/plugin/layer/skin/default/loading-2.gif) no-repeat;\">加载中...</div>",
				data_loading : "<div style=\"line-height:32px;padding-left: 40px;background:url("
						+ ctx
						+ "backstatic/plugin/layer/skin/default/loading-2.gif) no-repeat;\">数据加载中...</div>",
				page_loading : "<div style=\"line-height:32px;padding-left: 40px;background:url("
						+ ctx
						+ "backstatic/plugin/layer/skin/default/loading-2.gif) no-repeat;\">页面加载中...</div>",
				op_loading : "<div style=\"line-height:32px;padding-left: 40px;background:url("
						+ ctx
						+ "backstatic/plugin/layer/skin/default/loading-2.gif) no-repeat;\">操作中...</div>",
				title_exists_loading : "<div style=\"line-height:32px;padding-left: 40px;background:url("
						+ ctx
						+ "backstatic/plugin/layer/skin/default/loading-2.gif) no-repeat;\">唯一性校验中...</div>"

			}
		};
		var blurFunction = function(notNull,field){
			if(notNull != "undefined" && notNull){
				if(!$.trim($('input[name="'+field+'"]').val())){
					layer.msg("请填写必填项", {icon: 2,shade: [0.3,'#000']});
					return false;
				}
			}
			$('input[name="'+field+'"]').val($.trim(this.val()));
		}
		HomeView.init();
	</script>
</body>

</html>