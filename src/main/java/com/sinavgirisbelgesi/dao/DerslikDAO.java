package com.sinavgirisbelgesi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sinavgirisbelgesi.model.Derslik;
import com.sinavgirisbelgesi.model.Fakulte;
import com.sinavgirisbelgesi.model.Sinav;

public class DerslikDAO {

	public static ArrayList<Derslik> Derslikler(){
		
		ArrayList<Derslik> derslikler = new ArrayList<Derslik>();
		
		try {
			String queryall = "select d.id as d_id, d.derslikAd as d_ad, d.sirasayisi, f.id as f_id, f.ad as f_ad "+
							  "from derslik d "+
							  "inner join fakulte f on f.id = d.fakulte_id;";
			Connection con = ConnectionDatabase.getConnection();
			PreparedStatement psmt = con.prepareStatement(queryall);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Fakulte fakulte = new Fakulte(rs.getInt("f_id"), rs.getString("f_ad"));
				Derslik derslik = new Derslik(rs.getInt("d_id"), rs.getString("d_ad"), rs.getInt("sirasayisi"), fakulte);
				derslikler.add(derslik);
				
			}
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return derslikler;
	}

	public static int DerslikEkle(Derslik derslik){
	
		String sql = "insert into derslik(derslikAd,siraSayisi,fakulte_id) values(?,?,?);";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, derslik.getDerslikAd());
			psmt.setInt(2, derslik.getSiraSayisi());
			psmt.setInt(3, derslik.getFakulte().getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return state;
	}

	public static int DerslikDegistir(Derslik derslik){
	
		String sql = "update derslik set derslikAd=?, siraSayisi=? where id=?;";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, derslik.getDerslikAd());
			psmt.setInt(2, derslik.getSiraSayisi());
			psmt.setInt(3, derslik.getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	public static ArrayList<Derslik> SinavaAitDerslikler(int sinavID){
		
		ArrayList<Derslik> derslikler = new ArrayList<Derslik>();
		String sql = "select  dk.id as dk_id, dk.derslikAd as dk_ad "+
				     "from sinavyeri sy "+
//				     "inner join ders d on d.id = sy.ders_id "+
				     "inner join sinavderslik sd on sd.sinav_id = sy.id "+
				     "inner join derslik dk on dk.id = sd.derslik_id "+
				     "where sy.id =? ";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, sinavID);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Derslik derslik = new Derslik(rs.getInt("dk_id"), rs.getString("dk_ad"));
				derslikler.add(derslik);
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return derslikler;
	}
	
	public static ArrayList<Derslik> SinavinDersineAitDerslikler(int sinavID){
		ArrayList<Derslik> derslikler = new ArrayList<Derslik>();
		String sql = "select d.id as d_id, d.ad as d_ad, dk.id as dk_id, dk.derslikAd as dk_ad, "+
				     "dk.siraSayisi as dk_sirasayisi "+
				     "from sinavyeri sy "+
				     "inner join ders d on sy.ders_id = d.id "+
				     "inner join sinavderslik sd on sd.sinav_id = sy.id "+
				     "inner join derslik dk on sd.derslik_id = dk.id "+
				     "where sy.id = ?;";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, sinavID);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Derslik derslik = new Derslik(rs.getInt("dk_id"), rs.getInt("dk_sirasayisi"));
				derslikler.add(derslik);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return derslikler;
	}
	
	public static int DeleteDerslik(int derslikID){
		
		String sql = "delete from derslik where id=?";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, derslikID);
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
	
}
