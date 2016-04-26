package com.sinavgirisbelgesi.model;

import java.io.InputStream;

public class Ogrenci {
	private int id;
	private String ad;
	private String soyad;
	private int sinif;
	private Bolum bolum;
	private InputStream streamImg;
	private Fakulte fakulte;
	private String no;
	private String sifre;
	private String email;
	
	public Ogrenci(){
	}
	
	public Ogrenci(int id){
		super();
		this.id = id;
	}
	
	public Ogrenci(int id,String ad, String soyad, int sinif, String sifre,String email){
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.sinif = sinif;
		this.sifre = sifre;
		this.email = email;
	}
	
	public Ogrenci(int id,String ad, String soyad, int sinif,String email){
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.sinif = sinif;
		this.email = email;
	}
	
	public Ogrenci(int id, String ad, String soyad, int sinif, Bolum bolum, Fakulte fakulte, String no,String email){
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.sinif = sinif;
		this.bolum = bolum;
		this.fakulte = fakulte;
		this.no = no;
		this.email = email;
	}
	
	public Ogrenci( String ad, String soyad, int sinif, Bolum bolum, Fakulte fakulte, String no, String sifre,String email){
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.sinif = sinif;
		this.bolum = bolum;
		this.fakulte = fakulte;
		this.no = no;
		this.sifre = sifre;
		this.email = email;
	}
	public Ogrenci(int id, String no, String ad, String soyad){
		super();
		this.id = id;
		this.no = no;
		this.ad = ad;
		this.soyad = soyad;
	}
	
	public Ogrenci(int id, String ad, String soyad, String no, String sifre) {
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.no = no;
		this.sifre = sifre;
	}
	
	
	public Ogrenci(int id, Bolum bolum, String no, String sifre) {
		super();
		this.id = id;
		this.bolum = bolum;
		this.no = no;
		this.sifre = sifre;
	}

	public Ogrenci(int id, String no, String sifre) {
		super();
		this.id = id;
		this.no = no;
		this.sifre = sifre;
	}

	public Ogrenci(String no, String sifre) {
		super();
		this.no = no;
		this.sifre = sifre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public int getSinif() {
		return sinif;
	}

	public void setSinif(int sinif) {
		this.sinif = sinif;
	}

	public Bolum getBolum() {
		return bolum;
	}

	public void setBolum(Bolum bolum) {
		this.bolum = bolum;
	}

	public InputStream getStreamImg() {
		return streamImg;
	}

	public void setStreamImg(InputStream streamImg) {
		this.streamImg = streamImg;
	}

	public Fakulte getFakulte() {
		return fakulte;
	}

	public void setFakulte(Fakulte fakulte) {
		this.fakulte = fakulte;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
