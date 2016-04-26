package com.sinavgirisbelgesi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sinavgirisbelgesi.model.Duyuru;

public class DuyuruDAO {
	public static ArrayList<Duyuru> Duyurular(){
		ArrayList<Duyuru> duyurular = new ArrayList<Duyuru>();
		
		String sql = "select * from duyuru";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Duyuru duyuru = new Duyuru(rs.getInt("id"), rs.getString("aciklama"));
				duyurular.add(duyuru);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return duyurular;
		
	}
	
public static int DuyuruDegistir(Duyuru duyuru){
	String sql = "update duyuru set aciklama=? where id=?;";
	Connection con = ConnectionDatabase.getConnection();
	int state = 0;
	try {
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, duyuru.getAciklama());
		psmt.setInt(2, duyuru.getId());
		state = psmt.executeUpdate();
		
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return state;
}

public static int DuyuruSil(int duyuruID){
	String sql = "delete from duyuru where id = ?;";
	Connection con = ConnectionDatabase.getConnection();
	int state = 0 ;
	try {
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setInt(1, duyuruID);
		state = psmt.executeUpdate();
		
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return state;
}

public static int DuyuruEkle(Duyuru duyuru){
	String sql = "insert into duyuru(aciklama) values(?)";
	Connection con = ConnectionDatabase.getConnection();
	int state = 0;
	try {
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, duyuru.getAciklama());
		state = psmt.executeUpdate();
		
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return state;
}
	
}
	

