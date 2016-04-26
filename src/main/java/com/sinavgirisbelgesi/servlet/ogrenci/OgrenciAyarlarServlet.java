package com.sinavgirisbelgesi.servlet.ogrenci;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.OgrenciDAO;
import com.sinavgirisbelgesi.model.Ogrenci;

@WebServlet("/ogrenciayarlar")
public class OgrenciAyarlarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		Ogrenci ogrenci = (Ogrenci) request.getSession().getAttribute("ogrenci");
		if( ogrenci != null){
			int ogrenciID = Integer.parseInt(request.getParameter("ogrenciID"));
			String ad = request.getParameter("ad");
			String soyad = request.getParameter("soyad");
			String sifre = request.getParameter("password");
			int sinif = Integer.parseInt(request.getParameter("sinif"));
			String email = request.getParameter("email");
			int state = 0;
			if(!request.getParameter("password").equals("")){
				 ogrenci = new Ogrenci(ogrenciID, ad, soyad, sinif, sifre,email);
				state = OgrenciDAO.OgreciAyarlar(ogrenci);
			}else{
				 ogrenci = new Ogrenci(ogrenciID, ad, soyad, sinif,email);
				state = OgrenciDAO.OgreciAyarlar2(ogrenci);
			}
			String message;
			if(state == 1){
				request.getSession().setAttribute("ogrenci", ogrenci);
				response.sendRedirect("anasayfa");
			}else{
				message = "İşlem sırasında bir hata oluştu";
				request.setAttribute("state", message);
				request.getRequestDispatcher("anasayfa").forward(request, response);
			}
		}
	}

}
