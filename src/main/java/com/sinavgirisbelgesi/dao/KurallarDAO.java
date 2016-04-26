package com.sinavgirisbelgesi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sinavgirisbelgesi.model.Kurallar;

public class KurallarDAO {

	public static ArrayList<Kurallar> Kurallar(){
		ArrayList<Kurallar> kurallar = new ArrayList<Kurallar>();
		String sql = "select * from kural";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Kurallar kural = new Kurallar(rs.getInt("id"), rs.getString("ad"));
				kurallar.add(kural);
				
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kurallar;
	}
	
	public static int KuralDegistir(Kurallar kural){
		String sql = "update kural set ad=? where id=?;";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, kural.getAd());
			psmt.setInt(2, kural.getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public static int KuralSil(int kuralID){
		
		String sql = "delete from kural where id=?";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, kuralID);
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;	
		}
	
	public static int KuralEkle(Kurallar kural){
		String sql = "insert into kural(ad) values(?)";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, kural.getAd());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
}
