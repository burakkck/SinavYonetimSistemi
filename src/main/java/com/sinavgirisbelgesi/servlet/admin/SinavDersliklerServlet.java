package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.DerslikDAO;
import com.sinavgirisbelgesi.dao.SinavDAO;
import com.sinavgirisbelgesi.model.Derslik;
import com.sinavgirisbelgesi.model.Sinav;

@WebServlet("/admin/sinavderslikler")
public class SinavDersliklerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Sinav> sinavid = SinavDAO.getSinavID();
		for (int i = 0; i < sinavid.size(); i++) {
			int id = sinavid.get(i).getId();
//			System.out.println("id : " + id);
			ArrayList<Derslik> derslikler = DerslikDAO.SinavaAitDerslikler(id);
			for (int j = 0; j < derslikler.size(); j++) {
				int derslik = derslikler.get(j).getId();
//				System.out.println("derslik : " + derslik);
				request.setAttribute("derslik", derslik);
				request.getRequestDispatcher("sinavlar").forward(request, response);
			}
			
			
		}
	}

}
