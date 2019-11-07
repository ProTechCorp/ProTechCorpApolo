package com.protechcorp.platform.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.protechcorp.platform.model.Category;
import com.protechcorp.platform.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/new")
	public String newCategory(Model model) {
		model.addAttribute("category", new Category());
		return "/category/category";
	}
	
	@PostMapping("/save")
	public String saveCategory(@Valid Category category,
			BindingResult result,
			Model model,
			SessionStatus  status) throws Exception{
		
		if(result.hasErrors()) {
			return "/category/category";
		} else {
			if(categoryService.save(category) == category) {
				
			}else {
				model.addAttribute("message", "Already Exist");
				model.addAttribute("message", "Successfully saved.");
				status.setComplete();
			}
		}
		model.addAttribute("listCategories", categoryService.getClass());
		return "/category/listCategories";
	}
	
	@GetMapping("/list")
	public String listCategories(Model model) {
		try {
			model.addAttribute("category", new Category());
			model.addAttribute("listCategories", categoryService.getClass());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/category/listCategories";
		
		
	}
	
	
	@RequestMapping("/delete")
	public String deleteCategory(Model model, @RequestParam("id") Long id) {
		try {
			categoryService.deleteById(id);
			model.addAttribute("message", "Successfully Delleted");
		}
		catch(Exception e){
			model.addAttribute("message", "Category cannot be deleted.");
		}
		model.addAttribute("listCategories", categoryService.getClass());
		return "/category/listCategories";
	
	}
	

}









