package com.namoo.event.service.facade;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.namoo.event.domain.Event;
import com.namoo.event.domain.ImageFile;
import com.namoo.event.shared.AbstractDbUnitTestCase;

public class EventServiceTest extends AbstractDbUnitTestCase{
	//
	private static final String DATASET_XML="EventServiceTest_dataset.xml";
	
	@Autowired
	private EventService service; 
	
	@Test
	@DatabaseSetup(DATASET_XML)
	public void testCreateEvent() {
		//
		Event event = new Event();
		event.setDescription("test");
		event.setLargeImg(new ImageFile("image/jpeg", "test1.jpg"));
		event.setSmallImg(new ImageFile("image/jpeg", "test2.jpg"));
		event.setName("test");
		event.setSummaryDes("testSummary");
		int id = service.createEvent(event);
		
		//assertion
		event = service.findEvent(id);
		assertThat(event.getDescription(), is("test"));
		assertThat(event.getId(), is(4));
		assertThat(event.getLargeImg().getFileName(), is("test1.jpg"));
		assertThat(event.getName(), is("test"));
		assertThat(event.getSmallImg().getFileName(), is("test2.jpg"));
		assertThat(event.getSummaryDes(), is("testSummary"));
		
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testFindEvent() {
		//
		Event event = service.findEvent(1);
		
		//assertion
		assertThat(event.getDescription(), is("event1상세설명입니다."));
		assertThat(event.getLargeImg().getFileName(), is("1-large"));
		assertThat(event.getName(), is("event1"));
		assertThat(event.getSmallImg().getFileName(), is("1-small"));
		assertThat(event.getSummaryDes(), is("event1입니다."));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testFindAllEvents() {
		//
		List<Event> events = service.findAllEvents();
		
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
	public void testAdjustEvent() {
		//
		Event event = service.findEvent(1);
		event.setDescription("test");
		event.setSummaryDes("test");
		service.adjustEvent(event);
		
		//assertion
		event = service.findEvent(1);
		assertThat(event.getDescription(), is("test"));
		assertThat(event.getSummaryDes(), is("test"));
	}

	@Test
	@DatabaseSetup(DATASET_XML)
	public void testRemoveEvent() {
		//
		service.removeEvent(1);
		
		//assertion
		assertNull(service.findEvent(1));
	}

}
