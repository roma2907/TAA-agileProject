package fr.istic.agileProjet.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.istic.agileProjet.domain.Developper;

@Repository
public interface DeveloppeurRepository extends CrudRepository<Developper, Long>, DeveloppeurRepositoryCustom {

}
