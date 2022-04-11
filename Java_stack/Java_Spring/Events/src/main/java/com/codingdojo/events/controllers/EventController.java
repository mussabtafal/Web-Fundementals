package com.codingdojo.events.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.events.models.Event;
import com.codingdojo.events.models.Message;
import com.codingdojo.events.models.User;
import com.codingdojo.events.services.EventService;
import com.codingdojo.events.services.MessageService;

@Controller
public class EventController {
	private final EventService eventService;
	private final MessageService messageService;

	public EventController(EventService eventService, MessageService messageService) {
		this.eventService = eventService;
		this.messageService = messageService;
	}
	
	
	@GetMapping("/events")
	public String LandingPage (@ModelAttribute("event") Event event, BindingResult result, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			User thisUser = (User) session.getAttribute("user");
			List<Event> inStateEvents = eventService.findEventsByState(thisUser.getState());
			model.addAttribute("inStateEvent", inStateEvents);
			List<Event> outStateEvents = eventService.findEventsNotState(thisUser.getState());
			model.addAttribute("outStateEvent", outStateEvents);
			System.out.println(inStateEvents);
			System.out.println(outStateEvents);
			System.out.println(thisUser.getState());
			return "main.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@PostMapping ("/events")
	public String createEvent (@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			eventService.creatEvent(event, result);
			if (result.hasErrors()) {
				User thisUser = (User) session.getAttribute("user");
				List<Event> inStateEvents = eventService.findEventsByState(thisUser.getState());
				model.addAttribute("inStateEvent", inStateEvents);
				List<Event> outStateEvents = eventService.findEventsNotState(thisUser.getState());
				model.addAttribute("outStateEvent", outStateEvents);
				model.addAttribute("user", session.getAttribute("user"));
				return "main.jsp";
			}else {
				return "redirect:/events";
			}
		}else {
			return "redirect:/";
		}
	}
	@GetMapping("/events/{eventId}/join")
	public String joinEvent (@PathVariable("eventId") Long id, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			User thisUser = (User) session.getAttribute("user");
			Event thisEvent = eventService.findEventById(id);
			eventService.joinEvent(thisUser, thisEvent);
			return "redirect:/events";
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/events/{eventId}/cancel")
	public String cancelEvent (@PathVariable("eventId") Long id, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			User thisUser = (User) session.getAttribute("user");
			Event thisEvent = eventService.findEventById(id);
			eventService.cancelEvent(thisUser, thisEvent);
			return "redirect:/events";
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/events/{eventId}/edit")
	public String editEvent(@PathVariable("eventId") Long id, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			Event event = eventService.findEventById(id);
			model.addAttribute("myEvent",event);
			return "EditEvent.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	
	@PutMapping("/events/{eventId}/edit")
	public String updateEvent (@PathVariable("eventId") Long id, @Valid @ModelAttribute("myEvent") Event myEvent, BindingResult result,HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			System.out.println("before has errors");
			eventService.updateEvent(myEvent, result);
			if (result.hasErrors()) {
				System.out.println("after has errors");
				model.addAttribute("user", session.getAttribute("user"));
				Event thisEvent = eventService.findEventById(id);
				model.addAttribute("event",thisEvent);
				return "EditEvent.jsp";
			}else {
				return "redirect:/events";
			}
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/events/{eventId}/delete")
	public String deleteEvent (@PathVariable("eventId") Long id, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			eventService.deleteEvent(id);
			return "redirect:/events";
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/events/{eventId}")
	public String showEvent (@PathVariable("eventId") Long id, @ModelAttribute("message") Message message, BindingResult result, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			User thisUser = (User) session.getAttribute("user");
			model.addAttribute("user", session.getAttribute("user"));
			Event thisEvent = eventService.findEventById(id);
			model.addAttribute("event",thisEvent);
			return "ShowEvent.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	@PostMapping ("events/{eventId}")
	public String createMessage (@PathVariable("eventId") Long id, @Valid @ModelAttribute("message") Message message, BindingResult result, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			if (result.hasErrors()) {
				User thisUser = (User) session.getAttribute("user");
				model.addAttribute("user", session.getAttribute("user"));
				Event thisEvent = eventService.findEventById(id);
				model.addAttribute("event",thisEvent);
				return "ShowEvent.jsp";
			}else {
				messageService.createMessage(message);
				return "redirect:/events/"+ id;
			}
		}else {
			return "redirect:/";
		}
	}
}

