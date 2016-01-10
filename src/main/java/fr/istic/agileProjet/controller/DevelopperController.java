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

import fr.istic.agileProjet.domain.Developper;
import fr.istic.agileProjet.service.IDeveloppeurService;

/**
 * Controlleur développeur (acces /rest/developpeur).
 *
 * @author ramage
 *
 */
@RestController
@RequestMapping("/rest/developpeur")
@Api(value = "Controlleur développeurs", description = "Opérations possible sur les développeurs")
public class DevelopperController {

    @Autowired
    private IDeveloppeurService developpeurService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Récupère tous les développeurs.")
    public @ResponseBody Iterable<Developper> getAllDevelopper() {
        return developpeurService.getAllDevelopper();
    }

    @ApiOperation(httpMethod = "POST", value = "Création d'un nouveau développeur.")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addDevelopper(
            @ApiParam(required = true, value = "Développeur à créer.") @RequestBody final Developper developper) {
        developpeurService.addDevelopper(developper);
    }

    @ApiOperation(httpMethod = "GET", value = "Retourne les développeurs qui ne sont pas dans le projet.")
    @RequestMapping(value = "/notInProjet/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Developper> getDeveloppeurNotInProject(
            @ApiParam(required = true, value = "identifiant du projet") @PathVariable final Long id) {
        return developpeurService.getDeveloppeurNotInProject(id);
    }

    @ApiOperation(httpMethod = "GET", value = "Retourne les développeurs qui sont dans le projet de l'userstory indiqué.")
    @RequestMapping(value = "/userstory/{idUserStory}", method = RequestMethod.GET)
    public @ResponseBody List<Developper> getDevelopperInProject(
            @ApiParam(required = true, value = "identifiant de l'user story") @PathVariable final Long idUserStory) {
        return developpeurService.getDevelopperInProject(idUserStory);
    }
}
