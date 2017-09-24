package com.itm.ucompiler.service;

import com.itm.ucompiler.exceptions.UcompilerException;
import com.itm.ucompiler.model.User;

/**
 * 
 * @author Alexis Ortiz
 * @since 2017
 * 
 *        This interface include the declaration of the necessary methods for
 *        user data integrity
 *
 * 
 */
public interface UserService {

	/**
	 * Validate if a user exists in the database with the username or email
	 * 
	 * @param userName
	 * @param email
	 * @return true if user exists
	 * @throws UcompilerException
	 */
	boolean userExists(String userName, String email) throws UcompilerException;

	/**
	 * This method saves an user into the database
	 * 
	 * @param user
	 * @return user saved
	 */
	User save(User user);
}
