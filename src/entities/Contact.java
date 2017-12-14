package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcontact;

	private byte isAdmin;

	private byte isClient;

	private byte isTeam;

	private String login;

	private String password;

	//bi-directional many-to-one association to ProjectClient
	@OneToMany(mappedBy="contact")
	private List<ProjectClient> projectClients;

	//bi-directional many-to-one association to ProjectManager
	@OneToMany(mappedBy="contact")
	private List<ProjectManager> projectManagers;

	//bi-directional many-to-one association to ProjectTeam
	@OneToMany(mappedBy="contact")
	private List<ProjectTeam> projectTeams;

	public Contact() {
	}

	public int getIdcontact() {
		return this.idcontact;
	}

	public void setIdcontact(int idcontact) {
		this.idcontact = idcontact;
	}

	public byte getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(byte isAdmin) {
		this.isAdmin = isAdmin;
	}

	public byte getIsClient() {
		return this.isClient;
	}

	public void setIsClient(byte isClient) {
		this.isClient = isClient;
	}

	public byte getIsTeam() {
		return this.isTeam;
	}

	public void setIsTeam(byte isTeam) {
		this.isTeam = isTeam;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ProjectClient> getProjectClients() {
		return this.projectClients;
	}

	public void setProjectClients(List<ProjectClient> projectClients) {
		this.projectClients = projectClients;
	}

	public ProjectClient addProjectClient(ProjectClient projectClient) {
		getProjectClients().add(projectClient);
		projectClient.setContact(this);

		return projectClient;
	}

	public ProjectClient removeProjectClient(ProjectClient projectClient) {
		getProjectClients().remove(projectClient);
		projectClient.setContact(null);

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
		projectManager.setContact(this);

		return projectManager;
	}

	public ProjectManager removeProjectManager(ProjectManager projectManager) {
		getProjectManagers().remove(projectManager);
		projectManager.setContact(null);

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
		projectTeam.setContact(this);

		return projectTeam;
	}

	public ProjectTeam removeProjectTeam(ProjectTeam projectTeam) {
		getProjectTeams().remove(projectTeam);
		projectTeam.setContact(null);

		return projectTeam;
	}

}