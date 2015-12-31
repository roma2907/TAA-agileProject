package fr.istic.agileProjet.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.istic.agileProjet.domain.UserStory;

@Repository
public interface UserStoryRepository extends CrudRepository<UserStory, Long> {
	List<UserStory> findBySprint_idOrderByTimeEstimatedDayAsc(Long sprint);
}
