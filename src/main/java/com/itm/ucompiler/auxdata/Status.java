package com.itm.ucompiler.auxdata;

/**
 * 
 * @author Alexis Ortiz
 * @since 2017
 *
 *        Enum which represents the status
 */
public enum Status {

	// Active status
	ACTIVE("ACTIVE"),

	// Inactive status
	INACTIVE("INACTIVE");

	private String value;

	Status(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
