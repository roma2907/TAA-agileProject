package fr.istic.agileProjet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.agileProjet.domain.Project;
import fr.istic.agileProjet.service.IProjetService;

@RestController
@RequestMapping("/rest/projet")
public class ProjectController {


    @Autowired
    private IProjetService projetService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody Iterable<Project> getProjets() {
        return projetService.getAllProjet();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public void addProject(@RequestBody final Project projet) {
        projetService.addProject(projet);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
    public void updateProject(@RequestBody final Project projet) {
        projetService.updateProjet(projet);
    }

    @RequestMapping(value = "/exist/{name}", method = RequestMethod.GET)
    public @ResponseBody boolean isExist(@PathVariable final String name) {
        return projetService.isExistProjectWithName(name);
    }

    @RequestMapping(value = "/exist/{name}/{id}", method = RequestMethod.GET)
    public @ResponseBody boolean isExist(@PathVariable final String name, @PathVariable final Long id) {
        return projetService.isExistProjectWithNameAndId(name, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Project getProject(@PathVariable final Long id) {
        return projetService.getProjectById(id);
    }
}
