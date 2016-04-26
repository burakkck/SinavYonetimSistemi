<%@page import="com.sinavgirisbelgesi.dao.BolumDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Bolum"%>
<%@page import="com.sinavgirisbelgesi.dao.FakulteDAO"%>
<%@page import="com.sinavgirisbelgesi.dao.ArastirmaGorevlisiDAO"%>
<%@page import="com.sinavgirisbelgesi.model.ArastirmaGorevlisi"%>
<%@page import="com.sinavgirisbelgesi.dao.DerslikDAO"%>
<%@page import="com.sinavgirisbelgesi.dao.DersDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Ders"%>
<%@page import="com.sinavgirisbelgesi.model.Derslik"%>
<%@page import="com.sinavgirisbelgesi.model.Fakulte"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/admin/adminheader.jsp"/>

<%
	ArrayList<Ders> dersler = DersDAO.Dersler();
	request.setAttribute("dersler", dersler);
%>

<div class="col-lg-6">
	<div class="page-header" style="margin-top: -8px">
		<h1 style="color: #000000;">Sınav Ekle</h1>
	</div>
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<strong>Sınav Ekle </strong>
				</h3>
			</div>
			<div class="panel-body">
				<form action="sinavekle" id="sinavekle" method="post"
					class="form-horizontal">
					<div class="form-group">
						<label class="col-lg-2 control-label">Ders</label>
						<div class="col-lg-5">
							<select title="Ders Seçiniz"
								class="form-control ders-select" data-live-search="true"
								name="dersad">
								<option>Ders Seçiniz</option>
								<c:forEach items="${dersler}" var="dersler">
									<option value="${dersler.id}">${dersler.ad}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<%
						ArrayList<Derslik> derslikler = DerslikDAO.Derslikler();
						request.setAttribute("derslikler", derslikler);
					%>
					
					<div class="form-group">
						<label class="col-lg-2 control-label">Derslik</label>
						<div class="col-lg-5">
							<select title="Derslik Seçiniz"
								class="form-control derslik-select" id="derslik" data-live-search="true"
								name="derslik" multiple="multiple">
								<c:forEach items="${derslikler}" var="derslikler">
									<option value="${derslikler.id}" id="derslikk">${derslikler.derslikAd}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
<!-- 										<div class="form-group"> -->
<!-- 						<label class="col-lg-2 control-label">2.Derslik</label> -->
<!-- 						<div class="col-lg-5"> -->
<!-- 							<select title="Derslik Seçiniz" -->
<!-- 								class="form-control derslik-select" data-live-search="true" -->
<!-- 								name="derslik1"> -->
<!-- 								<option></option> -->
<%-- 								<c:forEach items="${derslikler}" var="derslikler"> --%>
<%-- 									<option value="${derslikler.id}">${derslikler.derslikAd}</option> --%>
<%-- 								</c:forEach> --%>
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 										<div class="form-group"> -->
<!-- 						<label class="col-lg-2 control-label">3.Derslik</label> -->
<!-- 						<div class="col-lg-5"> -->
<!-- 							<select title="Derslik Seçiniz" -->
<!-- 								class="form-control derslik-select" data-live-search="true" -->
<!-- 								name="derslik2" > -->
<!-- 								<option> </option> -->
<%-- 								<c:forEach items="${derslikler}" var="derslikler"> --%>
<%-- 									<option value="${derslikler.id}">${derslikler.derslikAd}</option> --%>
<%-- 								</c:forEach> --%>
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="form-group"> -->
<!-- 						<label class="col-lg-2 control-label">Sınav Tarihi</label> -->
<!-- 						<div class="col-lg-5"> -->
<!-- 							<input type="text" class="form-control" name="tarih" placeholder="GG/AA/YYYY"/> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="form-group"> -->
<!-- 						<label class="col-lg-2 control-label">Sınav Saati</label> -->
<!-- 						<div class="col-lg-5"> -->
<!-- 							<input type="text" class="form-control" name="saat" placeholder ="SS:DD"/> -->
<!-- 						</div> -->
<!-- 					</div> -->
			<div class="form-group" >
				<label for="tarih" class="col-lg-2 control-label">Tarih</label>
				<div class=' col-lg-5 date ' >
					<input type='text' class="form-control" name="date" id="datetimepicker" placeholder="Tarih Seçiniz"
						data-date-format="DD/MM/YYYY HH:mm"  />
				</div>
			</div>
					
					<%
						ArrayList<ArastirmaGorevlisi> arastirmagorevlileri = ArastirmaGorevlisiDAO.ArastirmaGorevlileri();
						request.setAttribute("arastirmagorevlileri", arastirmagorevlileri);
					%>
					<div class="form-group">
						<label class="col-lg-2 control-label">Araştırma Görevlisi</label>
						<div class="col-lg-5">
							<select title="Araştırma Görevlisi Seçiniz"
								class="form-control arastirmagorevlisi1-select" data-live-search="true"
								name="arastirmagorevlisi" id="arastirmagorevlisi" multiple="multiple">
								<c:forEach items="${arastirmagorevlileri}" var="arastirmagorevlileri">
									<option value="${arastirmagorevlileri.id}" id="ars">${arastirmagorevlileri.ad}  ${arastirmagorevlileri.soyad} , ${arastirmagorevlileri.getBolum().getAd()}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<%
						ArrayList<Fakulte> fakulteler = FakulteDAO.Fakulteler();
					request.setAttribute("fakulteler", fakulteler);
					%>
					
					<div class="form-group">
						<label class="col-lg-2 control-label">Fakülte</label>
						<div class="col-lg-5">
							<select title="Fakulte Seçiniz"
								class="form-control fakulte-select" data-live-search="true"
								name="fakulte" id="fakulte" >
								<c:forEach items="${fakulteler}" var="fakulteler">
									<option value="${fakulteler.id}" >${fakulteler.ad}</option>
								</c:forEach>
							</select>
						</div>
					</div>
										<%
						ArrayList<Bolum> bolumler = BolumDAO.Bolumler();
					request.setAttribute("bolumler", bolumler);
					%>
					
					<div class="form-group">
						<label class="col-lg-2 control-label">Bölüm</label>
						<div class="col-lg-5">
							<select title="Bölüm Seçiniz"
								class="form-control bolum-select" data-live-search="true"
								name="bolum" id="bolum" >
								<c:forEach items="${bolumler}" var="bolumler">
									<option value="${bolumler.id}" >${bolumler.ad}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-5 col-lg-offset-2">
							<input type="submit" class="form-control btn btn-success " id="buttonSinav"
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