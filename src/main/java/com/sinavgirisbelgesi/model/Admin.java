package com.sinavgirisbelgesi.model;

public class Admin {
	private int id;
	private String kullaniciAd;
	private String sifre;
	
	public Admin() {
	}
	
	public Admin(int id, String kullaniciAd, String sifre) {
		super();
		this.id = id;
		this.kullaniciAd = kullaniciAd;
		this.sifre = sifre;
	}
	
	public Admin(int id, String kullaniciAd) {
		super();
		this.id = id;
		this.kullaniciAd = kullaniciAd;
	}

	public Admin(String kullaniciAd, String sifre) {
		super();
		this.kullaniciAd = kullaniciAd;
		this.sifre = sifre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	
}
