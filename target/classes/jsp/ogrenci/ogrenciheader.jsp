<%@page import="com.sinavgirisbelgesi.model.Ogrenci"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%Ogrenci ogrenci = (Ogrenci)session.getAttribute("ogrenci"); %>
<div class="navbar navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a href="anasayfa" class="navbar-brand"><img style="height: 30px; width: 35px; position: 15" src="${pageContext.request.contextPath}/image/logo.png"> OMÜ SINAV SİSTEMİ</a>
		</div>
		
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
			
			</ul>
			<ul class="nav navbar-nav navbar-right">
<!-- 				<li><a href="rndv.jsp"><i class="fa fa-home"></i> Anasayfa</a></li>		 -->
				<li><a href="sinavlar"><i class="fa fa-history"></i> Sınavlar</a></li>
					<%
					if(session.getAttribute("ogrenci") != null){
					%>
						<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"> <i class="fa fa-user"></i> ${ogrenci.ad } ${ogrenci.soyad } <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#" data-toggle="modal" data-target="#AyarlarModal"><i class="glyphicon glyphicon-cog"></i> Ayarlar</a></li>
            <li class="divider"></li>
            <li><a href="ogrencilogout"><i class="glyphicon glyphicon-log-out"></i> Çıkış Yap</a></li>
          </ul>
        </li>
						<%
					}
					
					%>
				
				
			</ul>
		</div>
	</div>
</div>