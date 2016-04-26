package com.sinavgirisbelgesi.model;

public class Ders {
	private int id;
	private String ad;
	
	public Ders(){
		
	}
	public Ders(String ad){
		super();
		this.ad = ad;
	}
	public Ders(int id){
		super();
		this.id = id;
	}
	
	public Ders(int id, String ad){
		super();
		this.id = id;
		this.ad = ad;
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
	
}
