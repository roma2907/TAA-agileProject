package fr.istic.agileProjet.service;

import fr.istic.agileProjet.domain.UserStory;

public interface IUserStoryService {

    /**
     * Ajout d'une nouvelle user story.
     *
     * @param userStory
     *            : user story à ajouter
     * @param idSprint
     *            : identifiant du sprint auquel on rajoute une user story
     */
    void addUserStory(UserStory userStory, final Long idSprint);

    /**
     * Modification d'une user story.
     * 
     * @param userStory
     *            : nouvelle données de l'user story
     */
    void updateUserStory(UserStory userStory);

    /**
     * Récupération de l'user story ayant l'identifiant indiqué.
     * 
     * @param idUserStory
     *            : identifiant de l'user story voulu
     * @return l'user story recherché
     */
    UserStory getOneUserStory(Long idUserStory);
}
