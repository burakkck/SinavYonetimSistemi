package com.sinavgirisbelgesi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sinavgirisbelgesi.model.Bolum;
import com.sinavgirisbelgesi.model.Ders;
import com.sinavgirisbelgesi.model.Fakulte;
import com.sinavgirisbelgesi.model.Ogrenci;
import com.sinavgirisbelgesi.model.Sinav;


public class OgrenciDAO {

	
	public static ArrayList<Ogrenci> Ogrenciler(){
			
			ArrayList<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
			
			try {
				String queryall = "select o.id as o_id, o.no, o.ad as o_ad, o.soyad as o_soyad, o.sinif,o.email, b.id as b_id, b.ad as b_ad, "+ 
								  "f.id as f_id, f.ad as f_ad "+ 
								  "from ogrenci o "+
								  "inner join bolum b on b.id = o.bolum_id "+
								  "inner join fakulte f on f.id = o.fakulte_id;";
				Connection con = ConnectionDatabase.getConnection();
				PreparedStatement psmt = con.prepareStatement(queryall);
				ResultSet rs = psmt.executeQuery();
				while(rs.next()){
						Fakulte fakulte = new Fakulte(rs.getInt("f_id"), rs.getString("f_ad"));
						Bolum bolum = new Bolum(rs.getInt("b_id"), rs.getString("b_ad"), fakulte);
						Ogrenci ogrenci = new Ogrenci(rs.getInt("o_id"), rs.getString("o_ad"), rs.getString("o_soyad"), rs.getInt("sinif"), bolum, fakulte, rs.getString("no"),rs.getString("email"));
						ogrenciler.add(ogrenci);
				}
				con.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return ogrenciler;
		}
	
	public static int OgrenciSifreDegistir(int ogrenciID){
		
		String sql = "update ogrenci set ogrenci.sifre=md5(sha1(12345678)) where ogrenci.id=?;";
		
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, ogrenciID);
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	
	public static byte[] getImageByOgrenciId(int ogrenciID ){
		String query = "select resim from ogrenci where id=?";
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement psmt;
		byte[] bytesImage = null;
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, ogrenciID);
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()){
				bytesImage = rs.getBytes("resim");
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bytesImage;
	}
	
