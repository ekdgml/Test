package com.namoo.event.dao.sqlmap.mapper;

import java.util.List;

import com.namoo.event.domain.Event;

public interface EventMapper {
	//
	// insert, select, update, delete
	void insertEvent(Event event);
	Event selectEvent(int id);
	List<Event> selectAllEvent();
	void updateEvent(Event event);
	void deleteEvent(int id);
}
