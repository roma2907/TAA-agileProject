package fr.istic.agileProjet.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Project {

	private String name;
	private Long id;
	private Set<Developper> developpers;
	private Set<Sprint> sprints;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	@ManyToMany
	public Set<Developper> getDeveloppers() {
		return developpers;
	}

	public void setDeveloppers(final Set<Developper> developpers) {
		this.developpers = developpers;
	}

	@OneToMany(mappedBy = "project")
	public Set<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(final Set<Sprint> sprints) {
		this.sprints = sprints;
	}
}
