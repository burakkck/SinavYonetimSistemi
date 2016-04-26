package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.FakulteDAO;
import com.sinavgirisbelgesi.model.Fakulte;

@WebServlet("/admin/fakulteekle")
public class FakulteEkleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("utf-8");
			String ad = request.getParameter("name");
			Fakulte fakulte = new Fakulte(ad);
			int state = FakulteDAO.FakulteEkle(fakulte);
			String message;
			if(state == 1){
				message = "Fakülte başarıyla eklendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("fakulte-ekle").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}

}
