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

<link href="favicon.ico" type="image/x-icon" rel=icon>
<link href="favicon.ico" type="image/x-icon" rel="shortcut icon">

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
							<a href="#">首页</a>
						</li>
						<li>
							<a href="#about">关于</a>
						</li>
						<li>
							<a href="#contact">合作</a>
						</li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">
		<form id="formRegister" class="form-horizontal" method="post"
			action="${pageContext.request.contextPath}/company/register">
			<div class="control-group">
				<label class="control-label" for="inputCompanyName">公司名称</label>
				<div class="controls">
					<input type="ext" id="inputCompanyName" name="name" minlength="3" maxlength="200" placeholder="公司名称" required>
					<p class="help-block"></p>
					<input type="button" id="btnValidate" value="验证">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputCompanyDescription">公司简介</label>
				<div class="controls">
					<textarea rows="3" id="inputCompanyDescription" maxlength="2000" name="description" placebholder="公司简介文字"></textarea>
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputWebsite">公司网址</label>
				<div class="controls">
					<input type="text" id="inputWebsite" maxlength="300" name="website" placebholder="公司网址，如: http://www.baidu.com">
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputAddress">公司地址</label>
				<div class="controls">
					<input type="text" id="inputAddress" maxlength="300" name="address" placebholder="公司详细地址">
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputZipcode">邮政编码</label>
				<div class="controls">
					<input type="number" id="inputZipcode" maxlength="6" minlength="6" name="zipcode" placebholder="邮政编码">
					<p class="help-block"></p>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">确定</button>
		</form>


		<footer>
			<p class="text-center">
				©2013 Jeff.Tsai
				<a href="mailto:jjeffcaii@outlook.com">jjeffcaii@outlook.com</a>
				<a href="tel:+8618602162324">+8618602162324</a>
			</p>
		</footer>

	</div>
	<!-- /container -->

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
			$('#btnValidate').click(function() {
				$.ajax({
					url : '${pageContext.request.contextPath}/company/validate',
					data : {
						companyName : $('#inputCompanyName').val()
					},
					dataType : 'json',
					method : 'get',
					success : function(resp) {
						if (resp.success) {
							alert('恭喜，该公司尚未被注册！');
						} else {
							alert('抱歉，该公司已经被注册！您可进入公司申诉页面进行公司申诉!');
						}
					}
				});
			});

			$('#formRegister').ajaxForm({
				success : function(data) {
					if (data.success) {
						alert('注册成功!');
					} else {
						alert('注册失败:' + data.data)
					}
				},
				type : 'post',
				dataType : 'json'
			});
		});
	</script>
</body>