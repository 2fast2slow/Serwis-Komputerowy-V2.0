package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "Klienci")
public class Klient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_klienta")
	private long id;

	@Column(name = "Imie")
	private String imie;

	@Column(name = "Nazwisko")
	private String nazwisko;

	@Column(name = "Firma")
	private String firma;

	@Column(name = "NIP")
	private String nip;

	@Column(name = "Ulica")
	private String ulica;

	@Column(name = "Numer_domu")
	private String numerDomu;

	@Column(name = "Nume_lokalu")
	private String numerLokalu;

	@Column(name = "Miasto")
	private String miasto;

	@Column(name = "Kod_pocztowy")
	private String kodPocztowy;

	@Column(name = "Email")
	private String email;

	@Column(name = "Telefon")
	private String telefon;

	@Column(name = "Telefon2")
	private String telefon2;

	//KONSTRUKTORY*******************

	public Klient() {

	}

	public Klient(String imie, String nazwisko, String firma, String nip, String ulica, String numerDomu,
			String numerLokalu, String miasto, String kodPocztowy, String email, String telefon, String telefon2) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.firma = firma;
		this.nip = nip;
		this.ulica = ulica;
		this.numerDomu = numerDomu;
		this.numerLokalu = numerLokalu;
		this.miasto = miasto;
		this.kodPocztowy = kodPocztowy;
		this.email = email;
		this.telefon = telefon;
		this.telefon2 = telefon2;
	}

	//SETTERY I GETTERY******************

	public double getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getNumerDomu() {
		return numerDomu;
	}

	public void setNumerDomu(String numerDomu) {
		this.numerDomu = numerDomu;
	}

	public String getNumerLokalu() {
		return numerLokalu;
	}

	public void setNumerLokalu(String numerLokalu) {
		this.numerLokalu = numerLokalu;
	}

	public String getMiasto() {
		return miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	public String getKodPocztowy() {
		return kodPocztowy;
	}

	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getTelefon2() {
		return telefon2;
	}

	public void setTelefon2(String telefon2) {
		this.telefon2 = telefon2;
	}

}
