package ru.tisbi.college.groups;

import java.time.Year;

public record AddGroupDto(
        Year admissionYear,
        Long specializationId,
        Boolean isAfterHighSchool
) {
}
