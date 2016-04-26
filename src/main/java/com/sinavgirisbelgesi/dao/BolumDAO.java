package com.sinavgirisbelgesi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sinavgirisbelgesi.model.Bolum;
import com.sinavgirisbelgesi.model.Fakulte;

public class BolumDAO {
	
	public static ArrayList<Bolum> Bolumler(){
		ArrayList<Bolum> bolumler = new ArrayList<Bolum>();
		
		String sql = "select b.id as b_id, b.ad as b_ad, f.id as f_id, f.ad as f_ad "+
					 "from bolum b "+
					 "inner join fakulte f on f.id = b.fakulte_id;";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Fakulte fakulte = new Fakulte(rs.getInt("f_id"), rs.getString("f_ad"));
				Bolum bolum = new Bolum(rs.getInt("b_id"), rs.getString("b_ad"), fakulte);
				bolumler.add(bolum);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bolumler;
	}
	
	public static int BolumDegistir(Bolum bolum){
		
		String sql = "update bolum set ad=? where id=?;";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, bolum.getAd());
			psmt.setInt(2, bolum.getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	
	public static int DeleteBolum(int bolumID){
		
		String sql = "delete from bolum where id = ?";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, bolumID);
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public static ArrayList<Bolum> getBolumbyFakulteidID(int fakulteID){
		ArrayList<Bolum> bolumler = new ArrayList<Bolum>();
		Connection con = ConnectionDatabase.getConnection();
		String sql = "select * from bolum where fakulte_id = ?;";
		
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, fakulteID);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Fakulte fakulte = new Fakulte();
				fakulte.setId(fakulteID);
				Bolum bolum = new Bolum(rs.getInt("id"), rs.getString("ad"), fakulte);
				bolumler.add(bolum);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bolumler;
	}
	
	public static int bolumNoBuilder(){
		String query = "select max(id) as id from bolum";
		Connection con = ConnectionDatabase.getConnection();
		
		int bolumNo = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()){
				bolumNo = rs.getInt("id") + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bolumNo;
	}
	
	public static int BolumEkle(Bolum bolum){
		
		String sql = "insert into bolum(id,ad,fakulte_id) values(?,?,?)";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			int bolumID = BolumDAO.bolumNoBuilder();
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, bolumID);
			psmt.setString(2, bolum.getAd());
			psmt.setInt(3, bolum.getFakulte().getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
}
