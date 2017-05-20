/**
 * 
 */
/*<div class="alert alert-success">成功！很好地完成了提交。</div>
 <div class="alert alert-info">信息！请注意这个信息。</div>
 <div class="alert alert-warning">警告！请不要提交。</div>
 <div class="alert alert-danger">错误！请进行一些更改。</div>*/
/*var code = document.getElementById("code").innerHTML;
 var a = document.getElementById("info").innerHTML;*/
var code = $("#code")[0].innerHTML;
console.info(code);
var a = $("#info")[0].innerHTML;
console.info(a);
if ("" != a.trim()) {
	show();
}
function show() {
	/*document.getElementById("alert").style.display = "block";*/
	$("#alert").css("display", "block");
	if (code == 1) {
		/*document.getElementById("alert").className = "alert alert-success";*/
		$("#alert").addClass("alert alert-success");
	} else {
		/*document.getElementById("alert").className = "alert alert-danger";*/
		$("#alert").addClass("alert alert-danger");
	}
	setTimeout("hideAlert()", 5000);
}

function hideAlert() {
	$("#alert").css("display", "none");
}
