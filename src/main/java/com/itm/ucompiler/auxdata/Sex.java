package com.itm.ucompiler.auxdata;

/**
 * 
 * @author Alexis Ortiz
 * @since 2017
 *
 *        Enum which represents the sex
 */
public enum Sex {

	// male value
	MALE("MALE"),

	// female value
	FEMALE("FEMALE");

	private String value;

	Sex(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
