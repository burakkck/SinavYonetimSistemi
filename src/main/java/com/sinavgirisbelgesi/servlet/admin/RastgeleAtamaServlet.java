package com.sinavgirisbelgesi.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.sinavgirisbelgesi.dao.DersDAO;
import com.sinavgirisbelgesi.dao.DerslikDAO;
import com.sinavgirisbelgesi.dao.OgrenciDAO;
import com.sinavgirisbelgesi.dao.SinavDAO;
import com.sinavgirisbelgesi.model.Ders;
import com.sinavgirisbelgesi.model.Derslik;
import com.sinavgirisbelgesi.model.Ogrenci;
import com.sinavgirisbelgesi.model.Sinav;

/**
 * Servlet implementation class RastgeleAtamaServlet
 */
@WebServlet("/admin/rastgeleatama")
public class RastgeleAtamaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Sinav> sinavlar = SinavDAO.getSinavID();
		for (int m = 0; m < sinavlar.size(); m++) {
			int sinavID = sinavlar.get(m).getId();
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
									if (state == 1){
										System.out.println("İşlem başarılı");
									}
									else{
										System.out.println("İşlem sırasında bir hata oluştu");
									}
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

}
