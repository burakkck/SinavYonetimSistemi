<%@page import="com.sinavgirisbelgesi.dao.OgrenciDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Ogrenci"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html >
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">	
		<title>Admin Paneli</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="../../css/bootstrap.min.css" rel="stylesheet">
		
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="../../css/styles.css" rel="stylesheet">
		<script type="text/javascript" src="../../js/bootstrapp.min.js"></script>
	</head>
	<body>
<!-- Header -->
<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-toggle"></span>
      </button>
      <a class="navbar-brand" href="admin.jsp">Anasayfa</a> 
    </div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        
        <li class="dropdown">
          <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#">
            <i class="glyphicon glyphicon-user"></i> Admin <span class="caret"></span></a>
          <ul id="g-account-menu" class="dropdown-menu" role="menu">
            <li><a href="#">My Profile</a></li>
            <li><a href="adminlogout"><i class="glyphicon glyphicon-lock"></i> Çıkış</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div><!-- /container -->
</div>
<!-- /Header -->

<!-- Main -->
<div class="container">
  
  <!-- upper section -->
  <div class="row">
	<div class="col-sm-3">
      <!-- left -->
      <h3><i class="glyphicon glyphicon-briefcase"></i> İşlemler</h3>
      <hr>
      
      <ul class="nav nav-stacked">
        <li><a href="ogrenciler.jsp"><i class="glyphicon glyphicon-flash"></i> Öğrenciler</a></li>
        <li><a href="hocalar.jsp"><i class="glyphicon glyphicon-link"></i> Öğretim Elemanları</a></li>
        <li><a href="#"><i class="glyphicon glyphicon-list-alt"></i> Dersler</a></li>
        <li><a href="#"><i class="glyphicon glyphicon-user"></i> Sınavlar</a></li> 
<!--         <li><a href="javascript:;"><i class="glyphicon glyphicon-briefcase"></i> Tools</a></li> -->
<!--         <li><a href="javascript:;"><i class="glyphicon glyphicon-time"></i> Real-time</a></li> -->
<!--         <li><a href="javascript:;"><i class="glyphicon glyphicon-plus"></i> Advanced..</a></li> -->
      </ul> 
      
      <hr>
      
  	</div>
</div>
  </div>	
  	

	<!-- script references -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="../../js/bootstrap.min.js"></script>
	</body>
</html>