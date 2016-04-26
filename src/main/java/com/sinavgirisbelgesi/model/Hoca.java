package com.sinavgirisbelgesi.model;

public class Hoca {
	private int id;
	private String ad;
	private String soyad;
	private String kullaniciAd;
	private String sifre;
	private Bolum bolum;
	private Ders ders;
	
	public Hoca(){	
		
	}
	public Hoca(int id, String ad, String soyad){
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
	}
	
	public Hoca(int id, String ad, String soyad, String kullaniciAd){
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.kullaniciAd = kullaniciAd;
	}
	public Hoca( String ad,int id, String soyad, String sifre){
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.sifre = sifre;
	}
	
	public Hoca( String ad, String soyad, String kullaniciAd, String sifre){
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.kullaniciAd = kullaniciAd;
		this.sifre = sifre;
	}
	public Hoca( int id,String ad, String soyad, String kullaniciAd, String sifre){
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.kullaniciAd = kullaniciAd;
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

	public String getKullaniciAd() {
		return kullaniciAd;
	}

	public void setKullaniciAd(String kullaniciAd) {
		this.kullaniciAd = kullaniciAd;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
	public Bolum getBolum() {
		return bolum;
	}
	
	public void setBolum(Bolum bolum) {
		this.bolum = bolum;
	}
	public Ders getDers() {
		return ders;
	}
	public void setDers(Ders ders) {
		this.ders = ders;
	}
}

