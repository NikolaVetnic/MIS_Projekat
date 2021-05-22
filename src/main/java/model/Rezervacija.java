package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Rezervacija database table.
 * 
 */
@Entity
@NamedQuery(name="Rezervacija.findAll", query="SELECT r FROM Rezervacija r")
public class Rezervacija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRez;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datRez;

	private String opisRez;

	//bi-directional many-to-one association to Klijent
	@ManyToOne
	@JoinColumn(name="idKli")
	private Klijent klijent;

	//bi-directional many-to-one association to Sto
	@ManyToOne
	@JoinColumn(name="idSto")
	private Sto sto;

	public Rezervacija() {
	}

	public int getIdRez() {
		return this.idRez;
	}

	public void setIdRez(int idRez) {
		this.idRez = idRez;
	}

	public Date getDatRez() {
		return this.datRez;
	}

	public void setDatRez(Date datRez) {
		this.datRez = datRez;
	}

	public String getOpisRez() {
		return this.opisRez;
	}

	public void setOpisRez(String opisRez) {
		this.opisRez = opisRez;
	}

	public Klijent getKlijent() {
		return this.klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

	public Sto getSto() {
		return this.sto;
	}

	public void setSto(Sto sto) {
		this.sto = sto;
	}

}