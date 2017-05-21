/**
 * 
 */

/* 判断登陆时输入的用户名、密码是否为空 */
function isEmptyAdmin() {
	var adminName = $("#adminName").val();
	var password = $("#password").val();
	console.info(adminName + password);
	if (adminName.length == 0 || adminName.replace(/(^\s*)|(\s*$)/g, "") == "") {
		$("#adminNameInfo")[0].innerHTML = "用户名不能为空!";
		$("#adminNameInfo").css("display", "block");
		setTimeout("hideAdmin()", 3000);
		return false;
	} else {
		if (password.length == 0
				|| password.replace(/(^\s*)|(\s*$)/g, "") == "") {
			$("#passwordInfo")[0].innerHTML = "密码不能为空!";
			$("#passwordInfo").css("display", "block");
			setTimeout("hideAdmin()", 3000);
			return false;
		} else {
			return true;
		}
	}
}

/* 判断更新管理员信息时密码是否为空 */
function isEmptyPassword() {
	var password = $("#password").val();
	console.info(password);
	if (password.length == 0 || password.replace(/(^\s*)|(\s*$)/g, "") == "") {
		$("#psdInfo")[0].innerHTML = "密码不能为空!";
		$("#psdInfo").css("display", "block");
		setTimeout("hide()", 3000);
		return false;
	} else {
		return true;
	}
}
/* 获取全部的管理员信息， 判断管理员用户名是否已存在 */
function getAllAdmin() {
	$.get("http://localhost:8080/drug-manage/staffManage/getAllAdmin", "",
			function(adminList) {
				var adminName = $("#username").val();
				for (var i = 0; i < adminList.length; i++) {
					if (adminName.trim() == adminList[i].adminName.trim()) {
						$("#info")[0].innerHTML = "用户名"
								+ adminList[i].adminName + "已存在！";
						$("#info").css("display", "block");
						setTimeout("hide()", 3000);
						$("#username").val("");
					}
				}
			});
}

/* 获取全部的客户信息,判断客户用户名是否已存在 */
function getAllCustomer() {
	$.get("http://localhost:8080/drug-manage/customerManage/getAllCustomer",
			"", function(customerList) {
				var userName = $("#username").val();
				for (var i = 0; i < customerList.length; i++) {
					if (userName.trim() == customerList[i].username.trim()) {
						$("#info")[0].innerHTML = "用户名"
								+ customerList[i].username + "已存在！";
						$("#info").css("display", "block");
						setTimeout("hide()", 3000);
						$("#username").val("");
					}
				}
			});
}

/* 添加新管理员时判断用户名和密码是否为空 */
function isEmpty() {
	var username = $("#username").val();
	var password = $("#password").val();
	if (username.length == 0 || username.replace(/(^\s*)|(\s*$)/g, "") == "") {
		$("#info")[0].innerHTML = "用户名不能为空!";
		$("#info").css("display", "block");
		setTimeout("hide()", 3000);
		return false;
	} else {
		if (password.length == 0
				|| password.replace(/(^\s*)|(\s*$)/g, "") == "") {
			$("#psdInfo")[0].innerHTML = "密码不能为空!";
			$("#psdinfo").css("display", "block");
			setTimeout("hide()", 3000);
			return false;
		} else {
			return true;
		}
	}
}

/* 判断药品信息是否为空 */
function isEmptyDrug() {
	var approvedDrugName = $("#approvedDrugName").val();
	var drugPhoneticizedCode = $("#drugPhoneticizedCode").val();
	var drugCompany = $("#drugCompany").val();
	var drugApprovalNumber = $("#drugApprovalNumber").val();
	if (approvedDrugName.length == 0
			|| approvedDrugName.replace(/(^\s*)|(\s*$)/g, "") == "") {
		$("#approvedDrugNameInfo")[0].innerHTML = "药品通用名不能为空!";
		$("#approvedDrugNameInfo").css("display", "block");
		setTimeout("hideDrug()", 3000);
		return false;
	} else {
		if (drugPhoneticizedCode.length == 0
				|| drugPhoneticizedCode.replace(/(^\s*)|(\s*$)/g, "") == "") {
			$("#drugPhoneticizedCodeInfo")[0].innerHTML = "药品拼音码不能为空!";
			$("#drugPhoneticizedCodeInfo").css("display", "block");
			setTimeout("hideDrug()", 3000);
			return false;
		} else {
			if (drugCompany.length == 0
					|| drugCompany.replace(/(^\s*)|(\s*$)/g, "") == "") {
				$("#drugCompanyInfo")[0].innerHTML = "药品厂家不能为空!";
				$("#drugCompanyInfo").css("display", "block");
				setTimeout("hideDrug()", 3000);
				return false;
			} else {
				if (drugApprovalNumber.length == 0
						|| drugApprovalNumber.replace(/(^\s*)|(\s*$)/g, "") == "") {
					$("#approvalNumberInfo")[0].innerHTML = "药品批准文号不能为空!";
					$("#approvalNumberInfo").css("display", "block");
					setTimeout("hideDrug()", 3000);
					return false;
				} else {
					return true;
				}
			}
		}
	}
}

