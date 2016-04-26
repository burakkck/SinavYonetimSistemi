package com.sinavgirisbelgesi.servlet.ogrenci;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.DersDAO;
import com.sinavgirisbelgesi.dao.OgrenciDAO;
import com.sinavgirisbelgesi.model.Ders;
import com.sinavgirisbelgesi.model.Ogrenci;


@WebServlet("/ogrenciderskayit")
public class OgrenciDersKayitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OgrenciDersKayitServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=UTF-8");
		String dersler[] = request.getParameterValues("ders");
		Ogrenci ogrenci = (Ogrenci)request.getSession().getAttribute("ogrenci");
		if (dersler != null && dersler.length != 0) {
			
			for (int i = 0; i < dersler.length; i++) {
				Ders ders = DersDAO.getDersbyid(dersler[i]);
				
				int updateQuery = OgrenciDAO.addOgrenciDers(ogrenci, ders);
				/*if(updateQuery == 1){
					response.sendRedirect("ogrenci");
				}else{
					request.setAttribute("status", "kayıt işlemi başarısız oldu");
					request.getRequestDispatcher("ogrenci").forward(request, response);
				}
				*/
			}
			response.sendRedirect("anasayfa");
			
			
		}
	}

}
