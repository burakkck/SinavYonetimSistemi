		</div><!-- // row end -->
	</div>
	<!-- // container end -->
	
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
</body>
</html>

<!-- Ayarlar modal -->
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
				<form action="adminayarlar" method="post" id="ayarlarForm"
					class="form-horizontal">
					<div class="form-group">
						<label class="col-lg-3 control-label"></label>
						<div class="col-lg-5">
							<input type="hidden" class="form-control" name="adminID" value="${admin.id}" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">Kullanıcı Ad</label>
						<div class="col-lg-9">
							<input type="text" class="form-control" name="username" placeholder="Kullanıcı adınızı giriniz" value="${admin.kullaniciAd}" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-lg-3 control-label">Şifre</label>
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
<!-- // end Ayarlar modal -->