package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.BolumDAO;
import com.sinavgirisbelgesi.model.Bolum;

@WebServlet("/admin/bolumdegistir")
public class BolumDegistirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			int bolumID = Integer.parseInt(request.getParameter("bolumID"));
			String bolumad = request.getParameter("bolumad");
			Bolum bolum = new Bolum(bolumID, bolumad);
			
			int state = BolumDAO.BolumDegistir(bolum);
			String message;
			if(state == 1){
				message = "Bölüm bilgileri başarıyla güncellendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("bolumler").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}

}
