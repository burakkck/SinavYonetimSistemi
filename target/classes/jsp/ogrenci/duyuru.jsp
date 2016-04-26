<%@page import="com.sinavgirisbelgesi.model.Duyuru"%>
<%@page import="com.sinavgirisbelgesi.dao.DuyuruDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	ArrayList<Duyuru> duyurular = DuyuruDAO.Duyurular();
request.setAttribute("duyurular", duyurular);
%>
    <div class="panel-heading" style="background-color: #3498db; max-width: 500px;"><strong style="color:white">Duyuru</strong></div><br/>
  
          <ul id="ticker_01" class="ticker" style="min-width: 500px;min-height:350px; list-style-type:none;">
          <c:forEach items="${duyurular }" var="duyurular"> 								
              <li style=" background-color:#F1F1F1; min-height: 45px;">${duyurular.getAciklama()}</li>
<!--               <li style="background-color:#f9f9f9; min-height: 45px;">lütfen aldığınız derslerden gireceğiniz sınavın sistem kaydını yapınız</li> -->
      	  </c:forEach>
          </ul>


<script>

	function tick(){
		$('#ticker_01 li:first').slideUp( function () { $(this).appendTo($('#ticker_01')).slideDown(); });
	}
	setInterval(function(){ tick () }, 5000);


	function tick2(){
		$('#ticker_02 li:first').slideUp( function () { $(this).appendTo($('#ticker_02')).slideDown(); });
	}
	setInterval(function(){ tick2 () }, 3000);


	function tick3(){
		$('#ticker_03 li:first').animate({'opacity':0}, 200, function () { $(this).appendTo($('#ticker_03')).css('opacity', 1); });
	}
	setInterval(function(){ tick3 () }, 4000);	

	function tick4(){
		$('#ticker_04 li:first').slideUp( function () { $(this).appendTo($('#ticker_04')).slideDown(); });
	}


	/**
	 * USE TWITTER DATA
	 */

	 $.ajax ({
		 url: 'http://search.twitter.com/search.json',
		 data: 'q=%23javascript',
		 dataType: 'jsonp',
		 timeout: 10000,
		 success: function(data){
		 	if (!data.results){
		 		return false;
		 	}

		 	for( var i in data.results){
		 		var result = data.results[i];
		 		var $res = $("<li />");
		 		$res.append('<img src="' + result.profile_image_url + '" />');
		 		$res.append(result.text);

		 		console.log(data.results[i]);
		 		$res.appendTo($('#ticker_04'));
		 	}
			setInterval(function(){ tick4 () }, 4000);	

			$('#example_4').show();

		 }
	});


</script>

