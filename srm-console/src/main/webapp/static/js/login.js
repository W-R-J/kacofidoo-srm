$(function() {
	var loginErrorCode = parseInt(getParam("errorCode"));
	switch (loginErrorCode) {
	case 1:
		alert('用户名没有找到!');
		break;
	case 2:
		alert('用户名密码错误!');
		break;
	case 3:
		alert('其他登录错误!');
		break;
	default:
		break;
	}

	$('#btnLogin').click(function() {
		$('#formLogin').get(0).submit();
	});

	$('#btnRegister').click(function() {
		jumpTo('register.jsp');
	});

	$('#btnConsole').click(function() {
		jumpTo("auth/login");
	});
	$('#btnLogout').click(function() {
		jumpTo("auth/logout");
	});

});