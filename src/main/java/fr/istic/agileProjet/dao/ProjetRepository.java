package fr.istic.agileProjet.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.istic.agileProjet.domain.Project;

@Repository
public interface ProjetRepository extends CrudRepository<Project, Long>, ProjetRepositoryCustom {
	List<Project> findByName(final String name);
	List<Project> findByNameAndIdNot(final String name, final Long id);
}