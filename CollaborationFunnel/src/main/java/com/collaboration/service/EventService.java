package com.collaboration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.dao.EventDAOImpl;
import com.collaboration.model.Event;

@Service
@Transactional
public class EventService  {
	
	@Autowired
	public EventDAOImpl eventDAOImpl;
	
	public void addEvent(Event event)
	{
		eventDAOImpl.addEvent(event);
	}
	public List<Event> listEvent()
	{
		return eventDAOImpl.listEvent();
	}
	public void delete(int eventId)
	{
		eventDAOImpl.delete(eventId);
	}
	public Event get(int eventId)
	{
		return eventDAOImpl.get(eventId);
	}
	public void updateEvent(Event event)
	{
		eventDAOImpl.updateEvent(event);
	}
	public Event view(int eventId)
	{
		return eventDAOImpl.view(eventId);
	}
}
