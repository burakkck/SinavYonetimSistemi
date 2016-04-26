package com.sinavgirisbelgesi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.sinavgirisbelgesi.model.ArastirmaGorevlisi;
import com.sinavgirisbelgesi.model.Ders;
import com.sinavgirisbelgesi.model.Derslik;
import com.sinavgirisbelgesi.model.Fakulte;
import com.sinavgirisbelgesi.model.Ogrenci;
import com.sinavgirisbelgesi.model.Sinav;

public class SinavDAO {
	
//	public static ArrayList<Sinav> Sinavlar(){
//		ArrayList<Sinav> sinavlar = new ArrayList<Sinav>();
//		String sql = "select sinavyeri.id as s_id , ders.id as d_id , ders.ad as d_ad , derslik.id as dk_id , derslik.derslikAd as dk_ad , "+
//				"sinavyeri.sinav_tarih , sinavyeri.sinav_saat , arastirmagorevlisi.id as ag_id, "+
//				"arastirmagorevlisi.ad as ag_ad , arastirmagorevlisi.soyad as ag_soyad , "+
//				"fakulte.id as f_id , fakulte.ad as f_ad "+
//				"from sinavyeri "+
//				"inner join ders on ders.id = sinavyeri.ders_id "+
//				"inner join sinavderslik on sinavderslik.sinav_id = sinavyeri.id "+
//				"inner join derslik on derslik.id = sinavderslik.derslik_id "+
//				"inner join gozetmen on gozetmen.sinav_id = sinavyeri.id "+
//				"inner join arastirmagorevlisi on arastirmagorevlisi.id = gozetmen.arastirmagorevlisi_id "+
//				"inner join fakulte on fakulte.id = sinavyeri.fakulte_id ; ";
//		Connection con = ConnectionDatabase.getConnection();
//		try {
//			PreparedStatement psmt = con.prepareStatement(sql);
//			ResultSet rs = psmt.executeQuery();
//			while(rs.next()){
//				Fakulte fakulte = new Fakulte(rs.getInt("f_id"), rs.getString("f_ad"));
//				Ders ders = new Ders(rs.getInt("d_id"), rs.getString("d_ad"));
//				Derslik derslik = new Derslik(rs.getInt("dk_id"), rs.getString("dk_ad"),fakulte);
//				ArastirmaGorevlisi arastirmagorevlisi = new ArastirmaGorevlisi(rs.getInt("ag_id"),rs.getString("ag_ad"), rs.getString("ag_soyad"));
//				Sinav sinav = new Sinav(rs.getInt("s_id"), rs.getString("sinav_tarih"), rs.getString("sinav_saat"), ders, derslik, arastirmagorevlisi);
//				sinavlar.add(sinav);
//			}
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return sinavlar;
//	}
	
	public static ArrayList<Sinav> Sinavlar2(){
		ArrayList<Sinav> sinavlar = new ArrayList<Sinav>();
		String sql = "select sy.id as sy_id, d.id as d_id, d.ad as d_ad, sy.tarih as tarih, "+
					 "f.id as f_id, f.ad as f_ad "+
					 "from sinavyeri sy "+
					 "inner join ders d on d.id = sy.ders_id "+
					 "inner join fakulte f on f.id = sy.fakulte_id "
					 + "where sy.tarih BETWEEN DATE_SUB( CURDATE( ) ,INTERVAL 15 day ) AND CURDATE( )";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Fakulte fakulte = new Fakulte(rs.getInt("f_id"), rs.getString("f_ad"));
				Ders ders = new Ders(rs.getInt("d_id"), rs.getString("d_ad"));
				Sinav sinav = new Sinav(rs.getInt("sy_id"), ders, fakulte, rs.getTimestamp("tarih"));
				sinavlar.add(sinav);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sinavlar;
	}
	
	public static int sinavNoBuilder(){
		String query = "select max(id) as id from sinavyeri";
		Connection con = ConnectionDatabase.getConnection();
		
		int sinavNo = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()){
				sinavNo = rs.getInt("id") + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sinavNo;
	}
	
