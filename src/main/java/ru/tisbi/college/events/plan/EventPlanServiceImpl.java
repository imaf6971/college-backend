package ru.tisbi.college.events.plan;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Month;
import java.util.Collection;

@Service
public class EventPlanServiceImpl implements EventPlanService {

    private final EventPlanRepository planRepository;

    private final EventModuleRepository moduleRepository;

    public EventPlanServiceImpl(EventPlanRepository planRepository, EventModuleRepository moduleRepository) {
        this.planRepository = planRepository;
        this.moduleRepository = moduleRepository;
    }

    @Override
    public Collection<PlanDto> getEventPlanByMonth(Month month) {
        return moduleRepository.findAll().stream()
                .map(module -> getPlanEntry(month, module))
                .toList();
    }

    private PlanDto getPlanEntry(Month month, EventModule module) {
        return new PlanDto(
                EventModuleMapper.toDto(module),
                module.getPlannedEvents().stream()
                        .filter(eventPlan -> eventPlan.getMonth().equals(month))
                        .map(this::toDto)
                        .toList()
        );
    }

    private EventPlanDto toDto(EventPlan eventPlan) {
        return new EventPlanDto(
                eventPlan.getId(),
                eventPlan.getTitle()
        );
    }

    @Override
    public void planEvent(CreateEventPlanDto eventPlanDto) {
        var eventPlan = new EventPlan();
        eventPlan.setTitle(eventPlanDto.title());
        eventPlan.setMonth(eventPlanDto.month());
        eventPlan.setEventModule(getEventModuleById(eventPlanDto.eventModuleId()));
        planRepository.save(eventPlan);
    }

    private EventModule getEventModuleById(Long eventModuleId) {
        return moduleRepository.findById(eventModuleId)
                .orElseThrow(() -> new EntityNotFoundException("Event module not found"));
    }

}
