package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Reklama database table.
 * 
 */
@Entity
@NamedQuery(name="Reklama.findAll", query="SELECT r FROM Reklama r")
public class Reklama implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRek;

	private String txtRek;

	//bi-directional many-to-many association to Klijent
	@ManyToMany
	@JoinTable(
		name="KlijentReklama"
		, joinColumns={
			@JoinColumn(name="idRek")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idKli")
			}
		)
	private List<Klijent> klijenti;

	public Reklama() {
	}

	public int getIdRek() {
		return this.idRek;
	}

	public void setIdRek(int idRek) {
		this.idRek = idRek;
	}

	public String getTxtRek() {
		return this.txtRek;
	}

	public void setTxtRek(String txtRek) {
		this.txtRek = txtRek;
	}

	public List<Klijent> getKlijenti() {
		return this.klijenti;
	}

	public void setKlijenti(List<Klijent> klijenti) {
		this.klijenti = klijenti;
	}

}