package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Nabavka database table.
 * 
 */
@Entity
@NamedQuery(name="Nabavka.findAll", query="SELECT n FROM Nabavka n")
public class Nabavka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idNab;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datNab;

	//bi-directional many-to-one association to Dobavljac
	@ManyToOne
	@JoinColumn(name="idDob")
	private Dobavljac dobavljac;

	//bi-directional many-to-one association to Radnik
	@ManyToOne
	@JoinColumn(name="idMen")
	private Radnik radnik;

	//bi-directional many-to-one association to NabavkaArtikal
	@OneToMany(mappedBy="nabavka")
	private List<NabavkaArtikal> nabavkaArtikli;

	public Nabavka() {
	}

	public int getIdNab() {
		return this.idNab;
	}

	public void setIdNab(int idNab) {
		this.idNab = idNab;
	}

	public Date getDatNab() {
		return this.datNab;
	}

	public void setDatNab(Date datNab) {
		this.datNab = datNab;
	}

	public Dobavljac getDobavljac() {
		return this.dobavljac;
	}

	public void setDobavljac(Dobavljac dobavljac) {
		this.dobavljac = dobavljac;
	}

	public Radnik getRadnik() {
		return this.radnik;
	}

	public void setRadnik(Radnik radnik) {
		this.radnik = radnik;
	}

	public List<NabavkaArtikal> getNabavkaArtikli() {
		return this.nabavkaArtikli;
	}

	public void setNabavkaArtikli(List<NabavkaArtikal> nabavkaArtikli) {
		this.nabavkaArtikli = nabavkaArtikli;
	}

	public NabavkaArtikal addNabavkaArtikli(NabavkaArtikal nabavkaArtikli) {
		getNabavkaArtikli().add(nabavkaArtikli);
		nabavkaArtikli.setNabavka(this);

		return nabavkaArtikli;
	}

	public NabavkaArtikal removeNabavkaArtikli(NabavkaArtikal nabavkaArtikli) {
		getNabavkaArtikli().remove(nabavkaArtikli);
		nabavkaArtikli.setNabavka(null);

		return nabavkaArtikli;
	}

}