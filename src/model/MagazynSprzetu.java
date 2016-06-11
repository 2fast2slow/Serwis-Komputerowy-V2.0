package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Magazyn_sprzetu")
public class MagazynSprzetu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_magazynu")
	private long id;

	@Column(name = "Nazwa_magazynu")
	private String nazwaMagazynu;

	// KONSTRUKTORY******************

	public MagazynSprzetu() {

	}

	public MagazynSprzetu(String nazwaMagazynu) {
		super();
		this.nazwaMagazynu = nazwaMagazynu;
	}

	// SETTERY I GETTERY**************

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNazwaMagazynu() {
		return nazwaMagazynu;
	}

	public void setNazwaMagazynu(String nazwaMagazynu) {
		this.nazwaMagazynu = nazwaMagazynu;
	}

}
