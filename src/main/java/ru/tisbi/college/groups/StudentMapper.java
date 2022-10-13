package ru.tisbi.college.groups;

public class StudentMapper {

    public static StudentDto toDto(Student student) {
        return new StudentDto(
                student.getFirstName(),
                student.getLastName(),
                student.getPatronymic()
        );
    }

}
