<%@page import="com.sinavgirisbelgesi.dao.ArastirmaGorevlisiDAO"%>
<%@page import="com.sinavgirisbelgesi.model.ArastirmaGorevlisi"%>
<%@page import="com.sinavgirisbelgesi.dao.DerslikDAO"%>
<%@page import="com.sinavgirisbelgesi.dao.SinavDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Sinav"%>
<%@page import="com.sinavgirisbelgesi.model.Derslik"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/admin/adminheader.jsp" />

	<% 	
		ArrayList<Sinav> sinavlar = SinavDAO.Sinavlarr();
		request.setAttribute("sinavlar", sinavlar);  
	%>
	<%
// 	ArrayList<Sinav> sinavid = SinavDAO.getSinavID();
// 	for (int i = 0; i < sinavid.size(); i++) {
// 		int id = sinavid.get(i).getId();
//  		System.out.println("id : " + id);
// 		ArrayList<Derslik> derslikler = DerslikDAO.SinavaAitDerslikler(id);
// 		for (int j = 0; j < derslikler.size(); j++) {
// 			int derslik = derslikler.get(j).getId();
//  			System.out.println("derslik : " + derslikler);
// 			request.setAttribute("derslik", derslikler);
// 		}
// 	}
	%>
	
	

<div class="col-lg-9">
	<div class="page-header" style="margin-top:-8px">
	<h1 style="color:#000000;">Sınavlar</h1>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<table class="footable table table-bordered toggle-circle table-sort" id="sinavlar">
			<thead>
			<tr>
<!-- 				<th data-type="numeric" data-sort-initial="true">Id</th> -->
				<th>Dersin Adı</th>
				<th data-hide="phone">Derslik</th>
				<th data-hide="phone">Sınav Tarihi</th>
<!-- 				<th data-hide="phone">Sınav Saati</th> -->
				<th data-hide="phone">Araştırma Görevlisi</th>
				<th data-hide="phone">Fakülte</th>
				<th data-sort-ignore="true" ></th>
				<th data-sort-ignore="true" ></th>
			</tr>
			</thead>
			<tbody>
