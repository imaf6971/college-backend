package ru.tisbi.college.events;

import java.time.LocalDate;

public record CreateEventDto(
        String title,
        LocalDate date,
        int points
) {
}
