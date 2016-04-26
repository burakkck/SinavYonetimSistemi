package com.sinavgirisbelgesi.servlet.ogrenci;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.DersDAO;


@WebServlet("/ogrencidersiptal")
public class OgrenciDersIptalDervlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OgrenciDersIptalDervlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=UTF-8");
		int ders_id = Integer.valueOf(request.getParameter("ders"));
		int updateQuery = DersDAO.deleteDers(ders_id);
		response.getWriter().println(updateQuery);
		if(updateQuery == 1){
			response.sendRedirect("anasayfa");
		}else{
			request.setAttribute("status", "Silme iþlemi baþarýsýz");
			request.getRequestDispatcher("anasayfa").forward(request, response);
		}
		
	}

}
