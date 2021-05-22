package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Radnik database table.
 * 
 */
@Entity
@NamedQuery(name="Radnik.findAll", query="SELECT r FROM Radnik r")
public class Radnik implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRad;

	
	private String adrRad;
	private String emailRad;
	private String imeRad;
	private String jmbgRad;
	private String passRad;
	private double pltRad;
	private String przRad;
	private String telRad;

	
	//bi-directional many-to-one association to Nabavka
	@OneToMany(mappedBy="radnik")
	private List<Nabavka> nabavke;

	//bi-directional many-to-one association to Odsustvo
	@OneToMany(mappedBy="menadzer")
	private List<Odsustvo> odsustvaMen;

	//bi-directional many-to-one association to Odsustvo
	@OneToMany(mappedBy="konobari")
	private List<Odsustvo> odsustvaKon;

	//bi-directional many-to-one association to RadnoMesto
	@ManyToOne
	@JoinColumn(name="idRM")
	private RadnoMesto radnoMesto;

	//bi-directional many-to-one association to Smena
	@OneToMany(mappedBy="menadzer")
	private List<Smena> smeneMen;

	//bi-directional many-to-one association to Smena
	@OneToMany(mappedBy="konobar")
	private List<Smena> smeneKon;

	
	public Radnik() { }

	
	// idRad : get / set
	public int getIdRad() {
		return this.idRad;
	}

	public void setIdRad(int idRad) {
		this.idRad = idRad;
	}

	
	// adrRad : get / set
	public String getAdrRad() {
		return this.adrRad;
	}

	public void setAdrRad(String adrRad) {
		this.adrRad = adrRad;
	}

	
	// emailRad : get / set
	public String getEmailRad() {
		return this.emailRad;
	}

	public void setEmailRad(String emailRad) {
		this.emailRad = emailRad;
	}

	
	// imeRad : get / set
	public String getImeRad() {
		return this.imeRad;
	}

	public void setImeRad(String imeRad) {
		this.imeRad = imeRad;
	}

	
	// jmbgRad : get / set
	public String getJmbgRad() {
		return this.jmbgRad;
	}

	public void setJmbgRad(String jmbgRad) {
		this.jmbgRad = jmbgRad;
	}

	
	// passRad : get / set
	public String getPassRad() {
		return this.passRad;
	}

	public void setPassRad(String passRad) {
		this.passRad = passRad;
	}

	
	// pltRad : get / set
	public double getPltRad() {
		return this.pltRad;
	}

	public void setPltRad(double pltRad) {
		this.pltRad = pltRad;
	}

	
	// przRad : get / set
	public String getPrzRad() {
		return this.przRad;
	}

	public void setPrzRad(String przRad) {
		this.przRad = przRad;
	}

	
	// telRad : get / set
	public String getTelRad() {
		return this.telRad;
	}

	public void setTelRad(String telRad) {
		this.telRad = telRad;
	}

	
	// nabavke : get / set / add / remove
	public List<Nabavka> getNabavke() {
		return this.nabavke;
	}

	public void setNabavke(List<Nabavka> nabavke) {
		this.nabavke = nabavke;
	}

	public Nabavka addNabavke(Nabavka nabavke) {
		getNabavke().add(nabavke);
		nabavke.setRadnik(this);

		return nabavke;
	}

	public Nabavka removeNabavke(Nabavka nabavke) {
		getNabavke().remove(nabavke);
		nabavke.setRadnik(null);

		return nabavke;
	}

	
	// odsustvaMen : get / set / add / remove
	public List<Odsustvo> getOdsustvaMen() {
		return this.odsustvaMen;
	}

	public void setOdsustvaMen(List<Odsustvo> odsustvaMen) {
		this.odsustvaMen = odsustvaMen;
	}

	public Odsustvo addOdsustvaMen(Odsustvo odsustvaMen) {
		getOdsustvaMen().add(odsustvaMen);
		odsustvaMen.setMenadzer(this);

		return odsustvaMen;
	}

	public Odsustvo removeOdsustvaMen(Odsustvo odsustvaMen) {
		getOdsustvaMen().remove(odsustvaMen);
		odsustvaMen.setMenadzer(null);

		return odsustvaMen;
	}

	
	// odsustvaKon : get / set / add / remove
	public List<Odsustvo> getOdsustvaKon() {
		return this.odsustvaKon;
	}

	public void setOdsustvaKon(List<Odsustvo> odsustvaKon) {
		this.odsustvaKon = odsustvaKon;
	}

	public Odsustvo addOdsustvaKon(Odsustvo odsustvaKon) {
		getOdsustvaKon().add(odsustvaKon);
		odsustvaKon.setKonobari(this);

		return odsustvaKon;
	}

	public Odsustvo removeOdsustvaKon(Odsustvo odsustvaKon) {
		getOdsustvaKon().remove(odsustvaKon);
		odsustvaKon.setKonobari(null);

		return odsustvaKon;
	}

	
	// radnoMesto : get / set
	public RadnoMesto getRadnoMesto() {
		return this.radnoMesto;
	}

	public void setRadnoMesto(RadnoMesto radnoMesto) {
		this.radnoMesto = radnoMesto;
	}

	
	// smeneMen : get / set / add / rem
	public List<Smena> getSmeneMen() {
		return this.smeneMen;
	}

	public void setSmeneMen(List<Smena> smeneMen) {
		this.smeneMen = smeneMen;
	}

	public Smena addSmeneMen(Smena smeneMen) {
		getSmeneMen().add(smeneMen);
		smeneMen.setMenadzer(this);

		return smeneMen;
	}

	public Smena removeSmeneMen(Smena smeneMen) {
		getSmeneMen().remove(smeneMen);
		smeneMen.setMenadzer(null);

		return smeneMen;
	}

	
	// smeneKon : get / set / add / rem
	public List<Smena> getSmeneKon() {
		return this.smeneKon;
	}

	public void setSmeneKon(List<Smena> smeneKon) {
		this.smeneKon = smeneKon;
	}

	public Smena addSmeneKon(Smena smeneKon) {
		getSmeneKon().add(smeneKon);
		smeneKon.setKonobar(this);

		return smeneKon;
	}

	public Smena removeSmeneKon(Smena smeneKon) {
		getSmeneKon().remove(smeneKon);
		smeneKon.setKonobar(null);

		return smeneKon;
	}

	
	@Override
	public String toString() {
		return String.format("[%05d] <%s> %s", idRad, radnoMesto, imeRad);
	}
}