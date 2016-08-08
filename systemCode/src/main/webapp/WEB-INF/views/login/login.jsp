
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link rel="stylesheet" href="<%=basePath %>css/login/login_ht.css" />
<script type="text/javascript" src="<%=basePath %>js/jquery-1.9.1.min.js"></script>
<script language="JavaScript">

</script>
<script language="javascript" type="text/javascript">
function validate(){
var inputCode = document.getElementById("j_code").value.toUpperCase();
if(inputCode.length <=0) {
   alert("请输入验证码！");
   return false;
}
else {
   $("#formId").submit();
   return true;
}

}
</script>
</head>
<body>

<div class="login_ht">
<form id="formId" action="<c:url value='j_spring_security_check'/>" method="post">
  <table width="400" border="0" cellpadding="0" cellspacing="0" class="login_ht_table">
    <tr>
      <td width="113" height="165">&nbsp;</td>
      <td width="10">&nbsp;</td>
      <td width="153">&nbsp;</td>
      <td width="124">&nbsp;</td>
    </tr>
    <tr>
      <td height="30" align="right">用户</td>
      <td>&nbsp;</td>
      <td><input name="j_username" type="text" size="18" style=" width:130px;" value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="30" align="right">密码</td>
      <td>&nbsp;</td>
      <td><input name="j_password" type="password" size="18" style=" width:130px;" onfocus ="javascript:this.select();"/></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="30" align="right">验证码</td>
      <td>&nbsp;</td>
      <td><input name="j_code" type="text" id="j_code" size="18" style=" width:73px;"/>   
       <img src="CodeImageServlet" width="53" height="20" align="absmiddle" /></td>
      <td><img src="localstatic/images/login_ht3.jpg" width="49" height="18" border="0" onClick="validate()" style="cursor:pointer;"/>
      </td>
    </tr>
    <tr>
   	  <td>&nbsp;</td>
      <td height="30" align="left" colspan="2" >
       <c:if test="${not empty param.login_error}">
					 <font color="red">
			           <c:out value="${error}"/>.
				 </font>
				 </c:if>
				<c:if test="${not empty param.codeError}">
					 <font color="red">
			           <c:out value="验证码错误！"/>
				 </font>
		 </c:if>
      </td>
    </tr>
  </table>
  </form>
</div>
<script type="text/javascript">
if (document.addEventListener)   
	{//如果是Firefox   
		document.addEventListener("keypress", fireFoxHandler, true);   
	} else{   
		document.attachEvent("onkeypress", ieHandler);   
	}   
function fireFoxHandler(evt){   
	//alert(evt.keyCode);   
	if (evt.keyCode == 13){ 
			validate();
		}   
	}   
function ieHandler(evt){   
	//alert("IE");   
	if (evt.keyCode == 13){   
		validate();
	}   
} 
</script>
</body>
</html>
