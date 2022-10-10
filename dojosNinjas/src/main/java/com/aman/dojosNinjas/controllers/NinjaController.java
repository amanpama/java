package com.aman.dojosNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aman.dojosNinjas.models.Dojo;
import com.aman.dojosNinjas.models.Ninja;
import com.aman.dojosNinjas.services.DojoService;
import com.aman.dojosNinjas.services.NinjaService;

@Controller
public class NinjaController {

	
	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;

	@GetMapping("/newninja")
	public String ninja(@ModelAttribute("ninjas") Ninja ninjas, Model model) {
		List<Ninja> allNinjas = ninjaService.allNinjas();
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allNinjas", allNinjas);
		model.addAttribute("allDojos", allDojos);
		return "newNinja.jsp";
	}

	// post method = create ninja
	@PostMapping("/ninjas")
	public String createNinja(@Valid @ModelAttribute("ninjas") Ninja ninja,
								BindingResult res, Model model) {
		if (res.hasErrors()) {
			List<Dojo> allDojos = dojoService.allDojos();
			model.addAttribute("allDojos", allDojos);
			
			return "newNinja.jsp";	
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/newninja";
		}
	}
}
