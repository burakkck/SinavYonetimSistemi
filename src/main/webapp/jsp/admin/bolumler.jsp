<%@page import="com.sinavgirisbelgesi.dao.BolumDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Bolum"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/admin/adminheader.jsp" />

	<% 
		ArrayList<Bolum> bolumler = BolumDAO.Bolumler();
		request.setAttribute("bolumler", bolumler);  
	%>

<div class="col-lg-9">
	<div class="page-header" style="margin-top:-8px">
	<h1 style="color:#000000;">Bölümler</h1>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<table class="footable table table-bordered toggle-circle" id="bolumler">
			<thead>
			<tr>
<!-- 				<th>Id</th> -->
				<th>Bölüm Adı</th>
				<th data-hide="phone">Fakülte Adı</th>
				<th data-sort-ignore="true"></th>
				<th data-sort-ignore="true"></th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${bolumler }" var="bolumler"> 
			<tr>
<%-- 				<td>${bolumler.id}</td> --%>
				<td>${bolumler.ad}</td>
				<td>${bolumler.fakulte.ad }</td>
				<td><a href="#" data-toggle="modal" 
				data-target="#EditBolumModal" class="btn btn-primary"
				data-bolum-no="${bolumler.getId()}" data-bolum-ad="${bolumler.getAd()}">
				Değiştir <i class="glyphicon glyphicon-refresh" aria-hidden="true"></i></a></td>
				<td><a data-href="deletebolum?bolumID=${bolumler.id}" data-toggle="modal", data-target="#deleteBolumModal" class="btn btn-danger">Sil<i class="glyphicon glyphicon-trash"></i></a></td>
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

<div class="modal fade" id="deleteBolumModal" tabindex="-1"
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
					Bölümü silmeyi onaylıyor musunuz?
				</p>
				<a href="#" class="btn btn-danger btn-lg" id="btnDeleteBolum">Onayla</a>
				
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$('#bolumler').footable();
</script>
<jsp:include page="/jsp/admin/adminfooter.jsp" />

 <div class="modal fade" id="EditBolumModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Bolum Değiştir</h4>
			</div>

			<div class="modal-body">
				<!-- The form is placed inside the body of modal -->
				<form action="bolumdegistir" id="bolumdegistir" method="post"
					class="form-horizontal">
					<div class="form-group">
						<div class="col-lg-5">
							<input type="hidden" class="form-control" name="bolumID" id="bolumID" />
						</div>
					</div>
					<div class="form-group">
				<label class="col-lg-3 control-label">Ders Ad</label>
				<div class="col-lg-6">
					<input type="text" class="form-control" name="bolumad" id="bolumad"   />
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