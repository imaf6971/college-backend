package ru.tisbi.college.students;

import org.hibernate.Hibernate;
import ru.tisbi.college.model.AbstractEntity;

import javax.persistence.*;
import java.time.Year;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "student_groups")
public class Group extends AbstractEntity {

    @Column(name = "admission_year")
    private Year admissionYear;

    @Column(name = "after_highschool", nullable = false)
    private boolean isAfterHighschool;

    @Column(name = "num", nullable = false)
    private Integer number;

    @ManyToOne(optional = false)
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    @OneToMany(mappedBy = "group", orphanRemoval = true)
    private Set<Student> students = new LinkedHashSet<>();

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Group group = (Group) o;
        return getId() != null && Objects.equals(getId(), group.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
