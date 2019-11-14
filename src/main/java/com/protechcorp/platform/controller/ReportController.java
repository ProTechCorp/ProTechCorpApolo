package com.protechcorp.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.protechcorp.platform.service.ICategoryService;
import com.protechcorp.platform.service.ILocationService;
import com.protechcorp.platform.service.IProductService;

@Controller
@RequestMapping("/reports")
public class ReportController {

		@Autowired
		private ILocationService locationService;
		
		@Autowired
		private IProductService productService;
		
		@GetMapping(value="/locations")
		public String listCategories(Model model) throws Exception {
			
			model.addAttribute("locations", locationService.findAll());
			
			model.addAttribute("products",productService.findAll());
			return "report/locationproduct";
		}
		
		@GetMapping(value="/producs/{location}")
		public String listProductsByLocation(@PathVariable(value="location")String locationCategory,Model model) throws Exception {
			model.addAttribute("products",productService.findByLocation(locationCategory));
			model.addAttribute("locations",locationService.findAll());
			return "report/locationproduct";
		}
	
}