	public static int SinavEkle(Sinav sinav){
		
		String sqlsinav = "insert into sinavyeri(id,ders_id,fakulte_id,tarih) values(?,?,?,?)";
		String sql = "insert into dersbolum(ders_id,bolum_id) values(?,?)";
		
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			//sinav ekle
			 int sinavNo = SinavDAO.sinavNoBuilder();
			 PreparedStatement psmt = con.prepareStatement(sqlsinav);
			 psmt.setInt(1, sinavNo);
			 psmt.setInt(2, sinav.getDers().getId());
//		     psmt.setString(3, sinav.getSinav_tarih());
//		     psmt.setString(4, sinav.getSinav_saat());
		     psmt.setInt(3, sinav.getFakulte().getId());
		     psmt.setTimestamp(4, new Timestamp(sinav.getTarih().getTime()));
		     psmt.executeUpdate();
		     
		     //dersbolum ekle
		     psmt = con.prepareStatement(sql);
		     psmt.setInt(1, sinav.getDers().getId());
		     psmt.setInt(2, sinav.getBolum().getId());
		     state = psmt.executeUpdate();
		    
		    con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public static int SinavDerslikEkle(Sinav sinav){
		
		String sql = "insert into sinavderslik(derslik_id , sinav_id) "+
				     "values(? , ?); ";
		
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			int sinavNo = SinavDAO.sinavNoBuilder();
			PreparedStatement psmt = con.prepareStatement(sql);
			
			psmt.setInt(1, sinav.getDerslik().getId());
			psmt.setInt(2, sinavNo);
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public static int SinavArsGorEkle(Sinav sinav){
		
		String sql = "insert into gozetmen(arastirmagorevlisi_id , sinav_id) "+
				     "values(? , ?); ";
		
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			int sinavNo = SinavDAO.sinavNoBuilder();
			PreparedStatement psmt = con.prepareStatement(sql);
			
			psmt.setInt(1, sinav.getArastirmagorevlisi().getId());
			psmt.setInt(2, sinavNo);
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	
	public static int SinavDegistir(Sinav sinav){
		
		String sql = "update sinavyeri set tarih=?  where id=?;";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setTimestamp(1, new Timestamp(sinav.getTarih().getTime()));
			psmt.setInt(2, sinav.getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public static ArrayList<Sinav> SinavGoster(){
		ArrayList<Sinav> sinavlar = new ArrayList<Sinav>();
		
		String sql = "select sy.id as sinav_id, d.id as d_id, d.ad as d_ad, sy.tarih as tarih "+ 
				     "from sinavyeri sy "+
				     "inner join ders d on d.id = sy.ders_id ";
				    
		
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Ders ders = new Ders(rs.getInt("d_id"), rs.getString("d_ad"));
				Sinav sinavv = new Sinav(rs.getInt("sinav_id"), ders, rs.getTimestamp("tarih"));
				sinavlar.add(sinavv);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sinavlar;
	}
	
//	public static ArrayList<Sinav> Listele(int sinavID){
//		ArrayList<Sinav> ogrenciler = new ArrayList<Sinav>();
//		String sql = "select o.id as o_id, o.resim as o_resim, o.no as o_no, o.ad as o_ad, "+
//					 "o.soyad as o_soyad, dk.id as dk_id, dk.derslikAd as dk_ad, "+
//					 "syo.sinavyeri_id as syo_id, syo.sira_no as sira_no "+
//					 "from sinavyeri sy "+
//					 "inner join sinavyeri_ogrenci syo on syo.sinavyeri_id = sy.id "+
//					 "inner join derslik dk on syo.derslik_id = dk.id "+
//					 "inner join ogrenci o on o.id = syo.ogrenci_id "+
//					 "inner join ders d on d.id = sy.ders_id "+
//					 "where sy.id = ? "+
//					 "order by dk.derslikAd asc,syo.sira_no asc;";
//		Connection con = ConnectionDatabase.getConnection();
//		try {
//			PreparedStatement psmt = con.prepareStatement(sql);
//			psmt.setInt(1, sinavID);
//			ResultSet rs = psmt.executeQuery();
//			while(rs.next()){
//				Derslik derslik = new Derslik(rs.getInt("dk_id"), rs.getString("dk_ad"));
//				Ogrenci ogrenci = new Ogrenci(rs.getInt("o_id"), 
//						rs.getString("o_no"), rs.getString("o_ad"), rs.getString("o_soyad"));
//				ogrenci.setStreamImg(rs.getBlob("o_resim").getBinaryStream());
////				ArastirmaGorevlisi arastirmagorevlisi = new ArastirmaGorevlisi(rs.getInt("ag_id"), rs.getString("ag_ad"), rs.getString("ag_soyad"));
//				Sinav sinav = new Sinav(rs.getInt("sira_no"), ogrenci, derslik);
//				ogrenciler.add(sinav);
//			}
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return ogrenciler;
//	}
//	

	
	public static ArrayList<Sinav> Listele(int sinavID, int derslikID){
		ArrayList<Sinav> ogrenciler = new ArrayList<Sinav>();
		String sql = "select o.id as o_id, o.resim as o_resim, o.no as o_no, o.ad as o_ad, " +
					 "o.soyad as o_soyad, dk.id as dk_id, dk.derslikAd as dk_ad, " +
					 "syo.sinavyeri_id as syo_id, syo.sira_no as sira_no " +
					 "from sinavyeri sy " +
					 "inner join sinavyeri_ogrenci syo on syo.sinavyeri_id = sy.id " +
					 "inner join derslik dk on syo.derslik_id = dk.id " +
					 "inner join ogrenci o on o.id = syo.ogrenci_id " +
					 "inner join ders d on d.id = sy.ders_id " +
					 "where sy.id = ? and dk.id = ? " +
					 "order by syo.sira_no asc;";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, sinavID);
			psmt.setInt(2, derslikID);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Derslik derslik = new Derslik(rs.getInt("dk_id"), rs.getString("dk_ad"));
				Ogrenci ogrenci = new Ogrenci(rs.getInt("o_id"), 
						rs.getString("o_no"), rs.getString("o_ad"), rs.getString("o_soyad"));
				ogrenci.setStreamImg(rs.getBlob("o_resim").getBinaryStream());
				Sinav sinav = new Sinav(sinavID ,rs.getInt("sira_no"), ogrenci, derslik);
				ogrenciler.add(sinav);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ogrenciler;
	}
	
	public  static ArrayList<Sinav> getSinavDerslik(int sinavID){
		ArrayList<Sinav> derslikler = new ArrayList<Sinav>();
		
		String sql = "select sy.id as sy_id, dk.id as dk_id, dk.derslikAd as dk_ad "+
				     "from sinavyeri sy "+
				     "inner join sinavderslik sd on sd.sinav_id = sy.id "+
				     "inner join derslik dk on sd.derslik_id = dk.id "+
				     "where sy.id=?;";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, sinavID);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Derslik derslik = new Derslik(rs.getInt("dk_id"), rs.getString("dk_ad"));
				Sinav sinav = new Sinav(rs.getInt("sy_id"), derslik);
				derslikler.add(sinav);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return derslikler;
	}
	
	public static ArrayList<Sinav> getSinavArsgor(int sinavID){
		ArrayList<Sinav> arsgor = new ArrayList<Sinav>();
		String sql = "select sy.id as sy_id, ag.id as ag_id, ag.ad as ag_ad, ag.soyad as ag_soyad "+
				     "from sinavyeri sy "+
				     "inner join gozetmen g on g.sinav_id = sy.id "+
				     "inner join arastirmagorevlisi ag on g.arastirmagorevlisi_id = ag.id "+
				     "where sy.id=?;";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, sinavID);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				ArastirmaGorevlisi gozetmen = new ArastirmaGorevlisi(rs.getInt("ag_id"), rs.getString("ag_ad"),rs.getString("ag_soyad"));
				Sinav sinav = new Sinav(rs.getInt("sy_id"), gozetmen);
				arsgor.add(sinav);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arsgor;
		
	}
	
	public static ArrayList<Sinav> Sinavlarr(){
		ArrayList<Sinav> sinavlar = new ArrayList<Sinav>();
		String sql = "select sy.id as sy_id, d.id as d_id, d.ad as d_ad, sy.tarih as tarih, "+
				     "f.id as f_id, f.ad as f_ad "+
				     "from sinavyeri sy "+
				     "inner join ders d on sy.ders_id = d.id "+
				     "inner join fakulte f on sy.fakulte_id = f.id";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Ders ders = new Ders(rs.getInt("d_id"), rs.getString("d_ad"));
				Fakulte fakulte = new Fakulte(rs.getInt("f_id"), rs.getString("f_ad"));
				Sinav sinav = new Sinav(rs.getInt("sy_id"), ders, fakulte, rs.getTimestamp("tarih"));
				sinavlar.add(sinav);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sinavlar;
		
	}
	
	public static int randomOgrenciEkle(int ogrenciID, int derslikID, int siraNo, int sinavID){
		
//		int sinavID = SinavDAO.sinavID(dersID);
		int updateQuery = 0;
		try {
			String sql = "insert into sinavyeri_ogrenci(ogrenci_id, sinavyeri_id, sira_no, derslik_id) "+
						 "values (?,?,?,?)";
			Connection conn = ConnectionDatabase.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ogrenciID);
			psmt.setInt(2, sinavID);
			psmt.setInt(3, derslikID);
			psmt.setInt(4, siraNo);
			updateQuery = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateQuery;
	}
	
	public static ArrayList<Sinav> getSinavID(){
		ArrayList<Sinav> sinavid = new ArrayList<Sinav>();
		
		String sql = "select sy.id as sy_id  from sinavyeri sy;";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Sinav id = new Sinav(rs.getInt("sy_id"));
				sinavid.add(id);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sinavid;
	}
	
	public static int OgrenciSinavBilgileri(Sinav sinav){
		
		String sql ="insert into sinavyeri_ogrenci(ogrenci_id,sinavyeri_id,sira_no,derslik_id) "+
				    "values(?,?,?,?)";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, sinav.getOgrenci().getId());
			psmt.setInt(2, sinav.getId());
			psmt.setInt(3, sinav.getSirano());
			psmt.setInt(4, sinav.getDerslik().getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state; 
	}
	
	public static Sinav GirisBelgesi(int ogrenciID, int sinavID) {
		Sinav sinav = new Sinav();
		String sql = "select d.derslikAd as derslik_ad, f.ad as f_ad, drs.ad as ders_ad, s.ders_id as ders_id, s.tarih as tarih, " +
					 "so.sira_no as sira_no from sinavyeri_ogrenci so " +
					 "inner join derslik d on so.derslik_id = d.id " + 
					 "inner join sinavyeri s on s.id = so.sinavyeri_id " +
					 "inner join ders drs on drs.id = s.ders_id "+
					 "inner join fakulte f on f.id = s.fakulte_id " +
					 "where so.ogrenci_id = ? and s.id = ?";
		Connection conn = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ogrenciID);
			psmt.setInt(2, sinavID);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				Ders ders = new Ders(rs.getInt("ders_id"), rs.getString("ders_ad"));
				Derslik derslik = new Derslik(rs.getString("derslik_ad"));
				Fakulte fakulte = new Fakulte(rs.getString("f_ad"));
				sinav = new Sinav(ders, derslik, rs.getInt("sira_no"), fakulte, rs.getTimestamp("tarih"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sinav;
	}
	
	public static ArrayList<Sinav> OrtakGirisBelgesi(int ogr_id) {
		ArrayList<Sinav> TumSinavlar = new ArrayList<Sinav>();
		String sql = "select d.derslikAd as derslik_ad, f.ad as f_ad, drs.ad as ders_ad, s.ders_id as ders_id, s.tarih as tarih, " +
				 "so.sira_no as sira_no from sinavyeri_ogrenci so " +
				 "inner join derslik d on so.derslik_id = d.id " + 
				 "inner join sinavyeri s on s.id = so.sinavyeri_id " +
				 "inner join ders drs on drs.id = s.ders_id "+
				 "inner join fakulte f on f.id = s.fakulte_id " +
				 "where so.ogrenci_id = ? order by s.tarih ASC";
		Connection conn = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ogr_id);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Ders ders = new Ders(rs.getInt("ders_id"), rs.getString("ders_ad"));
				Derslik derslik = new Derslik(rs.getString("derslik_ad"));
				Fakulte fakulte = new Fakulte(rs.getString("f_ad"));
				Sinav sinav = new Sinav(ders, derslik, rs.getInt("sira_no"), fakulte, rs.getTimestamp("tarih"));
				TumSinavlar.add(sinav);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return TumSinavlar;
	}
	
	public static int DeleteSinav(int sinavID){
		
		String sql = "delete from sinavyeri where id=? ";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, sinavID);
			state = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
}
