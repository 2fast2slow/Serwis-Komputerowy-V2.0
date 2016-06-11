package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Typy_napraw")
public class TypNaprawy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_typu_naprawy")
	private long id;

	@Column(name = "Opis_typu_naprawy")
	private String opisTypuNaprawy;

	// KONSTRUKTORY---------------------------------

	public TypNaprawy(String op) {
		setOpisTypuNaprawy(op);
	}

	public TypNaprawy() {

	}

	// SETTERY I GETTERY -------------------------

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOpisTypuNaprawy() {
		return opisTypuNaprawy;
	}

	public void setOpisTypuNaprawy(String opis) {
		this.opisTypuNaprawy = opis;
	}

}
