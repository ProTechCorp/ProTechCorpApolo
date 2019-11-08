package com.protechcorp.platform.controller;

<<<<<<< HEAD
import java.util.Optional;

=======
import java.util.List;

import javax.validation.Valid;
>>>>>>> development

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
>>>>>>> development

import com.protechcorp.platform.model.Category;
import com.protechcorp.platform.service.ICategoryService;



@Controller
@SessionAttributes("category")
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
<<<<<<< HEAD
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
=======
	@GetMapping
	public String listCategories(Model model) throws Exception {
		
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		
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
>>>>>>> development
		
		String mensajeFlash= (category.getId()!= null)? "Edit category" : "Save Category";
		
<<<<<<< HEAD
		return "/category/add";
=======
		categoryService.save(category);
		status.setComplete();
		flash.addFlashAttribute("success",mensajeFlash);
		return "redirect:/categories";
>>>>>>> development
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









