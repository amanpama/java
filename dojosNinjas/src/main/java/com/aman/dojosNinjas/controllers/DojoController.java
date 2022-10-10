package com.aman.dojosNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aman.dojosNinjas.models.Dojo;
import com.aman.dojosNinjas.services.DojoService;

@Controller
public class DojoController {

	@Autowired
	private DojoService dojoService;

	@GetMapping("/")
	public String dojo(@ModelAttribute("dojo1") Dojo dojo1, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos", allDojos);

		return "/dojos/dojoIndex.jsp";
	}

	// post method = create d o j o
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo,
								BindingResult res) {
		if (res.hasErrors()) {
			return "/dojos/dojoIndex.jsp";	
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	// show dojos and ninjas displaying
	@GetMapping("/display/{id}")
	public String display(@PathVariable("id")Long id, Model model) {
	
	Dojo dojo = dojoService.findDojo(id);
	model.addAttribute("dojo", dojo);
	
	return "display.jsp";
	}
}
