package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.SinavDAO;
import com.sinavgirisbelgesi.model.ArastirmaGorevlisi;
import com.sinavgirisbelgesi.model.Bolum;
import com.sinavgirisbelgesi.model.Ders;
import com.sinavgirisbelgesi.model.Derslik;
import com.sinavgirisbelgesi.model.Fakulte;
import com.sinavgirisbelgesi.model.Sinav;


@WebServlet("/admin/sinavekle")
public class SinavEkleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null ){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			int dersid = Integer.parseInt(request.getParameter("dersad"));
//			int derslikid = Integer.parseInt(request.getParameter("derslik"));
//			int arastirmagorevlisi = Integer.parseInt(request.getParameter("arastirmagorevlisi"));
//			String tarih = request.getParameter("tarih");
//			String saat = request.getParameter("saat");
			int fakulteID = Integer.parseInt(request.getParameter("fakulte"));
			int sinavID = SinavDAO.sinavNoBuilder();
			int bolumID = Integer.parseInt(request.getParameter("bolum"));
			String date = request.getParameter("date").toString()+ ":00";
//			System.out.println("date: " + date);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date formatDate = null;
			try {
				formatDate = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			String derslikid = null;
			String arastirmaGorevlisi = null;
			String[] derslikler = request.getParameterValues("derslik");
			String[] arsgor = request.getParameterValues("arastirmagorevlisi");
//			System.out.println("sinavID : " + sinavID );
//			System.out.println("derslik : " + derslikler );
//			System.out.println("derslik boyut : " + derslikler.length );
//			System.out.println("arsgor boyut : " + arsgor.length );
			Bolum bolum = new Bolum(bolumID);
			
			
			for(int i=0;i<derslikler.length;i++){
				derslikid = derslikler[i];
//				System.out.println("derslik : " + Integer.parseInt(derslikid));
				Derslik derslik = new Derslik(Integer.parseInt(derslikid));
				Sinav sinav = new Sinav(sinavID, derslik);
				SinavDAO.SinavDerslikEkle(sinav);
			}
			
			for(int k=0;k<arsgor.length;k++){
				arastirmaGorevlisi = arsgor[k];
//				System.out.println("arsgor : " + Integer.parseInt(arastirmaGorevlisi));
				ArastirmaGorevlisi arastirmagorevlisii = new ArastirmaGorevlisi(Integer.parseInt(arastirmaGorevlisi));
				Sinav sinavarsgor = new Sinav(sinavID, arastirmagorevlisii);
				SinavDAO.SinavArsGorEkle(sinavarsgor);
			}
			
			Ders ders = new Ders(dersid);
//			Derslik derslik = new Derslik(derslikid);
//			ArastirmaGorevlisi arastirmagorevlisi_id = new ArastirmaGorevlisi(arastirmagorevlisi);
			Fakulte fakulte = new Fakulte(fakulteID);
//			Sinav sinav = new Sinav(tarih, saat, ders, derslik, arastirmagorevlisi_id, fakulte);
			Sinav sinav = new Sinav(ders, fakulte,bolum, formatDate);
//			Sinav sinav = new Sinav(tarih, saat, ders, arastirmagorevlisi_id, fakulte);
			int state = SinavDAO.SinavEkle(sinav);
			
			String message;
			if(state == 1){
				message = "Sınav başarıyla eklendi";
			}else{
				message = "İşlem sırasında bir hata oluştu";
			}
			request.setAttribute("state", message);
			request.getRequestDispatcher("sinav-ekle").forward(request, response);
		}else{
			response.sendRedirect("login");
		}
	}

}
