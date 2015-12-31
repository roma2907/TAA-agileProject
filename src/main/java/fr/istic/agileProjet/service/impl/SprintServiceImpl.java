package fr.istic.agileProjet.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.agileProjet.dao.EpicRepository;
import fr.istic.agileProjet.dao.ProjetRepository;
import fr.istic.agileProjet.dao.SprintRepository;
import fr.istic.agileProjet.dao.UserStoryRepository;
import fr.istic.agileProjet.domain.Epic;
import fr.istic.agileProjet.domain.Project;
import fr.istic.agileProjet.domain.Sprint;
import fr.istic.agileProjet.domain.UserStory;
import fr.istic.agileProjet.service.ISprintService;

@Service
@Transactional
public class SprintServiceImpl implements ISprintService {

	@Autowired
	private SprintRepository sprintRepository;

	@Autowired
	private ProjetRepository projetRepository;

	@Autowired
	private UserStoryRepository userStoryRepository;

	@Autowired
	private EpicRepository epicRepository;

	@Override
	public void addSprint(final Sprint sprint, final Long idProjet) {
		final Project projectBdd = projetRepository.findOne(idProjet);
		sprint.setProject(projectBdd);
		sprintRepository.save(sprint);
	}

	@Override
	public Sprint getOneSprint(final Long id) {
		return sprintRepository.findOne(id);
	}

	@Override
	public List<Epic> getEpics(final Long id) {
		return epicRepository.findBySprint_id(id);
	}

	@Override
	public List<UserStory> getUserStories(final Long id) {
		return userStoryRepository.findBySprint_idOrderByTimeEstimatedDayAsc(id);
	}

	@Override
	public void updateSprint(final Sprint sprint) {
		final Sprint sprintBdd = sprintRepository.findOne(sprint.getId());
		sprintBdd.setDateBegin(sprint.getDateBegin());
		sprintBdd.setDateEnd(sprint.getDateEnd());
		sprintBdd.setName(sprint.getName());
	}

}
