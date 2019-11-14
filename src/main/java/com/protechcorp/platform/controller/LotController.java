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

import com.protechcorp.platform.model.Lot;
import com.protechcorp.platform.service.ILotService;

@Controller
@SessionAttributes("lot")
@RequestMapping("/lots")
public class LotController {

	@Autowired
	private ILotService lotService;
	
	@GetMapping
	public String listLots(Model model) throws Exception{
		
		List<Lot> lots = lotService.findAll();
		model.addAttribute("lots", lots);
		
		return "lot/lot";
	}
	
	
	
	@GetMapping(value="/new")
	public String neLot(Model model) {
		Lot lot= new Lot();
		model.addAttribute("lot", lot);
		model.addAttribute("title", "New lot");
		return "lot/form";
	}
	
		
	
	
	@PostMapping(value="/save")
	public String saveLot(@Valid Lot lot,
			BindingResult result, Model model,
			RedirectAttributes flash,
			SessionStatus status) throws Exception{
		
		
		if(result.hasErrors()) {
			model.addAttribute("title", "Save Lot");
			return "lot/form";
		}
		String mensajeFlash=(lot.getId() != null)? "Edit Lot" : "Save Lot";
		
		lotService.save(lot);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/lots";
	}
	
	@RequestMapping("/delete")
	public String deleteLot(Model model,@RequestParam("id") Long id) {
		
	try {
		lotService.deleteById(id);
		model.addAttribute("message", "Successfully Delleted");
	}
	catch(Exception e) {
		model.addAttribute("message", "Lot can not be deleted ");
	}
	model.addAttribute("listLot", lotService);
	return "/lot/listLots";
	}
	
}
