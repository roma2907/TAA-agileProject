package fr.istic.agileProjet.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.istic.agileProjet.domain.Sprint;

@Repository
public interface SprintRepository extends CrudRepository<Sprint, Long> {

}
