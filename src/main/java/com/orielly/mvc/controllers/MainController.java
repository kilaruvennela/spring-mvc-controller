package com.orielly.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orielly.mvc.data.entities.Project;
import com.orielly.mvc.data.services.ProjectService;

@Controller
@RequestMapping("/home")
public class MainController {

	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "/")
	public String goHomeAgain(Model model, @ModelAttribute("project") Project project) {
		model.addAttribute("currentProject", project);
		return "home";
	}

	/*
	 * @RequestMapping(value = "/", params = "projectId") public String
	 * goHomeAgain(Model model, @RequestParam("projectId") Long projectId) {
	 * model.addAttribute("currentProject", this.projectService.find(projectId));
	 * return "home"; }
	 * 
	 * @RequestMapping("/") public String gretting(Model model) { Project project =
	 * new Project(); project.setName("First Project"); project.setSponsor(new
	 * Sponsor("NASA", "555-555-5555", "nasa@nasa.com"));
	 * project.setDescription("This is a simple project sponsored by Nasa");
	 * 
	 * model.addAttribute("currentProject", project);
	 * 
	 * return "home"; }
	 */
}
