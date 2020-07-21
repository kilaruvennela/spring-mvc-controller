package com.orielly.mvc.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.orielly.mvc.data.entities.Resource;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
public class ResourceController {

	@RequestMapping("/add")
	public String add(Model model) {
		/*
		 * model.addAttribute("resource", new Resource());
		 * 
		 * List<String> options = new ArrayList<String>( Arrays.asList(new String[] {
		 * "Material", "Staff", "Other", "Equipment" }));
		 * model.addAttribute("typeOptions", options);
		 * 
		 * List<String> radios = new ArrayList<String>(Arrays.asList(new String[] {
		 * "Hours", "Piece", "Tons" })); model.addAttribute("radioOptions", radios);
		 * 
		 * List<String> checks = new ArrayList<String>( Arrays.asList(new String[] {
		 * "Lead Time", "Special Rate", "Requires Approval" }));
		 * model.addAttribute("checkOptions", checks);
		 */
		System.out.println("Invoking add method");
		return "resource_add";
	}

	@ModelAttribute(name = "resource")
	public Resource getResource() {
		System.out.println("Adding an attribute to the model");
		return new Resource();
	}

	@ModelAttribute(value = "checkOptions")
	public List<String> getChecks() {
		return new ArrayList<String>(Arrays.asList(new String[] { "Lead Time", "Special Rate", "Requires Approval" }));
	}

	@ModelAttribute(value = "radioOptions")
	public List<String> getRadios() {
		return new ArrayList<String>(Arrays.asList(new String[] { "Hours", "Piece", "Tons" }));
	}

	@ModelAttribute(value = "typeOptions")
	public List<String> getTypes() {
		return new ArrayList<String>(Arrays.asList(new String[] { "Material", "Staff", "Other", "Equipment" }));
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource, SessionStatus status) {
		System.out.println(resource);
		System.out.println("Invoking the save method");
		status.setComplete();
		return "redirect:/resource/add";
	}

	@RequestMapping("/review")
	public String review(@ModelAttribute Resource resource) {
		System.out.println("Invoking the review method.");
		return "resource_review";
	}

	@ResponseBody
	@RequestMapping("/request")
	public String request(@ModelAttribute("resource") Resource resource) {
		// send out an email

		return "The request has been sent out for approval";
	}

}
