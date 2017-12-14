package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the project_manager database table.
 * 
 */
@Embeddable
public class ProjectManagerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idproject;

	@Column(insertable=false, updatable=false)
	private int idmanager;

	public ProjectManagerPK() {
	}
	public int getIdproject() {
		return this.idproject;
	}
	public void setIdproject(int idproject) {
		this.idproject = idproject;
	}
	public int getIdmanager() {
		return this.idmanager;
	}
	public void setIdmanager(int idmanager) {
		this.idmanager = idmanager;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProjectManagerPK)) {
			return false;
		}
		ProjectManagerPK castOther = (ProjectManagerPK)other;
		return 
			(this.idproject == castOther.idproject)
			&& (this.idmanager == castOther.idmanager);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idproject;
		hash = hash * prime + this.idmanager;
		
		return hash;
	}
}