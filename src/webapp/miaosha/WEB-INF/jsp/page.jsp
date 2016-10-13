<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="right">
		<span>共<b>${page.totalPage }</b>页</span>
		&nbsp;&nbsp;
		<span>当前第${page.nowPage } / ${page.totalPage } 页</span>
		&nbsp;&nbsp;&nbsp;&nbsp;
		
	</div>
</body>
</html>