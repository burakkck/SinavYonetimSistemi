package com.sinavgirisbelgesi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sinavgirisbelgesi.model.Admin;

public class AdminDAO {
	public static Admin getAdminControl(String kullaniciAd, String sifre){
		Admin admin = null;
		String query ="select * from admin where kullaniciAd=? and  sifre=md5(sha1(?)) ";
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement psmt ;
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, kullaniciAd);
			psmt.setString(2, sifre);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()){
				admin = new Admin(rs.getInt("id"),rs.getString("kullaniciAd"),rs.getString("sifre"));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
	
	public static int AdminAyarlar(Admin admin){
		
		String sql = "update admin set kullaniciAd=?, sifre=? where id=?";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, admin.getKullaniciAd());
			psmt.setString(2, admin.getSifre());
			psmt.setInt(3, admin.getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public static int AdminAyarlar2(Admin admin){
		
		String sql = "update admin set kullaniciAd=? where id=?";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, admin.getKullaniciAd());
			psmt.setInt(2, admin.getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	}

