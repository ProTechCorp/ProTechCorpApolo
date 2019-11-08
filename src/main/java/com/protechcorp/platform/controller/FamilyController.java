package com.protechcorp.platform.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.protechcorp.platform.model.Family;
import com.protechcorp.platform.service.IFamilyService;


@Controller
@SessionAttributes("family")
@RequestMapping("/families")
public class FamilyController {

	@Autowired
	private IFamilyService familyService;
	
	@GetMapping
	public String listLots(Model model) throws Exception{
		
		List<Family> families = familyService.findAll();
		model.addAttribute("families", families);
		
		return "family/family";
	}
	
	@GetMapping(value="/new")
	public String neLot(Model model) {
		Family family= new Family();
		model.addAttribute("family", family);
		model.addAttribute("title", "New Family");
		return "family/form";
	}
	
		
	
	
	@PostMapping(value="/save")
	public String saveFamily(@Valid Family family,
			BindingResult result, Model model,
			RedirectAttributes flash,
			SessionStatus status) throws Exception{
		
		
		if(result.hasErrors()) {
			model.addAttribute("title", "Save Family");
			return "family/form";
		}
		String mensajeFlash=(family.getId() != null)? "Edit Lot" : "Save Lot";
		
		familyService.save(family);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "family/form";
	}
	
	@RequestMapping("/delete")
	public String deleteLot(Model model,@RequestParam("id") Long id) {
		
	try {
		familyService.deleteById(id);
		model.addAttribute("message", "Successfully Delleted");
	}
	catch(Exception e) {
		model.addAttribute("message", "Lot can not be deleted ");
	}
	model.addAttribute("listFamily", familyService);
	return "/family/listFamilies";
	}
	
}