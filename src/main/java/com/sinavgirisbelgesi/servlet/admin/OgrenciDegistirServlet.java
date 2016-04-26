package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.OgrenciDAO;

@WebServlet("/admin/ogrencidegistir")
public class OgrenciDegistirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("utf-8");
			int ogrenciID = Integer.parseInt(request.getParameter("ogrenciID"));
			int state = OgrenciDAO.OgrenciSifreDegistir(ogrenciID);
			String message;
			if(state == 1){
				message ="Şifre sıfırlama işlemi başarıyla gerçekleşti";
			}
			else{
				message = "Şifre sıfırlanırken bir hata ile oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("ogrenciler").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}
		
}