/* 获取全部的药品信息，通过批准文号来判断信息是否已存在 */
function getAllDrug() {
	$
			.get(
					"http://localhost:8080/drug-manage/drugManage/getAllDrug",
					"",
					function(drugList) {
						var drugApprovalNumber = $("#drugApprovalNumber").val();
						for (var i = 0; i < drugList.length; i++) {
							if (drugApprovalNumber.trim() == drugList[i].drugApprovalNumber
									.trim()) {
								$("#approvalNumberInfo")[0].innerHTML = "该批准文号的药品信息已存在！请核实后重新输入！";
								$("#approvalNumberInfo")
										.css("display", "block");
								setTimeout("hideDrug()", 3000);
								$("#drugApprovalNumber").val("");
							}
						}
					});
}

/* 判断添加药品分类时分类名称是否为空 */
function isEmptyClassification() {
	var classificationName = $("#classificationName").val();
	if (classificationName.length == 0
			|| classificationName.replace(/(^\s*)|(\s*$)/g, "") == "") {
		$("#classificationInfo")[0].innerHTML = "分类名称不能为空!";
		$("#classificationInfo").css("display", "block");
		setTimeout("hideClassification()", 3000);
		return false;
	} else {
		return true;
	}
}

/* 验证剂型分类名称是否为空 */
function isEmptyDosageFormName() {
	var dosageFormName = $("#dosageFormName").val();
	if (dosageFormName.length == 0
			|| dosageFormName.replace(/(^\s*)|(\s*$)/g, "") == "") {
		$("#dosageFormInfo")[0].innerHTML = "药品剂型分类名称不能为空!";
		$("#dosageFormInfo").css("display", "block");
		setTimeout("hideClassification()", 3000);
		return false;
	} else {
		return true;
	}
}

/* 检查输入的药品库存信息是否合法 */
function isEmptyInventory() {
	var approvedDrugName = $("#approvedDrugName").val();
	var drugSize = $("#drugSize").val();
	var drugInventory = $("#drugInventory").val();
	var productionDate = $("#productionDate").val();
	var drugExpiryDate = $("#drugExpiryDate").val();
	var drugBuyingPrice = $("#drugBuyingPrice").val();
	var drugSellingPrice = $("#drugSellingPrice").val();
	var drugPosition = $("#drugPosition").val();

	if (approvedDrugName == 0) {
		$("#approvedDrugNameInfo")[0].innerHTML = "药品通用名不能为空!";
		$("#approvedDrugNameInfo").css("display", "block");
		setTimeout("hideInventory()", 3000);
		return false;
	} else {
		if (drugSize.length == 0
				|| drugSize.replace(/(^\s*)|(\s*$)/g, "") == "") {
			$("#drugSizeInfo")[0].innerHTML = "药品规格不能为空!";
			$("#drugSizeInfo").css("display", "block");
			setTimeout("hideInventory()", 3000);
			return false;
		} else {
			if (drugInventory.length == 0
					|| drugInventory.replace(/(^\s*)|(\s*$)/g, "") == "") {
				$("#drugInventoryInfo")[0].innerHTML = "药品库存量不能为空!";
				$("#drugInventoryInfo").css("display", "block");
				setTimeout("hideInventory()", 3000);
				return false;
			} else {
				if (productionDate.length == 0
						|| productionDate.replace(/(^\s*)|(\s*$)/g, "") == "") {
					$("#productionDateInfo")[0].innerHTML = "药品生产日期不能为空!";
					$("#productionDateInfo").css("display", "block");
					setTimeout("hideInventory()", 3000);
					return false;
				} else {
					if (drugExpiryDate.length == 0
							|| drugExpiryDate.replace(/(^\s*)|(\s*$)/g, "") == "") {
						$("#drugExpiryDateInfo")[0].innerHTML = "药品有效期不能为空!";
						$("#drugExpiryDateInfo").css("display", "block");
						setTimeout("hideInventory()", 3000);
						return false;
					} else {
						if (drugBuyingPrice.length == 0
								|| drugBuyingPrice
										.replace(/(^\s*)|(\s*$)/g, "") == "") {
							$("#drugBuyingPriceInfo")[0].innerHTML = "药品进价不能为空!";
							$("#drugBuyingPriceInfo").css("display", "block");
							setTimeout("hideInventory()", 3000);
							return false;
						} else {
							if (drugSellingPrice.length == 0
									|| drugSellingPrice.replace(
											/(^\s*)|(\s*$)/g, "") == "") {
								$("#drugSellingPriceInfo")[0].innerHTML = "药品售价不能为空!";
								$("#drugSellingPriceInfo").css("display",
										"block");
								setTimeout("hideInventory()", 3000);
								return false;
							} else {
								if (drugPosition.length == 0
										|| drugPosition.replace(
												/(^\s*)|(\s*$)/g, "") == "") {
									$("#drugPositionInfo")[0].innerHTML = "药品摆放位置不能为空!";
									$("#drugPositionInfo").css("display",
											"block");
									setTimeout("hideInventory()", 3000);
									return false;
								} else {
									return true;
								}
							}
						}
					}
				}
			}
		}
	}
}

