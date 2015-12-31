package fr.istic.agileProjet.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.istic.agileProjet.domain.UserStory;

@Repository
public interface UserStoryRepository extends CrudRepository<UserStory, Long> {
    /**
     * Récupération des user stories d'un sprint avec tri par ordre du temps
     * estimé.
     */
    List<UserStory> findBySprint_idOrderByTimeEstimatedDayAsc(Long sprint);
}
