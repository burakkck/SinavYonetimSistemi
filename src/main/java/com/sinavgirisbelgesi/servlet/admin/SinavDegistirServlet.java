package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.SinavDAO;
import com.sinavgirisbelgesi.model.Sinav;

@WebServlet("/admin/sinavdegistir")
public class SinavDegistirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			response.setCharacterEncoding("UTF");
			int sinavID = Integer.parseInt(request.getParameter("sinavID"));
//			String sinavTarih = request.getParameter("sinavtarih");
//			String sinavSaat = request.getParameter("sinavsaat");
			String date = request.getParameter("date").toString()+ ":00";
//			System.out.println("date: " + date);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date formatDate = null;
			try {
				formatDate = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Sinav sinav = new Sinav(sinavID, formatDate);
			
			int state = SinavDAO.SinavDegistir(sinav);
			String message;
			if(state == 1){
				message = "Sınav bilgileri başarıyla güncellendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("sinavlar").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}
}
