package fr.istic.agileProjet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.agileProjet.dao.DeveloppeurRepository;
import fr.istic.agileProjet.domain.Developper;
import fr.istic.agileProjet.service.IDeveloppeurService;

@Service
@Transactional
public class DeveloppeurServiceImpl implements IDeveloppeurService {

    @Autowired
    private DeveloppeurRepository developpeurRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<Developper> getAllDevelopper() {
        return developpeurRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addDevelopper(final Developper developper) {
        developpeurRepository.save(developper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Developper> getDeveloppeurNotInProject(final Long idProjet) {
        return developpeurRepository.developpersNotInsideProject(idProjet);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Developper> getDevelopperInProject(final Long idUserStory) {
        return developpeurRepository.getDevelopperInProject(idUserStory);
    }

}
