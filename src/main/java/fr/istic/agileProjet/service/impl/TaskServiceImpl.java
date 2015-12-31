package fr.istic.agileProjet.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.agileProjet.dao.TaskRepository;
import fr.istic.agileProjet.dao.UserStoryRepository;
import fr.istic.agileProjet.domain.Task;
import fr.istic.agileProjet.service.ITaskService;

@Transactional
@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserStoryRepository userStoryRepository;

    @Override
    public void addTask(final Task task, final Long idUserStory) {
        task.setUserStory(userStoryRepository.findOne(idUserStory));
        taskRepository.save(task);
    }

    @Override
    public Task getOneTask(final Long idTask) {
        return taskRepository.findOne(idTask);
    }

    @Override
    public void updateTask(final Task task) {
        // merge
        final Task taskBdd = taskRepository.findOne(task.getId());
        taskBdd.setDevelopper(task.getDevelopper());
        taskBdd.setName(task.getName());
    }

    @Override
    public void deleteTask(final Long idTask) {
        taskRepository.delete(idTask);
    }

}
