package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SmenaSto database table.
 * 
 */
@Entity
@NamedQuery(name="SmenaSto.findAll", query="SELECT s FROM SmenaSto s")
public class SmenaSto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SmenaStoPK id;

	//bi-directional many-to-one association to Racun
	@OneToMany(mappedBy="smenaSto")
	private List<Racun> racuni;

	public SmenaSto() {
	}

	public SmenaStoPK getId() {
		return this.id;
	}

	public void setId(SmenaStoPK id) {
		this.id = id;
	}

	public List<Racun> getRacuni() {
		return this.racuni;
	}

	public void setRacuni(List<Racun> racuni) {
		this.racuni = racuni;
	}

	public Racun addRacuni(Racun racuni) {
		getRacuni().add(racuni);
		racuni.setSmenaSto(this);

		return racuni;
	}

	public Racun removeRacuni(Racun racuni) {
		getRacuni().remove(racuni);
		racuni.setSmenaSto(null);

		return racuni;
	}

}