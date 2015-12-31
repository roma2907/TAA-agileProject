package fr.istic.agileProjet.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.istic.agileProjet.domain.Project;

@Repository
public interface ProjetRepository extends CrudRepository<Project, Long>, ProjetRepositoryCustom {
    /** Récupération de tous les projets ayant le nom indiqué. **/
    List<Project> findByName(final String name);

    /**
     * Récupération de tous les projets ayant le nom indiqué et un identifiant
     * de projet différent que celui indiqué.
     */
    List<Project> findByNameAndIdNot(final String name, final Long id);
}