package com.sinavgirisbelgesi.model;

public class Bolum {
	private int id;
	private String ad;
	private Fakulte fakulte;
	
	public Bolum(){
		
	}
	public Bolum (int id){
		super();
		this.id = id;
	}
	
	public Bolum (String ad){
		super();
		this.ad = ad;
	}
	
	public Bolum (int id, String ad){
		super();
		this.id = id;
		this.ad = ad;
	}
	
	public Bolum(int id, String ad, Fakulte fakulte){
		super();
		this.id = id;
		this.ad = ad;
		this.fakulte = fakulte;
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

	public Fakulte getFakulte() {
		return fakulte;
	}

	public void setFakulte(Fakulte fakulte) {
		this.fakulte = fakulte;
	}
	

}
