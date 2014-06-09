package com.namoo.event.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.namoo.event.domain.Event;
import com.namoo.event.domain.ImageFile;
import com.namoo.event.service.facade.EventService;
import com.namoo.event.web.controller.cmd.EventCommand;

@Controller
public class EventController {
	//
	@Value("#{event['imageRootPath']}")
	private String imageRoot;
	
	@Autowired
	private EventService service;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public ModelAndView main() {
		//
		List<Event> events = service.findAllEvents();
		return new ModelAndView("/main", "events", events);
	}
	
	@RequestMapping(value = "/{eventId}/smallImg", method = RequestMethod.GET)
	public void getSmallImage(@PathVariable("eventId")int eventId, HttpServletResponse resp) throws IOException {
		//
		Event event = service.findEvent(eventId);
		ImageFile imageFile = event.getSmallImg();
		String contentType = null;
		InputStream in = null;
		if (imageFile != null) {
			contentType = imageFile.getContentType();
			in = new FileInputStream(new File(imageRoot + imageFile.getFileName()));
		} else {
			contentType = "image/jpeg";
			in = this.getClass().getResourceAsStream("/default.jpg");
		}
		try {
			resp.setContentType(contentType);
			IOUtils.copy(in, resp.getOutputStream());
		} finally {
			IOUtils.closeQuietly(in);
		}
	}
	
	@RequestMapping(value = "/{eventId}/largeImg", method = RequestMethod.GET)
	public void getLargeImage(@PathVariable("eventId")int eventId, HttpServletResponse resp) throws IOException {
		//
		Event event = service.findEvent(eventId);
		ImageFile imageFile = event.getLargeImg();
		String contentType = null;
		InputStream in = null;
		if (imageFile != null) {
			contentType = imageFile.getContentType();
			in = new FileInputStream(new File(imageRoot + imageFile.getFileName()));
		} else {
			contentType = "image/jpeg";
			in = this.getClass().getResourceAsStream("/default.jpg");
		}
		try {
			resp.setContentType(contentType);
			IOUtils.copy(in, resp.getOutputStream());
		} finally {
			IOUtils.closeQuietly(in);
		}
	}
	
	@RequestMapping(value="/registEvent", method=RequestMethod.GET)
	public String getCreateEvent() {
		//
		return "/register";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String createEvent(EventCommand command, @RequestParam("smallImg") MultipartFile small, @RequestParam("largeImg") MultipartFile large) throws IOException {
		//
		Event event = new Event();
		event.setDescription(command.getDescription());
		event.setName(command.getName());
		event.setOpenDate(command.getOpenDate());
		event.setSummaryDes(command.getSummaryDes());
		int eventId = service.createEvent(event);

		event.setId(eventId);
		if (small != null && large != null) {
			setupImage(event, large, true);
			setupImage(event, small, false);
			
			service.adjustEvent(event);
		} else {
			
		}
		return "redirect:/main";
	}
	
	@RequestMapping(value= "/detail", method = RequestMethod.GET)
	@ResponseBody 
	public Event getEvent(@RequestParam("id") int id) {
		//
		return service.findEvent(id);
	}
	
	@RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
	public String removeEvent(@PathVariable("id") int id) {
		//
		service.removeEvent(id);
		return "redirect:/main";
	}
	
	//-------------------------------------------------------------------------------------
	//private method
	
	private void setupImage(Event event, MultipartFile file, boolean isLarge) throws IOException {
		//
		if (file.isEmpty()) return;
		//
		StringBuffer sb = new StringBuffer();
		if (isLarge) {
			sb.append(event.getId()+"_large");
		}else {
			sb.append(event.getId()+"_small");
		}
		sb.append(".");
		sb.append(FilenameUtils.getExtension(file.getOriginalFilename()));
		String saveFileName = sb.toString();
		File saveFile = new File(imageRoot + saveFileName);
		
		FileCopyUtils.copy(file.getBytes(), saveFile);
		System.out.println("image saved in " + saveFile.getCanonicalPath());
		
		String contentType = file.getContentType();
		if (isLarge){
			event.setLargeImg(new ImageFile(contentType, saveFileName));
		} else {
			event.setSmallImg(new ImageFile(contentType, saveFileName));
		}
	}
}
