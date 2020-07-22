package com.orielly.mvc.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.orielly.mvc.HitCounter;
import com.orielly.mvc.data.entities.Project;
import com.orielly.mvc.data.services.ProjectService;
import com.orielly.mvc.data.validators.ProjectValidator;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@Autowired
	HitCounter hitCounter;

	@RequestMapping("/find")
	public String find(Model model) {
		model.addAttribute("projects", projectService.findAll());
		return "projects";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProject(Model model) {

		hitCounter.setHits(hitCounter.getHits() + 1);
		System.out.println(hitCounter.getHits());

		model.addAttribute("types", new ArrayList<String>() {
			{
				add("");
				add("Single Year");
				add("Multi Year");
			}
		});
		model.addAttribute("project", new Project());

		return "project_add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveProject(@Valid @ModelAttribute Project project, Errors errors,
			RedirectAttributes redirectAttributes) {
		System.out.println("invoking save project");

		project.setProjectId(55L);
		this.projectService.save(project);
		redirectAttributes.addFlashAttribute("project", project);
		return "redirect:/home/";
	}

	@RequestMapping(value = "/{projectId}")
	public String findProject(Model model, @PathVariable("projectId") Long projectIdValue) {
		model.addAttribute("project", this.projectService.find(projectIdValue));
		return "project";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, params = { "type=multi" })
	public String multiYearProject() {
		System.out.println("Invoking multiYear project");
		return "project_add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, params = { "type=multi", "special" })
	public String specialProject() {
		System.out.println("Invoking multi year special project");
		return "project_add";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProjectValidator());
	}

	@ResponseBody
	@RequestMapping(value = "/api/{projectId}")
	public Project findProjectObject(@PathVariable("projectId") Long projectId) {
		return this.projectService.find(projectId);
	}
}
