<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/jsp/common/head.jsp"%>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- jQuery cookie操作插件 -->
<script
	src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js"></script>
	
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	
<title>用户登录</title>
</head>
<body>
	<div style="padding: 100px 100px 10px; width: 400px;" align="center">
		<form class="bs-example bs-example-form" role="form"
			action="/user/login">
			<div class="input-group">
				<span class="input-group-addon">用户名:</span> <input id="userName"
					name="userName" type="text" class="form-control"
					placeholder="输入用户名。">
			</div>
			<span id="checkUserName"></span>
			<br>
			<div class="input-group">
				<span class="input-group-addon">密&nbsp;&nbsp;码:</span> <input
					id="password" name="password" type="password" class="form-control"
					placeholder="请输入密码。">
			</div>
			<br>
			<% String message=(String)request.getAttribute("message");%>
			<span style="color:red;"><% if(message != null){%> <%=message  %> <%}%></span>
			
			<br> <input type="submit" id="loginBtn" value="登录"
				class="btn btn-primary" data-loading-text="Loading..." type="button" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="registeBtn" class="btn btn-info" href="/user/register"
				target="_blank">注册</a>
		</form>
	</div>
</body>
<script type="text/javascript" src="/resources/script/loginScript.js"></script>
<script type="text/javascript">
	$(function(){
		login.init();
		login.userNameCheck();
	});
</script> 

</html>