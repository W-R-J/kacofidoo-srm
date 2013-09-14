<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>SRM</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
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
<script>
	try {
		for ( var lastpass_iter = 0; lastpass_iter < document.forms.length; lastpass_iter++) {
			var lastpass_f = document.forms[lastpass_iter];
			if (typeof (lastpass_f.lpsubmitorig) == "undefined") {
				if (typeof (lastpass_f.submit) == "function") {
					lastpass_f.lpsubmitorig = lastpass_f.submit;
					lastpass_f.submit = function() {
						var form = this;
						try {
							if (document.documentElement && 'createEvent' in document) {
								var forms = document.getElementsByTagName('form');
								for ( var i = 0; i < forms.length; ++i)
									if (forms[i] == form) {
										var element = document.createElement('lpformsubmitdataelement');
										element.setAttribute('formnum', i);
										element.setAttribute('from', 'submithook');
										document.documentElement.appendChild(element);
										var evt = document.createEvent('Events');
										evt.initEvent('lpformsubmit', true, false);
										element.dispatchEvent(evt);
										break;
									}
							}
						} catch (e) {
						}
						try {
							form.lpsubmitorig();
						} catch (e) {
						}
					}
				}
			}
		}
	} catch (e) {
	}
</script>
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
				<a class="brand" href="#">SRM</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active">
							<a href="#">首页</a>
						</li>
						<li>
							<a href="#about">关于</a>
						</li>
						<li>
							<a href="#contact">合作</a>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								Dropdown
								<b class="caret"></b>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">Action</a>
								</li>
								<li>
									<a href="#">Another action</a>
								</li>
								<li>
									<a href="#">Something else here</a>
								</li>
								<li class="divider"></li>
								<li class="nav-header">Nav header</li>
								<li>
									<a href="#">Separated link</a>
								</li>
								<li>
									<a href="#">One more separated link</a>
								</li>
							</ul>
						</li>
					</ul>
					<form id="loginForm" class="navbar-form pull-right" action="user/login">
						<input class="span2" placeholder="登录名" type="text" name="loginName">
						<input class="span2" placeholder="密码" type="password" name="loginPassword">
						<select class="span2" name="loginType">
							<option value="-1">管理员</option>
							<option value="1">采购商</option>
							<option value="2">供应商</option>
						</select>
						<button type="submit" class="btn">登录</button>
					</form>
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
					<a class="btn" href="#">View details Â»</a>
				</p>
			</div>
			<div class="span4">
				<h2>Heading</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris
					condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec
					sed odio dui.</p>
				<p>
					<a class="btn" href="#">View details Â»</a>
				</p>
			</div>
			<div class="span4">
				<h2>Heading</h2>
				<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta
					felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa
					justo sit amet risus.</p>
				<p>
					<a class="btn" href="#">View details Â»</a>
				</p>
			</div>
		</div>

		<hr>

		<footer>
			<p>Â© Company 2013</p>
		</footer>

	</div>
	<!-- /container -->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="static/jquery/jquery.js"></script>
	<script src="static/bootstrap/js/bootstrap.js"></script>



</body>
</html>