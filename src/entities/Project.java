package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@Table(name="project")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idproject;

	private String code;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startdate;

	//bi-directional many-to-one association to ProjectClient
	@OneToMany(mappedBy="project")
	private List<ProjectClient> projectClients;

	//bi-directional many-to-one association to ProjectManager
	@OneToMany(mappedBy="project")
	private List<ProjectManager> projectManagers;

	//bi-directional many-to-one association to ProjectTeam
	@OneToMany(mappedBy="project")
	private List<ProjectTeam> projectTeams;

	//bi-directional many-to-one association to Release
	@OneToMany(mappedBy="project")
	private List<Release> releases;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="project")
	private List<Task> tasks;

	public Project() {
	}

	public int getIdproject() {
		return this.idproject;
	}

	public void setIdproject(int idproject) {
		this.idproject = idproject;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public List<ProjectClient> getProjectClients() {
		return this.projectClients;
	}

	public void setProjectClients(List<ProjectClient> projectClients) {
		this.projectClients = projectClients;
	}

	public ProjectClient addProjectClient(ProjectClient projectClient) {
		getProjectClients().add(projectClient);
		projectClient.setProject(this);

		return projectClient;
	}

	public ProjectClient removeProjectClient(ProjectClient projectClient) {
		getProjectClients().remove(projectClient);
		projectClient.setProject(null);

		return projectClient;
	}

	public List<ProjectManager> getProjectManagers() {
		return this.projectManagers;
	}

	public void setProjectManagers(List<ProjectManager> projectManagers) {
		this.projectManagers = projectManagers;
	}

	public ProjectManager addProjectManager(ProjectManager projectManager) {
		getProjectManagers().add(projectManager);
		projectManager.setProject(this);

		return projectManager;
	}

	public ProjectManager removeProjectManager(ProjectManager projectManager) {
		getProjectManagers().remove(projectManager);
		projectManager.setProject(null);

		return projectManager;
	}

	public List<ProjectTeam> getProjectTeams() {
		return this.projectTeams;
	}

	public void setProjectTeams(List<ProjectTeam> projectTeams) {
		this.projectTeams = projectTeams;
	}

	public ProjectTeam addProjectTeam(ProjectTeam projectTeam) {
		getProjectTeams().add(projectTeam);
		projectTeam.setProject(this);

		return projectTeam;
	}

	public ProjectTeam removeProjectTeam(ProjectTeam projectTeam) {
		getProjectTeams().remove(projectTeam);
		projectTeam.setProject(null);

		return projectTeam;
	}

	public List<Release> getReleases() {
		return this.releases;
	}

	public void setReleases(List<Release> releases) {
		this.releases = releases;
	}

	public Release addReleas(Release releas) {
		getReleases().add(releas);
		releas.setProject(this);

		return releas;
	}

	public Release removeReleas(Release releas) {
		getReleases().remove(releas);
		releas.setProject(null);

		return releas;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setProject(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setProject(null);

		return task;
	}

}