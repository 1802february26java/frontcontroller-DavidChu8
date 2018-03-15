package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.model.Customer;
import com.revature.service.CustomerServiceAlpha;

public class LoginControllerAlpha implements LoginController {

	private static LoginController loginController = new LoginControllerAlpha();
		
	private LoginControllerAlpha() {}
	
	public static LoginController getInstance() {
		return loginController;
	}
		
	@Override
	public Object login(HttpServletRequest request) {
		if(request.getMethod().equals("GET")) {
			return "login.html";
		}
		
		Customer loggedCustomer = CustomerServiceAlpha.getInstance().authenticate(
				new Customer(request.getParameter("username"),
							request.getParameter("password"))
				);
		
		/* If authentication failed */
		if (loggedCustomer == null) {
			return new ClientMessage("AUTHENTICATION FAILED");
		}
		
		/* Store the customer info on the session */
		request.getSession().setAttribute("loggedCustoemr", loggedCustomer);
		
		return loggedCustomer;
	}

	@Override
	public String logout(HttpServletRequest request) {
		throw new RuntimeException("something went wrong");
		
	}

}
