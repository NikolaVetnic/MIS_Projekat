package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RacunArtikal database table.
 * 
 */
@Embeddable
public class RacunArtikalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idArt;

	@Column(insertable=false, updatable=false)
	private int idRac;

	public RacunArtikalPK() {
	}
	public int getIdArt() {
		return this.idArt;
	}
	public void setIdArt(int idArt) {
		this.idArt = idArt;
	}
	public int getIdRac() {
		return this.idRac;
	}
	public void setIdRac(int idRac) {
		this.idRac = idRac;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RacunArtikalPK)) {
			return false;
		}
		RacunArtikalPK castOther = (RacunArtikalPK)other;
		return 
			(this.idArt == castOther.idArt)
			&& (this.idRac == castOther.idRac);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idArt;
		hash = hash * prime + this.idRac;
		
		return hash;
	}
}