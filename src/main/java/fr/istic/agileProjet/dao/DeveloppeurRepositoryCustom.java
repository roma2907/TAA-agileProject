package fr.istic.agileProjet.dao;

import java.util.List;

import fr.istic.agileProjet.domain.Developper;

public interface DeveloppeurRepositoryCustom {

    /**
     * Retourne l'ensemble des développeurs qui ne sont pas dans le projet.
     *
     * @param id
     *            : identfiant du projet.
     * @return les développeurs qui ne sont pas dans le projet
     */
    List<Developper> developpersNotInsideProject(Long id);

    /**
     * Retourne tous les développeurs dans le projet ayant l'identifiant de
     * l'user story.
     * 
     * @param idUserStory
     *            : identifiant user story
     * @return les développeurs du projet
     */
    List<Developper> getDevelopperInProject(Long idUserStory);
}
