package com.itm.ucompiler.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itm.ucompiler.model.AuxData;

/**
 * 
 * @author Alexis Ortiz
 * @since 2017
 * 
 *        This repository represents the methods to communicate with the
 *        database
 */
public interface AuxDataRepository extends JpaRepository<AuxData, Long> {

	/**
	 * this method finds an auxdata by id
	 * 
	 * @param id
	 * @return auxdata found
	 */
	@Query("SELECT A FROM AuxData A WHERE A.id = :id")
	AuxData findById(@Param("id") Long id);

	/**
	 * this method finds an auxdata by group shortname
	 * 
	 * @param shortName
	 * @return auxdata found
	 */
	@Query("SELECT A FROM AuxData A WHERE UPPER(A.auxDataGroup.shortName) = UPPER(:shortName)")
	AuxData findByGroup(@Param("shortName") String shortName);

	/**
	 * This method finds an auxdata by group id
	 * 
	 * @param id
	 * @return auxdata found
	 */
	@Query("SELECT A FROM AuxData A WHERE A.auxDataGroup.id = :id")
	AuxData findByAuxDataGroupId(@Param("id") Long id);

	/**
	 * this method finds an auxdata by shortname
	 * 
	 * @param shortName
	 * @return auxdata found
	 */
	AuxData findByshortName(String shortName);
}
