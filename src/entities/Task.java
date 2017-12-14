package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the task database table.
 * 
 */
@Entity
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtask;

	private String description;

	//bi-directional many-to-one association to ProjectTeam
	@OneToMany(mappedBy="task")
	private List<ProjectTeam> projectTeams;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="idproject")
	private Project project;

	//bi-directional many-to-many association to Release
	@ManyToMany
	@JoinTable(
		name="sprint"
		, joinColumns={
			@JoinColumn(name="idtask")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idrelease")
			}
		)
	private List<Release> releases;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="status")
	private Status statusBean;

	public Task() {
	}

	public int getIdtask() {
		return this.idtask;
	}

	public void setIdtask(int idtask) {
		this.idtask = idtask;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProjectTeam> getProjectTeams() {
		return this.projectTeams;
	}

	public void setProjectTeams(List<ProjectTeam> projectTeams) {
		this.projectTeams = projectTeams;
	}

	public ProjectTeam addProjectTeam(ProjectTeam projectTeam) {
		getProjectTeams().add(projectTeam);
		projectTeam.setTask(this);

		return projectTeam;
	}

	public ProjectTeam removeProjectTeam(ProjectTeam projectTeam) {
		getProjectTeams().remove(projectTeam);
		projectTeam.setTask(null);

		return projectTeam;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Release> getReleases() {
		return this.releases;
	}

	public void setReleases(List<Release> releases) {
		this.releases = releases;
	}

	public Status getStatusBean() {
		return this.statusBean;
	}

	public void setStatusBean(Status statusBean) {
		this.statusBean = statusBean;
	}

}