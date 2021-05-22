package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the NabavkaArtikal database table.
 * 
 */
@Embeddable
public class NabavkaArtikalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idNab;

	@Column(insertable=false, updatable=false)
	private int idArt;

	public NabavkaArtikalPK() {
	}
	public int getIdNab() {
		return this.idNab;
	}
	public void setIdNab(int idNab) {
		this.idNab = idNab;
	}
	public int getIdArt() {
		return this.idArt;
	}
	public void setIdArt(int idArt) {
		this.idArt = idArt;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NabavkaArtikalPK)) {
			return false;
		}
		NabavkaArtikalPK castOther = (NabavkaArtikalPK)other;
		return 
			(this.idNab == castOther.idNab)
			&& (this.idArt == castOther.idArt);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idNab;
		hash = hash * prime + this.idArt;
		
		return hash;
	}
}