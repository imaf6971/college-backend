package ru.tisbi.college.events;

import java.util.List;

public interface EventService {

    List<EventDto> getEvents();

    void createEvents(CreateEventDto createEvent);

    EventDto getEventById(Long id);
}
