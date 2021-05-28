package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Sto database table.
 * 
 */
@Entity
@NamedQuery(name="Sto.findAll", query="SELECT s FROM Sto s")
public class Sto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSto;

	private String opisSto;

	//bi-directional many-to-one association to Rezervacija
	@OneToMany(mappedBy="sto", fetch = FetchType.EAGER)
	private List<Rezervacija> rezervacije;

	//bi-directional many-to-many association to Smena
	@ManyToMany
	@JoinTable(
		name="SmenaSto"
		, joinColumns={
			@JoinColumn(name="idSto")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idSme")
			}
		)
	private List<Smena> smene;

	public Sto() {
	}

	public int getIdSto() {
		return this.idSto;
	}

	public void setIdSto(int idSto) {
		this.idSto = idSto;
	}

	public String getOpisSto() {
		return this.opisSto;
	}

	public void setOpisSto(String opisSto) {
		this.opisSto = opisSto;
	}

	public List<Rezervacija> getRezervacije() {
		return this.rezervacije;
	}

	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}

	public Rezervacija addRezervacije(Rezervacija rezervacije) {
		getRezervacije().add(rezervacije);
		rezervacije.setSto(this);

		return rezervacije;
	}

	public Rezervacija removeRezervacije(Rezervacija rezervacije) {
		getRezervacije().remove(rezervacije);
		rezervacije.setSto(null);

		return rezervacije;
	}

	public List<Smena> getSmene() {
		return this.smene;
	}

	public void setSmene(List<Smena> smene) {
		this.smene = smene;
	}
	
	
	@Override
	public String toString() {
		return String.format("[%05d] %s", idSto, opisSto);
	}
}