package com.aman.exam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aman.exam.models.Baby;
import com.aman.exam.services.BabyService;
import com.aman.exam.services.UserService;

@Controller
public class BabyController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BabyService babyService;

	
	//PAGE WHERE WE CREATE BOOKS
	@GetMapping("/create")
	public String create(Model model, HttpSession session) {
		//create baby object
		Baby newBaby = new Baby();
		model.addAttribute("baby", newBaby);
		Long user_id = (Long) session.getAttribute("user_id");
		model.addAttribute("user", user_id);
		return "create.jsp";
	}
	
	// CREATE METHOD REDIREDCT
	@PostMapping("/babys")
    public String create(
    		@Valid @ModelAttribute("baby") Baby baby,
    		BindingResult result, RedirectAttributes flash) {
        if (result.hasErrors()) {
            return "create.jsp";
        } else {
            babyService.createBaby(baby);
            flash.addFlashAttribute("success", "You made babys");
            return "redirect:/success";
        }
    }
	
	// EDIT PAGE
	@GetMapping("/edit/{id}")
	public String updatePage(@PathVariable("id")Long id, Model model) {
		Baby baby = babyService.findBaby(id);
		model.addAttribute("baby", baby);
		return "edit.jsp";
	}
	
	
	//edit method
	@RequestMapping(value="/babys/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("baby") Baby baby, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            babyService.updateBaby(baby);
            return "redirect:/success";
        }
    }
	
	//DELETE
	
	@RequestMapping(value="/babys/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        babyService.deleteBaby(id);
        return "redirect:/success";
    }
	
	//SHOW ONE
	@GetMapping("/babys/{id}")
	public String showOne(@PathVariable("id")Long id, Model model, HttpSession session) {
		Baby thisBaby = babyService.findBaby(id);
		model.addAttribute("thisBaby", thisBaby);
		Long user_id = (Long) session.getAttribute("user_id");
		model.addAttribute("user", user_id);
		return "showOne.jsp";
	}
		
	
	
	
}
