package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the project_client database table.
 * 
 */
@Embeddable
public class ProjectClientPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idproject;

	@Column(insertable=false, updatable=false)
	private int idclient;

	public ProjectClientPK() {
	}
	public int getIdproject() {
		return this.idproject;
	}
	public void setIdproject(int idproject) {
		this.idproject = idproject;
	}
	public int getIdclient() {
		return this.idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProjectClientPK)) {
			return false;
		}
		ProjectClientPK castOther = (ProjectClientPK)other;
		return 
			(this.idproject == castOther.idproject)
			&& (this.idclient == castOther.idclient);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idproject;
		hash = hash * prime + this.idclient;
		
		return hash;
	}
}