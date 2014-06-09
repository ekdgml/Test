package com.namoo.event.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namoo.event.dao.EventDao;
import com.namoo.event.domain.Event;
import com.namoo.event.service.facade.EventService;

@Service
public class EventServiceLogic implements EventService {
	//
	@Autowired
	private EventDao dao;
	
	@Override
	public int createEvent(Event event) {
		//
		dao.createEvent(event);
		return event.getId();
	}

	@Override
	public Event findEvent(int id) {
		//
		return dao.readEvent(id);
	}

	@Override
	public List<Event> findAllEvents() {
		//
		return dao.readAllEvent();
	}

	@Override
	public void adjustEvent(Event event) {
		//
		dao.updateEvent(event);
	}

	@Override
	public void removeEvent(int id) {
		//
		dao.deleteEvent(id);
	}

}
