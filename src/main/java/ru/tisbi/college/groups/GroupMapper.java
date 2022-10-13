package ru.tisbi.college.groups;

public class GroupMapper {
    public static GroupDto toDto(Group group) {
        return new GroupDto(
                group.getId(),
                group.getSpecialization().getCode(),
                group.getAdmissionYear(),
                group.getNumber());
    }
}
