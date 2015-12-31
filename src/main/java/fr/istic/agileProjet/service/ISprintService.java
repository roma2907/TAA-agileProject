package fr.istic.agileProjet.service;

import java.util.List;

import fr.istic.agileProjet.domain.Epic;
import fr.istic.agileProjet.domain.Sprint;
import fr.istic.agileProjet.domain.UserStory;

public interface ISprintService {
    /**
     * Ajout d'un sprint au projet d'id idProjet
     *
     * @param sprint
     *            : sprint à ajouter
     * @param idProjet
     *            : identifiant du projet auquel on rajoute le sprint
     */
    void addSprint(Sprint sprint, Long idProjet);

    /**
     * Modification d'un sprint.
     *
     * @param sprint
     *            : nouvelle données du sprint
     */
    void updateSprint(Sprint sprint);

    /**
     * Récupération du sprint possèdant l'id indiqué.
     *
     * @param id
     *            : identifiant du sprint
     * @return le sprint ayant l'id indiqué
     */
    Sprint getOneSprint(Long id);

    /**
     * Récupération de tous les epics du sprint ayant l'identifiant id.
     *
     * @param id
     *            : identifiant du sprint.
     * @return tous les epics du sprint.
     */
    List<Epic> getEpics(Long id);

    /**
     * Retourne toutes les user stories d'un sprint
     * 
     * @param id
     *            : identifiant du sprint
     * @return : toutes les user stories du sprint
     */
    List<UserStory> getUserStories(final Long id);
}
