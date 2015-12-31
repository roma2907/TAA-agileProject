package fr.istic.agileProjet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.agileProjet.domain.Task;
import fr.istic.agileProjet.service.ITaskService;

@RestController
@RequestMapping("/rest/task")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @RequestMapping(value = "/{idUserStory}", method = RequestMethod.POST, consumes = "application/json")
    public void addUserStory(@RequestBody final Task task, @PathVariable final Long idUserStory) {
        taskService.addTask(task, idUserStory);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = "application/json")
    public void updateTask(@RequestBody final Task task) {
        taskService.updateTask(task);
    }

    @RequestMapping(value = "{idTask}", method = RequestMethod.DELETE, consumes = "application/json")
    public @ResponseBody boolean deleteTask(@PathVariable final Long idTask) {
        taskService.deleteTask(idTask);
        return true;
    }

    @RequestMapping(value = "{idTask}", method = RequestMethod.GET)
    public @ResponseBody Task getOneTask(@PathVariable final Long idTask) {
        return taskService.getOneTask(idTask);
    }
}
