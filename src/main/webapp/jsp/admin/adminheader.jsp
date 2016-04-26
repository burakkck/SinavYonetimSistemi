<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Admin Paneli</title>
<meta name="generator" content="Bootply" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/footable.core.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/footable.metro.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-select.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/multiple-select.css" rel="stylesheet" type="text/css">
<%-- <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet"> --%>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<%-- <link href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css" rel="stylesheet"> --%>
<link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.css" rel="stylesheet">

<script type ="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script type ="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type ="text/javascript" src="${pageContext.request.contextPath}/js/footable.js"></script>
<script type ="text/javascript" src="${pageContext.request.contextPath}/js/footable.paginate.js"></script>
<script type ="text/javascript" src="${pageContext.request.contextPath}/js/custom_script_admin.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-select.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.multiselect.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.multiselect.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.multiple.select.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/footable.sort.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/moment-with-locales.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.datetimepicker.js"></script> --%>
</head>
<body>
	<!-- Header -->
	<div id="top-nav" class="navbar  navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-toggle"></span>
				</button>
				<a href="./ogrenciler" class="navbar-brand"><img style="height: 30px; width: 35px; position: 15" src="${pageContext.request.contextPath}/image/logo.png"> OMÜ SINAV SİSTEMİ</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
				<li><a href="ogrenci-dagitim"><i class="fa fa-history"></i> Sınavlar</a></li>
					<li class="dropdown"><a class="dropdown-toggle" role="button"
						data-toggle="dropdown" href="#"> <i
							class="glyphicon glyphicon-user"></i> ${admin.kullaniciAd} <span class="caret"></span></a>
						<ul id="g-account-menu" class="dropdown-menu" role="menu">
							<li><a href="#" data-toggle="modal"
										data-target="#AyarlarModal"><span
											class="glyphicon glyphicon-cog" aria-hidden="true"></span>
											Ayarlar</a></li>
							<li><a href="adminlogout"><i class="glyphicon glyphicon-log-out"></i> Çıkış</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /Header -->

	<!-- Main -->
	<div class="container">
		<!-- upper section -->
		<div class="row">
			<div class="col-sm-3">
				<!-- left -->
				<h3 style="color:#000000;">
					<i class="glyphicon glyphicon-briefcase"></i> İşlemler
				</h3>
