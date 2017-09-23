package com.itm.ucompiler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itm.ucompiler.dao.AuxDataRepository;

/**
 * 
 * @author Alexis Ortiz
 * @since 2017
 * 
 *        This service include the logic of business for auxdata, here, we'll
 *        add all the necessary methods for guarantee the data integrity
 * 
 *
 */
@Service
public class AuxDataServiceImpl implements AuxDataService {

	@Autowired
	protected AuxDataRepository auxDataRepository;
}
