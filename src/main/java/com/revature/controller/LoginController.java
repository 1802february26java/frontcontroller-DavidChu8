package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public interface LoginController {
	
	/**
	 * If the method is Get, it will return the view.
	 * 
	 * If the method is POST.
	 * -> If service layer returns null, we return a message
	 *    stating that authentication failed.
	 *    
	 * -> Else, it will return the Customer information.
	 *    (and store it in the session.)
	 * @param request
	 * @return
	 */
	public Object login(HttpServletRequest request);
	
	/**
	 * Invalidates the session and returns the login view.
	 * @param request
	 * @return 
	 */
	public String logout(HttpServletRequest request);
	
	
}
