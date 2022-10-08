package com.aman.safeTravels.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aman.safeTravels.models.Plan;
import com.aman.safeTravels.services.PlanService;

@Controller
public class PlanController {
	
	@Autowired
	private PlanService planServ;

	// page shows all the
	@GetMapping("/")
	public String index(Model model) {
		// get the plans
		List<Plan> alltheplans = planServ.allPlans();
		//pass the plans to the jsp
		model.addAttribute("alltheplans", alltheplans);
		
		return "index.jsp";
	}
	
	//PAGE WHERE WE CREATE BOOKS
	@GetMapping("/create")
	public String create(Model model) {
		//create book object
		Plan newPlan = new Plan();
		model.addAttribute("plan", newPlan);
		return "create.jsp";
	}
	
	// CREATE METHOD REDIREDCT
	@PostMapping("/plans")
    public String create(
    		@Valid @ModelAttribute("plan") Plan plan,
    		BindingResult result, RedirectAttributes flash) {
        if (result.hasErrors()) {
            return "create.jsp";
        } else {
            planServ.createPlan(plan);
            flash.addFlashAttribute("success", "You made plans");
            return "redirect:/";
        }
    }
	
	// EDIT PAGE
	@GetMapping("/edit/{id}")
	public String updatePage(@PathVariable("id")Long id, Model model) {
		Plan plan = planServ.findPlan(id);
		model.addAttribute("plan", plan);
		return "edit.jsp";
	}
	
	
	//edit method
	@RequestMapping(value="/plans/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("plan") Plan plan, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            planServ.updatePlan(plan);
            return "redirect:/";
        }
    }
	
	//DELETE
	
	@RequestMapping(value="/plans/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        planServ.deletePlan(id);
        return "redirect:/";
    }
	
	//SHOW ONE
	@GetMapping("/plans/{id}")
	public String showOne(@PathVariable("id")Long id, Model model) {
		Plan thisPlan = planServ.findPlan(id);
		model.addAttribute("thisPlan", thisPlan);
		return "showOne.jsp";
	}
		
	
	
	
}
