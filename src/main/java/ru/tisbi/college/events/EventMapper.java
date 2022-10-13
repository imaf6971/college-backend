package ru.tisbi.college.events;

public class EventMapper {

    public static EventDto toDto(Event event) {
        return new EventDto(
                event.getId(),
                event.getTitle(),
                event.getDate(),
                event.getPoints()
        );
    }

}
