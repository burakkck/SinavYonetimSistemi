package com.sinavgirisbelgesi.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sinavgirisbelgesi.model.ArastirmaGorevlisi;
import com.sinavgirisbelgesi.model.Bolum;
import com.sinavgirisbelgesi.model.Fakulte;
import com.sinavgirisbelgesi.model.Sinav;


public class ArastirmaGorevlisiDAO {

public static ArrayList<ArastirmaGorevlisi> ArastirmaGorevlileri(){
		
		ArrayList<ArastirmaGorevlisi> arastirmagorevlileri = new ArrayList<ArastirmaGorevlisi>();
		
		try {
			String queryall = "select ag.id as ag_id , ag.ad as ag_ad, ag.soyad as ag_soyad, "+ 
							  "b.id as b_id, b.ad as b_ad, f.id as f_id,f.ad as f_ad from arastirmagorevlisi ag "+
							  "inner join bolum b on b.id=ag.bolum_id "+
							  "inner join fakulte f on f.id = b.fakulte_id;";
			Connection con = ConnectionDatabase.getConnection();
			PreparedStatement psmt = con.prepareStatement(queryall);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
				Fakulte fakulte = new Fakulte(rs.getInt("f_id"), rs.getString("f_ad"));
				Bolum bolum = new Bolum(rs.getInt("b_id"), rs.getString("b_ad"), fakulte);
				ArastirmaGorevlisi arastirmagorevlisi = new ArastirmaGorevlisi(rs.getInt("ag_id"),
						rs.getString("ag_ad"), rs.getString("ag_soyad"), bolum);
				arastirmagorevlileri.add(arastirmagorevlisi);
				
			}
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return arastirmagorevlileri;
		
	}

	public static int ArastirmaGorevlisiEkle(ArastirmaGorevlisi arastirmagorevlisi){
		
		String sql ="insert into arastirmagorevlisi(ad,soyad,bolum_id) values(?,?,?)";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, arastirmagorevlisi.getAd());
			psmt.setString(2, arastirmagorevlisi.getSoyad());
			psmt.setInt(3, arastirmagorevlisi.getBolum().getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	
	public static int ArastirmaGorevlisiDegistir(ArastirmaGorevlisi arastirmagorevlisi){
		
		String sql = "update arastirmagorevlisi set ad=?, soyad=?  where id=?;";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, arastirmagorevlisi.getAd());
			psmt.setString(2, arastirmagorevlisi.getSoyad());
			psmt.setInt(3, arastirmagorevlisi.getId());
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	
	public static ArrayList<ArastirmaGorevlisi> ArsGorSinav(int sinavID){
		
		ArrayList<ArastirmaGorevlisi> arastirmagorevlileri = new ArrayList<ArastirmaGorevlisi>();
		String sql = "select ag.id as ag_id from sinavyeri sy "+
				     "inner join gozetmen g on g.sinav_id = sy.id "+
				     "inner join arastirmagorevlisi ag on ag.id = g.arastirmagorevlisi_id "+
				     "where sy.id= ? ;";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, sinavID);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
			ArastirmaGorevlisi arsgor = new ArastirmaGorevlisi(rs.getInt("ag_id"));
			arastirmagorevlileri.add(arsgor);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  arastirmagorevlileri;
	}
	
	public static ArrayList<ArastirmaGorevlisi> SinavaAitArsGor(int sinavID){
		
		ArrayList<ArastirmaGorevlisi> arastirmagorevlileri = new ArrayList<ArastirmaGorevlisi>();
		String sql = "select ag.id as ag_id, ag.ad as ag_ad, ag.soyad as ag_soyad "+
				     "from sinavyeri sy "+
				     "inner join gozetmen g on g.sinav_id = sy.id "+
				     "inner join arastirmagorevlisi ag on ag.id = g.arastirmagorevlisi_id "+ 
				     "where sy.id= ? ;";
		Connection con = ConnectionDatabase.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, sinavID);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()){
			ArastirmaGorevlisi arsgor = new ArastirmaGorevlisi(rs.getInt("ag_id"),rs.getString("ag_ad"),rs.getString("ag_soyad"));
			arastirmagorevlileri.add(arsgor);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  arastirmagorevlileri;
	}
	
	public static int DeleteArsGor(int arsgorID){
		
		String sql = "delete from arastirmagorevlisi where id = ?";
		Connection con = ConnectionDatabase.getConnection();
		int state = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, arsgorID);
			state = psmt.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}
}
