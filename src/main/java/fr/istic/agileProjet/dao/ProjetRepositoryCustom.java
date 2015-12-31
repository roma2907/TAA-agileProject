package fr.istic.agileProjet.dao;

import fr.istic.agileProjet.domain.Project;

public interface ProjetRepositoryCustom {

    /** Récupération du projet avec un fetch des sprints associés. */
    Project findOneWithFetch(Long id);
}
