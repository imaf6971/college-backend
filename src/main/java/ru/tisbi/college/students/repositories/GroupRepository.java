package ru.tisbi.college.students.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tisbi.college.students.entities.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
