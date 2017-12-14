package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the project_team database table.
 * 
 */
@Entity
@Table(name="project_team")
@NamedQuery(name="ProjectTeam.findAll", query="SELECT p FROM ProjectTeam p")
public class ProjectTeam implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateend;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datestart;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="idmember")
	private Contact contact;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="idproject")
	private Project project;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="status")
	private Status statusBean;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="idtask")
	private Task task;

	public ProjectTeam() {
	}

	public Date getDateend() {
		return this.dateend;
	}

	public void setDateend(Date dateend) {
		this.dateend = dateend;
	}

	public Date getDatestart() {
		return this.datestart;
	}

	public void setDatestart(Date datestart) {
		this.datestart = datestart;
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

	public Status getStatusBean() {
		return this.statusBean;
	}

	public void setStatusBean(Status statusBean) {
		this.statusBean = statusBean;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}