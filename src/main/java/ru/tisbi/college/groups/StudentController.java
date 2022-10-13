package ru.tisbi.college.groups;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/groups/{groupId}/students")
public class StudentController {

    private final GroupService groupService;

    public StudentController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public void addStudent(
            @PathVariable Long groupId,
            @RequestBody AddStudentDto addStudent
            ) {
        groupService.addStudent(groupId, addStudent);
    }

    @GetMapping
    public Collection<StudentDto> getStudents(@PathVariable Long groupId) {
        return groupService.getStudents(groupId);
    }

}
