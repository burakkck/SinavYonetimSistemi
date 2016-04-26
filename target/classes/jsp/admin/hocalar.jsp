<%@page import="com.sinavgirisbelgesi.dao.HocaDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Hoca"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/admin/adminheader.jsp" />

	<% 	ArrayList<Hoca> hoca = HocaDAO.Hocalar();
		request.setAttribute("hoca", hoca);  
	%>

<div class="col-lg-9">
	<div class="page-header" style="margin-top:-8px">
	<h1 style="color:#000000;">Öğretim Elemanları</h1>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<table class="footable table table-bordered toggle-circle" id="hocalar">
			<thead>
			<tr>
<!-- 				<th>Id</th> -->
				<th>Ad</th>
				<th data-hide="phone">Soyad</th>
				<th data-hide="phone">Kullanıcı Ad</th>
				<td data-hide="phone"></td>
<!-- 				<th data-hide="phone">Bölüm</th> -->
<!-- 				<th data-hide="all">Fakülte</th> -->
				<th data-sort-ignore="true"></th>
				<th data-sort-ignore="true"></th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${hoca }" var="hoca"> 
			<tr>
<%-- 				<td>${hoca.id}</td> --%>
				<td>${hoca.ad}</td>
				<td>${hoca.soyad }</td>
				<td data-hide="phone">${hoca.kullaniciAd}</td>
				
<%-- 				<td>${hoca.getBolum().getAd()}</td> --%>
<%-- 				<td>${hoca.getBolum().getFakulte().getAd()}</td> --%>
				<td><a href="#" data-toggle="modal" 
				data-target="#EditHocaModal" class="btn btn-primary"
				data-hoca-no="${hoca.getId()}" data-hoca-ad="${hoca.getAd()}"
				data-hoca-soyad="${hoca.getSoyad()}">
				Değiştir <i class="glyphicon glyphicon-refresh" aria-hidden="true"></i></a></td>
				<td><a href="hocasifredegistir?hocaID=${hoca.getId()}" class="btn btn-primary">Şifre Sıfırla <i class="glyphicon glyphicon-refresh"></i></a></td>
				<td><a data-href="deletehoca?hocaID=${hoca.id}" data-toggle="modal" data-target="#deleteHocaModal" class="btn btn-danger">Sil<i class="glyphicon glyphicon-trash"></i></a></td>
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
	<c:if test="${not empty states }">
		<div class="alert alert-warning alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${states}</strong>
		</div>
	</c:if>
	<c:if test="${not empty status}">
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
<div class="modal fade" id="deleteHocaModal" tabindex="-1"
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
					Öğretim elemanını silmeyi onaylıyor musunuz?
				</p>
				<a href="#" class="btn btn-danger btn-lg" id="btnDeleteHoca">Onayla</a>
				
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$('#hocalar').footable();
</script>

	<jsp:include page="/jsp/admin/adminfooter.jsp" />

 <div class="modal fade" id="EditHocaModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Öğretim Elemanı Değiştir</h4>
			</div>

			<div class="modal-body">
				<!-- The form is placed inside the body of modal -->
				<form action="hocadegistir" id="hocadegistir" method="post"
					class="form-horizontal">
					<div class="form-group">
						<div class="col-lg-5">
							<input type="hidden" class="form-control" name="hocaID" id="hocaID" />
						</div>
					</div>
				<div class="form-group">
				<label class="col-lg-3 control-label"> Ad </label>
				<div class="col-lg-5">
					<input type="text" class="form-control" name="hocaAd" id="hocaAd"   />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">Soyad </label>
					<div class="col-lg-5">
						<input type="text" class="form-control" name="hocaSoyad" id="hocaSoyad"   />
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