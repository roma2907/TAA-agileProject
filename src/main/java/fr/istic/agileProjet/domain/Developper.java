package fr.istic.agileProjet.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Developper {

	private Long id;
	private String firstName;
	private String lastName;
	private Set<Project> projets;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	@ManyToMany(mappedBy = "developpers")
	@JsonIgnore
	public Set<Project> getProjets() {
		return projets;
	}

	public void setProjets(final Set<Project> projets) {
		this.projets = projets;
	}

}
