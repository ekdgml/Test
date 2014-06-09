package com.namoo.event.dao;

import java.util.List;

import com.namoo.event.domain.Event;

public interface EventDao {
	//
	// create, read, update, delete
	int createEvent(Event event);
	Event readEvent(int id);
	List<Event> readAllEvent();
	void updateEvent(Event event);
	void deleteEvent(int id);
}
