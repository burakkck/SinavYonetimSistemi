package com.sinavgirisbelgesi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sinavgirisbelgesi.model.Fakulte;

public class FakulteDAO {

	public static ArrayList<Fakulte> Fakulteler(){
		ArrayList<Fakulte> fakulteler = new ArrayList<Fakulte>();
		
		String sql = "select * from fakulte;";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Fakulte fakulte = new Fakulte(rs.getInt("id"), rs.getString("ad"));
				fakulteler.add(fakulte);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fakulteler;
	}
	
	public static int FakulteEkle(Fakulte fakulte){
		
		String sql = "insert into fakulte(ad) values(?)";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, fakulte.getAd());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public static int DeleteFakulte(int fakulteID){
		String sql = "delete from fakulte where id=? ";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, fakulteID);
			state = psmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public static int FakulteDegistir(Fakulte fakulte){
		String sql = "update fakulte set ad=? where id=?";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, fakulte.getAd());
			psmt.setInt(2, fakulte.getId());
			state = psmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
}