<!-- 				<hr> -->
<!-- 				<ul class="nav nav-stacked"> -->
<!-- 					<li><a href="./ogrenciler"><i class="glyphicon glyphicon-user"></i>Öğrenciler</a></li> -->
<!-- 					<li><a href="./hocalar"><i class="glyphicon glyphicon-user"></i> Öğretim Elemanları</a></li> -->
<!-- 					<li><a href="./dersler"><i class="glyphicon glyphicon-list-alt"></i> Dersler</a></li> -->
<!-- 					<li><a href="./derslikler"><i class="glyphicon glyphicon-list-alt"></i> Derslikler</a></li> -->
<!-- 					<li><a href="./sinavlar"><i class="glyphicon glyphicon-list-alt"></i> Sınavlar</a></li> -->
<!-- 					<li><a href="./arastirmagorevlileri"><i class="glyphicon glyphicon-user"></i> Araştırma Görevlileri</a></li> -->
<!-- 					<li><a href="./bolumler"><i class="glyphicon glyphicon-list-alt"></i> Bölümler</a></li> -->
<!-- 					<li><a href="./fakulteler"><i class="glyphicon glyphicon-list-alt"></i> Fakülteler</a></li> -->
<!-- 					<li><a href="./duyurular"><i class="glyphicon glyphicon-list-alt"></i> Duyurular</a></li> -->
<!-- 					<li><a href="./kurallar"><i class="glyphicon glyphicon-list-alt"></i> Kurallar</a></li> -->
<!-- 					<li><a href="./hoca-ekle"><i class="glyphicon glyphicon-user"></i> Öğretim Elemanı Ekle</a></li> -->
<!-- 					<li><a href="./arastirmagorevlisi-ekle"><i class="glyphicon glyphicon-user"></i> Araştırma Görevlisi Ekle</a></li> -->
<!-- 					<li><a href="./ders-ekle"><i class="glyphicon glyphicon-list-alt"></i> Ders Ekle</a></li> -->
<!-- 					<li><a href="./derslik-ekle"><i class="glyphicon glyphicon-list-alt"></i> Derslik Ekle</a></li> -->
<!-- 					<li><a href="./sinav-ekle"><i class="glyphicon glyphicon-list-alt"></i> Sınav Ekle</a></li> -->
<!-- 					<li><a href="./bolum-ekle"><i class="glyphicon glyphicon-list-alt"></i> Bölüm Ekle</a></li> -->
<!-- 					<li><a href="./fakulte-ekle"><i class="glyphicon glyphicon-list-alt"></i> Fakülte Ekle</a></li> -->
<!-- 					<li><a href="./duyuru-ekle"><i class="glyphicon glyphicon-list-alt"></i> Duyuru Ekle</a></li> -->
<!-- 					<li><a href="./kural-ekle"><i class="glyphicon glyphicon-list-alt"></i> Kural Ekle</a></li> -->
<!-- 				</ul> -->
<!-- 				<hr> -->
<!-- <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true"> -->
<!--   <div class="panel panel-default"> -->
<!--     <div class="panel-heading" role="tab" id="heading"> -->
<!--       <h4 class="panel-title"> -->
<!--         <a data-toggle="collapse" data-parent="#accordion" href="#collapse" aria-expanded="true" aria-controls="collapseOne"> -->
<!--           Kurallar -->
<!--         </a> -->
<!--       </h4> -->
<!--     </div> -->
<!--     <div id="collapse" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne"> -->
<!--       <div class="panel-body"> -->
<!--       		<li><a href="./kurallar"><i ></i> Kurallar</a></li> -->
<!--       		<li><a href="./kural-ekle"><i></i> Kural Ekle</a></li>  -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- 			</div> -->
			

			
			<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
			
			<div class="panel panel-default">
    <div class="panel-heading" role="tab" id="heading5">
      <h4 class="panel-title">
        <a class="collapsed4" data-toggle="collapse" data-parent="#accordion" href="#collapse5" aria-expanded="false" aria-controls="collapse5">
          Öğrenci
        </a>
      </h4>
    </div>
    <div id="collapse5" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading5">
      <div class="panel-body">
      <li><a href="./ogrenciler"><i class="glyphicon glyphicon-user" ></i> Öğrenciler</a></li>
      <li><a href="./ogrenci-ekle"><i class="glyphicon glyphicon-plus" ></i> Öğrenci Ekle</a></li>
      </div>
    </div>
  </div>
  
			  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingThree">
      <h4 class="panel-title">
        <a class="collapsed3" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          Öğretim Elemanı
        </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
      <div class="panel-body">
      <li><a href="./hocalar"><i class="glyphicon glyphicon-user" ></i> Öğretim Elemanları</a></li>
      <li><a href="./hoca-ekle"><i class="glyphicon glyphicon-plus" ></i> Öğretim Elemanı Ekle</a></li>
      </div>
    </div>
  </div>
  
        <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="heading7">
      <h4 class="panel-title">
        <a class="collapsed7" data-toggle="collapse" data-parent="#accordion" href="#collapse7" aria-expanded="false" aria-controls="collapse7">
          Araştırma Görevlisi
        </a>
      </h4>
    </div>
    <div id="collapse7" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading7">
      <div class="panel-body">
      <li><a href="./arastirmagorevlileri"><i class="glyphicon glyphicon-user" ></i> Araştırma Görevlileri</a></li>
      <li><a href="./arastirmagorevlisi-ekle"><i class="glyphicon glyphicon-plus" ></i> Araştırma Görevlisi Ekle</a></li>
      </div>
    </div>
  </div>
  
          <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="heading7">
      <h4 class="panel-title">
        <a class="collapsed8" data-toggle="collapse" data-parent="#accordion" href="#collapse8" aria-expanded="false" aria-controls="collapse8">
          Sınav
        </a>
      </h4>
    </div>
    <div id="collapse8" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading8">
      <div class="panel-body">
      <li><a href="./sinavlar"><i class="glyphicon glyphicon-list-alt" ></i> Sınavlar</a></li>
      <li><a href="./sinav-ekle"><i class="glyphicon glyphicon-plus" ></i>Sınav Ekle</a></li>
      </div>
    </div>
  </div>
  
   <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="heading4">
      <h4 class="panel-title">
        <a class="collapsed5" data-toggle="collapse" data-parent="#accordion" href="#collapse4" aria-expanded="false" aria-controls="collapse4">
          Ders
        </a>
      </h4>
    </div>
    <div id="collapse4" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading4">
      <div class="panel-body">
      <li><a href="./dersler"><i class="glyphicon glyphicon-list-alt" ></i> Dersler</a></li>
      <li><a href="./ders-ekle"><i class="glyphicon glyphicon-plus" ></i> Ders Ekle</a></li>
      </div>
    </div>
  </div>
  
      <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="heading6">
      <h4 class="panel-title">
        <a class="collapsed6" data-toggle="collapse" data-parent="#accordion" href="#collapse6" aria-expanded="false" aria-controls="collapse6">
          Derslik
        </a>
      </h4>
    </div>
    <div id="collapse6" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading6">
      <div class="panel-body">
      <li><a href="./derslikler"><i class="glyphicon glyphicon-list-alt" ></i> Derslikler</a></li>
      <li><a href="./derslik-ekle"><i class="glyphicon glyphicon-plus" ></i> Derslik Ekle</a></li>
      </div>
    </div>
  </div>
  
        <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="heading9">
      <h4 class="panel-title">
        <a class="collapsed9" data-toggle="collapse" data-parent="#accordion" href="#collapse9" aria-expanded="false" aria-controls="collapse9">
          Bölüm
        </a>
      </h4>
    </div>
    <div id="collapse9" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading9">
      <div class="panel-body">
      <li><a href="./bolumler"><i class="glyphicon glyphicon-list-alt" ></i> Bölümler</a></li>
      <li><a href="./bolum-ekle"><i class="glyphicon glyphicon-plus" ></i> Bölüm Ekle</a></li>
      </div>
    </div>
  </div>
  
          <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="heading10">
      <h4 class="panel-title">
        <a class="collapsed10" data-toggle="collapse" data-parent="#accordion" href="#collapse10" aria-expanded="false" aria-controls="collapse10">
          Fakülte
        </a>
      </h4>
    </div>
    <div id="collapse10" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading10">
      <div class="panel-body">
      <li><a href="./fakulteler"><i class="glyphicon glyphicon-list-alt" ></i> Fakülteler</a></li>
      <li><a href="./fakulte-ekle"><i class="glyphicon glyphicon-plus" ></i> Fakülte Ekle</a></li>
      </div>
    </div>
  </div>
  
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a class="collapsed1" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          Kural
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
      	<li><a href="./kurallar"><i class="glyphicon glyphicon-list-alt" ></i> Kurallar</a></li>
      	<li><a href="./kural-ekle"><i class="glyphicon glyphicon-plus" ></i> Kural Ekle</a></li>
      </div>
    </div>
  </div>
  
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a class="collapsed2" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Duyuru
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
      <div class="panel-body">
      <li><a href="./duyurular"><i class="glyphicon glyphicon-list-alt" ></i> Duyurular</a></li>
      <li><a href="./duyuru-ekle"><i class="glyphicon glyphicon-plus" ></i> Duyuru Ekle</a></li>
      </div>
    </div>
  </div>
  
