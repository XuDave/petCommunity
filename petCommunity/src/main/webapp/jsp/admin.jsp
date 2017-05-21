<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>admin</title>
</head>
<body>
	<%@include file="../jsp/navigator.jsp"%>
	<div id="page-wrapper">
		<!-- 面包屑 -->
		<ul class="breadcrumb">
			<li><a href="#">首页</a> <span class="divider"></span></li>
			<li><a
				href="${pageContext.request.contextPath}/jsp/personalInfoManage.jsp">系统管理</a>
				<span class="divider"></span></li>
			<li class="active">修改密码</li>
		</ul>
		<!-- 提醒框 -->
		<div id="alert" style="display: none">
			<p id="code" style="display: none">
				${processResult.processResultCode }</p>
			<p id="info">${processResult.processResultDesc }</p>
		</div>
		<form action="../admin/modPsd"
			onsubmit="return isEmptyPasswords()" method="post">
			<div class="form-horizontal"
				style="width: 45%; margin: 40px 0 20px 250px"">
				<div class="form-group" style="display: none">
					<label for="curAdmin" class="col-sm-2 control-label">当前用户</label>
					<div class="col-sm-10" style="width: 30%">
						<input type="text" class="form-control" id="adminid"
							name="adminid" value="${curAdmin.adminid }">
					</div>
				</div>
				<div class="form-group">
					<p class="col-sm-2 control-label" style="width: 30%">原密码：</p>
					<div class="col-sm-10" style="width: 55%">
						<input type="password" class="form-control" id="oldPassword"
							placeholder="请输入原密码" onchange="change(this.value)">
					</div>
				</div>
				<!-- 	提示信息 -->
				<!-- <div id="oldPasswordAlert"> -->
					<p id="oldPasswordInfo" style="color: red; font-size: 10px; position: absolute;margin-top: -15px;margin-left: 200px"></p>
			<!-- 	</div> -->
				<div class="form-group">
					<p class="col-sm-2 control-label" style="width: 30%">新密码：</p>
					<div class="col-sm-10" style="width: 55%">
						<input type="password" class="form-control" id="newPassword"
							placeholder="请输入新密码">
					</div>
				</div>
				<!-- 	提示信息 -->
			<!-- 	<div id="newPasswordAlert"> -->
					<p id="newPasswordInfo" style="color: red; font-size: 10px; position: absolute;margin-top: -15px;margin-left: 200px"></p>
			<!-- 	</div> -->
				<div class="form-group">
					<p class="col-sm-2 control-label" style="width: 30%">确认密码：</p>
					<div class="col-sm-10" style="width: 55%">
						<input type="password" class="form-control" id="confirmPassword"
							name="password" placeholder="请输入确认密码">
					</div>
				</div>
				<!-- 	提示信息 -->
				<!-- <div id="confirmPasswordAlert"> -->
					<p id="confirmPasswordInfo"style="color: red; font-size: 10px; position: absolute;margin-top: -15px;margin-left: 200px"></p>
		<!-- 		</div> -->
			</div>
			<button type="submit" class="btn btn-info"
				style="margin-left: 420px">提交</button>
			<button type="reset" class="btn btn-info"
				style="margin-left: 50px">取消</button>
		</form>
	</div>
	<script type="text/javascript">
		function change(oldPassword) {
			var adminId = $("#adminid").val();
			console.info("旧密码"+oldPassword);
			checkOldPassword(adminId, oldPassword);
		}
	</script>
	<script src="${pageContext.request.contextPath}/js/parameterscheck.js"></script>
	<script src="${pageContext.request.contextPath}/js/alert.js"></script>
</body>
</html>