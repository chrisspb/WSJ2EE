package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the project_client database table.
 * 
 */
@Entity
@Table(name="project_client")
@NamedQuery(name="ProjectClient.findAll", query="SELECT p FROM ProjectClient p")
public class ProjectClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProjectClientPK id;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="idclient")
	private Contact contact;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="idproject")
	private Project project;

	//bi-directional many-to-one association to Release
	@ManyToOne
	@JoinColumn(name="idrelease")
	private Release release;

	public ProjectClient() {
	}

	public ProjectClientPK getId() {
		return this.id;
	}

	public void setId(ProjectClientPK id) {
		this.id = id;
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

	public Release getRelease() {
		return this.release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

}