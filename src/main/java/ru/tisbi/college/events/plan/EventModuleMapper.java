package ru.tisbi.college.events.plan;

public class EventModuleMapper {

    public static EventModuleDto toDto(EventModule module) {
        return new EventModuleDto(
                module.getNumber(),
                module.getTitle()
        );
    }
}
