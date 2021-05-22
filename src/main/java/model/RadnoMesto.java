package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RadnoMesto database table.
 * 
 */
@Entity
@NamedQuery(name="RadnoMesto.findAll", query="SELECT r FROM RadnoMesto r")
public class RadnoMesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRM;

	private String opisRM;

	//bi-directional many-to-one association to Radnik
	@OneToMany(mappedBy="radnoMesto")
	private List<Radnik> radnici;

	public RadnoMesto() {
	}

	public int getIdRM() {
		return this.idRM;
	}

	public void setIdRM(int idRM) {
		this.idRM = idRM;
	}

	public String getOpisRM() {
		return this.opisRM;
	}

	public void setOpisRM(String opisRM) {
		this.opisRM = opisRM;
	}

	public List<Radnik> getRadnici() {
		return this.radnici;
	}

	public void setRadnici(List<Radnik> radnici) {
		this.radnici = radnici;
	}

	public Radnik addRadnici(Radnik radnici) {
		getRadnici().add(radnici);
		radnici.setRadnoMesto(this);

		return radnici;
	}

	public Radnik removeRadnici(Radnik radnici) {
		getRadnici().remove(radnici);
		radnici.setRadnoMesto(null);

		return radnici;
	}

	
	@Override
	public String toString() {
		return opisRM;
	}
}