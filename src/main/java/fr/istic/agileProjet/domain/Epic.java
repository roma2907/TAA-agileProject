package fr.istic.agileProjet.domain;

import javax.persistence.Entity;

/**
 * Entité epic, grosse user story (plus longue qu'un sprint).
 *
 * @author ramage
 *
 */
@Entity
public class Epic extends UserStory {

    public Epic() {

    }

    public Epic(final Integer time, final String name, final Sprint s) {
        this.setTimeEstimatedDay(time);
        this.setSprint(s);
        this.setName(name);
    }
}
