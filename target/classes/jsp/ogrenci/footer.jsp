<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<div class="modal fade" id="AyarlarModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Ayarlar</h4>
			</div>

			<div class="modal-body">
				<!-- The form is placed inside the body of modal -->
				<form action="ogrenciayarlar" method="post" id="ayarlarForm"
					class="form-horizontal">
					<div class="form-group">
						<label class="col-md-3 control-label"></label>
						<div class="col-md-5">
							<input type="hidden" class="form-control" name="ogrenciID" value="${ogrenci.id}"  />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Öğrenci No</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="ogrencino" value="${ogrenci.no}" disabled />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Ad</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="ad" placeholder="adınızı giriniz" value="${ogrenci.ad}"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Soyad</label>
						<div class="col-lg-9">
							<input type="text" class="form-control" name="soyad"	placeholder="Soyadınızı giriniz" value="${ogrenci.soyad}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">E-Posta</label>
						<div class="col-lg-9">
							<input type="text" class="form-control" name="email"	placeholder="E-Posta adresinizi giriniz" value="${ogrenci.email}" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-3 control-label">Sınıf</label>
						<div class="col-lg-9">
							<input type="text" class="form-control" name="sinif"
								placeholder="Soyadınızı giriniz" value="${ogrenci.sinif}" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-3 control-label">Şifre </label>
						<div class="col-lg-9">
							<input type="password" class="form-control" name="password"
								placeholder="Şifreniz (Değiştirmek istemiyorsanız boş bırakınız)" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-3 control-label">Şifre Tekrar</label>
						<div class="col-lg-9">
							<input type="password" class="form-control" name="repeatpassword"
								placeholder="Şifrenizi tekrar (Değiştirmek istemiyorsanız boş bırakınız)"/>
						</div>
					</div>

					<div class="form-group">
						<div class="col-lg-5">	
							<button type="submit" class="col-lg-offset-8 btn btn-primary">Değiştir</button>
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
    
 <!--    
<div class="container">
	<div class="row">
		<div class="col-md-12">"
			<hr>
			<p>
				copyright &copy; Bu bir Burak,Kaan,Yavuz Projesidir.Her hakkı saklıdır.
				<a href="#myModal" data-toggle="modal">Daha Fazlası İçin</a>
			</p>
			
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h3>İletişim</h3>
						</div>
						<div class="modal-body">
							<p class="footerbilgi">Ondokuz Mayıs Üniversitesi Bilgisayar Mühendisliği 4. sınıf öğrencisi</p>
							<p class="footerbilgi">	e-mail : bkucuk@bil.omu.edu.tr </p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" data-dismiss="modal">Kapat</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
 -->
    
    
