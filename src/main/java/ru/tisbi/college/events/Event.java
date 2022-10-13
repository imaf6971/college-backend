package ru.tisbi.college.events;

import org.hibernate.Hibernate;
import ru.tisbi.college.groups.Student;
import ru.tisbi.college.model.AbstractEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event extends AbstractEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToMany(mappedBy = "events")
    private Set<Student> students = new LinkedHashSet<>();

    @Column(name = "points", nullable = false)
    private int points;

    public int getPoints() {
        return points;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Event event = (Event) o;
        return getId() != null && Objects.equals(getId(), event.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}