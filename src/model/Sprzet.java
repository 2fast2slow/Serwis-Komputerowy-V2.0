package model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity (name = "Sprzety")
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Sprzet {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Id_sprzetu")
	private long id;

	@Column (name = "Nazwa")
	private String nazwa;

	@Column (name = "Wartosc")
	private double wartosc;

	@Column (name = "Numer_seryjny")
	private String numerSeryjny;

	@Column (name = "Opis")
	private String opis;

	@Column (name = "Data_gwarancji")
	private Date dataGwarancji;

	@OneToOne
	@JoinColumn (name = "Magazyn_sprzetu_fk")
	private MagazynSprzetu magazyn;

	//Constructors*********************************

	public Sprzet() {

	}

	public Sprzet(String nazwa, double wartosc, String numerSeryjny, String opis, Date dataGwarancji,
			MagazynSprzetu magazyn) {
		super();
		this.nazwa = nazwa;
		this.wartosc = wartosc;
		this.numerSeryjny = numerSeryjny;
		this.opis = opis;
		this.dataGwarancji = dataGwarancji;
		this.magazyn = magazyn;
	}


	//Setters and getters**************************

	public double getWartosc() {
		return wartosc;
	}

	public MagazynSprzetu getMagazyn() {
		return magazyn;
	}

	public void setMagazyn(MagazynSprzetu magazyn) {
		this.magazyn = magazyn;
	}

	public void setWartosc(double wartosc) {
		this.wartosc = wartosc;
	}

	public String getNumerSeryjny() {
		return numerSeryjny;
	}

	public void setNumerSeryjny(String numerSeryjny) {
		this.numerSeryjny = numerSeryjny;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Date getDataGwarancji() {
		return dataGwarancji;
	}

	public void setDataGwarancji(Date dataGwarancji) {
		this.dataGwarancji = dataGwarancji;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

}
