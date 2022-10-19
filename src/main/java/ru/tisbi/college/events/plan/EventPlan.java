package ru.tisbi.college.events.plan;

import org.hibernate.Hibernate;
import ru.tisbi.college.model.AbstractEntity;

import javax.persistence.*;
import java.time.Month;
import java.util.Objects;

@Entity
@Table(name = "event_plan")
public class EventPlan extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "event_module_id")
    private EventModule eventModule;

    @Column(name = "title", nullable = false)
    private String title;

    @Enumerated
    @Column(name = "month", nullable = false)
    private Month month;

    public EventPlan() {
    }

    public EventPlan(String title, Month month) {
        this.title = title;
        this.month = month;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public EventModule getEventModule() {
        return eventModule;
    }

    public void setEventModule(EventModule eventModule) {
        this.eventModule = eventModule;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EventPlan eventPlan = (EventPlan) o;
        return getId() != null && Objects.equals(getId(), eventPlan.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
