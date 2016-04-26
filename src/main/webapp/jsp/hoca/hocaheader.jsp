<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Öğretim Elemanı Paneli</title>
<meta name="generator" content="Bootply" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/footable.core.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/footable.metro.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-select.min.css" rel="stylesheet" type="text/css">
<%-- <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet"> --%>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

<script type ="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script type ="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type ="text/javascript" src="${pageContext.request.contextPath}/js/footable.js"></script>
<script type ="text/javascript" src="${pageContext.request.contextPath}/js/footable.paginate.js"></script>
<script type ="text/javascript" src="${pageContext.request.contextPath}/js/custom_script_hoca.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-select.js"></script>
</head>
<body>
	<!-- Header -->
	<div id="top-nav" class="navbar  navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-toggle"></span>
				</button>
				<a href="./anasayfa" class="navbar-brand"><img style="height: 30px; width: 35px; position: 15" src="${pageContext.request.contextPath}/image/logo.png"> OMÜ SINAV SİSTEMİ</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle" role="button"
						data-toggle="dropdown" href="#"> <i
							class="glyphicon glyphicon-user"></i> ${hoca.ad} ${hoca.soyad} <span class="caret"></span></a>
						<ul id="g-account-menu" class="dropdown-menu" role="menu">
							<li><a href="#" data-toggle="modal"
										data-target="#AyarlarModal"><span
											class="glyphicon glyphicon-cog" aria-hidden="true"></span>
											Ayarlar</a></li>
							<li><a href="hocalogout"><i class="glyphicon glyphicon-log-out"></i> Çıkış</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /Header -->

	<!-- Main -->
	<div class="container">
		<!-- upper section -->
		<div class="row">