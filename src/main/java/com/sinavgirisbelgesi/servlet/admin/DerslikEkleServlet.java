package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.DersDAO;
import com.sinavgirisbelgesi.dao.DerslikDAO;
import com.sinavgirisbelgesi.model.Derslik;
import com.sinavgirisbelgesi.model.Fakulte;

@WebServlet("/admin/derslikekle")
public class DerslikEkleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String derslikAd =request.getParameter("name");
			int siraSayisi = Integer.parseInt(request.getParameter("sirasayisi"));
			int fakulteID = Integer.parseInt(request.getParameter("fakulte"));
			
			Fakulte fakulte = new Fakulte(fakulteID);
			Derslik derslik = new Derslik(derslikAd, siraSayisi, fakulte);
			int state = DerslikDAO.DerslikEkle(derslik);
			String message;
			if(state == 1){
				message = "Derslik başarıyla eklendi";
			}else{
				message = "İşlem sırasında bir hata oluştu!";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("derslik-ekle").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}

}
