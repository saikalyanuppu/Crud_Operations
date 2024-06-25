package com.example.crudexample.response;

public class ApiResponse {
	public String status;
	public String message;
	public Object data;
	
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}

	public ApiResponse(String status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
}
