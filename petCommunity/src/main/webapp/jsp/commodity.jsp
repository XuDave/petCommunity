<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>commodity</title>
</head>
<body>
	<%@include file="../jsp/navigator.jsp"%>
	<div id="page-wrapper">
		<!-- 面包屑 -->
		<ul class="breadcrumb">
			<li><a href="#">首页</a> <span class="divider"></span></li>
			<li><a href="#">商品管理</a> <span class="divider"></span></li>
			<li class="active">商品列表</li>
		</ul>
		<!-- 提醒框 -->
		<div id="alert" style="display: none">
			<p id="code" style="display: none">
				${processResult.processResultCode }</p>
			<p id="info">${processResult.processResultDesc }</p>
		</div>
		<table class="table table-bordered table-hover" id="amdinList">
			<thead>
				<tr align="center">
					<td>ID</td>
					<td>商品名</td>
					<td>单价</td>
					<td>数量</td>
					<td>状态</td>
					<td>更新时间</td>
					<td>操作</td>
				</tr>
			</thead>
			<c:forEach items="${commodityList }" var="commodity">
				<tr align="center">
					<td>${commodity.commodityid}</td>
					<td>${commodity.commoditycontent}</td>
					<td>${commodity.commodityprice}</td>
					<td>${commodity.commoditycount}</td>
					<td>${commodity.commoditystate}</td>
					<td><spring:eval expression="commodity.commodityupdatetime"></spring:eval></td>
					<td> <a
						href="#">更新</a> <a
						href="#"
						onclick="return confirm('确定删除?');">删除</a></td>
				</tr>
			</c:forEach>
		</table>	
	</div>
	<script src="${pageContext.request.contextPath}/js/ajax.js"></script>
	<script src="${pageContext.request.contextPath}/js/alert.js"></script>
</body>
</html>