package com.itm.ucompiler.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author Alexis Ortiz
 * @since 2017
 */
@Entity
@Table(name = "aux_data_groups")
@Access(AccessType.FIELD)
public class AuxDataGroup extends ParentEntity {

	private static final long serialVersionUID = -2501759086058654793L;

	@Column(name = "group_name", nullable = false, length = 25)
	private String groupName;

	@Column(name = "short_name", nullable = false, length = 10)
	private String shortName;

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

}
