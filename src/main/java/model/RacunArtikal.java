package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RacunArtikal database table.
 * 
 */
@Entity
@NamedQuery(name="RacunArtikal.findAll", query="SELECT r FROM RacunArtikal r")
public class RacunArtikal implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RacunArtikalPK id;

	private double cenaArt;

	private double kolArt;

	//bi-directional many-to-one association to Artikal
	@ManyToOne
	@JoinColumn(name="idArt", insertable=false, updatable=false)
	private Artikal artikal;

	//bi-directional many-to-one association to Racun
	@ManyToOne
	@JoinColumn(name="idRac", insertable=false, updatable=false)
	private Racun racun;

	public RacunArtikal() {
	}

	public RacunArtikalPK getId() {
		return this.id;
	}

	public void setId(RacunArtikalPK id) {
		this.id = id;
	}

	public double getCenaArt() {
		return this.cenaArt;
	}

	public void setCenaArt(double cenaArt) {
		this.cenaArt = cenaArt;
	}

	public double getKolArt() {
		return this.kolArt;
	}

	public void setKolArt(double kolArt) {
		this.kolArt = kolArt;
	}

	public Artikal getArtikal() {
		return this.artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}

	public Racun getRacun() {
		return this.racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}

}