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

import com.protechcorp.platform.model.Location;
import com.protechcorp.platform.service.ILocationService;

@Controller
@SessionAttributes("location")
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	private ILocationService locationService;
	
	@GetMapping
	public String listLocations(Model model) throws Exception {
		
		List<Location> locations = locationService.findAll();
		model.addAttribute("locations", locations);
		
		return "location/location";
	}
	
	@GetMapping(value="/new")
	public String newLocation(Model model) {
		
		Location location = new Location();
		model.addAttribute("location",location);
		model.addAttribute("title", "New location");
		return "location/form";
	}
	
	@PostMapping(value="/save")
	public String saveLocation(@Valid Location location,
			BindingResult result, Model model,
			RedirectAttributes flash, 
			SessionStatus status) throws Exception{
		if(result.hasErrors()) {
			model.addAttribute("title","Save Location");
			return "location/form";
		}
		
		String mensajeFlash= (location.getId()!= null)? "Edit location" : "Save Location";
		
		locationService.save(location);
		status.setComplete();
		flash.addFlashAttribute("success",mensajeFlash);
		return "redirect:/locations";
	}
	
	
	@RequestMapping("/delete")
	public String deleteCategory(Model model, @RequestParam("id") Long id) {
		try {
			locationService.deleteById(id);
			model.addAttribute("message", "Successfully Delleted");
		}
		catch(Exception e){
			model.addAttribute("message", "Category cannot be deleted.");
		}
		model.addAttribute("listLocations", locationService.getClass());
		return "/location/listLocations";
	
	}
	
}
