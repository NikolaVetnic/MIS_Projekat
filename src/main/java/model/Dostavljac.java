package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Dostavljac database table.
 * 
 */
@Entity
@NamedQuery(name="Dostavljac.findAll", query="SELECT d FROM Dostavljac d")
public class Dostavljac implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDos;

	
	private String adrDos;
	private String emailDos;
	private String nazDos;
	private String telDos;

	
	//bi-directional many-to-one association to Narudzbina
	@OneToMany(mappedBy="dostavljac")
	private List<Narudzbina> narudzbine;

	
	public Dostavljac() { }

	
	// idDos : get / set
	public int getIdDos() {
		return this.idDos;
	}

	public void setIdDos(int idDos) {
		this.idDos = idDos;
	}

	
	// adrDos : get / set
	public String getAdrDos() {
		return this.adrDos;
	}

	public void setAdrDos(String adrDos) {
		this.adrDos = adrDos;
	}

	
	// emailDos : get / set
	public String getEmailDos() {
		return this.emailDos;
	}

	public void setEmailDos(String emailDos) {
		this.emailDos = emailDos;
	}

	
	// nazDos : get / set
	public String getNazDos() {
		return this.nazDos;
	}

	public void setNazDos(String nazDos) {
		this.nazDos = nazDos;
	}

	
	// telDos : get / set
	public String getTelDos() {
		return this.telDos;
	}

	public void setTelDos(String telDos) {
		this.telDos = telDos;
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
		narudzbine.setDostavljac(this);

		return narudzbine;
	}

	public Narudzbina removeNarudzbine(Narudzbina narudzbine) {
		getNarudzbine().remove(narudzbine);
		narudzbine.setDostavljac(null);

		return narudzbine;
	}

	
	@Override
	public String toString() {
		return String.format("[%05d] %s", idDos, nazDos);
	}
}