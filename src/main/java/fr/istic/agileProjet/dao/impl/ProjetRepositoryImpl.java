package fr.istic.agileProjet.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import fr.istic.agileProjet.dao.ProjetRepositoryCustom;
import fr.istic.agileProjet.domain.Project;

public class ProjetRepositoryImpl implements ProjetRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    /**
     * {@inheritDoc}
     */
    @Override
    public Project findOneWithFetch(final Long id) {
        final CriteriaBuilder builder = em.getCriteriaBuilder();
        final CriteriaQuery<Project> crit = builder.createQuery(Project.class);
        final Root<Project> root = crit.distinct(true).from(Project.class);
        root.fetch("developpers", JoinType.LEFT);
        root.fetch("sprints", JoinType.LEFT);
        crit.where(builder.equal(root.get("id"), id));
        return em.createQuery(crit).getSingleResult();
    }

}
