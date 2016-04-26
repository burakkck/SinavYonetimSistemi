package com.sinavgirisbelgesi.servlet.hoca;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.OgrenciDAO;



@WebServlet("/hoca/image")
public class ImageControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ogrenciID = Integer.valueOf(request.getParameter("oid"));
		response.setContentType("image/jpeg");
		byte[] image = OgrenciDAO.getImageByOgrenciId(ogrenciID);
		response.setContentLength(image.length);
		response.getOutputStream().write(image);
	}

}
