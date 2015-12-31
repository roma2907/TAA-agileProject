package fr.istic.agileProjet.service;

import fr.istic.agileProjet.domain.Task;

public interface ITaskService {

    void addTask(Task task, Long idUserStory);

    Task getOneTask(Long idTask);

    void updateTask(Task task);

    void deleteTask(Long idTask);

}
