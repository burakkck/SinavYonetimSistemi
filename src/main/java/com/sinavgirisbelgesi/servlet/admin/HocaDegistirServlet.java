package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.HocaDAO;
import com.sinavgirisbelgesi.model.Hoca;

@WebServlet("/admin/hocadegistir")
public class HocaDegistirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			int hocaID = Integer.parseInt(request.getParameter("hocaID"));
			String hocaAd = request.getParameter("hocaAd");
			String hocaSoyad = request.getParameter("hocaSoyad");
			Hoca hoca = new Hoca(hocaID, hocaAd, hocaSoyad);
			
			int state = HocaDAO.HocaDegistir(hoca);
			String message;
			if(state == 1){
				message = "Öğretim elemanı bilgileri başarıyla güncellendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("hocalar").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}

}
