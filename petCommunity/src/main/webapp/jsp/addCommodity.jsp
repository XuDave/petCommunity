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
<link href="../css/drug-style.css" rel='stylesheet' type='text/css' />
<script src="${pageContext.request.contextPath}/js/ajax.js"></script>
<title>addCommodity</title>
</head>
<body>
	<%@include file="../jsp/navigator.jsp"%>
	<div id="page-wrapper">
		<!-- 面包屑 -->
		<ul class="breadcrumb">
			<li><a href="#">首页</a> <span class="divider"></span></li>
			<li><a href="../drugManage/getAllDrugInfo">商品管理</a> <span
				class="divider"></span></li>
			<li class="active">添加商品</li>
		</ul>
		<form action="../commodity/insertCommodity" method="post"
			onsubmit="return isEmptyCommodity()">
			<div class="form-horizontal"
				style="width: 45%; margin: 40px 0 20px 250px">
				<div class="form-group">
					<p class="col-sm-2 control-label" style="width: 30%">商品名：</p>
					<div class="col-sm-10" style="width: 65%">
						<input type="text" class="form-control" id="commoditycontent"
							name="commoditycontent" placeholder="商品名">
					</div>
				</div>
				<div class="form-group">
					<p class="col-sm-2 control-label" style="width: 30%">单价：</p>
					<div class="col-sm-10" style="width: 65%">
						<input type="text" class="form-control" id="commodityprice"
							name="commodityprice" placeholder="单价" onchange="getPinyin()">
					</div>
					<label style="color: red">*</label>
				</div>

				<div class="form-group">
					<p class="col-sm-2 control-label" style="width: 30%">数量：</p>
					<div class="col-sm-10" style="width: 65%">
						<input type="text" class="form-control" id="commoditycount"
							name="commoditycount" placeholder="数量">
					</div>
					<label style="color: red">*</label>
				</div>
				<div class="form-group">
					<p class="col-sm-2 control-label" style="width: 30%">状态：</p>
					<div class="col-sm-10" style="width: 30%">
						<select class="form-control" id="commoditystate"
							name="commoditystate">
							<option value="1">上架</option>
							<option value="0">下架</option>
						</select>
					</div>
					<label style="color: red">*</label>
				</div>
			</div>
			<button type="submit" class="btn btn-info" style="margin-left: 400px">提交</button>
			<button type="reset" class="btn btn-info" style="margin-left: 50px">取消</button>
		</form>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jQuery.Hz2Py-min.js"></script>
	<script src="${pageContext.request.contextPath}/js/ajax.js"></script>
	<script src="${pageContext.request.contextPath}/js/parameterscheck.js"></script>
</body>
</html>