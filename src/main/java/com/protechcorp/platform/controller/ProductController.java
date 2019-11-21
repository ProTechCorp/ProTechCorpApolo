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
import com.protechcorp.platform.model.Family;
import com.protechcorp.platform.model.Location;
import com.protechcorp.platform.model.Lot;
import com.protechcorp.platform.model.Product;
import com.protechcorp.platform.service.ICategoryService;
import com.protechcorp.platform.service.IFamilyService;
import com.protechcorp.platform.service.ILocationService;
import com.protechcorp.platform.service.ILotService;
import com.protechcorp.platform.service.IProductService;

@Controller
@SessionAttributes("product")
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IFamilyService familiService;
	
	@Autowired
	private ILocationService locationService;
	
	@Autowired
	private ILotService lotService;
	@Autowired
	private IProductService productService;
	
	@GetMapping
	public String listProducts(Model model) throws Exception {
		
		List<Product> products = productService.findAll();
		
		model.addAttribute("products", products);
		
		return "product/product";
	}
	
	@GetMapping("/searchName")
	public String searchProduct(@RequestParam("name") String name,Model model) {
		try {
			if(!name.isEmpty()) {
				List<Product> products=productService.fetchProductByName(name);
				if(!products.isEmpty()) {
					model.addAttribute("products",products);
				}else {
					model.addAttribute("info","No existe producto");
					model.addAttribute("products",productService.findAll());
				}
				
			}else {
				model.addAttribute("info","Debe ingresar un producto");
				model.addAttribute("products",productService.findAll());
			}
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "product/product";	
	}
	
	@GetMapping("/searchBrand")
	public String searchProductBrand(@RequestParam("brand") String brand,Model model) {
		try {
			if(!brand.isEmpty()) {
				List<Product> products=productService.fetchProductByBrand(brand);
				if(!products.isEmpty()) {
					model.addAttribute("products",products);
				}else {
					model.addAttribute("info","No existe brand");
					model.addAttribute("products",productService.findAll());
				}
				
			}else {
				model.addAttribute("info","Debe ingresar un brand");
				model.addAttribute("products",productService.findAll());
			}
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "product/product";	
	}
	
	@GetMapping("/searchDescription")
	public String searchProductDescription(@RequestParam("description") String description,Model model) {
		try {
			if(!description.isEmpty()) {
				List<Product> products=productService.fetchProductByDescription(description);
				if(!products.isEmpty()) {
					model.addAttribute("products",products);
				}else {
					model.addAttribute("info","No existe description");
					model.addAttribute("products",productService.findAll());
				}
			}else {
				model.addAttribute("info","Debe ingresar una description");
				model.addAttribute("products",productService.findAll());
			}
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "product/product";	
	}
	
	List<Category> loadCategories() throws Exception{
		return categoryService.findAll();
	}
	
	List<Family> loadFamilies() throws Exception{
		return familiService.findAll();
	}
	
	List<Lot> loadLots() throws Exception{
		return lotService.findAll();
	}
	
	List<Location> loadLocations() throws Exception{
		return locationService.findAll();
	}

	@GetMapping("/new")
	public String newPorduct(Model model) throws Exception {
		
		Product product = new Product();
		
		model.addAttribute("product", product);
		model.addAttribute("categories", loadCategories());
		model.addAttribute("families",loadFamilies());
		model.addAttribute("lots",loadLots());
		model.addAttribute("locations",loadLocations());
		
		model.addAttribute("titel","New Product");
		return "/product/form";
	}

	@PostMapping(value="/save")
	public String saveProduct(@Valid Product product, BindingResult result, Model model,
			SessionStatus status , RedirectAttributes flash)
			throws Exception {
		
		if (result.hasErrors()) {
			model.addAttribute("title","Save Product");
			return "product/form";
		} 
		
		String mensajeFlash=(product.getId()!=null) ? "Edit Product" : "Save Product";
		
		productService.save(product);
		status.setComplete();
		flash.addFlashAttribute("success",mensajeFlash);
		return "redirect:/Products";
	}
	
	@GetMapping(value="/edit/{id}")
	public String editProduct(@PathVariable(value="id") Long id, Model model, RedirectAttributes flash) throws Exception {
		
		Optional<Product> product;
		
		if(id>0) {
			product= productService.findById(id);
			
			if(!product.isPresent()) {
				flash.addFlashAttribute("error","el producto no existe");
				return "redirect:/products";
			}
		}else {
			flash.addFlashAttribute("error","El producto no existe");
			return "redirect:/products";
		}
		model.addAttribute("categories", loadCategories());
		model.addAttribute("product", product);
		model.addAttribute("title","Edit Products");
		return "product/form";
	}
}

