package com.itm.ucompiler.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itm.ucompiler.model.User;

/**
 * 
 * @author Alexis Ortiz
 * @since 2017
 *
 *        This repository represents the methods to communicate with the
 *        database
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Find a user by username
	 * 
	 * @param userName
	 * @return user found or null
	 */
	User findByUserName(String userName);

	/**
	 * Find a user by email
	 * 
	 * @param email
	 * @return user found or null
	 */
	User findByEmail(String email);
}
