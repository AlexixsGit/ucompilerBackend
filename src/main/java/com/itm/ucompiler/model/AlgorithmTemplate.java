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
@Table(name = "algorithm_templates")
@Access(AccessType.FIELD)
public class AlgorithmTemplate extends ParentEntity {

	private static final long serialVersionUID = 2289052708564915975L;

	@Column(name = "complete_name", nullable = false, length = 20)
	private String completeName;

	@Column(name = "template", nullable = false)
	private String template;

	public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
}
