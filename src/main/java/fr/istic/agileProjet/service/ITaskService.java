package fr.istic.agileProjet.service;

import fr.istic.agileProjet.domain.Task;

public interface ITaskService {

    /**
     * Ajout d'une nouvelle tache
     *
     * @param task
     *            : tache à ajouter
     * @param idUserStory
     *            : identifiant de l'user story auquel on rajoute la tache
     */
    void addTask(Task task, Long idUserStory);

    /**
     * Récupération de la tache ayant l'identifiant idTask.
     *
     * @param idTask
     *            : identifiant de la tache
     * @return la tache voulue
     */
    Task getOneTask(Long idTask);

    /**
     * Modification d'une tache.
     * 
     * @param task
     *            : nouvelle données de la tache
     */
    void updateTask(Task task);

    /**
     * Suppression de la tache d'id indiqué.
     * 
     * @param idTask
     *            : identifiant de la tache à supprimer
     */
    void deleteTask(Long idTask);

}
