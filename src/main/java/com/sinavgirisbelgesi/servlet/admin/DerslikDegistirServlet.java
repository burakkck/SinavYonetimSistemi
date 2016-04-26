package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.DerslikDAO;
import com.sinavgirisbelgesi.model.Derslik;
@WebServlet("/admin/derslikdegistir")
public class DerslikDegistirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			int derslikID = Integer.parseInt(request.getParameter("derslikID"));
			String derslikad = request.getParameter("derslikad");
			int sirasayisi = Integer.parseInt(request.getParameter("sirasayisi"));
			
			Derslik derslik = new Derslik(derslikID, derslikad, sirasayisi);
			int state = DerslikDAO.DerslikDegistir(derslik);
			String message;
			if(state == 1){
				message = "Derslik bilgileri başarıyla güncellendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("derslikler").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}

}
