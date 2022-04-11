package com.codingdojo.events.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.events.models.Event;
import com.codingdojo.events.models.User;
import com.codingdojo.events.repositories.EventRepository;

@Service
public class EventService {
	private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> allEvents(){
        return eventRepository.findAll();
    }

    public List<Event> findEventsByState(String state){
        return eventRepository.findByState(state);
    }

    public List<Event> findEventsNotState(String state){
        return eventRepository.findByStateNot(state);
    }
    
    public Event findEventById (Long id) {
    	Optional<Event> thisEvent = eventRepository.findById(id);
    	return thisEvent.get();
    }

    public Event creatEvent(Event event, BindingResult result) {
    	LocalDate currentDate = LocalDate.now();  	
		if (event.getEventDate() == null) {
			result.rejectValue("eventDate", "Exist", "Please enter your birthday");
			return null;}
		
		if (event.getEventDate().isBefore(currentDate)) {
			result.rejectValue("eventDate", "Compare", "Date mustb be in the future");
			return null;
		}
        return eventRepository.save(event);
    }

    public Event updateEvent(Event event, BindingResult result) {
    	LocalDate currentDate = LocalDate.now();  	
		if (event.getEventDate() == null) {
			result.rejectValue("eventDate", "Exist", "Please enter a Date");
			return null;}
		System.out.println("service check");
		if (event.getEventDate().isBefore(currentDate)) {
			result.rejectValue("eventDate", "Compare", "Date mustb be in the future");
			return null;
		}
		if(result.hasErrors()) {
			return null;
		}
        Event editEvent = eventRepository.findById(event.getId()).orElse(null);
        assert editEvent!=null;
        editEvent.setName(event.getName());
        editEvent.setEventDate(event.getEventDate());
        editEvent.setLocation(event.getLocation());
        editEvent.setState(event.getState());
        return eventRepository.save(editEvent);
    }
    
	public void deleteEvent(Long id) {
		Event thisEvent = eventRepository.findById(id).orElse(null);
		eventRepository.delete(thisEvent);
	}
    
  //Relating Users with Projects as either TeamLeaders or JoinTeams
	
  	public Event joinEvent (User user, Event event) {
  		event.getJoinedUsers().add(user);
  		return eventRepository.save(event);
  	}
  	
  	public Event cancelEvent(User user, Event event) {
  		event.getJoinedUsers().removeIf(item -> item.getId().equals(user.getId()));
  		return eventRepository.save(event);
  	}
    
}
