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
<title>user</title>
</head>
<body>
	<%@include file="../jsp/navigator.jsp"%>
	<div id="page-wrapper">
		<!-- 面包屑 -->
		<ul class="breadcrumb">
			<li><a href="#">首页</a> <span class="divider"></span></li>
			<li><a href="#">用户管理</a> <span class="divider"></span></li>
			<li class="active">用户列表</li>
		</ul>
		<!-- 提醒框 -->
		<div id="alert" style="display: none">
			<p id="code" style="display: none">
				${processResult.processResultCode }</p>
			<p id="info">${processResult.processResultDesc }</p>
		</div>
		<table class="table table-bordered table-hover" id="userList">
			<thead>
				<tr align="center">
					<td>ID</td>
					<td>登录名</td>
					<td>密码</td>
					<td>性别</td>
					<td>年龄</td>
					<td>电话号码</td>
					<td>地址</td>
					<td>登记时间</td>
					<td>操作</td>
				</tr>
			</thead>
			<c:forEach items="${userList }" var="user">
				<tr align="center">
					<td>${user.userid}</td>
					<td>${user.username}</td>
					<td>${user.userpassword}</td>
					<td>${user.usersex}</td>
					<td>${user.userage}</td>
					<td>${user.userphone}</td>
					<td>${user.useraddress}</td>
					<td><spring:eval expression="user.userupdatetime"></spring:eval></td>
					<td><a
						href="../pet/findPetByUser?id=${user.userid }">查看</a>
						<a
						href="../user/resetPsd?id=${user.userid }"
						onclick="return confirm('确定重置密码?');">重置密码</a>
						 <a
						href="../user/deleteUser?id=${user.userid }"
						onclick="return confirm('确定删除?');">删除</a></td>
				</tr>
			</c:forEach>
		</table>	
	</div>
	<script src="${pageContext.request.contextPath}/js/ajax.js"></script>
	<script src="${pageContext.request.contextPath}/js/alert.js"></script>
	<script type="text/javascript">
		var table = $("#userList");/*  获取表 */
		var trs = table.find("tr");/* 获取表中tr标签数 */
		console.info(trs.length);
		for (var i = 1; i < trs.length; i++) {
			var tag = $("tr").eq(i).find("td").eq(3).text();
			console.info(tag);
			if (tag == 0) {
				$("tr").eq(i).find("td").eq(3).text( '男');
			}else{
				$("tr").eq(i).find("td").eq(3).text( '女');
			}
		}
	</script>
</body>
</html>