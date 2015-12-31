package fr.istic.agileProjet.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.istic.agileProjet.domain.Epic;

@Repository
public interface EpicRepository extends CrudRepository<Epic, Long> {

    /** Récupération des epics du sprint id. */
    List<Epic> findBySprint_id(Long id);
}
