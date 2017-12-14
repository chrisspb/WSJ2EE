package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the project_manager database table.
 * 
 */
@Entity
@Table(name="project_manager")
@NamedQuery(name="ProjectManager.findAll", query="SELECT p FROM ProjectManager p")
public class ProjectManager implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProjectManagerPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startdate;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="idmanager")
	private Contact contact;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="idproject")
	private Project project;

	public ProjectManager() {
	}

	public ProjectManagerPK getId() {
		return this.id;
	}

	public void setId(ProjectManagerPK id) {
		this.id = id;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}