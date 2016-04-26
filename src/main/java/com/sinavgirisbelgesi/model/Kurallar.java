package com.sinavgirisbelgesi.model;

public class Kurallar {
	private int id;
	private String ad;
	
	public Kurallar(){
		
	}
	
	public Kurallar(int id){
		super();
		this.id = id;
		
	}
	
	public Kurallar(int id, String ad){
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
