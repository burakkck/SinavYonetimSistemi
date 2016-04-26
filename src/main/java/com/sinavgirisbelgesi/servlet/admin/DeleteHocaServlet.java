package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.HocaDAO;

@WebServlet("/admin/deletehoca")
public class DeleteHocaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("utf-8");
			int hocaID = Integer.parseInt(request.getParameter("hocaID"));
			int states = HocaDAO.DeleteHoca(hocaID);
			String message;
			if(states == 1){
				message = "Öğretim elemanı başarıyla silindi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("states", message);
			request.getRequestDispatcher("hocalar").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}
}
