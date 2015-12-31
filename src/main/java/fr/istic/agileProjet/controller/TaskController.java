package fr.istic.agileProjet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import fr.istic.agileProjet.domain.Task;
import fr.istic.agileProjet.service.ITaskService;

/**
 * Controlleur task (acces /rest/task).
 *
 * @author ramage
 *
 */
@RestController
@RequestMapping("/rest/task")
@Api(value = "Controlleur taches", description = "Opérations possible sur les taches")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @RequestMapping(value = "/{idUserStory}", method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation(httpMethod = "POST", value = "Création d'une tache")
    public void addTask(@ApiParam(required = true, value = "Tache à créer") @RequestBody final Task task,
            @ApiParam(required = true, value = "identifiant de l'user story à qui, nous rajoutons une tache") @PathVariable final Long idUserStory) {
        taskService.addTask(task, idUserStory);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = "application/json")
    @ApiOperation(httpMethod = "PUT", value = "Modififcation d'une tache")
    public void updateTask(@ApiParam(required = true, value = "Tache modifié") @RequestBody final Task task) {
        taskService.updateTask(task);
    }

    @RequestMapping(value = "{idTask}", method = RequestMethod.DELETE)
    @ApiOperation(httpMethod = "DELETE", value = "Suppression d'une tache")
    public @ResponseBody void deleteTask(
            @ApiParam(required = true, value = "identifiant de la tache a supprimé") @PathVariable final Long idTask) {
        taskService.deleteTask(idTask);
    }

    @RequestMapping(value = "{idTask}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Retourne la tache d'identifiant indiqué")
    public @ResponseBody Task getOneTask(
            @ApiParam(required = true, value = "identifiant de la tache") @PathVariable final Long idTask) {
        return taskService.getOneTask(idTask);
    }
}
