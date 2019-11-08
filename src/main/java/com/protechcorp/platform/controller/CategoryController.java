package com.protechcorp.platform.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.protechcorp.platform.model.Category;
import com.protechcorp.platform.service.CategoryService;



@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/list")
	public String listarCategory(Model model) {
		
		try {
			model.addAttribute("listCategory", categoryService.findAll());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "/category/list";
	}
	
	@GetMapping("/add")
	public String agregarCaegory(Model model) {
		
		
		return "/category/add";
	}
	
	@PostMapping("/add")
	public String agregarCategory(Model model,String name,String description) {
			
		
			
			
			Category ev1=new Category();
			ev1.setName(name);
			ev1.setDescription(description);
			
			
			try {
				model.addAttribute("registerCategory", categoryService.save(ev1));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return "/category/add";
	}
	
	@GetMapping("/detail/{id}")
	public String detailCategory(@PathVariable(value="id") Long id,Model model ) {
		try {
			Optional<Category> category = categoryService.findById(id);
			
			if(!category.isPresent()) {
				model.addAttribute("info", "Category doesn't exist");
				return "redirect:/category/list";
			}
			else
				model.addAttribute("category",category.get());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		
		return "/category/detail";
	}

}









