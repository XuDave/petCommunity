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
<title>pet</title>
</head>
<body>
	<%@include file="../jsp/navigator.jsp"%>
	<div id="page-wrapper">
		<!-- 面包屑 -->
		<ul class="breadcrumb">
			<li><a href="#">首页</a> <span class="divider"></span></li>
			<li><a href="#">用户管理</a> <span class="divider"></span></li>
			<li class="active">宠物列表</li>
		</ul>
		<!-- 提醒框 -->
		<div id="alert" style="display: none">
			<p id="code" style="display: none">
				${processResult.processResultCode }</p>
			<p id="info">${processResult.processResultDesc }</p>
		</div>
		<table class="table table-bordered table-hover" id="petList">
			<thead>
				<tr align="center">
					<td>ID</td>
					<td>名字</td>
					<td>种类</td>
					<td>年龄</td>
					<td>性别</td>
			<!-- 		<td>用户ID</td> -->
					<td>操作</td>
				</tr>
			</thead>
			<c:forEach items="${petList }" var="pet">
				<tr align="center">
					<td>${pet.petid}</td>
					<td>${pet.petname}</td>
					<td>${pet.pettypename}</td>
					<td>${pet.petage}</td>
					<td>${pet.petsex}</td>
			<%-- 		<td>${pet.userid}</td> --%>
					<td><a
						href="../pet/deletePet?id=${pet.petid}"
						onclick="return confirm('确定删除?');">删除</a></td>
				</tr>
			</c:forEach>
		</table>	
	</div>
	<script src="${pageContext.request.contextPath}/js/ajax.js"></script>
	<script src="${pageContext.request.contextPath}/js/alert.js"></script>
	<script type="text/javascript">
		var table = $("#petList");/*  获取表 */
		var trs = table.find("tr");/* 获取表中tr标签数 */
		console.info(trs.length);
		for (var i = 1; i < trs.length; i++) {
			var tag = $("tr").eq(i).find("td").eq(4).text();
			console.info(tag);
			if (tag == 0) {
				$("tr").eq(i).find("td").eq(4).text( '公');
			}else{
				$("tr").eq(i).find("td").eq(4).text( '母');
			}
		}
	</script>
</body>
</html>