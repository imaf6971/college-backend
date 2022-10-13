package ru.tisbi.college.groups;

import ru.tisbi.college.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specializations")
public class Specialization extends AbstractEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "code", length = 4)
    private String code;

    public Specialization() {
    }

    public Specialization(String code) {
        this.code = code;
    }

    public Specialization(String title, String code) {
        this.title = title;
        this.code = code;
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
