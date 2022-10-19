package ru.tisbi.college.events.plan;

import ru.tisbi.college.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "event_module")
public class EventModule extends AbstractEntity {
    @OneToMany(mappedBy = "eventModule", orphanRemoval = true)
    private Set<EventPlan> plannedEvents = new LinkedHashSet<>();

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "title", nullable = false)
    private String title;

    public Set<EventPlan> getPlannedEvents() {
        return plannedEvents;
    }

    public void setPlannedEvents(Set<EventPlan> plannedEvents) {
        this.plannedEvents = plannedEvents;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}