package ru.tisbi.college.events.plan;

import java.io.Serializable;

/**
 * A DTO for the {@link EventPlan} entity
 */
public record CreateEventPlanDto(Long eventModuleId, String title) implements Serializable {
}