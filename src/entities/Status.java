package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@Table(name="status")
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="code_status")
	private String codeStatus;

	private String description;

	//bi-directional many-to-one association to ProjectTeam
	@OneToMany(mappedBy="statusBean")
	private List<ProjectTeam> projectTeams;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="statusBean")
	private List<Task> tasks;

	public Status() {
	}

	public String getCodeStatus() {
		return this.codeStatus;
	}

	public void setCodeStatus(String codeStatus) {
		this.codeStatus = codeStatus;
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
		projectTeam.setStatusBean(this);

		return projectTeam;
	}

	public ProjectTeam removeProjectTeam(ProjectTeam projectTeam) {
		getProjectTeams().remove(projectTeam);
		projectTeam.setStatusBean(null);

		return projectTeam;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setStatusBean(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setStatusBean(null);

		return task;
	}

}