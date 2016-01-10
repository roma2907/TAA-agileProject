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

import fr.istic.agileProjet.domain.UserStory;
import fr.istic.agileProjet.service.IUserStoryService;

/**
 * Controlleur user story (acces /rest/userstory).
 *
 * @author ramage
 *
 */
@RestController
@RequestMapping("/rest/userstory")
@Api(value = "Controlleur User story", description = "Opérations possible sur les user stories")
public class UserStoryController {

    @Autowired
    private IUserStoryService userStoryService;

    @RequestMapping(value = "/{idSprint}", method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation(httpMethod = "POST", value = "Création d'une user story")
    public void addUserStory(
            @ApiParam(required = true, value = "user story a créé") @RequestBody final UserStory userStory,
            @ApiParam(required = true, value = "identifiant du sprint à qui on ajoute la nouvelle user story") @PathVariable final Long idSprint) {
        userStoryService.addUserStory(userStory, idSprint);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = "application/json")
    @ApiOperation(httpMethod = "PUT", value = "Modification d'une user story")
    public void updateUserStory(
            @ApiParam(required = true, value = "user story modifié") @RequestBody final UserStory userStory) {
        userStoryService.updateUserStory(userStory);
    }

    @RequestMapping(value = "/{idUserStory}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Récupération de l'user story de l'identifiant indiqué")
    public @ResponseBody UserStory getOneUserStory(
            @ApiParam(required = true, value = "identifiant de l'user story recherché") @PathVariable final Long idUserStory) {
        return userStoryService.getOneUserStory(idUserStory);
    }

    @RequestMapping(value = "/{idUserStory}", method = RequestMethod.DELETE)
    @ApiOperation(httpMethod = "DELETE", value = "Suppression de l'user story de l'identifiant indiqué")
    public void deleteUserStory(@PathVariable("idUserStory") final Long idUserStory) {
        userStoryService.deleteUserStory(idUserStory);
    }
}