/* 判断输入的库存数是否合法 */
function isValidInventory() {
	var drugInventory = $("#drugInventory").val();
	var reg = '^[0-9]*[1-9][0-9]*$'; /* 限定文本框输入必须为大于0的正整数 */
	if (drugInventory.match(reg) == null) {
		$("#drugInventoryInfo")[0].innerHTML = "输入的药品数量不合法!";
		$("#drugInventoryInfo").css("display", "block");
		$("#drugInventory").val("");
		setTimeout("hideInventory()", 3000);
	}
}
/* 判断输入的生产日期是否合法 */
function isValidProductionDate() {
	var a = $("#productionDate").val();
	var year = a.substring(0, 4);
	var month = a.substring(5, 7);
	var b = a.substring(5, 6);
	if (b == 0) {
		month = month.substring(1);
	}
	var d = new Date(); // 获取当前日期
	if (year > d.getFullYear()) { // 比较年份
		$("#productionDateInfo")[0].innerHTML = "输入的年份不合法!";
		$("#productionDateInfo").css("display", "block");
		$("#productionDate").val("");
		setTimeout("hideInventory()", 3000);
	} else if (year == d.getFullYear()) {
		if (month > (d.getMonth() + 1)) { // 比较月份
			$("#productionDateInfo")[0].innerHTML = "输入的月份不合法";
			$("#productionDateInfo").css("display", "block");
			$("#productionDate").val("");
			setTimeout("hideInventory()", 3000);
		} else if (month == (d.getMonth() + 1)) {
			var e = a.substring(8, 9);
			day = a.substring(8);
			if (e == 0) {
				day = day.substring(1);
			}
			if (day > d.getDate()) {// 比较日期
				$("#productionDateInfo")[0].innerHTML = "输入的日期不合法";
				$("#productionDateInfo").css("display", "block");
				$("#productionDate").val("");
				setTimeout("hideInventory()", 3000);
			}
		}
	}
}

/* 判断输入的药品进价是否合法 */
function isValidBuyingPrice() {
	var drugBuyingPrice = $("#drugBuyingPrice").val();
	if (drugBuyingPrice.match("^[0-9]+(.[0-9]{2})?$") == null) {
		$("#drugBuyingPriceInfo")[0].innerHTML = "输入的药品进价不合法!";
		$("#drugBuyingPriceInfo").css("display", "block");
		setTimeout("hideInventory()", 3000);
		$("#drugBuyingPrice").val("");
	}
}

