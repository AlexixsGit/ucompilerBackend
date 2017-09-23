package com.itm.ucompiler.util;

/**
 * 
 * @author Alexis Ortiz
 * @since 2017
 * 
 *        Class for getting a rest service message response and a code of it
 *
 *
 */
public class RestResponse {
	private Integer responseCode;
	private String message;

	public RestResponse(Integer responseCode) {
		super();
		this.responseCode = responseCode;
	}

	public RestResponse(Integer responseCode, String message) {
		super();
		this.responseCode = responseCode;
		this.message = message;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
