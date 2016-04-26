package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.KurallarDAO;
import com.sinavgirisbelgesi.model.Kurallar;

@WebServlet("/admin/kuraldegistir")
public class KuralDegistirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("UTF-8");
			int kuralID = Integer.parseInt(request.getParameter("kuralID"));
			String ad = request.getParameter("ad");
			Kurallar kural = new Kurallar(kuralID, ad);
			int state = KurallarDAO.KuralDegistir(kural);
			String message;
			if(state == 1){
				message = "Kural başarıyla güncellendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("kurallar").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}

}
