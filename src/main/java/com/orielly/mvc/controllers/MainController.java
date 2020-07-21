package com.orielly.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orielly.mvc.data.entities.Project;
import com.orielly.mvc.data.entities.Sponsor;

@Controller
@RequestMapping("/home")
public class MainController {

	@RequestMapping("/")
	public String gretting(Model model) {
		Project project = new Project();
		project.setName("First Project");
		project.setSponsor(new Sponsor("NASA", "555-555-5555", "nasa@nasa.com"));
		project.setDescription("This is a simple project sponsored by Nasa");

		model.addAttribute("currentProject", project);

		return "home";
	}
}
