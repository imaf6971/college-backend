package ru.tisbi.college.groups;

import java.util.Collection;

public interface GroupService {
    void addGroup(AddGroupDto addGroup);

    void addStudent(Long groupId, AddStudentDto addStudent);

    Collection<StudentDto> getStudents(Long groupId);

    Collection<GroupDto> getGroups();
}