<%-- 			<c:forEach items="${sinavlar }" var="sinavlar">  --%>
				<%	ArrayList<Sinav> sinavid = SinavDAO.getSinavID();
					for (int i = 0; i < sinavid.size(); i++) {
						int id = sinavid.get(i).getId();
//  						System.out.println("id : " + id);
 				%>
				<tr>
<%-- 					<td><%=id %></td> --%>
					<td><%=sinavlar.get(i).getDers().getAd() %></td>
<%-- 				<td>${sinavlar.id}</td> --%>
<%-- 				<td>${sinavlar.getDers().getAd()}</td> --%>
				
					<td>
					<%
// 							ArrayList<Sinav> sinavid = SinavDAO.getSinavID();
// 							for (int i = 0; i < sinavid.size(); i++) {
// 								int id = sinavid.get(i).getId();
//  								System.out.println("id : " + id);
								ArrayList<Derslik> derslikler = DerslikDAO.SinavaAitDerslikler(id); %>
								<select class="form-control " style="width:100px;">
							<%		for (int j = 0; j < derslikler.size(); j++) {
									String derslik = derslikler.get(j).getDerslikAd();
//  									System.out.println("derslik : " + derslikler);
// 									request.setAttribute("derslik", derslikler);  
 									%>
 										
 											<option>
 												<%=derslik %>
 											</option>
										
 									<%
							 	}
							%>
								</select>
						
					</td>
<!-- 				<select class="form-control"> -->
<%-- 				<c:forEach items="${derslik }" var="derslik"> --%>
<%-- 				<td>${sinavlar.getDerslik().getDerslikAd()}</td> --%>
<%-- 				    <option>${derslik.derslikAd}</option> --%>
<%-- 				</c:forEach> --%>
<!-- 				</select> -->
				
				
					
					<td><%=sinavlar.get(i).getTarih() %></td>
<%-- 					<td><%=sinavlar.get(i).getSinav_saat() %></td> --%>
					
					<td>
					<%
// 							ArrayList<Sinav> sinavid = SinavDAO.getSinavID();
// 							for (int i = 0; i < sinavid.size(); i++) {
// 								int id = sinavid.get(i).getId();
//  								System.out.println("id : " + id);
								ArrayList<ArastirmaGorevlisi> arsgor = ArastirmaGorevlisiDAO.SinavaAitArsGor(id); %>
								<select class="form-control" style="width:150px;">
							<%		for (int m = 0; m < arsgor.size(); m++) {
									String ad = arsgor.get(m).getAd();
									String soyad = arsgor.get(m).getSoyad();
//  									System.out.println("arsgor : " + arsgor);
// 									request.setAttribute("derslik", derslikler);  
 									%>
 										
 											<option>
 												<%=ad + " " + soyad %>
 											</option>
										
 									<%
							 	}
							%>
								</select>
						
					</td>
<%-- 					<td><%=sinavlar.get(i).getArastirmagorevlisi().getAd() + " " + sinavlar.get(i).getArastirmagorevlisi().getSoyad() %></td> --%>
					<td><%=sinavlar.get(i).getFakulte().getAd() %></td>
<%-- 				<td>${sinavlar.sinav_tarih}</td> --%>
<%-- 				<td>${sinavlar.sinav_saat}</td> --%>
<%-- 				<td>${sinavlar.getArastirmagorevlisi().getAd()}  ${sinavlar.getArastirmagorevlisi().getSoyad() }</td> --%>
<%-- 				<td>${sinavlar.getDerslik().getFakulte().getAd()}</td> --%>
				<td><a href="#" data-toggle="modal" 
				data-target="#EditSinavModal" class="btn btn-primary"
				data-sinav-no="<%=id %>" data-sinav-tarih="<%=sinavlar.get(i).getTarih() %>">
<%-- 				data-sinav-saat="<%=sinavlar.get(i).getSinav_saat() %>"> --%>
				Değiştir <i class="glyphicon glyphicon-refresh" aria-hidden="true"></i></a></td>
				<td><a data-href="sinavsil?sinavID=<%=id %>" data-toggle="modal" data-target="#deleteSinavModal" class="btn btn-danger">Sil  
				<i class="glyphicon glyphicon-trash"></i></a></td>
			</tr>
<%-- 			</c:forEach> --%>
<%
							}
					%>
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

<div class="modal fade" id="deleteSinavModal" tabindex="-1"
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
					Silme işlemini onaylıyor musunuz?
				</p>
				<a href="#" class="btn btn-danger btn-lg" id="btnDeleteSinav">Onayla</a>
				
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$('#sinavlar').footable();
</script>

	<jsp:include page="/jsp/admin/adminfooter.jsp" />

 <div class="modal fade" id="EditSinavModal" tabindex="-1" role="dialog"
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
				<form action="sinavdegistir" id="sinavdegistir" method="post"
					class="form-horizontal">
					<div class="form-group">
						<div class="col-lg-5">
							<input type="hidden" class="form-control" name="sinavID" id="sinavID" />
						</div>
					</div>
<!-- 					<div class="form-group"> -->
<!-- 				<label class="col-lg-3 control-label">Sınav Tarihi</label> -->
<!-- 				<div class="col-lg-5"> -->
<!-- 					<input type="text" class="form-control" placeholder="GG/AA/YYYY" name="sinavtarih" id="sinavtarih"   /> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 				<div class="form-group"> -->
<!-- 				<label class="col-lg-3 control-label">Sınav Saati</label> -->
<!-- 				<div class="col-lg-5"> -->
<!-- 					<input type="text" class="form-control" placeholder="SS:DD" name="sinavsaat" id="sinavsaat"   /> -->
<!-- 				</div> -->
<!-- 			</div> -->
			<div class="form-group" >
				<label for="tarih" class="col-lg-2 control-label">Tarih</label>
				<div class=' col-lg-5 date ' >
					<input type='text' class="form-control" name="date" id="datetimepicker" placeholder="Tarih Seçiniz"
						data-date-format="DD/MM/YYYY HH:mm"  />
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