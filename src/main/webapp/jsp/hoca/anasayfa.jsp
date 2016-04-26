<%@page import="com.sinavgirisbelgesi.dao.SinavDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Sinav"%>
<%@page import="com.sinavgirisbelgesi.dao.DerslikDAO"%>
<%@page import="com.sinavgirisbelgesi.model.Derslik"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/jsp/hoca/hocaheader.jsp" />

	<% 
		ArrayList<Sinav> sinavlar = SinavDAO.SinavGoster();
		request.setAttribute("sinavlar", sinavlar);  
	%>

<div class="col-lg-offset-1 col-lg-10 col-lg-offset-1">
	<div class="page-header" style="margin-top:-8px">
	<h1 style="color:#000000;">Sınavlar</h1>
	</div>
	<div class="row">
		<div class="col-lg-12">
			
			<table class="footable table table-bordered toggle-circle" id="bolumler">
			<thead>
			<tr>
				<th>Ders Adı</th>
				<th data-hide="phone">Sınav Tarihi</th>
<!-- 				<th data-hide="phone">Sınav Saati</th> -->
				<th data-hide="phone">Derslik</th>
				<th></th>
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
				<td><%= sinavlar.get(i).getDers().getAd()%></td>
				<td><%=sinavlar.get(i).getTarih() %></td>
<%-- 				<td><%=sinavlar.get(i).getSinav_saat() %></td> --%>
				<td>
					<%
// 							ArrayList<Sinav> sinavid = SinavDAO.getSinavID();
// 							for (int i = 0; i < sinavid.size(); i++) {
// 								int id = sinavid.get(i).getId();
//  								System.out.println("id : " + id);
								ArrayList<Derslik> derslikler = DerslikDAO.SinavaAitDerslikler(id); %>
								<form action="liste" method="post">
								<select class="form-control " style="width:100px;" name="dk" id="dk" >
							<%		for (int j = 0; j < derslikler.size(); j++) {
									String derslik = derslikler.get(j).getDerslikAd();
									int dk = derslikler.get(j).getId();
//  									System.out.println("derslik : " + derslikler);
//  									System.out.println("derslikid : " + derslikid);
//  									System.out.println("----------------------------" );
// 									request.setAttribute("derslik", derslikler);  
 									%>
 										
 											
 											<option value=<%=dk%> ><%=derslik%></option>
										
 									<%
							 	}
							%>
								</select>
						<input type="hidden" value=<%=id%> name="sinavID">
				</td>
				<td><button type="submit" class="btn btn-primary">Listele<i ></i></button></td>
				</form>
<%-- 				<td><a href="./liste?sinavID=<%=id%>"><button class="btn btn-primary" >Listele <i class="fa fa-list-alt"></i></button></a></td> --%>
			</tr>
<%-- 			</c:forEach> --%>
<%
							}
					%>
				</tbody>
				
				<tfoot>
					<tr>
						<td colspan="20">
							<div class="pagination pagination-centered hide-if-no-paging"></div>
						</td>
					</tr>
				</tfoot>
			</table>
			
		</div>
	</div>
	
</div>


<script type="text/javascript">
	$('#bolumler').footable();
</script>
<jsp:include page="/jsp/hoca/hocafooter.jsp" />

 