/* 判断输入的售价进价是否合法 */
function isValidSellingPrice() {
	var drugSellingPrice = $("#drugSellingPrice").val();
	if (drugSellingPrice.match("^[0-9]+(.[0-9]{2})?$") == null) {
		$("#drugSellingPriceInfo")[0].innerHTML = "输入的药品售价不合法!";
		$("#drugSellingPriceInfo").css("display", "block");
		setTimeout("hideInventory()", 3000);
		$("#drugSellingPrice").val("");
	}
}
/* 验证订单中收货地址信息是否为空 */
function isEmptyReceiverInfo() {
	var receiverName = $("#receiverName").val();
	var zipCode = $("#zipCode").val();
	var receiverPhone = $("#receiverPhone").val();
	var receiverAddress = $("#receiverAddress").val();
	if (receiverName.length == 0
			|| receiverName.replace(/(^\s*)|(\s*$)/g, "") == "") {
		$("#receiverNameInfo")[0].innerHTML = "收货人姓名不能为空!";
		$("#receiverNameInfo").css("display", "block");
		setTimeout("hideReceiver()", 3000);
		return false;
	} else {
		if (zipCode.length == 0 || zipCode.replace(/(^\s*)|(\s*$)/g, "") == "") {
			$("#zipCodeInfo")[0].innerHTML = "邮编不能为空!";
			$("#zipCodeInfo").css("display", "block");
			setTimeout("hideReceiver()", 3000);
			return false;
		} else {
			if (receiverPhone.length == 0
					|| receiverPhone.replace(/(^\s*)|(\s*$)/g, "") == "") {
				$("#receiverPhoneInfo")[0].innerHTML = "收货人电话不能为空!";
				$("#receiverPhoneInfo").css("display", "block");
				setTimeout("hideReceiver()", 3000);
				return false;
			} else {
				if (receiverAddress.length == 0
						|| receiverAddress.replace(/(^\s*)|(\s*$)/g, "") == "") {
					$("#receiverAddressInfo")[0].innerHTML = "收货人地址不能为空!";
					$("#receiverAddressInfo").css("display", "block");
					setTimeout("hideReceiver()", 3000);
					return false;
				} else {
					return true;
				}
			}

		}
	}
}

/* 判断用户输入的原密码是否正确 */
function checkOldPassword(aId, oldPassword) {
	$.get("http://localhost:8080/petCommunity/admin/getAdmin/" + aId,
			"", function(admin) {
		        console.log(admin);
				if (admin.password != oldPassword) {
					$("#oldPasswordInfo")[0].innerHTML = "输入的原密码错误!";
					$("#oldPasswordInfo").css("display", "block");
					setTimeout("hidePsdAlerts()", 3000);
					$("#oldPassword").val("");
				}
			});
}

/* 判断修改密码时参数输入 */
function isEmptyPasswords() {
	var oldPsd = $("#oldPassword").val();
	var newPsd = $("#newPassword").val();
	var confirmPsd = $("#confirmPassword").val();
	if (oldPsd.length == 0 || oldPsd.replace(/(^\s*)|(\s*$)/g, "") == "") {
		$("#oldPasswordInfo")[0].innerHTML = "原密码不能为空!";
		$("#oldPasswordInfo").css("display", "block");
		setTimeout("hidePsdAlerts()", 3000);
		return false;
	} else {
		if (newPsd.length == 0 || newPsd.replace(/(^\s*)|(\s*$)/g, "") == "") {
			$("#newPasswordInfo")[0].innerHTML = "新密码不能为空!";
			$("#newPasswordInfo").css("display", "block");
			setTimeout("hidePsdAlerts()", 3000);
			return false;
		} else {
			if (newPsd != oldPsd) {
				if (confirmPsd.length == 0
						|| confirmPsd.replace(/(^\s*)|(\s*$)/g, "") == "") {
					$("#confirmPasswordInfo")[0].innerHTML = "确认密码不能为空!";
					$("#confirmPasswordInfo").css("display", "block");
					setTimeout("hidePsdAlerts()", 3000);
					return false;
				} else {
					if (newPsd != confirmPsd) {
						$("#confirmPasswordInfo")[0].innerHTML = "确认密码与新密码不一致!";
						$("#confirmPasswordInfo").css("display", "block");
						setTimeout("hidePsdAlerts()", 3000);
						$("#confirmPassword").val('')
						return false;
					} else {
						return true;
					}
				}
			} else {
				$("#newPasswordInfo")[0].innerHTML = "输入的新密码与原密码相同!";
				$("#newPasswordInfo").css("display", "block");
				setTimeout("hidePsdAlerts()", 3000);
				$("#newPassword").val('');
				$("#confirmPassword").val('')
				return false;
			}
		}
	}
}

/* 检查药品数量是否合法 */
function checkDrugAmount() {
	var drugAmount = $("#drugAmount").val();
	if (drugAmount.length == 0
			|| drugAmount.replace(/(^\s*)|(\s*$)/g, "") == "") {
		$("#info")[0].innerHTML = "药品数量不能为空!";
		$("#info").css("display", "block");
		setTimeout("hide()", 3000);
		return false;
	} else {
		if (drugAmount.match("^[0-9]*[1-9][0-9]*$") == null) { /* 限定文本框输入必须为大于0的正整数 */
			$("#info")[0].innerHTML = "输入的药品数量不合法!";
			$("#info").css("display", "block");
			setTimeout("hide()", 3000);
			return false;
		} else {
			return true;
		}
	}
}

