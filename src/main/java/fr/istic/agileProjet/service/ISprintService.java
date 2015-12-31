package fr.istic.agileProjet.service;

import java.util.List;

import fr.istic.agileProjet.domain.Epic;
import fr.istic.agileProjet.domain.Sprint;
import fr.istic.agileProjet.domain.UserStory;

public interface ISprintService {

	void addSprint(Sprint sprint, Long idProjet);

	void updateSprint(Sprint sprint);
	Sprint getOneSprint(Long id);

	List<Epic> getEpics(Long id);
	List<UserStory> getUserStories(final Long id);
}
