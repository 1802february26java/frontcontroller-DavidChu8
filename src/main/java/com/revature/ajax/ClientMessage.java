package com.revature.ajax;

public class ClientMessage {
	private String message;
	
	public ClientMessage() {}
	
	public ClientMessage(String string) {
		this.message = string;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
