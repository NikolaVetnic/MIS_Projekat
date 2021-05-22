package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Odsustvo database table.
 * 
 */
@Entity
@NamedQuery(name="Odsustvo.findAll", query="SELECT o FROM Odsustvo o")
public class Odsustvo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOds;

	@Temporal(TemporalType.TIMESTAMP)
	private Date krajOds;

	private String opisOds;

	@Temporal(TemporalType.TIMESTAMP)
	private Date pocOds;

	//bi-directional many-to-one association to Radnik
	@ManyToOne
	@JoinColumn(name="idMen")
	private Radnik menadzer;

	//bi-directional many-to-one association to Radnik
	@ManyToOne
	@JoinColumn(name="idKon")
	private Radnik konobari;

	public Odsustvo() {
	}

	public int getIdOds() {
		return this.idOds;
	}

	public void setIdOds(int idOds) {
		this.idOds = idOds;
	}

	public Date getKrajOds() {
		return this.krajOds;
	}

	public void setKrajOds(Date krajOds) {
		this.krajOds = krajOds;
	}

	public String getOpisOds() {
		return this.opisOds;
	}

	public void setOpisOds(String opisOds) {
		this.opisOds = opisOds;
	}

	public Date getPocOds() {
		return this.pocOds;
	}

	public void setPocOds(Date pocOds) {
		this.pocOds = pocOds;
	}

	public Radnik getMenadzer() {
		return this.menadzer;
	}

	public void setMenadzer(Radnik menadzer) {
		this.menadzer = menadzer;
	}

	public Radnik getKonobari() {
		return this.konobari;
	}

	public void setKonobari(Radnik konobari) {
		this.konobari = konobari;
	}

}