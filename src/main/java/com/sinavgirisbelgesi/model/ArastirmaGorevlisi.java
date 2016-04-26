package com.sinavgirisbelgesi.model;

public class ArastirmaGorevlisi {
	private int id;
	private String ad;
	private String soyad;
	private Bolum bolum;
	private String ad1;
	private String soyad1;
	private int id1;
	
	public ArastirmaGorevlisi(){
		
	}
	public ArastirmaGorevlisi(int id){
		super();
		this.id = id;
	}
	

	
	public ArastirmaGorevlisi( String ad1,int id1, String soyad1){
		super();
		this.id1 = id1;
		this.ad1 = ad1;
		this.soyad1 = soyad1;
	}

	public ArastirmaGorevlisi(int id, String ad, String soyad, Bolum bolum){
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.bolum = bolum;
	}
	public ArastirmaGorevlisi(String ad, String soyad, Bolum bolum){
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.bolum = bolum;
	}
	public ArastirmaGorevlisi(int id, String ad, String soyad ){
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
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

	public Bolum getBolum() {
		return bolum;
	}

	public void setBolum(Bolum bolum) {
		this.bolum = bolum;
	}
	
	public String getAd1() {
		return ad1;
	}
	public void setAd1(String ad1) {
		this.ad1 = ad1;
	}
	public String getSoyad1() {
		return soyad1;
	}
	public void setSoyad1(String soyad1) {
		this.soyad1 = soyad1;
	}
	
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}

}
