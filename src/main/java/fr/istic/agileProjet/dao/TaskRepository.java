package fr.istic.agileProjet.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.istic.agileProjet.domain.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

}
