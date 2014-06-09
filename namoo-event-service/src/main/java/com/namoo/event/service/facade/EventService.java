package com.namoo.event.service.facade;

import java.util.List;

import com.namoo.event.domain.Event;

public interface EventService {
	//
	int createEvent(Event event);
	Event findEvent(int id);
	List<Event> findAllEvents();
	void adjustEvent(Event event);
	void removeEvent(int id);
}
