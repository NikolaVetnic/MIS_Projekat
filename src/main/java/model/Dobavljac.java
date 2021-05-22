package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Dobavljac database table.
 * 
 */
@Entity
@NamedQuery(name="Dobavljac.findAll", query="SELECT d FROM Dobavljac d")
public class Dobavljac implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDob;

	
	private String adrDob;
	private String emailDob;
	private String nazDob;
	private String telDob;
	

	//bi-directional many-to-one association to Nabavka
	@OneToMany(mappedBy="dobavljac")
	private List<Nabavka> nabavke;

	
	public Dobavljac() { }

	
	// idDob : get / set
	public int getIdDob() {
		return this.idDob;
	}

	public void setIdDob(int idDob) {
		this.idDob = idDob;
	}

	
	// adrDob : get / set
	public String getAdrDob() {
		return this.adrDob;
	}

	public void setAdrDob(String adrDob) {
		this.adrDob = adrDob;
	}

	
	// emailDob : get / set
	public String getEmailDob() {
		return this.emailDob;
	}

	public void setEmailDob(String emailDob) {
		this.emailDob = emailDob;
	}

	
	// nazDob : get / set
	public String getNazDob() {
		return this.nazDob;
	}

	public void setNazDob(String nazDob) {
		this.nazDob = nazDob;
	}

	
	// telDob : get / set
	public String getTelDob() {
		return this.telDob;
	}

	public void setTelDob(String telDob) {
		this.telDob = telDob;
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
		nabavke.setDobavljac(this);

		return nabavke;
	}

	public Nabavka removeNabavke(Nabavka nabavke) {
		getNabavke().remove(nabavke);
		nabavke.setDobavljac(null);

		return nabavke;
	}

	
	@Override
	public String toString() {
		return String.format("[%05d] %s", idDob, nazDob);
	}
}