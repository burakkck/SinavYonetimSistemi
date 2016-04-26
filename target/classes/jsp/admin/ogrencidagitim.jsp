<%@page import="com.sinavgirisbelgesi.dao.SinavDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Sinav"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/admin/adminheader.jsp" />

	<% 	
		ArrayList<Sinav> sinavlar = SinavDAO.Sinavlar2();
		request.setAttribute("sinavlar", sinavlar);  
	%>

<div class="col-lg-9">
	<div class="page-header" style="margin-top:-8px">
	<h1 style="color:#000000;">Sinavlar</h1>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<table class="footable table table-bordered toggle-circle" id="dersler">
			<thead>
			<tr>
<!-- 				<th>Id</th> -->
				<th>Dersin Adı</th>
				<th>Sınav Tarihi</th>
<!-- 				<th>Sınav Saati</th> -->
				<th>Fakulte</th>
				<td data-sort-ignore="true"></td>
<!-- 				<td data-sort-ignore="true"></td> -->
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${sinavlar }" var="sinavlar"> 
			<tr>
<%-- 				<td >${dersler.id}</td> --%>
				<td>${sinavlar.ders.ad}</td>
				<td>${sinavlar.tarih}</td>
<%-- 				<td>${sinavlar.sinav_saat}</td> --%>
				<td>${sinavlar.fakulte.ad}</td>
				<td><a data-href="rastgeleata?sinavID=${sinavlar.id}" data-toggle="modal" data-target="#DagitModal" class="btn btn-primary">Dağıtıma Başla<i></i></a></td>
<!-- 				<td><a href="#"  class="btn btn-primary" id="buttondagit">Dağıtıma Başla<i></i></a></td> -->
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
<%-- 		<c:if test="${not empty status }"> --%>
<!-- 		<div class="alert alert-warning alert-dismissible" role="alert"> -->
<!-- 			<button type="button" class="close" data-dismiss="alert" -->
<!-- 				aria-label="Close"> -->
<!-- 				<span aria-hidden="true">&times;</span> -->
<!-- 			</button> -->
<%-- 			<strong>${status}</strong> --%>
<!-- 		</div> -->
<%-- 	</c:if> --%>
		<c:if test="${not empty state }">
		<div class="alert alert-warning alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${state}</strong>
		</div>
	</c:if>
</div>

<div class="modal fade" id="DagitModal" tabindex="-1"
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
					Rastgele dağıtımın başlamasını onaylıyor musunuz?
				</p>
				<a href="#" class="btn btn-danger btn-lg" id="btnDagit">Onayla</a>
				
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$('#dersler').footable();
</script>
<jsp:include page="/jsp/admin/adminfooter.jsp" />

