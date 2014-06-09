package com.namoo.event.dao.sqlmap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.event.dao.EventDao;
import com.namoo.event.dao.sqlmap.mapper.EventMapper;
import com.namoo.event.domain.Event;

@Repository
public class EventDaoSqlMap implements EventDao {
	//
	@Autowired
	private EventMapper mapper;
	
	@Override
	public int createEvent(Event event) {
		//
		mapper.insertEvent(event);
		return event.getId();
	}

	@Override
	public Event readEvent(int id) {
		//
		return mapper.selectEvent(id);
	}

	@Override
	public List<Event> readAllEvent() {
		//
		return mapper.selectAllEvent();
	}

	@Override
	public void updateEvent(Event event) {
		//
		mapper.updateEvent(event);
	}

	@Override
	public void deleteEvent(int id) {
		//
		mapper.deleteEvent(id);
	}

}
