package ru.tisbi.college.events;

import java.time.LocalDate;

public record EventDto(
        Long id,
        String title,
        LocalDate date,
        int points
) {
}
