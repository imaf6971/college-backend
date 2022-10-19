package ru.tisbi.college.events.plan;

import java.io.Serializable;
import java.time.Month;

/**
 * A DTO for the {@link EventPlan} entity
 */
public record CreateEventPlanDto(Long eventModuleId, String title, Month month) implements Serializable {
}