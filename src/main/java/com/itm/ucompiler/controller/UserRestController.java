package com.itm.ucompiler.controller;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
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
import com.itm.ucompiler.auxdata.Status;
import com.itm.ucompiler.auxdata.YesNot;
import com.itm.ucompiler.dao.AuxDataRepository;
import com.itm.ucompiler.exceptions.UcompilerException;
import com.itm.ucompiler.model.User;
import com.itm.ucompiler.request.UserSaveRequest;
import com.itm.ucompiler.service.UserService;
import com.itm.ucompiler.util.Encryption;
import com.itm.ucompiler.util.RestResponse;

/**
 * 
 * @author Alexis Ortiz
 * @since 2017
 *
 *        this controller expose the methods for being called of an external
 *        url, also, it implements the required validations of an user. The
 *        controller is the bridge between the backend and the frontend, because
 *        it captures the data received from the user interface and then it
 *        saves them into the database.
 * 
 *        It resolves the business logic with the help of some services and
 *        spring repositories
 */
@RestController
public class UserRestController {

	@Autowired
	protected UserService userService;

	@Autowired
	protected AuxDataRepository auxDataRepository;

	protected ObjectMapper mapper;

	private StringBuilder errorMessage;

	public UserRestController() {
		this.mapper = new ObjectMapper();
	}

	/**
	 * This method save or update an user in the database
	 * 
	 * @param userJson
	 * @return RestResponse
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws UcompilerException
	 */
	@RequestMapping(value = "/saveOrUpdateUser", method = RequestMethod.POST)
	@Transactional(rollbackFor = Exception.class)
	public RestResponse saveOrUpdate(@RequestBody String userSaveRequestJson)
			throws JsonParseException, JsonMappingException, IOException, UcompilerException {

		UserSaveRequest userSaveRequest = this.mapper.readValue(userSaveRequestJson, UserSaveRequest.class);
		User user = userSaveRequest.getUser();

		if (!this.validate(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), this.errorMessage.toString());
		}

		// Validates if the user exists
		User userFound = this.userService.userExists(user.getUserName(), user.getEmail());
		// Validate if the user is new
		if (user.getId() == null && userFound != null) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Ya existe una cuenta con el usuario o correo ingresado");
		} else if (user.getId() != null && !(userFound.getEmail().equals(user.getEmail())
				&& userFound.getUserName().equals(user.getUserName()))) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"No se puede modificar ni el correo ni la contraseña");
		}

		this.complete(user);
		this.userService.save(user);

		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");

	}

	/**
	 * This method validate required fields
	 * 
	 * @param user
	 * @return true if all the required fields are not empty
	 */
	private boolean validate(User user) {
		this.errorMessage = new StringBuilder("Falta diligenciar los siguientes campos obligatorios: ");
		boolean isValid = true;
		if (StringUtils.trimToNull(user.getUserName()) == null) {
			this.errorMessage.append("\nNombre de usuario");
			isValid = false;
		}

		if (StringUtils.trimToNull(user.getEmail()) == null) {
			this.errorMessage.append("\nCorreo");
			isValid = false;
		}

		if (StringUtils.trimToNull(user.getUserPassword()) == null) {
			this.errorMessage.append("\nContraseña");
			isValid = false;
		}
		return isValid;
	}

	/**
	 * This method complete the information of a user
	 * 
	 * @param user
	 */
	private void complete(User user) {

		if (user.getIsEmailConfirmed() == null || user.getIsEmailConfirmed().getId() == null) {
			user.setIsEmailConfirmed(this.auxDataRepository.findByshortName(YesNot.NOT.getValue()));
		} else {
			user.setIsEmailConfirmed(this.auxDataRepository.findById(user.getIsEmailConfirmed().getId()));
		}
		if (user.getUserStatus() == null || user.getUserStatus().getId() == null) {
			user.setUserStatus(this.auxDataRepository.findByshortName(Status.ACTIVE.getValue()));
		} else {
			user.setUserStatus(this.auxDataRepository.findById(user.getUserStatus().getId()));
		}

		if (user.getIsAdmin() == null || user.getIsAdmin().getId() == null) {
			user.setIsAdmin(this.auxDataRepository.findByshortName(YesNot.NOT.getValue()));
		} else {
			user.setIsAdmin(this.auxDataRepository.findById(user.getIsAdmin().getId()));
		}

		if (user.getIsPasswordTemp() == null || user.getIsPasswordTemp().getId() == null) {
			user.setIsPasswordTemp(this.auxDataRepository.findByshortName(YesNot.NOT.getValue()));
		} else {
			user.setIsPasswordTemp(this.auxDataRepository.findById(user.getIsPasswordTemp().getId()));
		}

		if (user.getIsSuperAdmin() == null || user.getIsSuperAdmin().getId() == null) {
			user.setIsSuperAdmin(this.auxDataRepository.findByshortName(YesNot.NOT.getValue()));
		} else {
			user.setIsSuperAdmin(this.auxDataRepository.findById(user.getIsSuperAdmin().getId()));
		}
		if (user.getSex() != null && user.getSex().getId() != null) {
			user.setSex(this.auxDataRepository.findById(user.getSex().getId()));
		}

		if (user.getCreationDate() == null) {
			user.setCreationDate(new Date());
		}

		if (user.getModificationDate() == null) {
			user.setModificationDate(new Date());
		}
		user.setUserPassword(Encryption.encryptMD5(user.getUserPassword()));
	}
}
