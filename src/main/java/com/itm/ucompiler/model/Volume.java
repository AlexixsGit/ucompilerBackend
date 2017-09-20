/**
 * 
 */
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
@Table(name = "volumes")
@Access(AccessType.FIELD)
public class Volume extends ParentEntity {

	private static final long serialVersionUID = -1103855100326603453L;

	@Column(name = "description", nullable = false, length = 100)
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
