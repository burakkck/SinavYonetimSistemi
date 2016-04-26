package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.DuyuruDAO;
import com.sinavgirisbelgesi.model.Duyuru;

@WebServlet("/admin/duyurudegistir")
public class DuyuruDegistirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DuyuruDegistirServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			request.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(request.getParameter("duyuruID"));
			String aciklama = request.getParameter("aciklama");
			Duyuru duyuru = new Duyuru(id, aciklama);
			int state = DuyuruDAO.DuyuruDegistir(duyuru);
			String message;
			if (state == 1){
				message = "Duyuru başarıyla güncellendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("duyurular").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
		
	}

}
