package com.revature.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DispatcherServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5244611926643604805L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object data = RequestHelper.process(req);
		
		/*
		 * Don't know if data is a string
		 * If what the controllers return is a String, we forward to an HTML file.
		 * Else we marshal the given POJO.
		 */
		if (data instanceof String) {
			String URI = (String) data;
			req.getRequestDispatcher((URI)).forward(req, resp);
		}
		else {
			resp.getWriter().write(new ObjectMapper().writeValueAsString(data));
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
