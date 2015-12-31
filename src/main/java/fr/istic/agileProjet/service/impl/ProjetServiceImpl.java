package fr.istic.agileProjet.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.agileProjet.dao.ProjetRepository;
import fr.istic.agileProjet.domain.Project;
import fr.istic.agileProjet.service.IProjetService;

@Service
@Transactional
public class ProjetServiceImpl implements IProjetService {

    @Autowired
    private ProjetRepository projetRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void addProject(final Project projet) {
        // persist
        projetRepository.save(projet);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<Project> getAllProjet() {
        return projetRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isExistProjectWithName(final String name) {
        return CollectionUtils.isNotEmpty(projetRepository.findByName(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Project getProjectById(final Long id) {
        return projetRepository.findOneWithFetch(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateProjet(final Project projet) {
        // merge
        projetRepository.save(projet);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isExistProjectWithNameAndId(final String name, final Long id) {
        return CollectionUtils.isNotEmpty(projetRepository.findByNameAndIdNot(name, id));
    }

}
