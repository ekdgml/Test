package com.namoo.exam.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.namoo.exam.domain.User;

@Controller
public class ExamController {
	//
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String main(Model model) {
		//
		List<User> users = new ArrayList<User>(createUserMap().values());
		model.addAttribute("users", users);
		
		return "/index";
	}
	
	@RequestMapping(value= "/detail", method = RequestMethod.GET)
	@ResponseBody   //결과값을 json으로 변환!
	public User getUser(@RequestParam("name") String name) {
		//
		Map<String, User> map = createUserMap();
		return map.get(name);
	}
	
	//----------------------------------------------------------------
	
	private Map<String, User> createUserMap() {
		//
		Map<String, User> users = new HashMap<String, User>();
		users.put("sanghee", new User("sanghee", "ekdgml@naver.com"));
		users.put("hong", new User("hong", "hong@naver.com"));
		return users;
	}
}
