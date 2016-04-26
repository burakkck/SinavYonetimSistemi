package com.sinavgirisbelgesi.servlet.hoca;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.HocaDAO;
import com.sinavgirisbelgesi.model.Hoca;

@WebServlet("/hoca/hocaayarlar")
public class HocaAyarlarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		Hoca hoca = (Hoca)request.getSession().getAttribute("hoca");
		if(hoca != null){
			int hocaID = Integer.parseInt(request.getParameter("hocaID"));
			String ad = request.getParameter("ad");
			String soyad = request.getParameter("soyad");
			String sifre = request.getParameter("password");
			int state = 0;
			if(!request.getParameter("password").equals("")){
				 hoca = new Hoca(ad, hocaID, soyad, sifre);
				 state = HocaDAO.HocaAyarlar(hoca);
			}else{
				hoca = new Hoca(hocaID, ad, soyad);
				state = HocaDAO.HocaAyarlar2(hoca);
			}

			String message;
			if(state == 1){
				request.getSession().setAttribute("hoca", hoca);
				response.sendRedirect("anasayfa");
			}else{
				message = "İşlem sırasında bir hata oluştu";
				request.setAttribute("state", message);
				request.getRequestDispatcher("listele").forward(request, response);
			}
		}
	}

}
