package com.aman.loginAndReg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aman.loginAndReg.models.LoginUser;
import com.aman.loginAndReg.models.User;
import com.aman.loginAndReg.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/home")
	public String index(Model model) {
		// Bind empty User and LoginUser objects to the JSP
		// to capture the form input
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {
		// 1. execute service method
		userService.register(newUser, result);
		// TO-DO Later -- call a register method in the service
		// to do some extra validations and create a new user!

		if (result.hasErrors()) {
			// Be sure to send in the empty LoginUser before
			// re-rendering the page.
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		} else {
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/success";
		}

	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		// Add once service is implemented:
		User user = userService.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		} else {
			session.setAttribute("user_id", user.getId());
			return "redirect:/success";
		}
		// No errors!
		// TO-DO Later: Store their ID from the DB in session,
		// in other words, log them in.
	}

	@GetMapping("/success")
	public String success(HttpSession s, Model model) {

		Long userId = (Long) s.getAttribute("user_id");
		// check if logged user is in session
		if (userId == null) {
			return "redirect:/home";
		} else {
			User thisUser = userService.findOne(userId);
			model.addAttribute("thisUser", thisUser);
			return "success.jsp";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		model.addAttribute("newLogin", new LoginUser());
		session.invalidate();
		return "redirect:/home";
	}

}
