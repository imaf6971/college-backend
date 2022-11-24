package ru.tisbi.college.students.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tisbi.college.students.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
