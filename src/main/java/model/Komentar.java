package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Komentar database table.
 * 
 */
@Entity
@NamedQuery(name="Komentar.findAll", query="SELECT k FROM Komentar k")
public class Komentar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKom;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datKom;

	private String txtKom;

	//bi-directional many-to-one association to Artikal
	@ManyToOne
	@JoinColumn(name="idArt")
	private Artikal artikal;

	//bi-directional many-to-one association to Klijent
	@ManyToOne
	@JoinColumn(name="idKli")
	private Klijent klijent;

	public Komentar() {
	}

	public int getIdKom() {
		return this.idKom;
	}

	public void setIdKom(int idKom) {
		this.idKom = idKom;
	}

	public Date getDatKom() {
		return this.datKom;
	}

	public void setDatKom(Date datKom) {
		this.datKom = datKom;
	}

	public String getTxtKom() {
		return this.txtKom;
	}

	public void setTxtKom(String txtKom) {
		this.txtKom = txtKom;
	}

	public Artikal getArtikal() {
		return this.artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}

	public Klijent getKlijent() {
		return this.klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

}