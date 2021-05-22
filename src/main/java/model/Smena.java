package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Smena database table.
 * 
 */
@Entity
@NamedQuery(name="Smena.findAll", query="SELECT s FROM Smena s")
public class Smena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSme;

	@Temporal(TemporalType.TIMESTAMP)
	private Date krajSme;

	@Temporal(TemporalType.TIMESTAMP)
	private Date pocSme;

	//bi-directional many-to-one association to Radnik
	@ManyToOne
	@JoinColumn(name="idMen")
	private Radnik menadzer;

	//bi-directional many-to-one association to Radnik
	@ManyToOne
	@JoinColumn(name="idKon")
	private Radnik konobar;

	//bi-directional many-to-many association to Sto
	@ManyToMany(mappedBy="smene")
	private List<Sto> stolovi;

	public Smena() {
	}

	public int getIdSme() {
		return this.idSme;
	}

	public void setIdSme(int idSme) {
		this.idSme = idSme;
	}

	public Date getKrajSme() {
		return this.krajSme;
	}

	public void setKrajSme(Date krajSme) {
		this.krajSme = krajSme;
	}

	public Date getPocSme() {
		return this.pocSme;
	}

	public void setPocSme(Date pocSme) {
		this.pocSme = pocSme;
	}

	public Radnik getMenadzer() {
		return this.menadzer;
	}

	public void setMenadzer(Radnik menadzer) {
		this.menadzer = menadzer;
	}

	public Radnik getKonobar() {
		return this.konobar;
	}

	public void setKonobar(Radnik konobar) {
		this.konobar = konobar;
	}

	public List<Sto> getStolovi() {
		return this.stolovi;
	}

	public void setStolovi(List<Sto> stolovi) {
		this.stolovi = stolovi;
	}

}