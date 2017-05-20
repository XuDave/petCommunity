<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Navigator</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/css/style.css"
	rel='stylesheet' type='text/css' />
<link href="${pageContext.request.contextPath}/css/font-awesome.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/custom.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/buttons.css"
	rel="stylesheet">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
	 function hideURLbar(){ window.scrollTo(0,1); } 
</script>
</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="top1 navbar navbar-default navbar-static-top"
			role="navigation" style="margin-bottom: 0">
			<%-- 				<p>${curAdmin.adminName }</p> --%>
			<div class="navbar-header">
				<a class="navbar-brand" href="#">宠物社区后台管理系统</a>
				<p style="margin-left: 1200px; margin-top: 15px">
					${curAdmin.adminname } 您好，欢迎使用宠物社区后台管理系统
					<a href="${pageContext.request.contextPath}/staffManage/loginout"
						onclick=""><i class="fa fa-power-off fa-1x"></i></a>
				</p>
			</div>
			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li><a
							href="${pageContext.request.contextPath}/jsp/fontPage.jsp"
							style="padding-left: 40px"><i
								class="fa fa-home fa-fw  fa-2x nav_icon"></i></a></li>
						<li><a href="#"><i class="fa fa-cog fa-spin nav_icon"></i>系统管理<span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a
									href="${pageContext.request.contextPath}/jsp/admin.jsp">修改密码</a></li>
							</ul> <!-- /.nav-second-level --></li>
							<li><a href="#"><i class="fa fa-indent nav_icon"></i>帖子管理<span
									class="fa arrow"></span></a>
								<ul class="nav nav-second-level">
									<li><a
										href="${pageContext.request.contextPath}/jsp/classificationManage.jsp">分类列表</a></li>
									<li><a
										href="${pageContext.request.contextPath}/drugManage/getAllDrugInfo">药品列表</a></li>
								</ul> <!-- /.nav-second-level --></li>
							<li><a href="#"><i class="fa fa-table nav_icon"></i>商品管理<span
									class="fa arrow"></span></a>
								<ul class="nav nav-second-level">
									<li><a
										href="${pageContext.request.contextPath}/inventoryManage/getAllInventoryInfo">库存列表</a></li>
									<li><a
										href="${pageContext.request.contextPath}/orderManage/getExaminedOrderInfo">出库订单</a></li>
								</ul> <!-- /.nav-second-level --></li>
							<li><a href="#"><i class="fa fa-user fa-fw nav_icon"></i>用户管理<span
									class="fa arrow"></span></a>
								<ul class="nav nav-second-level">
									<li><a
										href="${pageContext.request.contextPath}/staffManage/getAllAdminInfo">员工管理</a></li>
									<li><a
										href="${pageContext.request.contextPath}/customerManage/getAllCustomerInfo">客户管理</a></li>
								</ul> <!-- /.nav-second-level --></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<!-- /#wrapper -->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<!-- Metis Menu Plugin JavaScript -->
	<script src="${pageContext.request.contextPath}/js/metisMenu.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/custom.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
