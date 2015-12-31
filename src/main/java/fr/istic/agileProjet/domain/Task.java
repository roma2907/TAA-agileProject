package fr.istic.agileProjet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Task {

    private Long id;
    private String name;
    private Developper developper;
    private UserStory userStory;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JsonIgnore
    public UserStory getUserStory() {
        return userStory;
    }

    public void setUserStory(final UserStory userStory) {
        this.userStory = userStory;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @OneToOne
    @JoinColumn(name = "DEVELOPPER")
    public Developper getDevelopper() {
        return developper;
    }

    public void setDevelopper(final Developper developper) {
        this.developper = developper;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
