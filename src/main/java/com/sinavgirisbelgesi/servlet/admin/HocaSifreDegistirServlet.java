package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.HocaDAO;

@WebServlet("/admin/hocasifredegistir")
public class HocaSifreDegistirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("UTF-8");
			int hocaID = Integer.parseInt(request.getParameter("hocaID"));
			int status = HocaDAO.HocaSifreDegistir(hocaID);
			String message;
			if(status == 1){
				message ="Şifre sıfırlama işlemi başarıyla gerçekleşti";
			}
			else{
				message = "Şifre sıfırlanırken bir hata ile oluştu";
			}
			request.setAttribute("status", message);
			request.getRequestDispatcher("hocalar").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}

}
