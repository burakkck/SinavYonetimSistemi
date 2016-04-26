package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.DersDAO;
import com.sinavgirisbelgesi.model.Ders;

@WebServlet("/admin/dersdegistir")
public class DersDegistirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			int dersID = Integer.parseInt(request.getParameter("dersID"));
			String dersad = request.getParameter("dersad");
			Ders ders = new Ders(dersID, dersad);
			int state = DersDAO.DersDegistir(ders);
			String message;
			if(state == 1){
				message = "Ders bilgileri başarıyla güncellendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("dersler").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}
}
