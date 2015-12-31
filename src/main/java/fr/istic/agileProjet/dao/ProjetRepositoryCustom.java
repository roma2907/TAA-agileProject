package fr.istic.agileProjet.dao;

import fr.istic.agileProjet.domain.Project;

public interface ProjetRepositoryCustom {


	Project findOneWithFetch(Long id);
}
