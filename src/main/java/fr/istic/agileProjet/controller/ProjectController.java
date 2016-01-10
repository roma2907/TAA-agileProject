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

import fr.istic.agileProjet.domain.Project;
import fr.istic.agileProjet.service.IProjetService;

/**
 * Controlleur projet (acces /rest/projet).
 *
 * @author ramage
 *
 */
@RestController
@RequestMapping("/rest/projet")
@Api(value = "Controlleur projets", description = "Opérations possible sur les projets")
public class ProjectController {


    @Autowired
    private IProjetService projetService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Retourne l'ensemble de tous les projets.")
    public @ResponseBody Iterable<Project> getProjets() {
        return projetService.getAllProjet();
    }


    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation(httpMethod = "POST", value = "Création d'un nouveau projet.")
    public void addProject(@ApiParam(required = true, value = "Projet à ajouter") @RequestBody final Project projet) {
        projetService.addProject(projet);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = "application/json")
    @ApiOperation(httpMethod = "PUT", value = "Modification d'un projet.")
    public void updateProject(
            @ApiParam(required = true, value = "Projet modifié") @RequestBody final Project projet) {
        projetService.updateProjet(projet);
    }

    @RequestMapping(value = "/exist/{name}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Retourne vrai s'il existe déjà un projet avec le nom indiqué.")
    public @ResponseBody boolean isExist(
            @ApiParam(required = true, value = "Nom à vérifier") @PathVariable final String name) {
        return projetService.isExistProjectWithName(name);
    }

    @RequestMapping(value = "/exist/{name}/{id}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Retourne vrai s'il existe déjà un projet avec le nom indiqué et avec un identifiant de projet différent.")
    public @ResponseBody boolean isExist(
            @ApiParam(required = true, value = "Nom à vérifier") @PathVariable final String name,
            @ApiParam(required = true, value = "Identifiant du projet") @PathVariable final Long id) {
        return projetService.isExistProjectWithNameAndId(name, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "Retourne le projet d'identifiant indiqué.")
    public @ResponseBody Project getProject(
            @ApiParam(required = true, value = "Identifiant du projet") @PathVariable final Long id) {
        return projetService.getProjectById(id);
    }
}
