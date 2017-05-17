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
			<li class="active">员工信息</li>
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
					<td><a href="#" onclick="getSaffInfo(${user.userid})"
						data-toggle="modal" data-target="#staff">查看</a> <a
						href="../staffManage/updateAdminByID/${user.userid }">更新</a> <a
						href="../staffManage/deleteAdminInfo?id=${user.userid }"
						onclick="return confirm('确定删除?');">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="../staffManage/getAllPrivilege">
			<button type="button" class="btn btn-info">
				<i class="fa fa-plus"></i>
			</button>
		</a>
		<!-- 分页功能 start -->
		<div align="center">
			<ul class="pagination" style="margin-top: -25px">
				<li><a href="../staffManage/getAllAdminInfo?curPage=1">&laquo;</a></li>
				<c:choose>
					<c:when test="${page.curPage - 1 > 0}">
						<li><a
							href="../staffManage/getAllAdminInfo?curPage=${page.curPage - 1}">&lt;</a></li>
					</c:when>
					<c:when test="${page.curPage - 1 <= 0}">
						<li class="disabled"><a
							href="../staffManage/getAllAdminInfo?curPage=1">&lt;</a></li>
					</c:when>
				</c:choose>
				<%-- <li><font size="2">第  ${page.curPage} 页</font> <font size="2">共
				${page.totalPageCount} 页</font></li> --%>
				<li><a>${page.curPage}/${page.totalPageCount}</a></li>
				<c:choose>
					<c:when test="${page.totalPageCount==0}">
						<li><a
							href="../staffManage/getAllAdminInfo?curPage=${page.curPage}">&gt;</a></li>
					</c:when>
					<c:when test="${page.curPage + 1 < page.totalPageCount}">
						<li><a
							href="../staffManage/getAllAdminInfo?curPage=${page.curPage + 1}">&gt;</a></li>
					</c:when>
					<c:when test="${page.curPage + 1 == page.totalPageCount}">
						<li><a
							href="../staffManage/getAllAdminInfo?curPage=${page.totalPageCount}">&gt;</a></li>
					</c:when>
					<c:when test="${page.curPage == page.totalPageCount}">
						<li class="disabled"><a
							href="../staffManage/getAllAdminInfo?curPage=${page.totalPageCount}">&gt;</a></li>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${page.totalPageCount==0}">
						<li><a
							href="../staffManage/getAllAdminInfo?curPage=${page.curPage}">&raquo;</a></li>
					</c:when>
					<c:otherwise>
						<li><a
							href="../staffManage/getAllAdminInfo?curPage=${page.totalPageCount}">&raquo;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<!-- 分页功能 End -->
	</div>
	<!-- 模态框 -->
	<div class="modal fade" id="staff" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="staffInfo">员工信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-horizontal">
						<div class="form-group" style="display: none">
							<p class="col-sm-2 control-label">员工ID:</p>
							<div class="col-sm-10" style="width: 30%">
								<input type="text" class="form-control" id="staffId"
									name="staffId" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<p class="col-sm-2 control-label">姓名:</p>
							<div class="col-sm-10" style="width: 30%">
								<input type="text" class="form-control" id="staffName"
									name="staffName" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<p class="col-sm-2 control-label">性别:</p>
							<div class="col-sm-10" style="width: 20%">
								<input type="text" class="form-control" id="staffSex"
									name="staffSex" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<p class="col-sm-2 control-label">年龄:</p>
							<div class="col-sm-10" style="width: 20%">
								<input type="text" class="form-control" id="staffAge"
									name="staffAge" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<p class="col-sm-2 control-label">电话:</p>
							<div class="col-sm-10" style="width: 30%">
								<input type="text" class="form-control" id="staffPhone"
									name="staffPhone" readonly="readonly">
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<script src="${pageContext.request.contextPath}/js/ajax.js"></script>
	<script src="${pageContext.request.contextPath}/js/alert.js"></script>
</body>
</html>