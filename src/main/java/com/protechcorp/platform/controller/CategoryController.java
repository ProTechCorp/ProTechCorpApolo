package com.protechcorp.platform.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.protechcorp.platform.model.Category;
import com.protechcorp.platform.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/new")
	public String newCategory(Model model) {
		return "/event/add";
	}
	
	@PostMapping("/save")
	public String saveCategory(
			Model model, String name , String description , ) {}
	

}
