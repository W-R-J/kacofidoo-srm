<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>SRM</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="static/datepicker/datepicker.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>
<link href="static/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="//cdnjs.bootcss.com/ajax/libs/html5shiv/3.6.2/html5shiv.js"></script>
    <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="http://www.bootcss.com/assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="http://www.bootcss.com/assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="http://www.bootcss.com/assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="http://www.bootcss.com/assets/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="http://www.bootcss.com/assets/ico/favicon.png">
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="brand" href="${pageContext.request.contextPath}">SRM</a>

				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="#">首页</a></li>
						<li><a href="#about">关于</a></li>
						<li><a href="#contact">合作</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">
		<h3>注册</h3>
		<form id="formRegister" class="form-horizontal" method="post" action="user/register">
			<div class="control-group">
				<label class="control-label" for="inputUsername">用户名</label>
				<div class="controls">
					<input type="email" id="inputUsername" name="name" minlength="3" maxlength="200" placeholder="邮箱" required>
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">密码</label>
				<div class="controls">
					<input type="password" id="inputPassword" minlength="6" maxlength="12" name="password" placeholder="6-12位" required>
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword2">重复密码</label>
				<div class="controls">
					<input type="password" data-validation-matches-match="password" data-validation-matches-message="密码输入不一致"
						id="inputPassword2" minlength="6" maxlength="12" placeholder="6-12位" required>
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputNickname">昵称</label>
				<div class="controls">
					<input type="text" id="inputNickname" maxlength="200" name="nickname" placebholder="用户昵称">
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputGender">性别</label>
				<div class="controls">
					<select id="inputGender" name="gender">
						<option value="0">保密</option>
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputBirthday">出生年月</label>
				<div class="controls">
					<div class="input-append date" data-date="2013-09-20" data-date-format="yyyy-mm-dd">
						<input id="inputBirthday" size="16" name="birthday" type="text" value="2013-09-20"> <span class="add-on"><i
							class="icon-th"></i></span>
					</div>
				</div>
			</div>
			<button class="btn" onclick="history.back();">返回</button>
			<button class="btn" type="reset">重置</button>
			<button id="btnRegisterSubmit" class="btn btn-primary">确定</button>
		</form>


		<footer>
			<p class="text-center">
				©2013 Jeff.Tsai <a href="mailto:jjeffcaii@outlook.com">jjeffcaii@outlook.com</a> <a href="tel:+8618602162324">+8618602162324</a>
			</p>
		</footer>

	</div>
	<!-- /container -->

	<!-- Le javascript
================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript" src="static/jquery/jquery.js"></script>
	<script type="text/javascript" src="static/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="static/datepicker/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="static/js/common.js"></script>
	<script type="text/javascript" src="static/js/jquery.form.js"></script>
	<script type="text/javascript" src="static/js/jqBootstrapValidation.js"></script>
	<script type="text/javascript">
		$(function() {
			$('.date').datepicker();
			$("input,select,textarea").not("[type=submit]").jqBootstrapValidation();
			$('#btnRegisterSubmit').click(function() {

				$('#formRegister').ajaxSubmit(function(data) {
					console.log(data);
					if (data.success) {
						alert('注册成功!');
					}
				});
			});
		});
	</script>
</body>