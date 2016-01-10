package fr.istic.agileProjet.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.agileProjet.dao.EpicRepository;
import fr.istic.agileProjet.dao.SprintRepository;
import fr.istic.agileProjet.dao.UserStoryRepository;
import fr.istic.agileProjet.domain.Epic;
import fr.istic.agileProjet.domain.UserStory;
import fr.istic.agileProjet.service.IUserStoryService;

@Service
@Transactional
public class UserStoryServiceImpl implements IUserStoryService {



    @Autowired
    private UserStoryRepository userStoryRepository;

    @Autowired
    private EpicRepository epicRepository;

    @Autowired
    private SprintRepository sprintRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void addUserStory(final UserStory userStory, final Long idSprint) {
        userStory.setSprint(sprintRepository.findOne(idSprint));
        if (userStory.isEpic()) {
            final Epic epic = userStory.convertToEpic();
            epicRepository.save(epic);
        } else {
            userStoryRepository.save(userStory);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUserStory(final UserStory userStory) {
        // on réucpère l'ancienne user story(pour garder les relations
        // task,Sprint)
        final UserStory result = userStoryRepository.findOne(userStory.getId());
        // on set les nouvelles données
        result.setName(userStory.getName());
        result.setTimeEstimatedDay(userStory.getTimeEstimatedDay());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserStory getOneUserStory(final Long idUserStory) {
        return userStoryRepository.findOne(idUserStory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteUserStory(final Long idUserStory) {
        userStoryRepository.delete(idUserStory);
    }

}
