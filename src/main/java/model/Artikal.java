package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Artikal database table.
 * 
 */
@Entity
@NamedQuery(name="Artikal.findAll", query="SELECT a FROM Artikal a")
public class Artikal implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idArt;

	
	private String nazArt;

	
	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="artikal")
	private List<Komentar> komentari;

	//bi-directional many-to-one association to NabavkaArtikal
	@OneToMany(mappedBy="artikal")
	private List<NabavkaArtikal> nabavkaArtikli;

	//bi-directional many-to-one association to RacunArtikal
	@OneToMany(mappedBy="artikal")
	private List<RacunArtikal> racunArtikli;

	
	public Artikal() { }

	
	// idArt : get / set
	public int getIdArt() {
		return this.idArt;
	}

	public void setIdArt(int idArt) {
		this.idArt = idArt;
	}

	
	// nazArt : get / set
	public String getNazArt() {
		return this.nazArt;
	}

	public void setNazArt(String nazArt) {
		this.nazArt = nazArt;
	}

	
	// komentari : get / set / add / remove
	public List<Komentar> getKomentari() {
		return this.komentari;
	}

	public void setKomentari(List<Komentar> komentari) {
		this.komentari = komentari;
	}

	public Komentar addKomentari(Komentar komentari) {
		getKomentari().add(komentari);
		komentari.setArtikal(this);

		return komentari;
	}

	public Komentar removeKomentari(Komentar komentari) {
		getKomentari().remove(komentari);
		komentari.setArtikal(null);

		return komentari;
	}

	
	// nabavkaArtikli : get / set / add / remove 
	public List<NabavkaArtikal> getNabavkaArtikli() {
		return this.nabavkaArtikli;
	}

	public void setNabavkaArtikli(List<NabavkaArtikal> nabavkaArtikli) {
		this.nabavkaArtikli = nabavkaArtikli;
	}

	public NabavkaArtikal addNabavkaArtikli(NabavkaArtikal nabavkaArtikli) {
		getNabavkaArtikli().add(nabavkaArtikli);
		nabavkaArtikli.setArtikal(this);

		return nabavkaArtikli;
	}

	public NabavkaArtikal removeNabavkaArtikli(NabavkaArtikal nabavkaArtikli) {
		getNabavkaArtikli().remove(nabavkaArtikli);
		nabavkaArtikli.setArtikal(null);

		return nabavkaArtikli;
	}

	
	// racunArtikli : get / set / add / remove
	public List<RacunArtikal> getRacunArtikli() {
		return this.racunArtikli;
	}

	public void setRacunArtikli(List<RacunArtikal> racunArtikli) {
		this.racunArtikli = racunArtikli;
	}

	public RacunArtikal addRacunArtikli(RacunArtikal racunArtikli) {
		getRacunArtikli().add(racunArtikli);
		racunArtikli.setArtikal(this);

		return racunArtikli;
	}

	public RacunArtikal removeRacunArtikli(RacunArtikal racunArtikli) {
		getRacunArtikli().remove(racunArtikli);
		racunArtikli.setArtikal(null);

		return racunArtikli;
	}

	
	@Override
	public String toString() {
		return String.format("[%05d] %s", idArt, nazArt.toUpperCase());
	}
}