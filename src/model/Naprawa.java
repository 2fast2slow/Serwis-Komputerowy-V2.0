package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "Naprawy")
public class Naprawa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_naprawy")
	private long id;

	@Column(name = "Data_przyjecia")
	private Date dataPrzyjecia;

	@Column(name = "Przewidywana_data_naprawy")
	private Date przewidywanaDataNaprawy;

	@Column(name = "Przewidywany_koszt_naprawy")
	private double przewidywanyKoszt;

	@Column(name = "Opis_uszkodzenia")
	private String opisUszkodzenia;

	@Column(name = "Komentarz")
	private String komentarz;

	@Column(name = "Cena_naprawy")
	private double cenaNaprawy;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id_klienta_fk")
	private Klient klient;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id_sprzetu_fk")
	private Sprzet sprzet;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id_naprawy_fk")
	private List<Notatka> notatki;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Status_naprawy_fk")
	private StatusNaprawy statusNaprawy;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Typ_naprawy")
	private TypNaprawy typNaprawy;

	// KONSTRUKTORY******************************

	public Naprawa() {

	}

	public Naprawa(Date dataPrzyjecia, Date przewidywanaDataNaprawy, double przewidywanyKoszt,
			String opisUszkodzenia, String komentarz, double cenaNaprawy, Klient klient, Sprzet sprzet,
			List<Notatka> notatki, StatusNaprawy statusNaprawy, TypNaprawy typNaprawy) {
		super();
		this.dataPrzyjecia = dataPrzyjecia;
		this.przewidywanaDataNaprawy = przewidywanaDataNaprawy;
		this.przewidywanyKoszt = przewidywanyKoszt;
		this.opisUszkodzenia = opisUszkodzenia;
		this.komentarz = komentarz;
		this.cenaNaprawy = cenaNaprawy;
		this.klient = klient;
		this.sprzet = sprzet;
		this.notatki = notatki;
		this.statusNaprawy = statusNaprawy;
		this.typNaprawy = typNaprawy;
	}

	// SETTERY I GETTERY------------------------

	public StatusNaprawy getStatusNaprawy() {
		return statusNaprawy;
	}

	public TypNaprawy getTypNaprawy() {
		return typNaprawy;
	}

	public void setTypNaprawy(TypNaprawy typNaprawy) {
		this.typNaprawy = typNaprawy;
	}

	public void setStatusNaprawy(StatusNaprawy statusNaprawy) {
		this.statusNaprawy = statusNaprawy;
	}

	public List<Notatka> getNotatki() {
		return notatki;
	}

	public void setNotatki(List<Notatka> notatki) {
		this.notatki = notatki;
	}

	public Klient getKlient() {
		return klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

	public Sprzet getSprzet() {
		return sprzet;
	}

	public void setSprzet(Sprzet sprzet) {
		this.sprzet = sprzet;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataPrzyjecia() {
		return dataPrzyjecia;
	}

	public void setDataPrzyjecia(Date dataPrzyjecia) {
		this.dataPrzyjecia = dataPrzyjecia;
	}

	public Date getPrzewidywanaDataNaprawy() {
		return przewidywanaDataNaprawy;
	}

	public void setPrzewidywanaDataNaprawy(Date przewidywanaDataNaprawy) {
		this.przewidywanaDataNaprawy = przewidywanaDataNaprawy;
	}

	public double getPrzewidywanyKoszt() {
		return przewidywanyKoszt;
	}

	public void setPrzewidywanyKoszt(double przewidywanyKoszt) {
		this.przewidywanyKoszt = przewidywanyKoszt;
	}

	public String getOpisUszkodzenia() {
		return opisUszkodzenia;
	}

	public void setOpisUszkodzenia(String opisUszkodzenia) {
		this.opisUszkodzenia = opisUszkodzenia;
	}

	public String getKomentarz() {
		return komentarz;
	}

	public void setKomentarz(String komentarz) {
		this.komentarz = komentarz;
	}

	public double getCenaNaprawy() {
		return cenaNaprawy;
	}

	public void setCenaNaprawy(double cenaNaprawy) {
		this.cenaNaprawy = cenaNaprawy;
	}

}
