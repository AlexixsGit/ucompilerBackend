package com.itm.ucompiler.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itm.ucompiler.dao.UserRepository;
import com.itm.ucompiler.exceptions.UcompilerException;
import com.itm.ucompiler.model.User;

/**
 * 
 * @author Alexis Ortiz
 * @since 2017
 * 
 *        This service include the logic of business for user, here, we'll add
 *        all the necessary methods for guarantee the data integrity
 * 
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	protected UserRepository userRepository;

	@Override
	public boolean userExists(String userName, String email) throws UcompilerException {

		if (StringUtils.trimToNull(userName) == null && StringUtils.trimToNull(email) == null) {
			throw new UcompilerException("Error: You must enter a username or email");
		}

		User userFound = userRepository.findByUserName(userName);

		if (userFound != null) {
			return true;
		}

		userFound = userRepository.findByEmail(email);

		if (userFound != null) {
			return true;
		}

		return false;
	}

	@Override
	public User save(User user) {
		return this.userRepository.save(user);
	}
}
