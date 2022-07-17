package com.greatlearning.crmmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.crmmanagement.entity.Customer;
import com.greatlearning.crmmanagement.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/begin-add")
	public String handleBeginAdd(Model theModel) {

		Customer customer = new Customer();

		theModel.addAttribute("customer", customer);

		return "customer-detials";
	}

	@RequestMapping("/begin-update")
	public String handleBeginUpdate(
			@RequestParam("customerId") int theId, 
			Model theModel) {

		Customer customer = customerService.findById(theId);
		theModel.addAttribute("customer", customer);
		return "customer-detials";
	}

	@PostMapping("/save")
	public String handleSave(
		@RequestParam("id") int id, 
		@RequestParam("email") String email,
		@RequestParam("firstName") String firstName,
		@RequestParam("lastName") String lastName)	
	
		{

		Customer customer;
		if (id != 0) {
			
			// Update customer
			customer = customerService.findById(id);
			customer.setEmail(email);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
	
			
		} else {
		
			// Add customer
			customer = new Customer(email, firstName, lastName);
		}	
		customerService.save(customer);
		return "redirect:/customers/list";

	}

	@RequestMapping("/delete")
	public String handleDelete(@RequestParam("customerId") int theId) {

		customerService.deleteById(theId);

		return "redirect:/customers/list";

	}

}

