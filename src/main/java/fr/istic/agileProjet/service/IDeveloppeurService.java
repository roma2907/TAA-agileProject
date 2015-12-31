package fr.istic.agileProjet.service;

import java.util.List;

import fr.istic.agileProjet.domain.Developper;

public interface IDeveloppeurService {
    /**
     * Récupréation de tous les développeurs.
     * 
     * @return tous les développeurs.
     */
    Iterable<Developper> getAllDevelopper();

    /**
     * Ajout d'un développeur.
     *
     * @param developper
     *            : développeur à ajouter
     */
    void addDevelopper(Developper developper);

    /**
     * Retourne l'intégralité des développeurs qui ne font pas partie du projet.
     *
     * @param idProjet
     *            : identifiant du projet
     * @return l'intégralité des développeurs qui ne font pas partie du projet
     */
    List<Developper> getDeveloppeurNotInProject(Long idProjet);

    /**
     * Récupère tous les développeurs qui travaille sur le projet de l'user
     * story indiqué.
     *
     * @param idUserStory:
     *            identifiant de l'user story
     * @return tous les développeurs du projet
     */
    List<Developper> getDevelopperInProject(Long idUserStory);
}
