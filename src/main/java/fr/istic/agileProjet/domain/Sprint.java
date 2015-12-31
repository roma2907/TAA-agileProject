package fr.istic.agileProjet.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wordnik.swagger.annotations.ApiModel;

/**
 * Entité Sprint, représente un sprint dans le contexte d'un projet agile.
 * 
 * @author ramage
 *
 */
@Entity
@ApiModel(value = "Model d'un sprint")
public class Sprint {
    private Long id;
    private List<UserStory> userStories;
    private Date dateBegin;
    private Date dateEnd;
    private Project project;
    private String name;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @ManyToOne
    @JsonIgnore
    public Project getProject() {
        return project;
    }

    public void setProject(final Project project) {
        this.project = project;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(final Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(final Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "sprint")
    public List<UserStory> getUserStories() {
        return userStories;
    }

    public void setUserStories(final List<UserStory> userStories) {
        this.userStories = userStories;
    }
}
