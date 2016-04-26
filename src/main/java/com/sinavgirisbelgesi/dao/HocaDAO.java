package com.sinavgirisbelgesi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sinavgirisbelgesi.model.Bolum;
import com.sinavgirisbelgesi.model.Fakulte;
import com.sinavgirisbelgesi.model.Hoca;

public class HocaDAO {

	
	public static ArrayList<Hoca> Hocalar(){
			
			ArrayList<Hoca> hoca = new ArrayList<Hoca>();
			
			try {
				String queryall = "select * from hoca;";
				Connection con = ConnectionDatabase.getConnection();
				PreparedStatement psmt = con.prepareStatement(queryall);
				ResultSet rs = psmt.executeQuery();
				while(rs.next()){
					Hoca hocalar = new Hoca(rs.getInt("id"), rs.getString("ad"), rs.getString("soyad"),
							rs.getString("kullaniciad"));
					hoca.add(hocalar);
				}
				con.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return hoca;
		}

	public static int HocaEkle(Hoca hoca){
		
		String sql = "insert into hoca(ad,soyad,kullaniciad,sifre) values(?,?,?,md5(sha1(?)));";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, hoca.getAd());
			psmt.setString(2, hoca.getSoyad());
			psmt.setString(3, hoca.getKullaniciAd());
			psmt.setString(4, hoca.getSifre());
			state = psmt.executeUpdate();
			
			con.close();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}

	public static int HocaDegistir(Hoca hoca){
		
		String sql = "update hoca set ad=?, soyad=?  where id=?;";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, hoca.getAd());
			psmt.setString(2, hoca.getSoyad());
			psmt.setInt(3, hoca.getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	
	public static int HocaSifreDegistir(int hocaID){
		
		String sql = "update hoca set hoca.sifre=md5(sha1(12345678)) where hoca.id=?;";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, hocaID);
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public static Hoca getHocaControl(String kullaniciAd, String sifre){
		
		Hoca hoca = null;
		String sql = "select * from hoca where kullaniciad=? and sifre=md5(sha1(?))";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, kullaniciAd);
			psmt.setString(2, sifre);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()){
				hoca = new Hoca(rs.getInt("id"), rs.getString("ad"),rs.getString("soyad"), rs.getString("kullaniciad"), rs.getString("sifre"));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hoca;
	}
	
	public static int HocaAyarlar(Hoca hoca){
		
		String sql = "update hoca set ad=?, soyad=?, sifre=md5(sha1(?)) where id=? ;";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, hoca.getAd());
			psmt.setString(2, hoca.getSoyad());
			psmt.setString(3, hoca.getSifre());
			psmt.setInt(4, hoca.getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	public static int HocaAyarlar2(Hoca hoca){
		
		String sql = "update hoca set ad=?, soyad=?  where id=? ;";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, hoca.getAd());
			psmt.setString(2, hoca.getSoyad());
			psmt.setInt(3, hoca.getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}

	public static int DeleteHoca(int hocaID){
		
		String sql = "delete from hoca where id=?";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, hocaID);
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
}
