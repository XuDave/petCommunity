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
<style type="text/css">
body{
   background-color: #ebebeb;
}
.top_div {
	/* background: #008ead; */
	background: rgb(6, 217, 149);
	width: 100%;
	height: 330px;
}

p {
	font-family: "微软雅黑";
}

#alert {
	width: 20%;
	height: 60px;
	position: fixed;
	z-index: 100;
	right: 0;
	top: 0;
}
</style>
<title>login</title>
</head>
<body>
	<div id="alert" style="display: none">
		<p id="code" style="display: none">
			${processResult.processResultCode }</p>
		<p id="info" align="center">${processResult.processResultDesc }</p>
	</div>
	<div class="top_div">
		<div style="position: absolute; margin-left: 650px; margin-top: 170px">
			<h3 style="color: white; font-weight: bold;">宠物社区后台管理系统</h3>
		</div>
	</div>

	<div
		style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 200px; text-align: center; border-radius: 15px">
		<p style="font-size: 16px; font-family: '微软雅黑'; margin-top: 10px">管理员登录</p>
		<form
			<%-- action="${pageContext.request.contextPath}/staffManage/checkLogin" --%>
			action="${pageContext.request.contextPath}/user/userList" 
			method="post" onsubmit="return isEmptyAdmin()">
			<div>
				<div class="form-horizontal">
					<div class="form-group" style="margin: 10px 0px 20px 0px">
						<p class="col-sm-2 control-label" style="width: 30%">用户名：</p>
						<div class="col-sm-10" style="width: 60%; margin-left: -20px">
							<input type="text" name="adminName" id="adminName"
								class="form-control" onchange="isExistingAdmin()"
								placeholder="管理员登录名" />
						</div>
						<!-- 用户名输入错误提示信息 -->
						<p id="adminNameInfo"
							style="color: red; font-size: 10px; position: absolute; margin: 35px 0px 0px 160px"></p>
					</div>
					<div class="form-group">
						<p class="col-sm-2 control-label" style="width: 30%">密码：</p>
						<div class="col-sm-10" style="width: 55%; margin-left: -15px">
							<input type="password" name="password" id="password"
								class="form-control" placeholder="登录密码" />
						</div>
						<!-- 密码输入错误提示信息 -->
						<p id="passwordInfo"
							style="color: red; font-size: 10px; position: absolute; margin: 35px 0px 0px 160px"></p>
					</div>
					<!--分割线 -->
					<div
						style="height: 40px; line-height: 40px; margin-top: 20px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
						<input type="submit" value="登录" class="btn btn-info" /> <input
							type="reset" value="重置" class="btn btn-info"
							style="margin-left: 40px" />
					</div>
				</div>
			</div>
		</form>
	</div>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/alert.js"></script>
	<script src="${pageContext.request.contextPath}/js/ajax.js"></script>
	<script src="${pageContext.request.contextPath}/js/parameterscheck.js"></script>
</body>
</html>