<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/header.jsp"%>
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
<link href="favicon.ico" type="image/x-icon" rel=icon>
<link href="favicon.ico" type="image/x-icon" rel="shortcut icon">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="//cdnjs.bootcss.com/ajax/libs/html5shiv/3.6.2/html5shiv.js"></script>
    <![endif]-->

</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="brand" href="${pageContext.request.contextPath}">SRM</a>

				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active">
							<a href="${pageContext.request.contextPath}">首页</a>
						</li>
						<li>
							<a href="#about">关于</a>
						</li>
						<li>
							<a href="#contact">合作</a>
						</li>
					</ul>
					<div class="pull-right">
						<c:choose>
							<c:when test="${sessionScope.username!=null}">
								<input type="button" id="btnConsole" class="btn btn-success" value="管理">
								<input type="button" id="btnLogout" class="btn btn-warning" value="登出">
							</c:when>
							<c:otherwise>
								<input type="button" id="btnLoginModal" data-toggle="modal" data-target="#loginModal" class="btn" value="登录">
								<input type="button" id="btnRegister" class="btn" value="注册">
							</c:otherwise>
						</c:choose>
					</div>

				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">

		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			<h1>Hello, world!</h1>

			<p>This is a template for a simple marketing or informational website. It includes a large callout called the
				hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>

			<p>
				<a href="#" class="btn btn-primary btn-large">Learn more Â»</a>
			</p>
		</div>

		<!-- Example row of columns -->
		<div class="row">
			<div class="span4">
				<h2>Heading</h2>

				<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
					condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec
					sed odio dui.</p>

				<p>
					<a class="btn" href="#">View details</a>
				</p>
			</div>
			<div class="span4">
				<h2>Heading</h2>

				<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
					condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec
					sed odio dui.</p>

				<p>
					<a class="btn" href="#">View details</a>
				</p>
			</div>
			<div class="span4">
				<h2>Heading</h2>

				<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta
					felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa
					justo sit amet risus.</p>

				<p>
					<a class="btn" href="#">View details</a>
				</p>
			</div>
		</div>

		<hr>

		<footer>
			<p class="text-center">
				©2013 Jeff.Tsai
				<a href="mailto:jjeffcaii@outlook.com">jjeffcaii@outlook.com</a>
				<a href="tel:+8618602162324">+8618602162324</a>
			</p>
		</footer>

		<div id="loginModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3 id="myModalLabel">登录</h3>
			</div>
			<div class="modal-body">
				<form id="formLogin" class="form-horizontal" method="post" action="auth/login">
					<div class="control-group">
						<label class="control-label" for="inputUsername">用户名</label>
						<div class="controls">
							<input type="text" id="inputUsername" name="username" placeholder="邮箱或手机">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword">密码</label>
						<div class="controls">
							<input type="password" name="password" id="inputPassword" placeholder="6到12个字符">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputLoginType">登录类型</label>
						<div class="controls">
							<select id="inputLoginType" name="loginType">
								<option value="1">采购商</option>
								<option value="2">供应商</option>
								<option value="9">管理员</option>
							</select>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<label class="checkbox">
								<input name="rememberMe" type="checkbox" value="true">
								记住我
							</label>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
				<button id="btnLogin" class="btn btn-primary">登录</button>
			</div>
		</div>


	</div>
	<!-- /container -->

	<!-- Le javascript
================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript" src="static/jquery/jquery.js"></script>
	<script type="text/javascript" src="static/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="static/js/common.js"></script>
	<script type="text/javascript" src="static/js/jquery.form.js"></script>
	<script type="text/javascript" src="static/js/login.js"></script>
</body>