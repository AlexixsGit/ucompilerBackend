package com.itm.ucompiler.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itm.ucompiler.exceptions.UcompilerException;
import com.itm.ucompiler.model.User;
import com.itm.ucompiler.service.UserService;
import com.itm.ucompiler.util.RestResponse;

@RestController
public class UserRestController {

	@Autowired
	protected UserService userService;

	protected ObjectMapper mapper;

	public UserRestController() {
		this.mapper = new ObjectMapper();
	}

	/**
	 * This method save or update a user in the database
	 * 
	 * @param userJson
	 * @return RestResponse
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws UcompilerException
	 */
	@RequestMapping(value = "/saveOrUpdate/", method = RequestMethod.POST)
	@Transactional(rollbackFor = Exception.class)
	public RestResponse saveOrUpdate(@RequestBody String userJson)
			throws JsonParseException, JsonMappingException, IOException, UcompilerException {

		User user = this.mapper.readValue(userJson, User.class);

		if (this.validate(user)) {
			return new RestResponse(HttpStatus.NOT_FOUND.value(),
					"Ya existe una cuenta con el usuario o correo ingresado");
		}
		// Validate if the user is new
		if (user.getId() == null) {
			// Validates if the user exists
			if (this.userService.userExists(user.getUserName(), user.getEmail())) {
				return new RestResponse(HttpStatus.NOT_FOUND.value(),
						"Ya existe una cuenta con el usuario o correo ingresado");
			}
		}
		return new RestResponse(HttpStatus.OK.value(), "Registro guardado exitosamente");
	}

	private boolean validate(User user) {

		return false;
	}
}