/* 判断输入的失效药品数量是否合法 */
function isValidExpiredNumber() {
	var expiredDrugNumber = $("#expiredDrugNumber").val();
	if (expiredDrugNumber.length == 0
			|| expiredDrugNumber.replace(/(^\s*)|(\s*$)/g, "") == "") {
		$("#expiredDrugNumberInfo")[0].innerHTML = "失效药品数量不能为空!";
		$("#expiredDrugNumberInfo").css("display", "block");
		$("#expiredDrugNumber").val("")
		setTimeout("hideExpiredDrugInfo()", 3000);
		return false;
	} else {
		if (expiredDrugNumber.match("^[0-9]*[1-9][0-9]*$") == null) { /* 限定文本框输入必须为大于0的正整数 */
			$("#expiredDrugNumberInfo")[0].innerHTML = "输入的失效药品数量不合法!";
			$("#expiredDrugNumberInfo").css("display", "block");
			setTimeout("hideExpiredDrugInfo()", 3000);
			$("#expiredDrugNumber").val("");
			return false;
		} else {
			return true;
		}
	}
}

/* 判断失效药品库存ID是否合法 */
function checkInventoryId() {
	var inventoryId = $("#inventoryId").val();
	$
			.get(
					"http://localhost:8080/drug-manage/inventoryManage/getAllDrugInventoryInfo",
					"", function(inventoryList) {
						var arr = new Array();
						for (var i = 0; i < inventoryList.length; i++) {
							arr.push(inventoryList[i].inventoryId + "");
						}
						console.info(inventoryId);
						if ($.inArray(inventoryId, arr) > -1) {
							getInventory(inventoryId);
						} else {
							$("#inventoryIdInfo")[0].innerHTML = "库存ID不存在!";
							$("#inventoryIdInfo").css("display", "block");
							setTimeout("hideExpiredDrugInfo()", 3000);
							$("#inventoryId").val("");
						}
					});
}

/* 判断输入的失效药品信息是否为空 */
function isEmptyExpiredDrug() {
	var inventoryId = $("#inventoryId").val();
	var expiredDrugNumber = $("#expiredDrugNumber").val();
	if (inventoryId.length == 0
			|| inventoryId.replace(/(^\s*)|(\s*$)/g, "") == "") {
		$("#inventoryIdInfo")[0].innerHTML = "库存ID不能为空!";
		$("#inventoryIdInfo").css("display", "block");
		setTimeout("hideExpiredDrugInfo()", 3000);
		return false;
	} else {
		if (expiredDrugNumber.length == 0
				|| expiredDrugNumber.replace(/(^\s*)|(\s*$)/g, "") == "") {
			$("#expiredDrugNumberInfo")[0].innerHTML = "失效数量不能为空!";
			$("#expiredDrugNumberInfo").css("display", "block");
			setTimeout("hideExpiredDrugInfo()", 3000);
			return false;
		} else {
			return true;
		}
	}
}

/* 隐藏提示信息 */
function hide() {
	$('#info').css("display", "none");
	$('#psdInfo').css("display", "none");
}

function hideReceiver() {
	$("#receiverNameInfo").css("display", "none");
	$("#zipCodeInfo").css("display", "none");
	$("#receiverPhoneInfo").css("display", "none");
	$("#receiverAddressInfo").css("display", "none");
}

function hideClassification() {
	$("#classificationInfo").css("display", "none");
	$("#dosageFormInfo").css("display", "none");
}

function hideDrug() {
	$("#approvedDrugNameInfo").css("display", "none");
	$("#drugPhoneticizedCodeInfo").css("display", "none");
	$("#drugCompanyInfo").css("display", "none");
	$("#approvalNumberInfo").css("display", "none");
}

function hideAdmin() {
	$("#adminNameInfo").css("display", "none");
	$("#passwordInfo").css("display", "none");
}
function hidePsdAlerts() {
	$("#oldPasswordInfo").css("display", "none");
	$("#newPasswordInfo").css("display", "none");
	$("#confirmPasswordInfo").css("display", "none");
}

function hideInventory() {
	$("#approvedDrugNameInfo").css("display", "none");
	$("#drugSizeInfo").css("display", "none");
	$("#drugInventoryInfo").css("display", "none");
	$("#productionDateInfo").css("display", "none");
	$("#drugExpiryDateInfo").css("display", "none");
	$("#drugBuyingPriceInfo").css("display", "none");
	$("#drugSellingPriceInfo").css("display", "none");
	$("#drugPositionInfo").css("display", "none");
}

function hideExpiredDrugInfo() {
	$("#inventoryIdInfo").css("display", "none");
	$("#expiredDrugNumberInfo").css("display", "none");
}
