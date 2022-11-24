package ru.tisbi.college.students;

import ru.tisbi.college.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "faculties")
public class Faculty extends AbstractEntity {

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "faculty_code", nullable = false, unique = true, length = 4)
    private String code;

    @OneToMany(mappedBy = "faculty", orphanRemoval = true)
    private Set<Group> groups = new LinkedHashSet<>();

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
