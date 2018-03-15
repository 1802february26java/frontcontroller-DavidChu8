package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public interface CustomerController {
	
	/**
	 * Registers the user.
	 * -> If the method id GET, return registration view.
	 * -> Else, return a message stating that registration was successful, or not.
	 * @param request
	 * @return
	 */
	public Object register(HttpServletRequest request);
	
	/**
	 * Get all customers in the database.
	 * 
	 * -> If it's GET with no parameters, then we return the view.
	 * -> If it's GET with a parameter, then we return the list of users.
	 * @param request
	 * @return
	 */
	public Object getAllCustomers(HttpServletRequest request);
	
	
}
