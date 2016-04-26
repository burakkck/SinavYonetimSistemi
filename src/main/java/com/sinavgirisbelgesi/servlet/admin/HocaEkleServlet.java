package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.HocaDAO;
import com.sinavgirisbelgesi.model.Hoca;

@WebServlet("/admin/hocaekle")
public class HocaEkleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin")!= null){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String kullaniciad = request.getParameter("username");
			String ad = request.getParameter("name");
			String soyad = request.getParameter("lastname");
			String sifre = request.getParameter("password");
			
			Hoca hoca = new Hoca(ad, soyad, kullaniciad, sifre);
			int state = HocaDAO.HocaEkle(hoca);
			String message;
			if(state ==1){
				message = "Öğretim elemanı başarıyla eklendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("hoca-ekle").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
		
	}

}
