<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<title>Login</title>
<link rel=”shortcut icon ” href="${pageContext.request.contextPath}/image/omu.ico">
<meta name="generator" content="Bootply" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/footable.core.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/footable.metro.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-select.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/footable.js"></script>
<script src="${pageContext.request.contextPath}/js/custom_script_admin.js" charset="UTF-8"></script>
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
				<a class="navbar-brand" href="login">Sisteme Giriş</a>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /Header -->
<div class="row">
<div class="col-lg-5 col-lg-offset-4" style="margin-top: 100px; margin-left: 420px">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<strong>Sisteme Giriş Yap </strong>
				</h3>
			</div>
			<div class="panel-body">
				<form role="form" method="post" action="ogrencilogin">
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-user"></span>
							</div>
							<input name="username" type="text" class="form-control"
								id="inputUsername" placeholder="Kullanıcı Adı">
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-lock"></span>
							</div>
							<input name="password" type="password" class="form-control"
								id="inputPassword" placeholder="Şifre">
						</div>
					</div>
					<button style="float: right;" type="submit" class="btn btn-sm btn-default">Giriş
						Yap</button>
						 <a href="kayitol"  >Kayıt ol</a> 
				</form>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-lg-5 col-lg-offset-4">
		<c:if test="${not empty status}">
			<div class="alert alert-danger alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${status}</strong>
			</div>
		</c:if>
	</div>
</div>



</body>
</html>












