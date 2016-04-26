package com.sinavgirisbelgesi.servlet.hoca;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.SinavDAO;
import com.sinavgirisbelgesi.model.Sinav;

@WebServlet("/hoca/liste")
public class ListeleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("hoca") != null){
			request.setCharacterEncoding("UTF-8");
			int derslikid = Integer.parseInt(request.getParameter("dk"));
			int sinavID = Integer.valueOf(request.getParameter("sinavID").toString());
			request.setAttribute("derslikid", derslikid);
			request.setAttribute("sinavID", sinavID);
//			System.out.println("sinavID = " + sinavID);
//			System.out.println("derslikid = " + derslikid);
			
			ArrayList<Sinav> sinav = SinavDAO.Listele(sinavID, derslikid);
			
			
			request.setAttribute("sinav", sinav);
			request.getRequestDispatcher("listele").forward(request, response);
		}else{
			response.sendRedirect("hoca-login");
		}
	}

}
