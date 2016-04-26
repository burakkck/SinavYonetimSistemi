<%@page import="com.sinavgirisbelgesi.model.Bolum"%>
<%@page import="com.sinavgirisbelgesi.model.Ogrenci"%>
<%@page import="com.sinavgirisbelgesi.dao.DersDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Ders"%>
<%@page import="com.sinavgirisbelgesi.dao.OgrenciDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/ogrenci/ogrenciheader.jsp" />
<%
	Ogrenci ogrenci =  (Ogrenci)session.getAttribute("ogrenci"); 
	Bolum bolum = OgrenciDAO.getOgrenciBolum(ogrenci.getId());
	ArrayList<Ders> dersler = DersDAO.SecilmemisBolumDersler(bolum.getId(), ogrenci.getId());
	request.setAttribute("dersler", dersler);
	ArrayList<Ders> secilenDersler = DersDAO.SecilmisDersler(ogrenci);
	request.setAttribute("secilendersler", secilenDersler);
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
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
<!-- <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"> -->
<!-- <link href='http://fonts.googleapis.com/css?family=IM+Fell+DW+Pica+SC' rel='stylesheet' type='text/css'> -->
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/footable.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/footable.paginate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom_script_ogrenci.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom_script_admin.js" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-select.js"></script>
</head>
<body>
<%-- <%if(request.getSession().getAttribute("ogrenci") != null){ %> --%>
	<br>
	<br>
	<br>

	<div class="container">
		<div class="row">
			<div class="col-md-6">

				<div class="panel-heading" style="background-color: #3498db;">
					<strong style="color: white">Başvuru Yap</strong> 
				</div>

				<div class="panel-body">
					<!-- Ders İptal -->
					
						<table class="footable table table-condensed toggle-circle" id="dersler">
							<thead>
								<tr>
									<td>Ders Adı</td>
									<td></td>
									<td>Seç</td>
									
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${secilendersler }" var="ders">
									<tr>
										<td>${ders.getAd()}</td>
										<form action="ogrencidersiptal" method="post" accept-charset="UTF-8">
											<td><input type="hidden" name="ders" value="${ders.getId()}"></td>
											<td><input type="submit" value="iptal" class="btn btn-danger"></td>
										</form>
									</tr>
								</c:forEach>
<!-- 							</tbody> -->
<!-- 								<tfoot class="hide-if-no-paging"> -->
<!-- 									<tr> -->
<!-- 										<td colspan="5"> -->
<!-- 											<div class="pagination pagination-centered"></div> -->
<!-- 										</td> -->
<!-- 									</tr> -->
<!-- 								</tfoot> -->
<!-- 						</table> -->
					

					<!-- Ders kayıt -->
					<form action="ogrenciderskayit" method="post" id="basvurform" accept-charset="UTF-8">
<!-- 						<table class="footable table table-condensed toggle-circle" id="ders"> -->
<!-- 							<thead> -->
<!-- 								<tr> -->
<!-- 									<td>Ders Adı</td> -->
<!-- 									<td>Seç</td> -->
<!-- 								</tr> -->
<!-- 							</thead> -->
							<tbody>
								<c:forEach items="${dersler }" var="ders">
									<tr>
										<td>${ders.getAd()}</td>
										<td></td>
										<td><input type="checkbox" name="ders" id="basvur" value="${ders.getId()}"></td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot class="hide-if-no-paging">
								<tr>
									<td colspan="5">
										<div class="pagination pagination-centered"></div>
									</td>
								</tr>
							</tfoot>
						</table>
						
						
							<div class="col-md-6">
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
							<input style="float: right" type="submit" class="btn btn-primary" id="basvur" value="başvur">
						
						
							
				</div>
				</form>

			</div>
			<div class="col-md-6">
				<%@include file="duyuru.jsp"%>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
	<script type="text/javascript">
		$('#dersler').footable();
		$('#ders').footable();
	</script>
	<%
// 	}else{
// 		response.sendRedirect("index");
// 	}
		%>
	
</body>
</html>