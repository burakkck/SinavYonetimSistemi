package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinavgirisbelgesi.dao.DersDAO;
import com.sinavgirisbelgesi.dao.DerslikDAO;
import com.sinavgirisbelgesi.dao.OgrenciDAO;
import com.sinavgirisbelgesi.dao.SinavDAO;
import com.sinavgirisbelgesi.model.Ders;
import com.sinavgirisbelgesi.model.Derslik;
import com.sinavgirisbelgesi.model.Ogrenci;
import com.sinavgirisbelgesi.model.Sinav;

/**
 * Servlet implementation class RastgeleAta2Servlet
 */
@WebServlet("/admin/rastgeleata")
public class RastgeleAta2Servlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sinavID = Integer.parseInt(request.getParameter("sinavID"));
		System.out.println("sinavID : " + sinavID);
//		ArrayList<Sinav> sinavlar = SinavDAO.getSinavID();
//		for (int m = 0; m < sinavlar.size(); m++) {
//			int sinavID = sinavlar.get(m).getId();
			Ders ders = DersDAO.getDersbySinavID(sinavID);
			Random rastgele = new Random();
			int dersID = ders.getId();
			ArrayList<Ogrenci> ogrenciler = OgrenciDAO.SinavaGirenOgrenciler(dersID);
			ArrayList<Derslik> derslikler = DerslikDAO.SinavinDersineAitDerslikler(sinavID);
			for (int j = 0; j < derslikler.size(); ) {
				for (int z = 0; z < ogrenciler.size(); ) {
					ArrayList<Integer> siralar = new ArrayList<Integer>();
					int derslikID = derslikler.get(j).getId();
					for (int k = 0; k < derslikler.get(j).getSiraSayisi(); ) {
						if( z != ogrenciler.size()){
						int siraNo = (rastgele.nextInt(derslikler.get(j).getSiraSayisi()))+1;
						
						int deger = SiraKontrol.kontrol(siralar, siraNo);
							if(deger == 1){
								int ogrenciID = ogrenciler.get(z).getId();
								System.out.println("ogrenci ad : "+ ogrenciID);
								z++;
								System.out.println("siraNO :" + siraNo);
								System.out.println("dersID:" + dersID);
								System.out.println("sinavID:" + sinavID);
								System.out.println("derslikID : " + derslikID);
								System.out.println("----------------");
								Ogrenci ogrenci = new Ogrenci(ogrenciID);
								Derslik derslik = new Derslik(derslikID);
								Sinav sinav = new Sinav(sinavID, ogrenci, siraNo, derslik);
								int state = SinavDAO.OgrenciSinavBilgileri(sinav);
								String message;
								if (state == 1){
									System.out.println("İşlem başarılı");
									message = "Rastgele atama işlemi başarıyla gerçekleştirildi.";
								}
								else{
									System.out.println("İşlem sırasında bir hata oluştu");
									message = "İşlem sırasında bir hata oluştu";
								}
								request.setAttribute("state", message);
								request.getRequestDispatcher("ogrenci-dagitim").forward(request, response);
								k++;
								siralar.add(siraNo);
			//					ogrenciler.remove(k);
							}
							else{
								continue;
								
							}
						}
						else{
							break;
						}
					}
					j++;
				}
			}
		}
	}


