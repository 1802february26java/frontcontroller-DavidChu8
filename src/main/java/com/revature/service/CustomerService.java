package com.revature.service;

import java.util.List;

import com.revature.model.Customer;

public interface CustomerService {
	
	public boolean registered(Customer customer);
	
	public boolean registeredCustomerSecured(Customer customer);
	
	public List<Customer>listAllCustomer();
	
	public Customer authenticate(Customer customer);
	
	
}
