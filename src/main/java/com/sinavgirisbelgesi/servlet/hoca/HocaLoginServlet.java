package com.sinavgirisbelgesi.servlet.hoca;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.HocaDAO;
import com.sinavgirisbelgesi.model.Hoca;


@WebServlet("/hoca/hocalogin")
public class HocaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String kullaniciAd = request.getParameter("username");
		String sifre = request.getParameter("password");
		
		Hoca hoca = HocaDAO.getHocaControl(kullaniciAd, sifre);
		if(hoca != null){
			request.getSession().setAttribute("hoca", hoca);
			response.sendRedirect("anasayfa");
		}else{
			request.setAttribute("status", "Kullanıcı Adı veya Şifre yanlış....");
			request.getRequestDispatcher("hoca-login").forward(request, response);
		}
	}

}
