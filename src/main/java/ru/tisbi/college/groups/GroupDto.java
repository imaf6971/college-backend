package ru.tisbi.college.groups;

import java.time.Year;

public record GroupDto(
        Long id,
        String specializationCode,
        Year admissionYear,
        Integer number
) {
}
