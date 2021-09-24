package com.nag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nag.entity.Specialization;
import com.nag.service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {
	
	@Autowired
	private ISpecializationService service;
	
	
	/**
	 * 1. Show Register page
	 */
	
	@GetMapping("/register")
	public String showRegister() {
		return "SpecializationRegister";
	}
	
	/**
	 * 2. Save Specialization data
	 */
	
	@PostMapping("/save")
	public String saveSpecialization(@ModelAttribute Specialization specialization,Model model) {
		Long specId = service.saveSpecialization(specialization);
		String message="Specialization with ("+specId+") Created";
		model.addAttribute("message",message);
		return "specializationRegister";
	}
	
	/**
	 * 3. Dsplay All Employees Data
	 */

	@GetMapping("/all")
	public String getAllSpecializations(
			                            Model model,
			                            @RequestParam(required = false) String message) 
	{
		
		List<Specialization> allSpecializations = service.getAllSpecializations();
		model.addAttribute("specs", allSpecializations);
		model.addAttribute("message", message);
		return "SpecializationData";
	}
	
	/**
	*
	*  4 . delete operation
	*/
	
	@GetMapping("/delete")
	public String deleteSpecialization(@RequestParam Long id,RedirectAttributes redirect) {
		service.removeSpecialization(id);
		String message="Record with id ("+id+") deleted";
		redirect.addAttribute("message",message);
		
		return "redirect:all";
		
	}
	
	
	/**
	 * 
	 *5. Edit operation
	 *
	 *
	*/
	@GetMapping("/edit")
	public String editSpecialization(@RequestParam Long id,Model model) {
		Specialization spec = service.getOneSpecialization(id);
		model.addAttribute("specializaton", spec);
		return "SpecializationEdit";
	}
	
	
	/**
	 * 
	 * 6. Update Operation
	 * 
	 */
	@PostMapping("/update")
	public String updateSpecialization(@ModelAttribute Specialization spec,RedirectAttributes attribute) {
		service.updateSpecialization(spec);
		String message="Record with id ("+spec.getId()+") Updated Succesfully";
		attribute.addAttribute("message",message);
		return "redirect:all";
	}
	
}
