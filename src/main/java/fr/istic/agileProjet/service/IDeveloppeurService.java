package fr.istic.agileProjet.service;

import java.util.List;

import fr.istic.agileProjet.domain.Developper;

public interface IDeveloppeurService {
	Iterable<Developper> getAllDevelopper();

	void addDevelopper(Developper developper);

	List<Developper> getDeveloppeurNotInProject(Long idProjet);

	List<Developper> getDevelopperInProject(Long idUserStory);
}
