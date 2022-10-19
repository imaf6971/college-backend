package ru.tisbi.college.events.plan;

import java.util.Collection;

public record PlanDto(
        EventModuleDto module,
        Collection<EventPlanDto> events
) {
}
