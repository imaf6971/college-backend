package ru.tisbi.college.students.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tisbi.college.students.entities.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
