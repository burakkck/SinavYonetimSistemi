package com.sinavgirisbelgesi.servlet.ogrenci;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.sinavgirisbelgesi.dao.BolumDAO;
import com.sinavgirisbelgesi.model.Bolum;

@WebServlet("/getbolum")
public class AjaxBolumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  public AjaxBolumServlet() {
	        super();
	    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		int fakulteID = Integer.valueOf(request.getParameter("fakulteNo"));
		Map<String, Object> map = new HashMap<String, Object>();
		ArrayList<Bolum> bolum = BolumDAO.getBolumbyFakulteidID(fakulteID);
		
		map.put("bolum", bolum);
//		System.out.println("fak no :" + fakulteID);
//		System.out.println("bolum size :" + bolum.size());
		ObjectMapper mapper = new ObjectMapper();
		resp.getWriter().write(mapper.writeValueAsString(map));
	}

}
