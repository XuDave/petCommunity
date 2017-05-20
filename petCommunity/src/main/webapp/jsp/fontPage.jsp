<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/alert.js"></script>
<title>fontPage.jsp</title>
</head>
<body>
	<%@include file="../jsp/navigator.jsp"%>
	<div id="page-wrapper">
		<ul class="breadcrumb">
			<li><a>首页</a> <span class="divider"></span></li>
		</ul>
		<!-- 提醒框 -->
		<div id="alert" style="display: none">
			<p id="code" style="display: none">
				${processResult.processResultCode }</p>
			<p id="info">${processResult.processResultDesc }</p>
		</div>
		<div style="margin: 80px 0px 0px 350px">
			<img src="../images/fontPagePic.jpg"
				style="width: 420px; height: 230px">
			<h3 style="margin-left: 50px">欢迎进入宠物社区后台管理系统！</h3>
		</div>
	</div>
</body>
</html>