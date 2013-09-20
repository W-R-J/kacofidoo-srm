$(function() {
			var loginErrorCode = parseInt(getParam(window.location.href, "errorCode"));
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
			};

			$('#btnRegister').click(function(){
			jumpTo('register.html');
			});
});