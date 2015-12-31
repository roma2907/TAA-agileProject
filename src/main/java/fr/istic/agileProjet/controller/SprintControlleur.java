package fr.istic.agileProjet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.agileProjet.domain.Epic;
import fr.istic.agileProjet.domain.Sprint;
import fr.istic.agileProjet.domain.UserStory;
import fr.istic.agileProjet.service.ISprintService;

@RestController
@RequestMapping("/rest/sprint")
public class SprintControlleur {

    @Autowired
    private ISprintService sprintServcice;

    @RequestMapping(value = "/add/{idProjet}", method = RequestMethod.POST, consumes = "application/json")
    public void addSprint(@RequestBody final Sprint sprint, @PathVariable final Long idProjet) {
        sprintServcice.addSprint(sprint, idProjet);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
    public void updateSprint(@RequestBody final Sprint sprint) {
        sprintServcice.updateSprint(sprint);
    }

    @RequestMapping(value = "/{idSprint}", method = RequestMethod.GET)
    public @ResponseBody Sprint getOneSprint(@PathVariable final Long idSprint) {
        return sprintServcice.getOneSprint(idSprint);
    }

    @RequestMapping(value = "/{id}/epic", method = RequestMethod.GET)
    public @ResponseBody List<Epic> getEpics(@PathVariable final Long id) {
        return sprintServcice.getEpics(id);
    }

    @RequestMapping(value = "/{id}/userStory", method = RequestMethod.GET)
    public @ResponseBody List<UserStory> getUserStories(@PathVariable final Long id) {
        return sprintServcice.getUserStories(id);
    }

}
