package com.example.demo.Service;

import com.example.demo.Repository.EventRepository;
import com.example.demo.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService {

    private final EventRepository eventRepository;
    public EventService(EventRepository eventRepository)
    {
        this.eventRepository=eventRepository;
    }
    public Event addEvent(Event event)
    {
        return eventRepository.save(event);
    }
    public List<Event> getAllEvents()
    {
        return  eventRepository.findAll();
    }
    public Optional<Event> getEventById(Long id)
    {
        return eventRepository.findById(id);
    }
    public Event updateEvent(Long id,Event updatedEvent)
    {

        return eventRepository.findById(id).map(event->{
            event.setEventName(updatedEvent.getEventName());
            event.setEventLocation(updatedEvent.getEventLocation());
            event.setDate(updatedEvent.getDate());
            return eventRepository.save(event);
        }).orElseThrow(()->new RuntimeException("Event not found with the id"));
    }

    public void deleteEvent(Long id)
    {
        if(!eventRepository.existsById(id))
        {
            throw  new RuntimeException("Event not Found with id: "+id);
        }
        eventRepository.deleteById(id);
    }

}
