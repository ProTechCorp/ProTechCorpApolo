package com.protechcorp.platform.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.protechcorp.platform.model.Category;
import com.protechcorp.platform.model.Product;
import com.protechcorp.platform.service.ICategoryService;

@Controller
@SessionAttributes("category")
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping
	public String listCategories(Model model) throws Exception {
		
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		
		return "category/category";
	}
	
	@GetMapping("/search")
	public String searchCategory(@RequestParam("name") String name,Model model) {
		try {
			if(!name.isEmpty()) {
				List<Category> categories=categoryService.fetchCategoryByName(name);
				if(!categories.isEmpty()) {
					model.addAttribute("categories",categories);
				}else {
					model.addAttribute("info","No existe categoria");
					model.addAttribute("families",categoryService.findAll());
				}
				
			}else {
				model.addAttribute("info","Debe ingresar un categoria");
				model.addAttribute("categories",categoryService.findAll());
			}
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "category/category";
	}
	
	@GetMapping(value="/new")
	public String newCategory(Model model) {
		
		Category category = new Category();
		model.addAttribute("category",category);
		model.addAttribute("title", "New Category");
		return "category/form";
	}
	
	@PostMapping(value="/save")
	public String saveCategory(@Valid Category category,
			BindingResult result, Model model,
			RedirectAttributes flash, 
			SessionStatus status) throws Exception{
		if(result.hasErrors()) {
			model.addAttribute("title","Save Category");
			return "category/form";
		}
		
		String mensajeFlash= (category.getId()!= null)? "Edit category" : "Save Category";
		
		categoryService.save(category);
		status.setComplete();
		flash.addFlashAttribute("success",mensajeFlash);
		return "redirect:/categories";
	}
	
	@GetMapping(value="/edit/{id}")
	public String editCategory(@PathVariable(value="id") Long id, Model model, RedirectAttributes flash) throws Exception {
		
		Optional<Category> category;
		
		if(id>0) {
			category= categoryService.findById(id);
			
			if(!category.isPresent()) {
				flash.addFlashAttribute("error","la categoria no existe");
				return "redirect:/categories";
			}
		}else {
			flash.addFlashAttribute("error","La categoria no existe");
			return "redirect:/categories";
		}
		model.addAttribute("category", category);
		model.addAttribute("title","Edit Category");
		return "category/form";
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
