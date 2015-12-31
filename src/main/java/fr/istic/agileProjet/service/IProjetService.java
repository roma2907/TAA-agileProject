package fr.istic.agileProjet.service;

import fr.istic.agileProjet.domain.Project;

public interface IProjetService {
    /**
     * Ajout d'un projet.
     * 
     * @param projet
     *            : projet a ajouté
     */
    void addProject(Project projet);

    /**
     * Renvoie tous les projets.
     * 
     * @return tous les projets
     */
    Iterable<Project> getAllProjet();

    /**
     * Renvoie true s'il existe un projet avec ce nom.
     *
     * @param name
     *            : nom du projet
     * @return true s'il existe un projet avec ce nom
     */
    boolean isExistProjectWithName(final String name);

    /**
     * Renvoie true, s'il existe un projet avec un nom identique et un
     * identifiant différent.
     *
     * @param name
     *            : nom du projet
     * @param id
     *            : identifiant du projet
     * @return un booléen indiquant si le nom existe déjà en dehors de
     *         l'identifiant id
     */
    boolean isExistProjectWithNameAndId(final String name, Long id);

    /**
     * Récupération du projet avec l'identifiant indiqué.
     *
     * @param id
     *            : identifiant du projet
     * @return le projet ayant l'identifiant
     */
    Project getProjectById(Long id);

    /**
     * Mise à jour du projet.
     *
     * @param projet
     *            : nouvelle données concernant le projet.
     */
    void updateProjet(Project projet);
}
