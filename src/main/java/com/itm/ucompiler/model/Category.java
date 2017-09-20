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
@Table(name = "categories")
@Access(AccessType.FIELD)
public class Category extends ParentEntity {
	
	private static final long serialVersionUID = -3795729143983582733L;

	@Column(name = "cat_name", nullable = false, length = 50)
	private String catName;
	
	@Column(name = "description", nullable = false, length = 100)
	private String description;

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
