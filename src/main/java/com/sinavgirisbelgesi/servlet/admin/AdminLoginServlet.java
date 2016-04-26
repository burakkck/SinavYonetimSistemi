package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.AdminDAO;
import com.sinavgirisbelgesi.model.Admin;



@WebServlet("/admin/adminlogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String kullaniciAd = request.getParameter("username");
		String sifre = request.getParameter("password");

		Admin admin = AdminDAO.getAdminControl(kullaniciAd, sifre);
		if(admin != null){
			request.getSession().setAttribute("admin", admin);
			response.sendRedirect("ogrenciler");
		}else{
			request.setAttribute("status", "Kullanıcı adı veya şifre hatalı....");
			request.getRequestDispatcher("login").forward(request, response);
		}
	}

}
