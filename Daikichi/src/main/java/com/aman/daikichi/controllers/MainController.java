package com.aman.daikichi.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping("/travel/{var1}")
	public String find(@PathVariable("var1") String var1) {
		return "Congratulations! You will soon travel to " + var1;
	}

	@RequestMapping("/lotto/{int1}")
	public String look(@PathVariable("int1") int int1) {
		if (int1 % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		} else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends ";
		}
	}
}
