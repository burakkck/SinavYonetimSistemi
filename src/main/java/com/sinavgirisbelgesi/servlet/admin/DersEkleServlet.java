package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.DersDAO;
import com.sinavgirisbelgesi.model.Ders;

@WebServlet("/admin/dersekle")
public class DersEkleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String dersad = request.getParameter("name");
			
			Ders ders = new Ders(dersad);
			int state = DersDAO.DersEkle(ders);
			String message;
			if(state == 1){
				message = "Ders başarıyla eklendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("ders-ekle").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	
	}

}
