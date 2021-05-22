package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Klijent database table.
 * 
 */
@Entity
@NamedQuery(name="Klijent.findAll", query="SELECT k FROM Klijent k")
public class Klijent implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKli;

	
	private String adrKli;
	private String emailKli;
	private String imeKli;
	private String passKli;
	private String przKli;
	private String telKli;
	

	//bi-directional many-to-many association to Reklama
	@ManyToMany(mappedBy="klijenti")
	private List<Reklama> reklame;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="klijent")
	private List<Komentar> komentari;

	//bi-directional many-to-one association to Narudzbina
	@OneToMany(mappedBy="klijent")
	private List<Narudzbina> narudzbine;

	//bi-directional many-to-one association to Rezervacija
	@OneToMany(mappedBy="klijent")
	private List<Rezervacija> rezervacije;

	
	public Klijent() { }

	
	// idKli : get / set
	public int getIdKli() {
		return this.idKli;
	}

	public void setIdKli(int idKli) {
		this.idKli = idKli;
	}

	
	// adrKli : get / set
	public String getAdrKli() {
		return this.adrKli;
	}

	public void setAdrKli(String adrKli) {
		this.adrKli = adrKli;
	}

	
	// emailKli : get / set
	public String getEmailKli() {
		return this.emailKli;
	}

	public void setEmailKli(String emailKli) {
		this.emailKli = emailKli;
	}

	
	// imeKli : get / set
	public String getImeKli() {
		return this.imeKli;
	}

	public void setImeKli(String imeKli) {
		this.imeKli = imeKli;
	}

	
	// passKli : get / set
	public String getPassKli() {
		return this.passKli;
	}

	public void setPassKli(String passKli) {
		this.passKli = passKli;
	}

	
	// przKli : get / set
	public String getPrzKli() {
		return this.przKli;
	}

	public void setPrzKli(String przKli) {
		this.przKli = przKli;
	}

	
	// telKli : get / set
	public String getTelKli() {
		return this.telKli;
	}

	public void setTelKli(String telKli) {
		this.telKli = telKli;
	}

	
	// reklame : get / set
	public List<Reklama> getReklame() {
		return this.reklame;
	}

	public void setReklame(List<Reklama> reklame) {
		this.reklame = reklame;
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
		komentari.setKlijent(this);

		return komentari;
	}

	public Komentar removeKomentari(Komentar komentari) {
		getKomentari().remove(komentari);
		komentari.setKlijent(null);

		return komentari;
	}

	
	// narudzbine : get / set / add / remove
	public List<Narudzbina> getNarudzbine() {
		return this.narudzbine;
	}

	public void setNarudzbine(List<Narudzbina> narudzbine) {
		this.narudzbine = narudzbine;
	}

	public Narudzbina addNarudzbine(Narudzbina narudzbine) {
		getNarudzbine().add(narudzbine);
		narudzbine.setKlijent(this);

		return narudzbine;
	}

	public Narudzbina removeNarudzbine(Narudzbina narudzbine) {
		getNarudzbine().remove(narudzbine);
		narudzbine.setKlijent(null);

		return narudzbine;
	}

	
	// rezervacije : get / set / add / remove
	public List<Rezervacija> getRezervacije() {
		return this.rezervacije;
	}

	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}

	public Rezervacija addRezervacije(Rezervacija rezervacije) {
		getRezervacije().add(rezervacije);
		rezervacije.setKlijent(this);

		return rezervacije;
	}

	public Rezervacija removeRezervacije(Rezervacija rezervacije) {
		getRezervacije().remove(rezervacije);
		rezervacije.setKlijent(null);

		return rezervacije;
	}

	
	@Override
	public String toString() {
		return String.format("[%05d] %s, %s <%s>", idKli, imeKli, emailKli, passKli.replaceAll(".", "*"));
	}
}