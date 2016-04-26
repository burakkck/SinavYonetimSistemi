<%@page import="com.sinavgirisbelgesi.model.Ogrenci"%>
<%@page import="com.sinavgirisbelgesi.dao.SinavDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Sinav"%>
<%@page import="com.sinavgirisbelgesi.dao.KurallarDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Kurallar"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	Ogrenci ogr = (Ogrenci)session.getAttribute("ogrenci");
	int ogr_id = ogr.getId(); 
	ArrayList<Kurallar> kurallar = KurallarDAO.Kurallar();
	request.setAttribute("kurallar", kurallar);
	ArrayList<Sinav> sinavlar = SinavDAO.OrtakGirisBelgesi(ogr_id);
	request.setAttribute("sinavlar", sinavlar);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sınav Giriş Belgesi</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/bootstrap-select.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/footable.core.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/footable.metro.min.css" rel="stylesheet">
<!-- <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"> -->
<!-- <link href='http://fonts.googleapis.com/css?family=IM+Fell+DW+Pica+SC' rel='stylesheet' type='text/css'> -->
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/footable.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/footable.paginate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom_script_ogrenci.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-select.js"></script>
<!-- <style type="text/css">
/* 	body { */
/* 		background-image: url(${pageContext.request.contextPath}/image/logo.png); */
/* 		background-repeat: no-repeat; */
/* 		background-position: 2%; */
/* 	} */
	 </style> -->
</head>
<body>
	<div class="container">
		<div class="row">
		<br>
			
						
					<div style="width: 894px;" class="col-md-offset-1 col-md-9 thumbnail">
						<h5><b> ÖĞRENCİ BİLGİLERİ</b></h5><hr>
						
							<div class="col-md-4">
							
<!-- 								<label><b>TC KİMLİK NUMARASI :</b></label><span> 13060550224</span><br> -->
								<label><b>ADI :</b></label><span> ${ogrenci.ad }</span><br>
								<label><b>SOYADI :</b></label><span> ${ogrenci.soyad }</span><br>
								<label><b>NUMARASI :</b></label><span> ${ogrenci.no }</span><br>
								<label><b>SINIFI :</b></label><span> ${ogrenci.sinif }</span>
							
							</div>
							<div class="col-md-4">
									<label><b>FAKÜLTESİ :</b></label><span> ${ogrenci.fakulte.ad }</span><br> 
									<label><b>BÖLÜMÜ :</b></label><span> ${ogrenci.bolum.ad }</span><br>
									
									<span><b></b></span>			
							</div>
							<div class="col-md-offset-2 col-md-2">
								<img class="img-thumbnail" style="width: 120px; height: 150px;" src="imagecontrol?oid=${ogrenci.id }" alt="..."> 
							</div>
					
					</div>
				<div class="col-md-offset-1">
				<c:forEach items="${sinavlar }" var="sinav">
					<div class="col-md-5 thumbnail">
						<h5><b>&nbsp&nbsp&nbsp ${sinav.ders.ad }</b></h5><hr>
						<label><b>&nbsp&nbsp&nbsp FAKÜLTE :</b></label><span> ${sinav.fakulte.ad }</span><br>
							<div class="col-md-5">
								
								
								<label><b>SINIF :</b></label><span> ${sinav.derslik.derslikAd }</span><br>
								<label><b>SIRA NO :</b></label><span> ${sinav.sirano }</span><br> 
							
							
							</div>
							<div class="col-md-5">
<%-- 								<label><b>ADI :</b></label><span> ${sinav.ders.ad }</span><br> --%>
								<label><b>TARİH :</b></label><span> ${sinav.sinav_tarih }</span><br>
								<label><b>SAAT &nbsp:</b></label><span> ${sinav.sinav_saat }</span><br>  	
							</div>
					</div>
				</c:forEach>
				</div>
					<div class="col-md-offset-1 col-md-9 thumbnail">
						<h5><b> SINAV KURALLARI</b></h5><hr>
						
							<div class="col-md-12">
								<c:forEach items="${kurallar}" var="kural">
									<p><i class="fa fa-check"></i> ${kural.ad } </p>
									
								</c:forEach>
							</div>
					</div>
				
			</div>	
	</div>


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>