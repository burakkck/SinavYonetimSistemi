package com.sinavgirisbelgesi.model;

import java.util.Date;


public class Sinav {
	
	private int id;
	private Ders ders;
	private Derslik derslik;
	private String sinav_tarih;
	private String sinav_saat;
	private ArastirmaGorevlisi arastirmagorevlisi;
	private Ogrenci ogrenci;
	private int sirano;
	private Fakulte fakulte;
	private Bolum bolum;
	private Date tarih;
	
	public Bolum getBolum() {
		return bolum;
	}

	public void setBolum(Bolum bolum) {
		this.bolum = bolum;
	}
//////////////////////////////
	
	
	
	public Sinav(Ders ders, Fakulte fakulte, Bolum bolum, Date tarih) {
		super();
		this.ders = ders;
		this.fakulte = fakulte;
		this.bolum = bolum;
		this.tarih = tarih;
	}

	public Sinav(int id, Date tarih) {
		super();
		this.id = id;
		this.tarih = tarih;
	}

	public Sinav(Ders ders, Derslik derslik,int sirano, Fakulte fakulte, Date tarih) {
		super();
		this.ders = ders;
		this.derslik = derslik;
		this.sirano = sirano;
		this.fakulte = fakulte;
		this.tarih = tarih;
	}

	public Sinav(int id, Ders ders, Date tarih) {
		super();
		this.id = id;
		this.ders = ders;
		this.tarih = tarih;
	}

	public Sinav(int id, Ders ders, Fakulte fakulte, Date tarih) {
		super();
		this.id = id;
		this.ders = ders;
		this.fakulte = fakulte;
		this.tarih = tarih;
	}

	/////////////////////////////////
	public Sinav(int id, Ders ders, String sinav_tarih, String sinav_saat,
			Fakulte fakulte) {
		super();
		this.id = id;
		this.ders = ders;
		this.sinav_tarih = sinav_tarih;
		this.sinav_saat = sinav_saat;
		this.fakulte = fakulte;
	}

	public Sinav(int id, String sinav_tarih, String sinav_saat, Ders ders) {
		super();
		this.id = id;
		this.ders = ders;
		this.sinav_tarih = sinav_tarih;
		this.sinav_saat = sinav_saat;
	}
	
	
	
	public Sinav(Ders ders, String sinav_tarih, String sinav_saat,int id) {
		super();
		this.id = id;
		this.ders = ders;
		this.sinav_tarih = sinav_tarih;
		this.sinav_saat = sinav_saat;
	}

	public Sinav(){
	}
	
	public Sinav(int id){
		super();
		this.id = id;
	}
	
	
	public Sinav(int id, Derslik derslik){
		super();
		this.id = id;
		this.derslik = derslik;
	}
	
	public Sinav(int id, Ders ders, Fakulte fakulte, String sinav_tarih, String sinav_saat ){
		super();
		this.id = id;
		this.ders = ders;
		this.fakulte = fakulte;
		this.sinav_tarih = sinav_tarih;
		this.sinav_saat = sinav_saat;
	}
	
	public Sinav(int id, Ogrenci ogrenci, int sirano, Derslik derslik){
		super();
		this.id = id;
		this.ogrenci = ogrenci;
		this.sirano = sirano;
		this.derslik = derslik;
	}
	
	public Sinav(int id, ArastirmaGorevlisi arastirmagorevlisi){
		super();
		this.id = id;
		this.arastirmagorevlisi = arastirmagorevlisi;
	}
	
	public Sinav(int sirano, Ogrenci ogrenci, Derslik derslik, ArastirmaGorevlisi arastirmagorevlisi ){
		super();
		this.sirano = sirano;
		this.ogrenci = ogrenci;
		this.derslik = derslik;
		this.arastirmagorevlisi = arastirmagorevlisi;
	}
	
	public Sinav( String sinav_tarih, String sinav_saat,Ders ders, Derslik derslik, ArastirmaGorevlisi arastirmagorevlisi, Fakulte fakulte ){
		super();
		this.sinav_tarih = sinav_tarih;
		this.sinav_saat = sinav_saat;
		this.ders = ders;
		this.derslik = derslik;
		this.arastirmagorevlisi = arastirmagorevlisi;
		this.fakulte = fakulte;
	}
	
