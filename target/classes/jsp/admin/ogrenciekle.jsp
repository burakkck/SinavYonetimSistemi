<%@page import="com.sinavgirisbelgesi.dao.FakulteDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Fakulte"%>
<%@page import="com.sinavgirisbelgesi.dao.BolumDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Bolum"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kayıt Ol</title>
<link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/bootstrap-select.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/footable.core.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/footable.metro.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">
<!-- <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"> -->
<!-- <link href='http://fonts.googleapis.com/css?family=IM+Fell+DW+Pica+SC' rel='stylesheet' type='text/css'> -->
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/footable.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/footable.paginate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-select.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom_script_admin.js" charset="UTF-8"></script>
<%-- <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" type="text/css" /> --%>
<!-- <link href='http://fonts.googleapis.com/css?family=IM+Fell+DW+Pica+SC' rel='stylesheet' type='text/css'> -->
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"> --%>
<!-- <link href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet"> -->
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%@include file="adminheader.jsp" %>
<div class="col-lg-6">
	<div class="page-header" style="margin-top: -8px">
		<h1 style="color: #000000;">Öğrenci Ekle</h1>
	</div>
		<div class="row" >
		<div class="panel panel-default">
					<div class="panel-heading">
				<h3 class="panel-title">
					<strong>Öğrenci Ekle  </strong>
				</h3>
			</div>
		<div class="panel-body">
			<form action="ogrenciekle" method="post" class="form-horizontal" id="addogrenci" enctype="multipart/form-data" >
				<div class="form-group">
					<label class="col-sm-2 control-label">Öğrenci No</label>
					<div class="col-md-6">
						<input type="text" class="form-control" name="ogrencino" id="ogrencino" placeholder="Öğrenci Numaranızı Girin...">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Ad</label>
					<div class="col-md-6">
						<input type="text" class="form-control" name="ad" id="ad" placeholder="Adınızı Girin...">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Soyad</label>
					<div class="col-md-6">
						<input type="text" class="form-control" name="soyad" id="soyad" placeholder="Soyadınızı Girin...">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">E-Posta</label>
					<div class="col-md-6">
						<input type="text" class="form-control" name="email" id="email" placeholder="E-Posta Adresinizi Girin...">
					</div>
				</div>
				<div class="form-group">
					<label  class="col-sm-2 control-label">Sınıf</label>
					<div class="col-md-6">
						<select name="sinif" class="form-control sinif-select" >
							<option value="">Sınıfınızı Seçiniz...</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
				</div>
				
				<% 
					ArrayList<Fakulte> fakulteler = FakulteDAO.Fakulteler();
					request.setAttribute("fakulteler", fakulteler);  
				%>
				<div class="form-group">
						<label for="fakulte" class="col-sm-2 control-label">Fakülte</label>
						<div class="col-lg-6">
							<select title="Fakulte Seçiniz"
								class="form-control " data-live-search="true"
								name="fakulte" id="fakulte" >
								<option value="" >Fakülte Seçiniz </option>
								<c:forEach items="${fakulteler}" var="fakulteler">
									<option value="${fakulteler.id}" >${fakulteler.ad}</option>
								</c:forEach>
							</select>
						</div>
				</div>
				
				<%
// 					ArrayList<Bolum> bolumler = BolumDAO.Bolumler();
// 					request.setAttribute("bolumler", bolumler);
				%>
				<div class="form-group">
						<label for="bolum" class="col-lg-2 control-label">Bölüm</label>
						<div class="col-lg-6">
							<select title="Bölüm Seçiniz"
								class="form-control" id="bolum" data-live-search="true"
								name="bolum" disabled>
 								<option value="">Bölüm Seçiniz </option>
<%-- 								<c:forEach items="${bolumler}" var="bolumler"> --%>
<%-- 									<option value="${bolumler.id}">${bolumler.ad}</option> --%>
<%-- 								</c:forEach> --%>
							</select>
						</div>
					</div>
			
				<div class="form-group">
						<label class="col-lg-2 control-label">Şifre</label>
						<div class="col-lg-6">
							<input type="password" class="form-control" name="password" placeholder="Şifrenizi giriniz..." />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">Şifre Tekrar</label>
						<div class="col-lg-6">
							<input type="password" class="form-control" name="repeatpassword" placeholder="Şifrenizi tekrar giriniz..." />
						</div>
					</div>
			<div class="form-group">
				<label class="col-lg-2 control-label">Fotoğraf</label>
				<div class="col-lg-6">
					<input type="file" name="ogrenci_img" class="form-control"  >
				</div>
			</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-md-6">
						<input type="submit" name="kayit" value = "Kayıt Ol" class="btn btn-primary">
					</div>
				</div>
			</form>
			</div>
			</div>
		</div>
<c:if test="${not empty state}">
		<div class="alert alert-warning alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${state}</strong>
		</div>
	</c:if>
	<c:if test="${not empty message}">
		<div class="alert alert-warning alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${message}</strong>
		</div>
	</c:if>
	</div>





<!-- 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> -->
<%--     <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> --%>
	
</body>
</html>