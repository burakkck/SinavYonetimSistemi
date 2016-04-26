package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.DuyuruDAO;
import com.sinavgirisbelgesi.model.Duyuru;

@WebServlet("/admin/duyuruekle")
public class DuyuruEkleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String aciklama = request.getParameter("name");
			Duyuru duyuru = new Duyuru();
			duyuru.setAciklama(aciklama);
			int state = DuyuruDAO.DuyuruEkle(duyuru);
			String message ;
			if(state == 1){
				message = "Duyuru başarıyla eklendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("duyuru-ekle").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}

}
