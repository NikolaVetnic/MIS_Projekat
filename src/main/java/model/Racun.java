package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Racun database table.
 * 
 */
@Entity
@NamedQuery(name="Racun.findAll", query="SELECT r FROM Racun r")
public class Racun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRac;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datRac;

	private double uplRac;

	//bi-directional many-to-one association to Narudzbina
	@OneToMany(mappedBy="racun")
	private List<Narudzbina> narudzbine;

	//bi-directional many-to-one association to SmenaSto
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="idSme", referencedColumnName="idSme"),
		@JoinColumn(name="idSto", referencedColumnName="idSto")
		})
	private SmenaSto smenaSto;

	//bi-directional many-to-one association to RacunArtikal
	@OneToMany(mappedBy="racun")
	private List<RacunArtikal> racunArtikli;

	public Racun() {
	}

	public int getIdRac() {
		return this.idRac;
	}

	public void setIdRac(int idRac) {
		this.idRac = idRac;
	}

	public Date getDatRac() {
		return this.datRac;
	}

	public void setDatRac(Date datRac) {
		this.datRac = datRac;
	}

	public double getUplRac() {
		return this.uplRac;
	}

	public void setUplRac(double uplRac) {
		this.uplRac = uplRac;
	}

	public List<Narudzbina> getNarudzbine() {
		return this.narudzbine;
	}

	public void setNarudzbine(List<Narudzbina> narudzbine) {
		this.narudzbine = narudzbine;
	}

	public Narudzbina addNarudzbine(Narudzbina narudzbine) {
		getNarudzbine().add(narudzbine);
		narudzbine.setRacun(this);

		return narudzbine;
	}

	public Narudzbina removeNarudzbine(Narudzbina narudzbine) {
		getNarudzbine().remove(narudzbine);
		narudzbine.setRacun(null);

		return narudzbine;
	}

	public SmenaSto getSmenaSto() {
		return this.smenaSto;
	}

	public void setSmenaSto(SmenaSto smenaSto) {
		this.smenaSto = smenaSto;
	}

	public List<RacunArtikal> getRacunArtikli() {
		return this.racunArtikli;
	}

	public void setRacunArtikli(List<RacunArtikal> racunArtikli) {
		this.racunArtikli = racunArtikli;
	}

	public RacunArtikal addRacunArtikli(RacunArtikal racunArtikli) {
		getRacunArtikli().add(racunArtikli);
		racunArtikli.setRacun(this);

		return racunArtikli;
	}

	public RacunArtikal removeRacunArtikli(RacunArtikal racunArtikli) {
		getRacunArtikli().remove(racunArtikli);
		racunArtikli.setRacun(null);

		return racunArtikli;
	}

}