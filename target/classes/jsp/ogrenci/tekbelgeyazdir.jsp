<%@page import="com.sinavgirisbelgesi.dao.SinavDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Sinav"%>
<%@page import="com.sinavgirisbelgesi.model.Ogrenci"%>
<%@page import="com.sinavgirisbelgesi.dao.KurallarDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Kurallar"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	ArrayList<Kurallar> kurallar = KurallarDAO.Kurallar();
	request.setAttribute("kurallar", kurallar);
	Ogrenci ogrenci = (Ogrenci)session.getAttribute("ogrenci");
	int ogrenciID = ogrenci.getId();
	int sinavID = Integer.valueOf(request.getParameter("sinavID"));
	Sinav sinav = SinavDAO.GirisBelgesi(ogrenciID, sinavID);
	request.setAttribute("sinav", sinav);
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
<style type="text/css">
	body 
/* 	{ */
/* 		background-image: url(${pageContext.request.contextPath}/image/logo.png); */
/* 		background-repeat: no-repeat; */
/*  		background-position: 2%; */
/*   		opacity : 0.95;    */
/* 	} */
</style>
</head>
<body onload="window.print()">
	<br>
	<div>	
					
					<table border="1" bordercolor="#ddd">
						<tr>
							<th height="180" colspan="5" >
								<span  style="margin-left: 10px; ">ÖĞRENCİ BİLGİLERİ</span>
								<img class="img-thumbnail" style="width: 120px; height: 150px; float: right; margin-right: 10px;" src="imagecontrol?oid=${ogrenci.id }" alt="..."/> 
							</th>
						</tr>

						<tr>
							<td height="40" width="500"><label><b>&nbsp ADI :</b></label><span> ${ogrenci.ad }</span></td>
							<td height="40" width="500"><label><b>&nbsp FAKÜLTESİ :</b></label><span> ${ogrenci.fakulte.ad }</span></td>
						</tr>
						<tr>
							<td height="40" width="500"><label><b>&nbsp SOYADI :</b></label><span> ${ogrenci.soyad }</span></td>
							<td height="40" width="500"><label><b>&nbsp BÖLÜMÜ :</b></label><span> ${ogrenci.bolum.ad }</span></td>
						</tr>
						<tr>
							<td height="40" width="500"><label><b>&nbsp NUMARASI :</b></label><span> ${ogrenci.no }</span></td>
							<td height="40" width="500"><label><b>&nbsp SINIFI :</b></label><span> ${ogrenci.sinif }</span></td>
						</tr>		
					</table>
						<br>
					<table border="1" bordercolor="#ddd">
						<tr><th height="40" colspan="5"><h5><b>&nbsp SINAV YERİ BİLGİLERİ</b></h5></th></tr>
						
						<tr>
							<td height="40" width="500"><label><b>&nbsp FAKÜLTE :</b></label><span> ${sinav.fakulte.ad }</span></td>
							<td height="40" width="500"><label><b>&nbsp SINAVIN ADI :</b></label><span> ${sinav.ders.ad }</span></td>
						</tr>
						<tr>
							<td height="40" width="500"><label><b>&nbsp SINIF :</b></label><span> ${sinav.derslik.derslikAd }</span></td>
							<td height="40" width="500"><label><b>&nbsp SINAV TARİHİ VE SAATİ :</b></label><span> ${sinav.tarih }</span></td>
						</tr>
						<tr><td height="40" width="500" colspan="5"><label><b>&nbsp SIRA NO :</b></label><span> ${sinav.sirano }</span></td></tr>
												
					</table>
						<br>
					<table border="1" bordercolor="#ddd">
						<tr><th height="40" width="1000" colspan="5"><h5><b>&nbsp SINAV KURALLARI</b></h5></th></tr>
						
							
								<c:forEach items="${kurallar}" var="kural">
								<tr>
									<td height="40" colspan="5">
										&nbsp<i class="fa fa-check"></i> ${kural.ad }
									</td>
								</tr>
								</c:forEach>
								
					</table>
					<br>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>