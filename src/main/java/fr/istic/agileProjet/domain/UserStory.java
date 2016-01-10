package fr.istic.agileProjet.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wordnik.swagger.annotations.ApiModel;

/**
 * Entité UserStory, représente une user story dans le contexte d'un projet
 * agile.
 *
 * @author ramage
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@ApiModel(value = "Model d'une user story")
public class UserStory {

    @Transient
    protected static final int DAYMILLIS = 86400000;

    private Long id;
    private List<Task> tasks;
    private String name;
    private Integer timeEstimatedDay;
    private Sprint sprint;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @ManyToOne
    @JsonIgnore
    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(final Sprint sprint) {
        this.sprint = sprint;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public Integer getTimeEstimatedDay() {
        return timeEstimatedDay;
    }

    public void setTimeEstimatedDay(final Integer timeEstimatedDay) {
        this.timeEstimatedDay = timeEstimatedDay;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "userStory", cascade = CascadeType.REMOVE)
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(final List<Task> tasks) {
        this.tasks = tasks;
    }

    /** Création d'un epic à partir de l'user story. */
    public Epic convertToEpic() {
        return new Epic(timeEstimatedDay, name, sprint);
    }

    /**
     * indique si l'user story est une epic. si la durée du sprint est inférieur
     * à la durée de l'user story, c'est un épic
     *
     * @return true si l'user story est un epic
     */
    @Transient
    @JsonIgnore
    public boolean isEpic() {
        return (this.getSprint().getDateEnd().getTime() - this.getSprint().getDateBegin().getTime())
                / DAYMILLIS < this
                .getTimeEstimatedDay();
    }
}
