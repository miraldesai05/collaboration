package com.collaboration.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.model.Event;
import com.collaboration.service.EventService;

@RestController
public class EventController {
	
	@Autowired(required = true)
	private EventService eventService;	
	
	@RequestMapping(value="/event", method=RequestMethod.GET)
	public ResponseEntity<List<Event>> listEvents(){
		
		List<Event> event = eventService.listEvent();
		if(event.isEmpty()){		
			return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);		
		}	
		return new ResponseEntity<List<Event>>(event,HttpStatus.OK);	
	}
	
	@RequestMapping(value="/event", method=RequestMethod.POST)
	public ResponseEntity<Event> createEvent(@RequestBody Event event, HttpSession session){
		
		if(eventService.get(event.getEventId())== null)
		{
			int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
			event.setUserId(loggedInUserID);
			eventService.addEvent(event);
			return new ResponseEntity<Event>(event,HttpStatus.OK);
		}
		return new ResponseEntity<Event>(event,HttpStatus.OK);
	}
	
	@RequestMapping(value="/event/{eventId}", method=RequestMethod.DELETE)
	public ResponseEntity<Event> deleteEvent(@PathVariable("eventId") int eventId)
	{
		Event event=eventService.get(eventId);
		if(event==null)
		{
			event=new Event();
			return new ResponseEntity<Event>(event,HttpStatus.NOT_FOUND);
		}
		eventService.delete(eventId);
		return new ResponseEntity<Event>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/event/{eventId}", method=RequestMethod.GET)
	public ResponseEntity<Event> getEvent(@PathVariable("eventId") int eventId)
	{
		Event event=eventService.get(eventId);
		if(event==null)
		{
			event=new Event();
			return new ResponseEntity<Event>(event,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Event>(event,HttpStatus.OK);
	}
	
	@RequestMapping(value="/event/{eventId}", method=RequestMethod.PUT)
	public ResponseEntity<Event> updateEvent(@RequestBody Event event){
		
		if(eventService.get(event.getEventId())== null)
		{
			event=new Event();
			return new ResponseEntity<Event>(event,HttpStatus.NOT_FOUND);	
		}
		eventService.updateEvent(event);
		return new ResponseEntity<Event>(event,HttpStatus.OK);
	}
}
	

