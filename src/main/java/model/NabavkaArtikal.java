package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the NabavkaArtikal database table.
 * 
 */
@Entity
@NamedQuery(name="NabavkaArtikal.findAll", query="SELECT n FROM NabavkaArtikal n")
public class NabavkaArtikal implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NabavkaArtikalPK id;

	private double cenaArt;

	private double kolArt;

	//bi-directional many-to-one association to Artikal
	@ManyToOne
	@JoinColumn(name="idArt", insertable=false, updatable=false)
	private Artikal artikal;

	//bi-directional many-to-one association to Nabavka
	@ManyToOne
	@JoinColumn(name="idNab", insertable=false, updatable=false)
	private Nabavka nabavka;

	public NabavkaArtikal() {
	}

	public NabavkaArtikalPK getId() {
		return this.id;
	}

	public void setId(NabavkaArtikalPK id) {
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

	public Nabavka getNabavka() {
		return this.nabavka;
	}

	public void setNabavka(Nabavka nabavka) {
		this.nabavka = nabavka;
	}

}