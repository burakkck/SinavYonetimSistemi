package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.KurallarDAO;
import com.sinavgirisbelgesi.model.Kurallar;

@WebServlet("/admin/kuralekle")
public class KuralEkleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("name");
			Kurallar kural = new Kurallar();
			kural.setAd(name);
			int state = KurallarDAO.KuralEkle(kural);
			String message;
			if(state == 1){
				message = "Kural başarıyla eklendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("kural-ekle").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}

}
