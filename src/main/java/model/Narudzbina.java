package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Narudzbina database table.
 * 
 */
@Entity
@NamedQuery(name="Narudzbina.findAll", query="SELECT n FROM Narudzbina n")
public class Narudzbina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idNar;

	//bi-directional many-to-one association to Dostavljac
	@ManyToOne
	@JoinColumn(name="idDos")
	private Dostavljac dostavljac;

	//bi-directional many-to-one association to Klijent
	@ManyToOne
	@JoinColumn(name="idKli")
	private Klijent klijent;

	//bi-directional many-to-one association to Racun
	@ManyToOne
	@JoinColumn(name="idRac")
	private Racun racun;

	public Narudzbina() {
	}

	public int getIdNar() {
		return this.idNar;
	}

	public void setIdNar(int idNar) {
		this.idNar = idNar;
	}

	public Dostavljac getDostavljac() {
		return this.dostavljac;
	}

	public void setDostavljac(Dostavljac dostavljac) {
		this.dostavljac = dostavljac;
	}

	public Klijent getKlijent() {
		return this.klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

	public Racun getRacun() {
		return this.racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}

}