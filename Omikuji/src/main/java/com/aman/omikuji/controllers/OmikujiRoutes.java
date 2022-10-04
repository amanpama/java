package com.aman.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiRoutes {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
	session.setAttribute("name", "waldo");
	return "index.jsp";
	}
	@RequestMapping("/show")
	public String show() {
		
	return "show.jsp";
	}
	@RequestMapping(value="/processShow", method=RequestMethod.POST)
	public String processShow(@RequestParam("city") String city,
								@RequestParam("name")String name,
								@RequestParam("hobby")String hobby,
								@RequestParam("living")String living,
								@RequestParam("nice")String nice,
								HttpSession s) {
		s.setAttribute("city", city);
		s.setAttribute("name", name);
		s.setAttribute("hobby", hobby);
		s.setAttribute("living", living);
		s.setAttribute("nice", nice);
		return "redirect:/show";
	}
}
