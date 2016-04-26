<%@page import="com.sinavgirisbelgesi.model.Ders"%>
<%@page import="com.sinavgirisbelgesi.dao.SinavDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Sinav"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%	
	int derslikid = Integer.valueOf(request.getParameter("derslikid").toString());
	int sinavID = Integer.valueOf(request.getParameter("sinavID").toString());
	System.out.println(derslikid);
	System.out.println(sinavID);
	ArrayList<Sinav> sinav = SinavDAO.Listele(sinavID, derslikid);
	request.setAttribute("sinav", sinav);
%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Öğrenciler</title>
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


<!-- <div class="col-lg-offset-1 col-lg-10 col-lg-offset-1" > -->
<!-- 	<div class="page-header" style="margin-top:-8px" > -->
<!-- 	</div> -->
<!-- 	<div class="row" > -->
<!-- 		<div  class="col-lg-12"  > -->
<!-- 		<div class="thumbnail" style="background-color: #f2f2f2;" > -->
<!-- 			<table  class="footable table table-bordered toggle-circle" id="sinav"> -->
<!-- 			<thead> -->
<!-- 			<tr> -->
<!-- 				<th>Resim</th> -->
<!-- 				<th data-hide="phone">No</th> -->
<!-- 				<th data-hide="phone">Ad</th> -->
<!-- 				<th data-hide="phone">Soyad</th> -->
<!-- 				<th data-hide="phone">Derslik</th> -->
<!-- 				<th data-hide="phone">Sıra No</th> -->
<!-- 			</tr> -->
<!-- 			</thead> -->
<!-- 			<tbody> -->
<%-- 			<c:forEach items="${sinav }" var="sinav">  --%>
<!-- 			<tr> -->
<%-- 				<td><img src="image?oid=${sinav.getOgrenci().getId()}" alt="..." ></td> --%>
<%-- 				<td>${sinav.getOgrenci().getNo()}</td> --%>
<%-- 				<td>${sinav.getOgrenci().getAd()}</td> --%>
<%-- 				<td>${sinav.getOgrenci().getSoyad()}</td> --%>
<%-- 				<td>${sinav.getDerslik().getDerslikAd()}</td> --%>
<%-- 				<td>${sinav.sirano}</td> --%>
<!-- 			</tr> -->
<%-- 			</c:forEach> --%>
<!-- 				</tbody> -->
				
<!-- 			</table> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	</div> -->
<!-- </div> -->



</body>
</html>
<%-- <jsp:include page="/jsp/hoca/hocafooter.jsp" /> --%>

 