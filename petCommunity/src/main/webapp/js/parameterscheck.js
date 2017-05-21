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

/* 隐藏提示信息 */
function hide() {
	$('#info').css("display", "none");
	$('#psdInfo').css("display", "none");
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

