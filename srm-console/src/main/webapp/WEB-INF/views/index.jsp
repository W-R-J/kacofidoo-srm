<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
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
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/datepicker/datepicker.css" rel="stylesheet">
    <style type="text/css">
        body {
        padding-top: 60px;
        padding-bottom: 40px;
        }
    </style>
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">

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
    <link rel="apple-touch-icon-precomposed"
          href="http://www.bootcss.com/assets/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="http://www.bootcss.com/assets/ico/favicon.png">
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
                        <a href="#">公司信息</a>
                    </li>
                    <li>
                        <a href="#about">联系人</a>
                    </li>
                    <li>
                        <a href="#contact">文档报告</a>
                    </li>
                    <li>
                        <a href="#contact">产品数据</a>
                    </li>
                    <li>
                        <a href="#contact">询价报价</a>
                    </li>
                    <li>
                        <a href="#contact">价格管理</a>
                    </li>
                    <li>
                        <a href="#contact">订单处理</a>
                    </li>
                    <li>
                        <a href="#contact">抱怨处理</a>
                    </li>
                </ul>
                <c:if test="${}"></c:if>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container">

    <hr>

    <footer>
        <p>©2013 Jeff.Tsai <a href="mailto:jjeffcaii@outlook.com">jjeffcaii@outlook.com</a> <a
                href="tel:+8618602162324">+8618602162324</a></p>
    </footer>


</div>
<!-- /container -->

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
</body>