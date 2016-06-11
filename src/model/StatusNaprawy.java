package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Statusy_napraw")
public class StatusNaprawy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_statusu_naprawy")
	private long id;

	@Column(name = "Status_naprawy")
	private String statusNaprawy;

	// KONSTRUKTORY***************************

	public StatusNaprawy(String st) {
		setStatusNaprawy(st);
	}

	public StatusNaprawy() {

	}

	// SETTERY I GETTERY**********************

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatusNaprawy() {
		return statusNaprawy;
	}

	public void setStatusNaprawy(String statusNaprawy) {
		this.statusNaprawy = statusNaprawy;
	}

}
