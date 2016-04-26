<%@page import="com.sinavgirisbelgesi.dao.OgrenciDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Ogrenci"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/admin/adminheader.jsp" />

	<% 	
		ArrayList<Ogrenci> ogrenciler = OgrenciDAO.Ogrenciler();
		request.setAttribute("ogrenciler", ogrenciler);
	%>

<div class="col-lg-9">
	<div class="page-header" style="margin-top:-8px">
	<h1 style="color:#000000;">Öğrenciler</h1>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<table class="footable table table-bordered toggle-circle" id="ogrenciler">
			<thead>
			<tr>
<!-- 				<th>Id</th> -->
				<th>No</th>
				<th >Ad</th>
				<th >Soyad</th>
				<th data-hide="phone">E-Posta</th>
				<th data-hide="phone">Sınıf</th>
				<th data-hide="phone">Bölüm</th>
				<th data-hide="phone">Fakülte</th>
				<th data-hide="phone" data-sort-ignore="true"></th>
				<th data-hide="phone" data-sort-ignore="true"></th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${ogrenciler }" var="ogrenciler"> 
			<tr>
<%-- 				<td>${ogrenciler.getId()}</td> --%>
				<td>${ogrenciler.getNo()}</td>
				<td>${ogrenciler.getAd()}</td>
				<td>${ogrenciler.getSoyad()}</td>
				<td>${ogrenciler.email}</td>
				<td>${ogrenciler.getSinif()}</td>
				<td>${ogrenciler.getBolum().getAd()}</td>
				<td>${ogrenciler.getFakulte().getAd()}</td>
				<td><a href="ogrencidegistir?ogrenciID=${ogrenciler.getId()}"  class="btn btn-primary">Şifre Sıfırla <i class="glyphicon glyphicon-refresh"></i></a></td>
				<td><a data-href="deleteogrenci?ogrenciID=${ogrenciler.id}" data-toggle="modal" data-target="#deleteOgrenciModal" class="btn btn-danger">Sil<i class="glyphicon glyphicon-trash"></i></a></td>
			</tr>
			</c:forEach>
				</tbody>
				
				<tfoot>
					<tr>
						<td colspan="10">
							<div class="pagination pagination-centered hide-if-no-paging"></div>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
			<c:if test="${not empty status }">
		<div class="alert alert-warning alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${status}</strong>
		</div>
	</c:if>
	<c:if test="${not empty state}">
		<div class="alert alert-warning alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${state}</strong> 
		</div>
	</c:if>
</div>

<div class="modal fade" id="deleteOgrenciModal" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Uyarı !</h4>
			</div>

			<div class="modal-body">
				<!-- The form is placed inside the body of modal -->
				
				<p class="bg-danger">
					Ogrenci silmeyi onaylıyor musunuz?
				</p>
				<a href="#" class="btn btn-danger btn-lg" id="btnDeleteOgrenci">Onayla</a>
				
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$('#ogrenciler').footable();
</script>

<!-- 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> -->
<!--     <script src="http://code.jquery.com/jquery.js"></script> -->
    <script src="../../js/bootstrap.min.js"></script>
</body>
</html>