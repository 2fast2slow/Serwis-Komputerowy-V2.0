package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity (name = "Notatki")
public class Notatka {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Id_notatki")
	private long id;

	@Column (name = "Data_notatki")
	@Temporal (TemporalType.DATE)
	private Date dataNotatki;

	@Column (name = "Tresc_notatki")
	private String trescNotatki;

	//KONSTRUKTORY***************

	public Notatka() {

	}

	public Notatka(Date dataNotatki, String trescNotatki) {
		super();
		this.dataNotatki = dataNotatki;
		this.trescNotatki = trescNotatki;
	}

	//SETTERY I GETTERY********************

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataNotatki() {
		return dataNotatki;
	}

	public void setDataNotatki(Date dataNotatki) {
		this.dataNotatki = dataNotatki;
	}

	public String getTrescNotatki() {
		return trescNotatki;
	}

	public void setTrescNotatki(String trescNotatki) {
		this.trescNotatki = trescNotatki;
	}



}
