package com.sinavgirisbelgesi.model;

public class Fakulte {
	private int id;
	private String ad;
	
	public Fakulte(){
		
	}
	public Fakulte (int id){
		super();
		this.id = id;
	}
	
	public Fakulte (int id, String ad){
		super();
		this.id = id;
		this.ad = ad;
	}

	public Fakulte ( String ad){
		super();
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
