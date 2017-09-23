package com.itm.ucompiler.exceptions;

/**
 * 
 * @author Alexis Ortiz
 * @since 2017
 *
 *        Here we define the custom exception we used in our Controller class to
 *        explain what happened
 */

public class UcompilerException extends Exception {

	private static final long serialVersionUID = -4305928863506951294L;

	public UcompilerException(String message) {
		super(message);
	}

}
