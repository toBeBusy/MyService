<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<title>用户注册</title>
</head>
<body>
	<div style="padding: 100px 100px 10px; width: 600px;" align="center">
		<form class="bs-example bs-example-form" role="form"
			action="/user/registerHandler" method="post">
			<div class="input-group" style="width: 400px;">
				<span class="input-group-addon">用户名:</span> <input id="userName"
					name="userName" type="text" class="form-control"
					placeholder="twitterhandle">
			</div>
			<span class="glyphicon" id="userNameError"></span> <br>
			<div class="input-group" style="width: 400px;">
				<span class="input-group-addon">密&nbsp;&nbsp;码:</span> <input
					id="password" name="password" type="text" class="form-control"
					placeholder="twitterhandle">
			</div>
			<br>
			<div class="input-group" style="width: 400px;">
				<span class="input-group-addon">确认密码:</span> <input id="rePassword"
					type="text" class="form-control" placeholder="twitterhandle">
			</div>
			<span class="glyphicon" id="rePasswordError"></span> <br>
			<div class="input-group" style="width: 400px;">
				<span class="input-group-addon">手机号码:</span> <input id="userPhone"
					name="userPhone" type="text" class="form-control"
					placeholder="twitterhandle">
			</div>
			<span class="glyphicon" id="userPhoneError"></span> <br> <input
				type="submit" id="registeBtn" class="btn btn-info" />
		</form>
	</div>
</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/resources/script/register.js"></script>
<script type="text/javascript">
	$(function(){
		register.registerHandler();
	});
</script>
</html>