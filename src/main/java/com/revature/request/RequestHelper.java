package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.revature.controller.CustomerControllerAlpha;
import com.revature.controller.LoginControllerAlpha;
import com.revature.util.ConnectionUtil;

public class RequestHelper {
	
	private static Logger logger = Logger.getLogger(RequestHelper.class);

	private RequestHelper() {}
	
	public static Object process(HttpServletRequest request) {
		switch(request.getRequestURI()) {
		case "/FrontController/login.do":
			return LoginControllerAlpha.getInstance().login(request);
		case "/FrontController/logout.do":
			return LoginControllerAlpha.getInstance().logout(request);
		case "/FrontController/register.do":
			return CustomerControllerAlpha.getInstance().register(request);
		case "/FrontController/getAll.do":
			return CustomerControllerAlpha.getInstance().getAllCustomers(request);
		
		default:
			return "not-implemented.html";
		}
	}
}
