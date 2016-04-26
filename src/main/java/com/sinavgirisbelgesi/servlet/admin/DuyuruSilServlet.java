package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.DuyuruDAO;

/**
 * Servlet implementation class DuyuruSil
 */
@WebServlet("/admin/duyurusil")
public class DuyuruSilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DuyuruSilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null ){
			request.setCharacterEncoding("UTF-8");
			int duyuruID = Integer.parseInt(request.getParameter("duyuruID"));
			int status = DuyuruDAO.DuyuruSil(duyuruID);
			String message;
			if(status == 1){
				message = "Duyuru silme işlemi başarılı";	 
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("status", message);
			request.getRequestDispatcher("duyurular").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}

}