	public static Ogrenci getOgrenciControl(String kullaniciAd, String sifre) {
		Ogrenci ogrenci = null;
		String query = "select o.id as o_id, o.ad as o_ad, o.soyad as o_soyad, o.sinif as o_sinif,o.email, o.resim as resim, f.ad as f_ad, " +
					   "f.id as f_id, b.id as b_id, " +
				       "b.ad as b_ad, o.no as o_no, o.sifre as o_sifre from ogrenci o " +
					   "inner join fakulte f on f.id = o.fakulte_id " +
					   "inner join bolum b on o.bolum_id = b.id where o.no = ? and o.sifre= md5(sha1(?))";
		Connection conn = ConnectionDatabase.getConnection();
		PreparedStatement psmt ;
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, kullaniciAd);
			psmt.setString(2, sifre);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				Fakulte fakulte = new Fakulte(rs.getInt("f_id"), rs.getString("f_ad"));
				Bolum bolum = new Bolum(rs.getInt("b_id"), rs.getString("b_ad"), fakulte);
				ogrenci = new Ogrenci(rs.getInt("o_id"), rs.getString("o_ad"), rs.getString("o_soyad"), rs.getInt("o_sinif"), bolum, fakulte, rs.getString("o_no"),rs.getString("email"));
				ogrenci.setStreamImg(rs.getBlob("resim").getBinaryStream());
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ogrenci;
	}
		
	
	public static Bolum getOgrenciBolum(int ogr_id){
		Bolum bolum = null;
		try {
			String queryall = "select o.id as o_id, o.no, o.ad as o_ad, o.soyad as o_soyad, o.sinif, b.id as b_id, b.ad as b_ad, "+ 
					  "f.id as f_id, f.ad as f_ad "+ 
					  "from ogrenci o "+
					  "inner join bolum b on b.id = o.bolum_id "+
					  "inner join fakulte f on f.id = o.fakulte_id where o.id= ?";
			Connection conn = ConnectionDatabase.getConnection();
			PreparedStatement psmt = conn.prepareStatement(queryall);
			psmt.setInt(1, ogr_id);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){	
				bolum = new Bolum(rs.getInt("b_id"), rs.getString("b_ad"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bolum;
	}
	
	public static int addOgrenci (Ogrenci ogr){
		String query = "insert into ogrenci(ad, soyad, sinif, bolum_id, resim, fakulte_id, no, sifre,email) values (?,?,?,?,?,?,?,md5(sha1(?)),?)";
		Connection conn = ConnectionDatabase.getConnection();
		int UpdateQuery = 0;
		try {
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, ogr.getAd());
			psmt.setString(2, ogr.getSoyad());
			psmt.setInt(3, ogr.getSinif());
			psmt.setInt(4, ogr.getBolum().getId());
			psmt.setBlob(5, ogr.getStreamImg());
			psmt.setInt(6, ogr.getFakulte().getId());
			psmt.setString(7, ogr.getNo());
			psmt.setString(8, ogr.getSifre());
			psmt.setString(9, ogr.getEmail());
			UpdateQuery = psmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UpdateQuery;
	}
	
	public static int addOgrenciDers (Ogrenci ogr, Ders ders){
		int UpdateQuery = 0;
		try {
			String query = "insert into ogrenciders(ders_id, ogrenci_no) values(?,?)";
			Connection conn = ConnectionDatabase.getConnection();
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1, ders.getId());
			psmt.setInt(2, ogr.getId());
			UpdateQuery = psmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UpdateQuery;
	}
	
	public static int OgreciAyarlar(Ogrenci ogrenci){
		
		String sql = "update ogrenci set ad=?, soyad=?, sinif=?, sifre=md5(sha1(?)),email=? where id=?;";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, ogrenci.getAd());
			psmt.setString(2, ogrenci.getSoyad());
			psmt.setInt(3, ogrenci.getSinif());
			psmt.setString(4, ogrenci.getSifre());
			psmt.setString(5, ogrenci.getEmail());
			psmt.setInt(6, ogrenci.getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public static int OgreciAyarlar2(Ogrenci ogrenci){
		
		String sql = "update ogrenci set ad=?, soyad=?, sinif=?,email=? where id=?;";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, ogrenci.getAd());
			psmt.setString(2, ogrenci.getSoyad());
			psmt.setInt(3, ogrenci.getSinif());
			psmt.setString(4, ogrenci.getEmail());
			psmt.setInt(5, ogrenci.getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public static ArrayList<Ogrenci> SinavaGirenOgrenciler(int dersID){
		ArrayList<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
		
		String sql = "select o.id as o_id, o.ad as o_ad, o.soyad as o_soyad, d.id as d_id, "+
				     "d.ad as d_ad "+
				     "from ogrenciders od "+
				     "inner join ogrenci o on od.ogrenci_no = o.id "+
				     "inner join ders d on od.ders_id = d.id where d.id = ?;";
		
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement psmt;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, dersID);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Ogrenci ogrenci = new Ogrenci(rs.getInt("o_id"));
				ogrenciler.add(ogrenci);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ogrenciler;
	}
	
	public static int DeleteOgrenci(int ogrenciID){
		
		String sql = "delete from ogrenci where id = ?";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, ogrenciID);
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public static ArrayList<Sinav> OgrencininGirecegiSinavlar(int ogrenciID) {
		ArrayList<Sinav> sinavlar = new ArrayList<Sinav>();
		String sql = "select d.ad as d_ad, s.id as s_id, s.tarih as tarih from sinavyeri s " +
				 "inner join sinavyeri_ogrenci syo on s.id = syo.sinavyeri_id " +
				 "inner join ders d on s.ders_id = d.id where syo.ogrenci_id = ?";
		Connection conn = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ogrenciID);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Ders ders = new Ders(rs.getString("d_ad"));
				Sinav sinav = new Sinav(rs.getInt("s_id"),ders, rs.getTimestamp("tarih") );
				sinavlar.add(sinav);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sinavlar;
	}
	
	public static int getEmailAvailablebyEmail(String email){
		
		String sql = "select count(*) as email from ogrenci o where o.email=? ;";
		Connection con = ConnectionDatabase.getConnection();
		int status = -1;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, email);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()){
				status = rs.getInt("email");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(status == 1){
			return 0;
		}else{
			return 1;
		}
	}
	
	public static int getAvailableOgrenciNo(String ogrenciNo){
		
		String sql = "select count(*) as status from ogrenci o where o.no=? ;";
		Connection con = ConnectionDatabase.getConnection();
		int status = -1;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, ogrenciNo);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()){
				status = rs.getInt("status");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(status == 1){
			return 0;
		}else{
			return 1;
		}
	}
	
}
