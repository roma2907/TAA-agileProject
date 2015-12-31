package fr.istic.agileProjet.service;

import fr.istic.agileProjet.domain.Project;

public interface IProjetService {
	void addProject(Project projet);

	Iterable<Project> getAllProjet();

	boolean isExistProjectWithName(final String name);

	boolean isExistProjectWithNameAndId(final String name, Long id);

	Project getProjectById(Long id);

	void updateProjet(Project projet);
}