	public Sinav( String sinav_tarih, String sinav_saat,Ders ders,  Fakulte fakulte, Bolum bolum ){
		super();
		this.sinav_tarih = sinav_tarih;
		this.sinav_saat = sinav_saat;
		this.ders = ders;
		this.fakulte = fakulte;
		this.bolum = bolum;
	}
	
	public Sinav(String sinav_tarih, String sinav_saat, Ders ders){
		super();
		this.sinav_tarih = sinav_tarih;
		this.sinav_saat = sinav_saat;
		this.ders = ders;
	}
	public Sinav(int id, String sinav_tarih, String sinav_saat){
		super();
		this.id = id;
		this.sinav_tarih = sinav_tarih;
		this.sinav_saat = sinav_saat;
	}
	
	public Sinav(int id,String sinav_tarih, String sinav_saat, Ders ders, Derslik derslik, ArastirmaGorevlisi arastirmagorevlisi){
		super();
		this.id = id;
		this.sinav_tarih = sinav_tarih;
		this.sinav_saat = sinav_saat;
		this.ders = ders;
		this.derslik = derslik;
		this.arastirmagorevlisi = arastirmagorevlisi;

	}
	public Sinav(String sinav_tarih, String sinav_saat,  Derslik derslik,Ders ders, ArastirmaGorevlisi arastirmagorevlisi){
		super();
		this.sinav_tarih = sinav_tarih;
		this.sinav_saat = sinav_saat;
		this.ders = ders;
		this.derslik = derslik;
		this.arastirmagorevlisi = arastirmagorevlisi;
		
	}
	
	public Sinav(String sinav_tarih, String sinav_saat, Ders ders, Derslik derslik, ArastirmaGorevlisi arastirmagorevlisi){
		super();
		this.sinav_tarih = sinav_tarih;
		this.sinav_saat = sinav_saat;
		this.ders = ders;
		this.derslik = derslik;
		this.arastirmagorevlisi = arastirmagorevlisi;
		this.derslik = derslik;
		
	}
	
	public Sinav(String sinav_tarih, String sinav_saat, Ders ders,  ArastirmaGorevlisi arastirmagorevlisi,Fakulte fakulte){
		super();
		this.sinav_tarih = sinav_tarih;
		this.sinav_saat = sinav_saat;
		this.ders = ders;
		this.arastirmagorevlisi = arastirmagorevlisi;
		this.fakulte = fakulte;
		
	}
	
	public Sinav(int id, int sirano, Ogrenci ogrenci, Derslik derslik){
		super();
		this.id = id;
		this.sirano = sirano;
		this.ogrenci = ogrenci;
		this.derslik = derslik;
	}
	
	
	
	
	public Sinav(Ders ders, Derslik derslik, String sinav_tarih,
			String sinav_saat, int sirano, Fakulte fakulte) {
		super();
		this.ders = ders;
		this.derslik = derslik;
		this.sinav_tarih = sinav_tarih;
		this.sinav_saat = sinav_saat;
		this.sirano = sirano;
		this.fakulte = fakulte;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Ders getDers() {
		return ders;
	}
	public void setDers(Ders ders) {
		this.ders = ders;
	}
	public Derslik getDerslik() {
		return derslik;
	}
	public void setDerslik(Derslik derslik) {
		this.derslik = derslik;
	}
	public String getSinav_tarih() {
		return sinav_tarih;
	}
	public void setSinav_tarih(String sinav_tarih) {
		this.sinav_tarih = sinav_tarih;
	}
	public String getSinav_saat() {
		return sinav_saat;
	}
	public void setSinav_saat(String sinav_saat) {
		this.sinav_saat = sinav_saat;
	}
	public ArastirmaGorevlisi getArastirmagorevlisi() {
		return arastirmagorevlisi;
	}
	public void setArastirmagorevlisi(ArastirmaGorevlisi arastirmagorevlisi) {
		this.arastirmagorevlisi = arastirmagorevlisi;
	}
	
	public Ogrenci getOgrenci() {
		return ogrenci;
	}
	public void setOgrenci(Ogrenci ogrenci) {
		this.ogrenci = ogrenci;
	}
	public int getSirano() {
		return sirano;
	}
	public void setSirano(int sirano) {
		this.sirano = sirano;
	}
	public Fakulte getFakulte() {
		return fakulte;
	}
	public void setFakulte(Fakulte fakulte) {
		this.fakulte = fakulte;
	}
	
	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
}
