package com.greatlearning.crmmanagement.service;

import java.util.List;

import com.greatlearning.crmmanagement.entity.Customer;

public interface CustomerService {

List<Customer> listAll();
Customer findById(int theId);

void save(Customer thecustomer);

void deleteById(int theId);


}


