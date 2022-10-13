package ru.tisbi.college.groups;

import ru.tisbi.college.model.AbstractEntity;

import javax.persistence.*;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group extends AbstractEntity {

    @Column(name = "admission_year", nullable = false)
    private Year admissionYear;

    @Column(name = "after_high_school", nullable = false)
    private boolean isAfterHighSchool;

    @ManyToOne(optional = false)
    @JoinColumn(name = "specialization_id", nullable = false)
    private Specialization specialization;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private Set<Student> students = new LinkedHashSet<>();

    @Column(name = "number", nullable = false)
    private int number;

    public Group() {}

    public Group(Specialization specialization, Year admissionYear, boolean isAfterHighSchool, int number) {
        this.specialization = specialization;
        this.admissionYear = admissionYear;
        this.isAfterHighSchool = isAfterHighSchool;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Year getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(Year admissionYear) {
        this.admissionYear = admissionYear;
    }

    public boolean isAfterHighSchool() {
        return isAfterHighSchool;
    }

    public void setAfterHighSchool(boolean afterHighSchool) {
        isAfterHighSchool = afterHighSchool;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getTitle() {
        var builder = new StringBuilder();
        builder.append(getSpecialization().getCode());
        builder.append('-');
        builder.append(admissionYear.format(DateTimeFormatter.ofPattern("uu")));

        if (isAfterHighSchool) {
            builder.append(2);
        } else {
            builder.append(1);
        }

        builder.append('.');
        builder.append(getNumber());
        return builder.toString();
    }
}
