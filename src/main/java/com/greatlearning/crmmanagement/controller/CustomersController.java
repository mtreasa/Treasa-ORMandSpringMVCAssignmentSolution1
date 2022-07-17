 package com.greatlearning.crmmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.crmmanagement.entity.Customer;
import com.greatlearning.crmmanagement.service.CustomerService;


@Controller
@RequestMapping("/customers")
public class CustomersController {
	@Autowired
	private CustomerService customerservice;

	@RequestMapping("/list")

	public String handleListStudents(Model theModel) {

		List<Customer> customers = customerservice.listAll();

		theModel.addAttribute("customers", customers);

		return "customer-lister";
	}

}
