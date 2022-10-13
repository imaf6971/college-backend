package ru.tisbi.college.groups;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    private final SpecializationRepository specializationRepository;

    public GroupServiceImpl(GroupRepository groupRepository, SpecializationRepository specializationRepository) {
        this.groupRepository = groupRepository;
        this.specializationRepository = specializationRepository;
    }

    @Override
    public void addGroup(AddGroupDto addGroup) {
        var group = new Group();
        group.setAdmissionYear(addGroup.admissionYear());
        group.setSpecialization(getSpecializationById(addGroup.specializationId()));
        group.setAfterHighSchool(addGroup.isAfterHighSchool());
        groupRepository.save(group);
    }

    @Override
    public void addStudent(Long groupId, AddStudentDto addStudent) {
        var group = getGroupById(groupId);
        var student = createStudent(addStudent);
        group.addStudent(student);
        groupRepository.save(group);
    }

    @Override
    public Collection<StudentDto> getStudents(Long groupId) {
        var group = getGroupById(groupId);

        return group.getStudents().stream()
                .map(StudentMapper::toDto)
                .toList();
    }

    @Override
    public Collection<GroupDto> getGroups() {
        return groupRepository.findAll().stream()
                .map(GroupMapper::toDto)
                .toList();
    }

    private Student createStudent(AddStudentDto addStudent) {
        var student = new Student();
        student.setFirstName(addStudent.firstName());
        student.setLastName(addStudent.lastName());
        student.setPatronymic(addStudent.patronymic());
        return student;
    }

    private Group getGroupById(Long groupId) {
        return groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Can't find group with id " + groupId));
    }

    private Specialization getSpecializationById(Long specializationId) {
        return specializationRepository.findById(specializationId)
                .orElseThrow(() -> new RuntimeException("Can't find specialization with id " + specializationId));
    }

}
