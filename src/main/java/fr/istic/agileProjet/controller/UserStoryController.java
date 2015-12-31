package fr.istic.agileProjet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.agileProjet.domain.UserStory;
import fr.istic.agileProjet.service.IUserStoryService;

@RestController
@RequestMapping("/rest/userstory")
public class UserStoryController {

    @Autowired
    private IUserStoryService userStoryService;

    @RequestMapping(value = "/add/{idSprint}", method = RequestMethod.POST, consumes = "application/json")
    public void addUserStory(@RequestBody final UserStory userStory, @PathVariable final Long idSprint) {
        userStoryService.addUserStory(userStory, idSprint);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
    public void updateUserStory(@RequestBody final UserStory userStory) {
        userStoryService.updateUserStory(userStory);
    }

    @RequestMapping(value = "/{idUserStory}", method = RequestMethod.GET)
    public @ResponseBody UserStory getOneSprint(@PathVariable final Long idUserStory) {
        return userStoryService.getOneUserStory(idUserStory);
    }
}
