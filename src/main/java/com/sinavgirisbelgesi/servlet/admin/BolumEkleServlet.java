package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.BolumDAO;
import com.sinavgirisbelgesi.model.Bolum;
import com.sinavgirisbelgesi.model.Fakulte;

@WebServlet("/admin/bolumekle")
public class BolumEkleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("utf-8");
			String ad = request.getParameter("name");
			int fakulteID = Integer.parseInt(request.getParameter("fakulte"));
			int bolumID = BolumDAO.bolumNoBuilder();
			
			Fakulte fakulte = new Fakulte(fakulteID);
			Bolum bolum = new Bolum(bolumID, ad, fakulte);
			int state = BolumDAO.BolumEkle(bolum);
			String message;
			if(state == 1){
				message = "Bölüm başarıyla eklendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("bolum-ekle").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}

}
