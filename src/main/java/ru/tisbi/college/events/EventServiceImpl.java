package ru.tisbi.college.events;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
                .map(this::toDto)
                .toList();
    }

    private EventDto toDto(Event event) {
        return new EventDto(
                event.getId(),
                event.getTitle(),
                event.getDate(),
                event.getPoints()
        );
    }

    @Override
    public void createEvents(CreateEventDto createEvent) {
        var event = new Event();
        event.setDate(createEvent.date());
        event.setPoints(createEvent.points());
        event.setTitle(createEvent.title());
        eventRepository.save(event);
    }

    @Override
    public EventDto getEventById(Long id) {
        return toDto(getById(id));
    }

    private Event getById(Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event not found!"));
    }

}
