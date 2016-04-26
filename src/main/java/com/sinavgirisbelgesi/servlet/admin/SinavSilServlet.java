package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.SinavDAO;

@WebServlet("/admin/sinavsil")
public class SinavSilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			int sinavID = Integer.parseInt(request.getParameter("sinavID"));
			int status = SinavDAO.DeleteSinav(sinavID);
			String message;
			if(status == 1){
				message = "Sinav başarıyla silindi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("status", message);
			request.getRequestDispatcher("sinavlar").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}

}
