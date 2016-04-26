package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.FakulteDAO;
import com.sinavgirisbelgesi.model.Fakulte;

@WebServlet("/admin/fakultedegistir")
public class FakulteDegistirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			int fakulteID = Integer.parseInt(request.getParameter("fakulteID"));
			String ad = request.getParameter("fakultead");
			Fakulte fakulte = new Fakulte(fakulteID, ad);
			
			int status = FakulteDAO.FakulteDegistir(fakulte);
			String message;
			if(status == 1){
				message = "Fakulte bilgileri başarıyla güncellendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("status", message);
			request.getRequestDispatcher("fakulteler").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}
}
