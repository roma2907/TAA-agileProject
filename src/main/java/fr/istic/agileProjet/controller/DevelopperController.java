package fr.istic.agileProjet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.agileProjet.domain.Developper;
import fr.istic.agileProjet.service.IDeveloppeurService;

@RestController
@RequestMapping("/rest/developpeur")
// @Api(value = "Controlleur des développeurs", description = "Opérations
// possible sur les développeurs")
public class DevelopperController {

    @Autowired
    private IDeveloppeurService developpeurService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    // @ApiOperation(httpMethod = "GET", value = "Récupère tous les
    // développeurs.")
    public @ResponseBody Iterable<Developper> getAllDevelopper() {
        return developpeurService.getAllDevelopper();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addDevelopper(@RequestBody final Developper developper) {
        developpeurService.addDevelopper(developper);
    }

    @RequestMapping(value = "/notInProjet/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Developper> getDeveloppeurNotInProject(@PathVariable final Long id) {
        return developpeurService.getDeveloppeurNotInProject(id);
    }

    @RequestMapping(value = "/userstory/{idUserStory}", method = RequestMethod.GET)
    public @ResponseBody List<Developper> getDevelopperInProject(@PathVariable final Long idUserStory) {
        return developpeurService.getDevelopperInProject(idUserStory);
    }
}
