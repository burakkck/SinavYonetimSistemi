<%@page import="com.sinavgirisbelgesi.dao.DerslikDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Derslik"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/admin/adminheader.jsp" />

	<% 
		ArrayList<Derslik> derslikler = DerslikDAO.Derslikler();
		request.setAttribute("derslikler", derslikler);  
	%>

<div class="col-lg-9">
	<div class="page-header" style="margin-top:-8px">
	<h1 style="color:#000000;">Derslikler</h1>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<table class="footable table table-bordered toggle-circle" id="derslikler">
			<thead>
			<tr>
<!-- 				<th>Id</th> -->
				<th>Derslik Adı</th>
				<th>Sıra Sayısı</th>
				<th data-hide="phone">Fakülte</th>
				<th data-hide="phone" data-sort-ignore="true"></th>
				<th data-hide="phone" data-sort-ignore="true"></th>

			</tr>
			</thead>
			<tbody>
			<c:forEach items="${derslikler }" var="derslikler"> 
			<tr>
<%-- 				<td>${derslikler.getId()}</td> --%>
				<td>${derslikler.getDerslikAd()}</td>
				<td>${derslikler.getSiraSayisi()}</td>
				<td>${derslikler.getFakulte().getAd()}</td>
				<td><a href="#" data-toggle="modal" 
				data-target="#EditDerslikModal" class="btn btn-primary"
				data-derslik-no="${derslikler.getId()}" data-derslik-ad="${derslikler.getDerslikAd()}"
				data-sirasayisi="${derslikler.getSiraSayisi()}">
				Değiştir <i class="glyphicon glyphicon-refresh" aria-hidden="true"></i></a></td>
				<td><a data-href="deletederslik?derslikID=${derslikler.id}" data-toggle="modal" data-target="#deleteDerslikModal" class="btn btn-danger">Sil<i class="glyphicon glyphicon-trash"></i></a></td>
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
	</c:if>
</div>

<div class="modal fade" id="deleteDerslikModal" tabindex="-1"
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
					Derslik silmeyi onaylıyor musunuz?
				</p>
				<a href="#" class="btn btn-danger btn-lg" id="btnDeleteDerslik">Onayla</a>
				
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$('#derslikler').footable();
</script>
<jsp:include page="/jsp/admin/adminfooter.jsp" />

 <div class="modal fade" id="EditDerslikModal" tabindex="-1" role="dialog"
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
				<form action="derslikdegistir" id="derslikdegistir" method="post"
					class="form-horizontal">
					<div class="form-group">
						<div class="col-lg-5">
							<input type="hidden" class="form-control" name="derslikID" id="derslikid" />
						</div>
					</div>
					<div class="form-group">
				<label class="col-lg-3 control-label">Derslik Ad</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" name="derslikad" id="derslikad"   />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">Sıra Sayısı</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" name="sirasayisi" id="sirasayisi" />
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

</div>