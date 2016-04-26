package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.AdminDAO;
import com.sinavgirisbelgesi.model.Admin;
import com.sinavgirisbelgesi.model.Ogrenci;

@WebServlet("/admin/adminayarlar")
public class AdminAyarlarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if(admin != null){
			int id = Integer.parseInt(request.getParameter("adminID"));
			String username = request.getParameter("username");
			String sifre = request.getParameter("password");
			int state = 0;
			if(!request.getParameter("password").equals("")){
				admin = new Admin(id, username, sifre);
				state = AdminDAO.AdminAyarlar(admin);
			}else{
				admin = new Admin(id, username);
				state = AdminDAO.AdminAyarlar2(admin);
			}
			String message;
			if(state == 1){
				request.getSession().setAttribute("admin", admin);
				response.sendRedirect("ogrenciler");
			}else{
				message = "İşlem sırasında bir hata oluştu";
				request.setAttribute("state", message);
				request.getRequestDispatcher("ogrenciler").forward(request, response);
			}
			
		}
	}

}
