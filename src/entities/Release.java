package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the release database table.
 * 
 */
@Entity
@Table(name="release")
@NamedQuery(name="Release.findAll", query="SELECT r FROM Release r")
public class Release implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idrelease;

	@Temporal(TemporalType.TIMESTAMP)
	private Date daterelease;

	private String version;

	//bi-directional many-to-one association to ProjectClient
	@OneToMany(mappedBy="release")
	private List<ProjectClient> projectClients;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="idproject")
	private Project project;

	//bi-directional many-to-many association to Task
	@ManyToMany(mappedBy="releases")
	private List<Task> tasks;

	public Release() {
	}

	public int getIdrelease() {
		return this.idrelease;
	}

	public void setIdrelease(int idrelease) {
		this.idrelease = idrelease;
	}

	public Date getDaterelease() {
		return this.daterelease;
	}

	public void setDaterelease(Date daterelease) {
		this.daterelease = daterelease;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<ProjectClient> getProjectClients() {
		return this.projectClients;
	}

	public void setProjectClients(List<ProjectClient> projectClients) {
		this.projectClients = projectClients;
	}

	public ProjectClient addProjectClient(ProjectClient projectClient) {
		getProjectClients().add(projectClient);
		projectClient.setRelease(this);

		return projectClient;
	}

	public ProjectClient removeProjectClient(ProjectClient projectClient) {
		getProjectClients().remove(projectClient);
		projectClient.setRelease(null);

		return projectClient;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}