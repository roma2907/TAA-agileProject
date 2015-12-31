package fr.istic.agileProjet.dao;

import java.util.List;

import fr.istic.agileProjet.domain.Developper;

public interface DeveloppeurRepositoryCustom {
	List<Developper> developpersNotInsideProject(Long id);

	List<Developper> getDevelopperInProject(Long idUserStory);
}
