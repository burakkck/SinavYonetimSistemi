package com.sinavgirisbelgesi.model;

public class Duyuru {
	private int id;
	private String aciklama;
	
	public Duyuru(){
		
	}
	
	public Duyuru(int id){
		super();
		this.id = id;
	}
	
	public Duyuru(int id, String aciklama){
		super();
		this.id = id;
		this.aciklama = aciklama;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
}


