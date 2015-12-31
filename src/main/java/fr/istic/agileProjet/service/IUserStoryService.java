package fr.istic.agileProjet.service;

import fr.istic.agileProjet.domain.UserStory;

public interface IUserStoryService {

	void addUserStory(UserStory userStory, final Long idSprint);

	void updateUserStory(UserStory userStory);

	UserStory getOneUserStory(Long idUserStory);
}
