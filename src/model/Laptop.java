package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Laptopy")
public class Laptop extends Sprzet {

	@Column(name = "Plyta_glowna")
	private String plytaGlowna;

	@Column(name = "Procesor")
	private String procesor;

	@Column(name = "Ilosc_ram")
	private String iloscRam;

	@Column(name = "Producent_ram")
	private String producentRam;

	@Column(name = "Typ_ram")
	private String typRam;

	@Column(name = "Dysk_twardy")
	private String dyskTwardy;

	@Column(name = "Karta_graficzna")
	private String kartaGraficzna;

	@Column(name = "Naped")
	private String naped;

	@Column(name = "Bateria")
	private String bateria;

	@Column(name = "Zasilacz")
	private String zasilacz;

	// KONSTRUKTORY********************************

	public Laptop() {

	}

	public Laptop(String nazwa, double wartosc, String numerSeryjny, String opis, Date dataGwarancji,
			MagazynSprzetu magazyn, String plytaGlowna, String procesor, String iloscRam, String producentRam,
			String typRam, String dyskTwardy, String kartaGraficzna, String naped, String bateria, String zasilacz) {
		super(nazwa, wartosc, numerSeryjny, opis, dataGwarancji, magazyn);
		this.plytaGlowna = plytaGlowna;
		this.procesor = procesor;
		this.iloscRam = iloscRam;
		this.producentRam = producentRam;
		this.typRam = typRam;
		this.dyskTwardy = dyskTwardy;
		this.kartaGraficzna = kartaGraficzna;
		this.naped = naped;
		this.bateria = bateria;
		this.zasilacz = zasilacz;
	}



	// SETTERY I GETTERY

	public String getPlytaGlowna() {
		return plytaGlowna;
	}

	public void setPlytaGlowna(String plytaGlowna) {
		this.plytaGlowna = plytaGlowna;
	}

	public String getProcesor() {
		return procesor;
	}

	public void setProcesor(String procesor) {
		this.procesor = procesor;
	}

	public String getIloscRam() {
		return iloscRam;
	}

	public void setIloscRam(String iloscRam) {
		this.iloscRam = iloscRam;
	}

	public String getProducentRam() {
		return producentRam;
	}

	public void setProducentRam(String producentRam) {
		this.producentRam = producentRam;
	}

	public String getTypRam() {
		return typRam;
	}

	public void setTypRam(String typRam) {
		this.typRam = typRam;
	}

	public String getDyskTwardy() {
		return dyskTwardy;
	}

	public void setDyskTwardy(String dyskTwardy) {
		this.dyskTwardy = dyskTwardy;
	}

	public String getKartaGraficzna() {
		return kartaGraficzna;
	}

	public void setKartaGraficzna(String kartaGraficzna) {
		this.kartaGraficzna = kartaGraficzna;
	}

	public String getNaped() {
		return naped;
	}

	public void setNaped(String naped) {
		this.naped = naped;
	}

	public String getBateria() {
		return bateria;
	}

	public void setBateria(String bateria) {
		this.bateria = bateria;
	}

	public String getZasilacz() {
		return zasilacz;
	}

	public void setZasilacz(String zasilacz) {
		this.zasilacz = zasilacz;
	}

}
