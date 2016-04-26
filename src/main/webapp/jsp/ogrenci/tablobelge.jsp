<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
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
<br>
						<div id="tabloid" style="margin-left: 150px;">
						<table border='1' bordercolor="#ddd">
							<tr>
								<th height="180" colspan="5">
									<span style="margin-left: 10px; "> Öğrenci Bilgileri </span>
<!-- 									<a href="belgeyazdir" style="margin-left: 30%;" class="btn btn-default btn-lg" type="button"><i class="fa fa-print"></i> Yazdır</a> -->
									<button style="margin-left: 30%;" class="btn btn-default btn-lg" id="button" type="button"><i class="fa fa-print"></i> Yazdır</button>
									<img  style="width: 120px; height: 150px; float: right; margin-right: 10px;" src="imagecontrol?oid=<%=ogr_id %>" alt="..."/> 
								</th> 
							</tr>
							
							<tr>
								<td height='40' style="width: 500px;"><label><b>&nbsp ADI :</b></label><span> <%=ogr.getAd() %> </span></td>
								<td style="width: 500px;" ><label><b>&nbsp FAKÜLTESİ :</b></label><span> <%=ogr.getFakulte().getAd() %></span></td>
							</tr>
							<tr>
								<td height="40" ><label><b>&nbsp SOYADI :</b></label><span> <%=ogr.getSoyad() %></span></td>
								<td style="width: 500px;" ><label><b>&nbsp BÖLÜMÜ :</b></label><span> <%=ogr.getBolum().getAd() %></span></td>
							</tr>
							<tr>
								<td height="40" ><label><b>&nbsp NUMARASI :</b></label><span> <%=ogr.getNo() %></span></td>
								<td style="width: 500px;" ><label><b>&nbsp SINIFI :</b></label><span> <%=ogr.getSinif() %></span></td>
							</tr>
							<tr></tr>
							
					
							</table>
					<br/>
						<table border="1" bordercolor="#ddd">
							<tr><th height="50" colspan="5"><span style="margin-left: 10px;"> Sınav Yeri Bilgileri </span></th> </tr>
							<tr>
								<th height="40" style="width: 200px;">&nbsp Ders Ad</th>
								<th style="width: 200px;">&nbsp Fakülte</th>
								<th style="width: 200px;">&nbsp Sınıf</th>
								<th style="width: 200px;">&nbsp Tarih ve Saat</th>
								<th style="width: 200px;">&nbsp Sıra No</th>
							</tr>
								<% for(Sinav sinav: sinavlar){ %>
								
								<tr>
									<td height="40">&nbsp <%=sinav.getDers().getAd() %></td>
									<td>&nbsp <%=sinav.getFakulte().getAd() %></td>
									<td>&nbsp <%=sinav.getDerslik().getDerslikAd() %></td>
									<td>&nbsp <%=sinav.getTarih() %></td>
									<td>&nbsp <%=sinav.getSirano() %></td>
								</tr>
								<%} %>
								
						</table>
						<br/>
						
						<table style="width: 1000px;" border="1" bordercolor="#ddd">
						<tr><th height="40" colspan="5"><span style="margin-left: 10px;">Sınav Kuralları</span></th></tr>						
								<%for(Kurallar kural : kurallar){ %>
									<tr><td height="40px;">&nbsp <%=kural.getAd() %></td></tr>
								<%} %>
						</table>
		
	</div>
   
    <br>
<script>
$("#button").click(function(){
	$("#button").hide();
	$("#tabloid").css("margin-left","10px")
	window.print();
	setTimeout(function(){
		$("#button").show();
		$("#tabloid").css("margin-left","150px")
	}, 0);	  
});
</script>
</body>
</html>