package com.sinavgirisbelgesi.servlet.ogrenci;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.SinavDAO;
import com.sinavgirisbelgesi.model.Ogrenci;
import com.sinavgirisbelgesi.model.Sinav;


@WebServlet("/sinavbilgileri")
public class SinavGirisBelgesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SinavGirisBelgesiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sinavID = Integer.parseInt(request.getParameter("sinavID"));
		Ogrenci ogr = (Ogrenci)request.getSession().getAttribute("ogrenci");
		int ogrenciID = ogr.getId();
		Sinav sinav = SinavDAO.GirisBelgesi(ogrenciID, sinavID);
		request.setAttribute("sinav", sinav);
		request.setAttribute("sinavID", sinavID);
		request.getRequestDispatcher("sinavgirisbelgesi").forward(request, response);
	}

}
