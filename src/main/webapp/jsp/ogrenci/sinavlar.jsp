<%@page import="com.sinavgirisbelgesi.dao.OgrenciDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Sinav"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sinavgirisbelgesi.model.Ogrenci"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/ogrenci/ogrenciheader.jsp" />
<%
	Ogrenci ogrenci = (Ogrenci)session.getAttribute("ogrenci");
	int ogrenciID = ogrenci.getId(); 
	ArrayList<Sinav> sinavlar = OgrenciDAO.OgrencininGirecegiSinavlar(ogrenciID);
	request.setAttribute("sinavlar", sinavlar);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Anasayfa</title>
<link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/bootstrap-select.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/footable.core.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/footable.metro.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">
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
</head>
<body style="background-color: #F2F2F2">
<br><br><br>
	<div class="container">
		<div class="row">
			
			<table class="footable table table-condensed table table-striped">
				<thead>
					<tr>
						<th><h4>Ders Adı</h4></th>
						<th><center><h4 sty class="col-sm-offset-2">Sınav Tarihi</h4></center></th>
<!-- 						<th><h4 class="col-sm-offset-5">Sınav Saati</h4></th> -->
						<th><h4 class="col-sm-offset-5" style="float: right;">Sınav Giriş Belgesi</h4></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${sinavlar }" var="sinav">
						
						<tr>
							<td>${sinav.ders.ad }</td>
							<td><center><span style="margin-left: 40px;" class="col-sm-offset-2">${sinav.tarih }</span></center></td>
<%-- 							<td><span style="margin-left: 190px;" class="col-sm-offset-5">${sinav.sinav_saat }</span></td> --%>
							
							<td>
								<form action="sinavbilgileri" style="height: 20px;" method="get" >
									<div class="col-sm-offset-6">
										<input type="hidden" name="sinavID" value="${sinav.id}">
<%-- 										<a href="sinavbilgileri?sinavID=${sinav.id}" class="btn btn-danger">Görüntüle<i class="fa fa-file-pdf-o"></i></a> --%>
										<button style="float: right;" type="submit" class="btn btn-danger">
										<i class="fa fa-file-text"></i> Görüntüle</button>
										
									</div>
								</form>
							</td>
						</tr>
						
					</c:forEach>	
						<tr>
							<td>Tüm Dersler</td>
							
							<td><center></center></td>
<%-- 							<td><input type="button" class="btn btn-danger" value='Görüntüle <i class="fa fa-file-pdf-o"></i>' style="float: right; margin-right: 10px;"></td> --%>
							<td> <a href="tablobelge" class="btn btn-danger" style="float: right;"><i class="fa fa-list-alt"></i> Görüntüle</a> </td>
						</tr>
				</tbody>
			</table>
		</div>
	</div>
	<%@include file = "footer.jsp" %>
</body>
</html>