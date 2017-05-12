<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link type="text/css" rel="stylesheet" href="<%=basePath%>backstatic/plugin/paginator/bootstrap-paginator.css">
<script src="<%=basePath%>backstatic/plugin/paginator/bootstrap-paginator.min.js"></script>
<link type="text/css" rel="stylesheet"	href="<%=basePath%>backstatic/madmin/vendors/bootstrap-datepicker/css/datepicker.css">
<script src="<%=basePath%>backstatic/madmin/vendors/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script src="<%=basePath%>backstatic/madmin/vendors/bootstrap-datepicker/js/bootstrap-datepicker.zh-CN.min.js"></script>

<link type="text/css" rel="stylesheet" href="<%=basePath%>backstatic/css/jplist-custom.css">
<style>
	.notOneRow{
		word-break: break-all;
	    word-wrap: break-word;
}
</style>
<div id="promotion_list" style="background-color: #FFF">
	<!--BEGIN TITLE & BREADCRUMB PAGE-->
	<div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
		<ol class="breadcrumb page-breadcrumb pull-left">
			<li><i class="fa fa-home"></i>&nbsp;&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;<a href="#">${parentName}</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
			<li class="">${subName}</li>
		</ol>
		<div class="clearfix"></div>
	</div>
	<!--END TITLE & BREADCRUMB PAGE-->
	<!--BEGIN CONTENT-->
<div class="page-content">
  <form action="#" class="form-horizontal" id="list_form">
	<div class="form-group">
		
		<div class="form-body pal">
			  <div class="row">
		   <c:if test="${!empty surfaceResult && surfaceResult.state eq false}">
			  	<h1>${result.msg}</h1>
		   </c:if>
		   <c:if test="${!empty surfaceResult && surfaceResult.state eq true}">
			<c:if test="${!empty surfaceResult.result}">
				<c:forEach items="${surfaceResult.result}" var="item" varStatus="Status">
					  <div class="col-md-3">
		                  <div class="form-group">
		                      <label for="inputName" class="control-label">
		                      		${item.name}
		                      		<c:if test="${item.notNull eq true}">(必填)</c:if>
		                      		<c:if test="${item.type eq 'Integer' || item.type eq 'int'}">(整数)</c:if>
		                      </label>
		                      <div class="input-icon right">
		                          <input  type="text" name="${item.field}" placeholder="${item.name}" class="form-control ${item.notNull} ${item.type} "
		                          onblur="blurFunction(${item.notNull},${item.field})">
		                      </div>
		                  </div>
		              </div>
					  <c:if test="${((Status.count)%4)==0}">
				        </div>
				        <div class="row">      
					  </c:if>
					  <c:if test="${fn:length(searchList)==Status.count}">
				        </div>    
					  </c:if>
		         </c:forEach>
			</c:if>
		   </c:if>
		 
		<div class="col-md-8" style="padding-right: 175px;">
				<input type= "hidden" id="surface_url" name="surface_url" value = "${url}"/>
				<input type= "hidden" id="surface_businessCode" name="surface_businessCode" value = "${businessCode}"/>
			<button type="submit" class="btn btn-info" id="btn_search"><i class="fa fa-search"></i> 查询</button>
		</div>
	</div>
</form>
		<br/>
		<h4 class="header-option-page">
			查询结果&nbsp;
			
		</h4>
		<div id="list_data"></div>
	</div>
	<!--END CONTENT-->
</div>
<script type="text/javascript">
</script>
