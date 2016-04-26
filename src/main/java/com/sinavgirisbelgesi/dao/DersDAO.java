package com.sinavgirisbelgesi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sinavgirisbelgesi.model.Ders;
import com.sinavgirisbelgesi.model.Ogrenci;

public class DersDAO {

	public static ArrayList<Ders> Dersler(){
		ArrayList<Ders> dersler = new ArrayList<Ders>();
		
		String sql ="select * from ders;";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Ders ders = new Ders(rs.getInt("id"), rs.getString("ad"));
				dersler.add(ders);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dersler;
	}
	
	public static int DersEkle(Ders ders){
		String sql = "insert into ders(ad) values(?);";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, ders.getAd());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public static int DersDegistir(Ders ders){
		
		String sql = "update ders set ad=? where id=?;";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, ders.getAd());
			psmt.setInt(2, ders.getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public static int DersSil(int dersID){
		
		String sql = "delete from ders where id=?;";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, dersID);
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public static ArrayList<Ders> SecilmemisBolumDersler(int bolum_id, int ogrenci_id){
		ArrayList<Ders> dersler = new ArrayList<Ders>();
		
		try {
			String query = "select d.id as d_id, d.ad as d_ad from dersbolum db inner join ders d on db.ders_id = d.id " +
							"inner join bolum b on db.bolum_id = b.id where b.id = ? " +
							"and d.ad not in (select d.ad from ogrenciders od inner join ders d on od.ders_id = d.id where od.ogrenci_no = ? );";
			Connection conn = ConnectionDatabase.getConnection();
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1, bolum_id);
			psmt.setInt(2, ogrenci_id);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Ders ders = new Ders(rs.getInt("d_id"), rs.getString("d_ad"));
				dersler.add(ders);
				
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dersler;
	}
	
	public static Ders getDersbyid(String ders_id){
		Ders ders = null;
		try {
			String query = "select d.id as d_id, d.ad as d_ad from ders d where d.id = ?";
			Connection conn = ConnectionDatabase.getConnection();
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, ders_id);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				ders = new Ders(rs.getInt("d_id"), rs.getString("d_ad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ders;
	}
	
	public static ArrayList<Ders> SecilmisDersler(Ogrenci ogr) {
		ArrayList<Ders> secilendersler = new ArrayList<Ders>();
		try {
			Connection conn = ConnectionDatabase.getConnection();
			String query = "select d.id as d_id, d.ad as d_ad from ogrenciders od inner join ders d on od.ders_id = d.id where od.ogrenci_no = ?";
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1, ogr.getId());
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Ders ders = new Ders(rs.getInt("d_id"), rs.getString("d_ad"));
				secilendersler.add(ders);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return secilendersler;
	}
	
	public static int deleteDers (int ders_id) {
		int updateQuery = 0 ;
		try {
			String query = "delete from ogrenciders where ders_id = ?";
			Connection conn = ConnectionDatabase.getConnection();
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setInt(1, ders_id);
			updateQuery = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateQuery;
	}
	
	public static Ders getDersbySinavID(int sinavID){
		Ders ders = null;
		String sql ="select d.id as d_id, d.ad as d_ad from sinavyeri sy "+
				    "inner join ders d on sy.ders_id = d.id "+
				    "where sy.id = ?;";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, sinavID);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()){
				ders = new Ders(rs.getInt("d_id"), rs.getString("d_ad"));
		}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ders;
	}
	
	public static int getAvailableDers(String dersad){
		
		String sql = "select count(*) as status from ders d where d.ad=? ;";
		Connection con = ConnectionDatabase.getConnection();
		int status = -1;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, dersad);
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
