<%@page import="com.sinavgirisbelgesi.dao.DersDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Ders"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/admin/adminheader.jsp" />

	<% 	
		ArrayList<Ders> dersler = DersDAO.Dersler();
		request.setAttribute("dersler", dersler);  
	%>

<div class="col-lg-9">
	<div class="page-header" style="margin-top:-8px">
	<h1 style="color:#000000;">Dersler</h1>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<table class="footable table table-bordered toggle-circle" id="dersler">
			<thead>
			<tr>
<!-- 				<th>Id</th> -->
				<th>Dersin Adı</th>
				<td data-sort-ignore="true"></td>
				<td data-sort-ignore="true"></td>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${dersler }" var="dersler"> 
			<tr>
<%-- 				<td>${dersler.id}</td> --%>
				<td>${dersler.ad}</td>
				<td><a href="#" data-toggle="modal" 
				data-target="#EditDersModal" class="btn btn-primary"
				data-ders-no="${dersler.getId()}" data-ders-ad="${dersler.getAd()}">
				Değiştir <i class="glyphicon glyphicon-refresh" aria-hidden="true"></i></a></td>
				<td><a data-href="deleteders?dersID=${dersler.id}" data-toggle="modal" data-target="#deleteDersModal" class="btn btn-danger">Sil<i class="glyphicon glyphicon-trash"></i></a></td>
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

<div class="modal fade" id="deleteDersModal" tabindex="-1"
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
					Dersi silmeyi onaylıyor musunuz?
				</p>
				<a href="#" class="btn btn-danger btn-lg" id="btnDeleteDers">Onayla</a>
				
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$('#dersler').footable();
</script>
<jsp:include page="/jsp/admin/adminfooter.jsp" />

 <div class="modal fade" id="EditDersModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Derslik Değiştir</h4>
			</div>

			<div class="modal-body">
				<!-- The form is placed inside the body of modal -->
				<form action="dersdegistir" id="dersdegistir" method="post"
					class="form-horizontal">
					<div class="form-group">
						<div class="col-lg-5">
							<input type="hidden" class="form-control" name="dersID" id="dersID" />
						</div>
					</div>
					<div class="form-group">
				<label class="col-lg-3 control-label">Ders Ad</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" name="dersad" id="dersad"   />
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-5 col-lg-offset-3">
				<input type="submit" class="form-control btn btn-success" name="degistir" value="DEĞİŞTİR">
				</div>
			</div>
				</form>
			</div>
		</div>
	</div>
</div>