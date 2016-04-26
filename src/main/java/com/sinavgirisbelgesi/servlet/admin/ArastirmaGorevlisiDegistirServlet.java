package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.ArastirmaGorevlisiDAO;
import com.sinavgirisbelgesi.model.ArastirmaGorevlisi;

@WebServlet("/admin/arastirmagorevlisidegistir")
public class ArastirmaGorevlisiDegistirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			int arsgorID = Integer.parseInt(request.getParameter("arsgorID"));
			String arsgorAd = request.getParameter("arsgorAd");
			String arsgorSoyad = request.getParameter("arsgorSoyad");
			ArastirmaGorevlisi arastirmagorevlisi = new ArastirmaGorevlisi(arsgorID, arsgorAd, arsgorSoyad);
			
			int state = ArastirmaGorevlisiDAO.ArastirmaGorevlisiDegistir(arastirmagorevlisi);
			String message;
			if(state == 1){
				message = "Araştırma görevlisi bilgileri başarıyla güncellendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("arastirmagorevlileri").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}
}
