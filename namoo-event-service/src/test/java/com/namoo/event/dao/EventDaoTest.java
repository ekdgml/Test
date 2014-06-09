package com.namoo.event.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.namoo.event.domain.Event;
import com.namoo.event.domain.ImageFile;
import com.namoo.event.shared.AbstractDbUnitTestCase;


public class EventDaoTest extends AbstractDbUnitTestCase{
	//
	private static final String DATASET_XML="EventDaoTest_dataset.xml";
	
	@Autowired
	private EventDao dao;
	
	@Test
	@DatabaseSetup(DATASET_XML)
	public void testCreateEvent() {
		Event event = new Event();
		event.setDescription("test");
		event.setLargeImg(new ImageFile("image/jpeg", "test1.jpg"));
		event.setSmallImg(new ImageFile("image/jpeg", "test2.jpg"));
		event.setName("test");
		event.setSummaryDes("testSummary");
		int id = dao.createEvent(event);
		
		//assertion
		event = dao.readEvent(id);
		assertThat(event.getDescription(), is("test"));
		assertThat(event.getId(), is(5));
		assertThat(event.getLargeImg().getFileName(), is("test1.jpg"));
		assertThat(event.getName(), is("test"));
		assertThat(event.getSmallImg().getFileName(), is("test2.jpg"));
		assertThat(event.getSummaryDes(), is("testSummary"));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testReadEvent() {
		//
		Event event = dao.readEvent(1);
		
		//assertion
		assertThat(event.getDescription(), is("event1상세설명입니다."));
		assertThat(event.getLargeImg().getFileName(), is("1-large"));
		assertThat(event.getName(), is("event1"));
		assertThat(event.getSmallImg().getFileName(), is("1-small"));
		assertThat(event.getSummaryDes(), is("event1입니다."));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testReadAllEvent() {
		//
		List<Event> events = dao.readAllEvent();
		
		//assertion
		assertThat(events.size(), is(3));
		assertThat(events.get(0).getName(), is("event1"));
		assertThat(events.get(0).getSummaryDes(), is("event1입니다."));
		assertThat(events.get(1).getName(), is("event2"));
		assertThat(events.get(1).getSummaryDes(), is("event2입니다."));
		assertThat(events.get(2).getName(), is("event3"));
		assertThat(events.get(2).getSummaryDes(), is("event3입니다."));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testUpdateEvent() {
		//
		Event event = dao.readEvent(1);
		event.setDescription("test");
		event.setSummaryDes("test");
		dao.updateEvent(event);
		
		//assertion
		event = dao.readEvent(1);
		assertThat(event.getDescription(), is("test"));
		assertThat(event.getSummaryDes(), is("test"));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testDeleteEvent() {
		//
		dao.deleteEvent(1);
		
		//assertion
		assertNull(dao.readEvent(1));
	}
}
