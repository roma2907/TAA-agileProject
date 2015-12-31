package fr.istic.agileProjet.controller;

import java.util.List;

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

import fr.istic.agileProjet.domain.Epic;
import fr.istic.agileProjet.domain.Sprint;
import fr.istic.agileProjet.domain.UserStory;
import fr.istic.agileProjet.service.ISprintService;

/**
 * Controlleur sprint (acces /rest/sprint).
 *
 * @author ramage
 *
 */
@RestController
@RequestMapping("/rest/sprint")
@Api(value = "Controlleur sprints", description = "Opérations possible sur les sprints")
public class SprintControlleur {

    @Autowired
    private ISprintService sprintServcice;

    @RequestMapping(value = "/{idProjet}", method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation(httpMethod = "POST", value = "Création d'un nouveau sprint.")
    public void addSprint(@ApiParam(required = true, value = "Sprint à créer") @RequestBody final Sprint sprint,
            @ApiParam(required = true, value = "Sprint à ajouter au projet de cet identifiant") @PathVariable final Long idProjet) {
        sprintServcice.addSprint(sprint, idProjet);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = "application/json")
    @ApiOperation(httpMethod = "PUT", value = "Modification d'un sprint.")
    public void updateSprint(
            @ApiParam(required = true, value = "Sprint modifié") @RequestBody final Sprint sprint) {
        sprintServcice.updateSprint(sprint);
    }

    @RequestMapping(value = "/{idSprint}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Retourne le sprint avec l'identifiant indiqué")
    public @ResponseBody Sprint getOneSprint(
            @ApiParam(required = true, value = "identfiant du sprint recherché") @PathVariable final Long idSprint) {
        return sprintServcice.getOneSprint(idSprint);
    }

    @RequestMapping(value = "/{id}/epic", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Retourne tous les epics du sprint d'id indiqué")
    public @ResponseBody List<Epic> getEpics(
            @ApiParam(required = true, value = "identifiant du sprint") @PathVariable final Long id) {
        return sprintServcice.getEpics(id);
    }

    @RequestMapping(value = "/{id}/userStory", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Retourne tous les users stories du sprint d'id indiqué")
    public @ResponseBody List<UserStory> getUserStories(
            @ApiParam(required = true, value = "identifiant du sprint") @PathVariable final Long id) {
        return sprintServcice.getUserStories(id);
    }

}
