package com.example.devoir.controllers;

import com.example.devoir.entities.Event;
import com.example.devoir.entities.Participant;
import com.example.devoir.repositories.EventRepository;
import com.example.devoir.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @GetMapping
    public String listEvents(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "events/list";
    }

    @GetMapping("/add")
    public String showAddEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "events/add";
    }

    @PostMapping("/add")
    public String addEvent(@ModelAttribute Event event) {
        eventRepository.save(event);
        return "redirect:/events";
    }

    @GetMapping("/{id}")
    public String eventDetails(@PathVariable Long id, Model model) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (!optionalEvent.isPresent()) {
            throw new IllegalArgumentException("Invalid event Id:" + id);
        }
        Event event = optionalEvent.get();
        model.addAttribute("event", event);
        model.addAttribute("participants", participantRepository.findByEventId(id));
        model.addAttribute("newParticipant", new Participant());
        return "events/details";
    }

    @PostMapping("/{id}/participants/add")
    public String addParticipant(@PathVariable Long id, @ModelAttribute Participant newParticipant) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (!optionalEvent.isPresent()) {
            throw new IllegalArgumentException("Invalid event Id:" + id);
        }
        Event event = optionalEvent.get();
        newParticipant.setEvent(event);
        participantRepository.save(newParticipant);
        return "redirect:/events/" + id;
    }
}