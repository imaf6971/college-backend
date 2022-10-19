package ru.tisbi.college.events.plan;

import java.time.Month;
import java.util.Collection;

public interface EventPlanService {

    Collection<PlanDto> getEventPlanByMonth(Month month);

    void planEvent(CreateEventPlanDto eventPlanDto);

}
