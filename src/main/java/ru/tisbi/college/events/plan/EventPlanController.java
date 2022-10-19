package ru.tisbi.college.events.plan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;
import java.util.Collection;

@RestController
@RequestMapping("/api/event-plan")
public class EventPlanController {

    private final EventPlanService planService;

    public EventPlanController(EventPlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public Collection<PlanDto> getPlanByMonth(@RequestParam Month month) {
        return planService.getEventPlanByMonth(month);
    }

}
