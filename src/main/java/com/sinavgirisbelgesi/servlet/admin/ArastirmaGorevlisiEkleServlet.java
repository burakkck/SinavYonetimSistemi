package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.ArastirmaGorevlisiDAO;
import com.sinavgirisbelgesi.model.ArastirmaGorevlisi;
import com.sinavgirisbelgesi.model.Bolum;

@WebServlet("/admin/arastirmagorevlisiekle")
public class ArastirmaGorevlisiEkleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin")!= null){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String ad = request.getParameter("name");
			String soyad = request.getParameter("lastname");
			int bolumID = Integer.parseInt(request.getParameter("bolum"));
			
			Bolum bolum = new Bolum(bolumID);
			ArastirmaGorevlisi arastirmagorevlisi = new ArastirmaGorevlisi(ad, soyad, bolum);
			int state = ArastirmaGorevlisiDAO.ArastirmaGorevlisiEkle(arastirmagorevlisi);
			String message;
			if (state == 1){
				message = "Araştırma görevlisi başarıyla eklendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("arastirmagorevlisi-ekle").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
		
	}

}
