package com.sinavgirisbelgesi.servlet.ogrenci;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.OgrenciDAO;
import com.sinavgirisbelgesi.model.Ogrenci;


@WebServlet("/ogrencilogin")
public class OgrenciLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public OgrenciLoginServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kullaniciAd = request.getParameter("username");
		String sifre = request.getParameter("password");
		
		Ogrenci ogrenci = OgrenciDAO.getOgrenciControl(kullaniciAd, sifre);
		if (ogrenci != null) {
			request.getSession().setAttribute("ogrenci", ogrenci);
			response.sendRedirect("anasayfa"); 
		}else {
			request.setAttribute("status", "kullanıcı adı veya şifre hatalı");
			request.getRequestDispatcher("index").forward(request, response);
		}
	}

}
