package fr.istic.agileProjet.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import fr.istic.agileProjet.dao.DeveloppeurRepositoryCustom;
import fr.istic.agileProjet.domain.Developper;
import fr.istic.agileProjet.domain.Project;
import fr.istic.agileProjet.domain.Sprint;
import fr.istic.agileProjet.domain.UserStory;

public class DeveloppeurRepositoryImpl implements DeveloppeurRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Developper> developpersNotInsideProject(final Long id) {
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Developper> query = cb.createQuery(Developper.class);
		final Root<Developper> poRoot = query.from(Developper.class);
		query.select(poRoot);

		final Subquery<Developper> subquery = query.subquery(Developper.class);
		final Root<Developper> subRoot = subquery.from(Developper.class);
		final Join<Developper, Project> project = subRoot.join("projets");
		subquery.select(subRoot);

		final Predicate p = cb.equal(project.get("id"), id);
		subquery.where(p);
		query.where(cb.not(poRoot.get("id").in(subquery)));

		return em.createQuery(query).getResultList();
	}

	@Override
	public List<Developper> getDevelopperInProject(final Long idUserStory) {
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Developper> query = cb.createQuery(Developper.class);
		final Root<Developper> root = query.from(Developper.class);
		final Join<Developper, Project> project = root.join("projets");
		final Join<Project, Sprint> sprint = project.join("sprints");
		final Join<Sprint, UserStory> userStory = sprint.join("userStories");
		query.where(cb.equal(userStory.get("id"), idUserStory));
		return em.createQuery(query).getResultList();
	}

}
