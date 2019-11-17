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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.protechcorp.platform.model.Employee;
import com.protechcorp.platform.model.Location;
import com.protechcorp.platform.service.IEmployeeService;
import com.protechcorp.platform.service.ILocationService;

@Controller
@SessionAttributes("employee")
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private ILocationService locationService;

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping
	public String listEmployees(Model model) throws Exception {
		List<Employee> employees = employeeService.findAll();
	model.addAttribute("employees", employees);
	return "employee/employee";
	}
	
	List<Location> loadLocations() throws Exception{
		return locationService.findAll();
	}
	@GetMapping("/new")
	public String newEmployee(Model model) throws Exception {
		
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		model.addAttribute("locations",loadLocations());
		
		model.addAttribute("titel","New Employee");
		return "/employee/form";
	}
	
	@PostMapping(value="/save")
	public String saveEmployee(@Valid Employee employee, BindingResult result, Model model,
			SessionStatus status , RedirectAttributes flash)
			throws Exception {
		
		if (result.hasErrors()) {
			model.addAttribute("title","Save Employee");
			return "employee/form";
		} 
		
		String mensajeFlash=(employee.getId()!=null) ? "Edit Employee" : "Save Employee";
		
		employeeService.save(employee);
		status.setComplete();
		flash.addFlashAttribute("success",mensajeFlash);
		return "redirect:/Employees"; //puede que salga error employees
	}
	
	@GetMapping(value="/edit/{id}")
	public String editEmployee(@PathVariable(value="id") Long id, Model model, RedirectAttributes flash) throws Exception {
		
		Optional<Employee> employee;
		
		if(id>0) {
			employee= employeeService.findById(id);
			
			if(!employee.isPresent()) {
				flash.addFlashAttribute("error","the employee doesnt exist");
				return "redirect:/employees";
			}
		}else {
			flash.addFlashAttribute("error","the employee doesnt exist");
			return "redirect:/employees";
		}
		model.addAttribute("location", loadLocations()); //puede que salga erros
		model.addAttribute("employee", employee);
		model.addAttribute("title","Edit Employees");
		return "employee/form";
	}
}
