package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SmenaSto database table.
 * 
 */
@Embeddable
public class SmenaStoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idSto;

	@Column(insertable=false, updatable=false)
	private int idSme;

	public SmenaStoPK() {
	}
	public int getIdSto() {
		return this.idSto;
	}
	public void setIdSto(int idSto) {
		this.idSto = idSto;
	}
	public int getIdSme() {
		return this.idSme;
	}
	public void setIdSme(int idSme) {
		this.idSme = idSme;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SmenaStoPK)) {
			return false;
		}
		SmenaStoPK castOther = (SmenaStoPK)other;
		return 
			(this.idSto == castOther.idSto)
			&& (this.idSme == castOther.idSme);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idSto;
		hash = hash * prime + this.idSme;
		
		return hash;
	}
}