<!--     <div class="panel panel-default"> -->
<!--     <div class="panel-heading" role="tab" id="heading11"> -->
<!--       <h4 class="panel-title"> -->
<!--         <a class="collapsed11" data-toggle="collapse" data-parent="#accordion" href="#collapse11" aria-expanded="false" aria-controls="collapse11"> -->
<!--           Başvuru Tarihi -->
<!--         </a> -->
<!--       </h4> -->
<!--     </div> -->
<!--     <div id="collapse11" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading11"> -->
<!--       <div class="panel-body"> -->
<!--       <li><a href="./basvuruduzenle"><i class="glyphicon glyphicon-list-alt" ></i> Düzenle</a></li> -->
<!--       <li><a href="./duyuru-ekle"><i class="glyphicon glyphicon-plus" ></i> Duyuru Ekle</a></li> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
  
   
</div>
</div>
    <script type="text/javascript"> $('.collapsed1').collapse();</script>  <!-- kural -->
    <script type="text/javascript"> $('.collapsed2').collapse();</script>  <!--duyuru  -->
    <script type="text/javascript"> $('.collapsed3').collapse();</script>   <!--hoca  --> 
    <script type="text/javascript"> $('.collapsed4').collapse();</script>   <!--öğrenci  -->
    <script type="text/javascript"> $('.collapsed5').collapse();</script>   <!--ders  -->
    <script type="text/javascript"> $('.collapsed6').collapse();</script>   <!--derslik  -->
    <script type="text/javascript"> $('.collapsed7').collapse();</script>   <!-- arsgor -->
    <script type="text/javascript"> $('.collapsed8').collapse();</script>   <!-- sınav -->
    <script type="text/javascript"> $('.collapsed9').collapse();</script>   <!-- bölüm -->
    <script type="text/javascript"> $('.collapsed10').collapse();</script>   <!--fakülte  -->
    <script type="text/javascript"> $('.collapsed11').collapse();</script>   <!--fakülte  -->
