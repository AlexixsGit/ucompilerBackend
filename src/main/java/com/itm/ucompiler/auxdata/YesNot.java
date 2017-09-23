package com.itm.ucompiler.auxdata;

/**
 * 
 * @author Alexis Ortiz
 * @since 2017
 *
 *        Enum which represents the yes/no value
 */
public enum YesNot {

	// yes value
	YES("YES"),

	// not value
	NOT("NOT");

	private String value;

	YesNot(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
