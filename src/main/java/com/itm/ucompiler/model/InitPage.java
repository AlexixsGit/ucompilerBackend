package com.itm.ucompiler.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Alexis Ortiz
 * @since 2017
 */
@Entity
@Table(name = "init_page")
@Access(AccessType.FIELD)
public class InitPage extends ParentEntity {


	private static final long serialVersionUID = 7578893404995852630L;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "how_start", nullable = false)
	private String howStart;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_week_problem")
	private Problem weekProblem;

	@Column(name = "image_folder")
	private String imageFolder;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHowStart() {
		return howStart;
	}

	public void setHowStart(String howStart) {
		this.howStart = howStart;
	}

	public Problem getWeekProblem() {
		return weekProblem;
	}

	public void setWeekProblem(Problem weekProblem) {
		this.weekProblem = weekProblem;
	}

	public String getImageFolder() {
		return imageFolder;
	}

	public void setImageFolder(String imageFolder) {
		this.imageFolder = imageFolder;
	}
}
