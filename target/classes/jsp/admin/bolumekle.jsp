<%@page import="com.sinavgirisbelgesi.dao.FakulteDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Fakulte"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/admin/adminheader.jsp"/>

<%
	ArrayList<Fakulte> fakulteler = FakulteDAO.Fakulteler();
	request.setAttribute("fakulteler", fakulteler);
%>

<div class="col-lg-6">
	<div class="page-header" style="margin-top: -8px">
		<h1 style="color: #000000;">Bölüm Ekle</h1>
	</div>
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<strong>Bölüm Ekle </strong>
				</h3>
			</div>
			<div class="panel-body">
				<form action="bolumekle" id="bolumekle" method="post"
					class="form-horizontal">
					<div class="form-group">
						<label class="col-lg-2 control-label">Bölüm Ad</label>
						<div class="col-lg-5">
							<input type="text" class="form-control" name="name" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-2 control-label">Fakülte</label>
						<div class="col-lg-5">
							<select title="Fakülte Seçiniz"
								class="form-control fakulte-select" data-live-search="true"
								name="fakulte">
								<c:forEach items="${fakulteler}" var="fakulteler">
									<option value="${fakulteler.id}">${fakulteler.ad}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-5 col-lg-offset-2">
							<input type="submit" class="form-control btn btn-success"
								name="ekle" value="EKLE">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
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
<jsp:include page="/jsp/admin/adminfooter.jsp"/>

