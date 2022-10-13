package ru.tisbi.college.events;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<EventDto> getEvents() {
        return eventRepository.findAll().stream()
                .map(EventMapper::toDto)
                .toList();
    }

    @Override
    public void createEvents(CreateEventDto createEvent) {
        var event = new Event(
                createEvent.title(),
                createEvent.date(),
                createEvent.points()
        );
        eventRepository.save(event);
    }

    @Override
    public EventDto getEventById(Long id) {
        return null;
    }

}
