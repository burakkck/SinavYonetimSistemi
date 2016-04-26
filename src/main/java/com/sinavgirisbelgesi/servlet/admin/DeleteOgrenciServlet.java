package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.OgrenciDAO;

@WebServlet("/admin/deleteogrenci")
public class DeleteOgrenciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("utf-8");
			int ogrenciID = Integer.parseInt(request.getParameter("ogrenciID"));
			int state = OgrenciDAO.DeleteOgrenci(ogrenciID);
			String message;
			if(state == 1){
				message = "Öğrenci başarıyla silindi";
			}
			else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("status", message);
			request.getRequestDispatcher("ogrenciler").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}
}


