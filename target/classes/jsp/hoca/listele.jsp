<%@page import="com.sinavgirisbelgesi.model.Ders"%>
<%@page import="com.sinavgirisbelgesi.dao.SinavDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Sinav"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Öğrenci Listesi</title>
<meta name="generator" content="Bootply" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/footable.core.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/footable.metro.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-select.min.css" rel="stylesheet" type="text/css">
<%-- <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet"> --%>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<script type ="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script type ="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type ="text/javascript" src="${pageContext.request.contextPath}/js/footable.js"></script>
<script type ="text/javascript" src="${pageContext.request.contextPath}/js/footable.paginate.js"></script>
<script type ="text/javascript" src="${pageContext.request.contextPath}/js/custom_script_hoca.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-select.js"></script>

</head>
<body>
<!-- <div class="container"> -->
<h3 style="margin-left: 1.5%;"><div id="ogrliste" class="col-md-offset-1">Öğrenci Listesi
<button style="float: right; margin-right: 11%" class="btn btn-primary" id="button" type="button"><i class="fa fa-print"></i> Yazdır</button></div></h3>

<div class="col-lg-offset-1 col-lg-10 col-lg-offset-1" >
	<div class="page-header" style="margin-top:-8px" >
	</div>
	<div class="row" >
		<div  class="col-lg-12"  >
		<div class="thumbnail" style="background-color: #f2f2f2;" >
			<table  class="footable table table-bordered toggle-circle" id="sinav">
			<thead>
			<tr>
				<th>Resim</th>
				<th data-hide="phone">No</th>
				<th data-hide="phone">Ad</th>
				<th data-hide="phone">Soyad</th>
				<th data-hide="phone">Derslik</th>
				<th data-hide="phone">Sıra No
<%-- 				 <a href="listeyazdir?derslikid=${derslikid}&sinavID=${sinavID}" style="float: right;" class="btn btn-default" type="button"><i class="fa fa-print"></i> Yazdır</a> --%>
				 </th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${sinav }" var="sinav"> 
			<tr>
				<td><img src="image?oid=${sinav.getOgrenci().getId()}" alt="..." ></td>
				<td>${sinav.getOgrenci().getNo()}</td>
				<td>${sinav.getOgrenci().getAd()}</td>
				<td>${sinav.getOgrenci().getSoyad()}</td>
				<td>${sinav.getDerslik().getDerslikAd()}</td>
				<td>${sinav.sirano}</td>
			</tr>
			</c:forEach>
				</tbody>
				
<!-- 				<tfoot> -->
<!-- 					<tr> -->
<!-- 						<td colspan="10"> -->
<!-- 							<div class="pagination pagination-centered hide-if-no-paging"></div> -->
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 				</tfoot> -->
			</table>
		</div>
	</div>
	</div>
</div>
<hr>

<!-- </div> -->
<!-- <script type="text/javascript"> -->
<!--  	$('#sinav').footable(); -->
<!-- </script> -->
<script>
$("#button").click(function(){
	$("#button").hide();
	$("#ogrliste").hide();
	window.print();
	setTimeout(function(){
		$("#button").show();
		$("#ogrliste").show();
	}, 0);	  
});
</script>
</body>
</html>
<%-- <jsp:include page="/jsp/hoca/hocafooter.jsp" /> --%>

 