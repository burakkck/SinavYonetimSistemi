package com.sinavgirisbelgesi.model;

public class Derslik {
	private int id;
	private String derslikAd;
	private int siraSayisi;
	private Fakulte fakulte;
	
	public Derslik(){
		
	}
	
	public Derslik(int id){
		super();
		this.id = id;
	}
	public Derslik(int id, int siraSayisi){
		super();
		this.id = id;
		this.siraSayisi = siraSayisi;
	}
	public Derslik(String derslikAd){
		super();
		this.derslikAd = derslikAd;
	}
	
	public Derslik(int id, String derslikAd){
		super();
		this.id = id;
		this.derslikAd = derslikAd;
	}
	
//	public Derslik(String derslikAd1, int id1 ){
//		super();
//		this.id1 = id1;
//		this.derslikAd1 = derslikAd1;
//	}
	

	
	public Derslik(int id, String derslikAd, int siraSayisi){
		super();
		this.id = id;
		this.derslikAd = derslikAd;
		this.siraSayisi = siraSayisi;
	}
	
	public Derslik(int id, String derslikAd, int siraSayisi, Fakulte fakulte){
		super();
		this.id = id;
		this.derslikAd = derslikAd;
		this.siraSayisi = siraSayisi;
		this.fakulte = fakulte;
	}
	
	public Derslik(String derslikAd, int siraSayisi, Fakulte fakulte){
		super();
		this.derslikAd = derslikAd;
		this.siraSayisi = siraSayisi;
		this.fakulte = fakulte;
	}
	
	public Derslik(int id, String derslikAd, Fakulte fakulte){
		super();
		this.id = id;
		this.derslikAd = derslikAd;
		this.fakulte = fakulte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDerslikAd() {
		return derslikAd;
	}

	public void setDerslikAd(String derslikAd) {
		this.derslikAd = derslikAd;
	}

	public int getSiraSayisi() {
		return siraSayisi;
	}

	public void setSiraSayisi(int siraSayisi) {
		this.siraSayisi = siraSayisi;
	}

	public Fakulte getFakulte() {
		return fakulte;
	}

	public void setFakulte(Fakulte fakulte) {
		this.fakulte = fakulte;
	}
//	public int getId1() {
//		return id1;
//	}
//	public void setId1(int id1) {
//		this.id1 = id1;
//	}
//	public String getDerslikAd1() {
//		return derslikAd1;
//	}
//	public void setDerslikAd1(String derslikAd1) {
//		this.derslikAd1 = derslikAd1;
//	}
//	public int getId2() {
//		return id2;
//	}
//	public void setId2(int id2) {
//		this.id2 = id2;
//	}
//	public String getDerslikAd2() {
//		return derslikAd2;
//	}
//	public void setDerslikAd2(String derslikAd2) {
//		this.derslikAd2 = derslikAd2;
//	}

}
