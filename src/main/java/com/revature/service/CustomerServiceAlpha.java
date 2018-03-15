
package com.revature.service;
import com.revature.repository.CustomerRepositoryJdbc;

import java.util.List;

import com.revature.model.Customer;

public class CustomerServiceAlpha implements CustomerService {
	
	private static CustomerServiceAlpha customerServiceAlpha;
	
	private CustomerServiceAlpha() {}
	
	public static CustomerServiceAlpha getInstance() {
		if(customerServiceAlpha == null) {
			customerServiceAlpha = new CustomerServiceAlpha();
		}
		
		return customerServiceAlpha;
	}
	
	@Override
	public List<Customer> listAllCustomer() {
		return CustomerRepositoryJdbc.getInstance().selectAll();
	}
	
	@Override
	public Customer authenticate(Customer customer) {
		
		// info on the db
		Customer loggedCustomer = CustomerRepositoryJdbc.getInstance().select(customer);
				
		/*
		 * What we have stored in the db i the username + password hash.
		 * we can't compare the blank password provided by the user, against the hash.
		 * so we have to obtain the hash of the user input.
		 */
		if (loggedCustomer.getPassword().equals(CustomerRepositoryJdbc.getInstance().getCustomerHash(customer))) {
			return loggedCustomer;
		}
		
		return null;
	}

	@Override
	public boolean registered(Customer customer) {
		return CustomerRepositoryJdbc.getInstance().insert(customer);
		
	}

	@Override
	public boolean registeredCustomerSecured(Customer customer) {
		return CustomerRepositoryJdbc.getInstance().insertProcedure(customer);
		
	}

}
