package com.itm.ucompiler.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Alexis Ortiz
 * @since 2017
 */
@Entity
@Table(name = "problems")
@Access(AccessType.FIELD)
public class Problem extends ParentEntity {

	private static final long serialVersionUID = -2487388328110771660L;

	@Column(name = "title", nullable = false, length = 50)
	private String title;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_subcategory", nullable = false)
	private SubCategory subCategory;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_volume", nullable = false)
	private Volume volume;

	@Column(name = "problem_text", nullable = false)
	private String problemText;

	@Column(name = "input_description", length = 1000)
	private String inputDescription;

	@Column(name = "output_description", length = 1000)
	private String outputDescription;

	@Column(name = "input_example", length = 1000)
	private String inputExample;

	@Column(name = "output_example", length = 1000)
	private String outputExample;

	@Column(name = "attached_file", length = 500)
	private String attachedFile;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "is_pdf")
	private AuxData isPdf;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "complexity")
	private AuxData complexity;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}

	public String getProblemText() {
		return problemText;
	}

	public void setProblemText(String problemText) {
		this.problemText = problemText;
	}

	public String getInputDescription() {
		return inputDescription;
	}

	public void setInputDescription(String inputDescription) {
		this.inputDescription = inputDescription;
	}

	public String getOutputDescription() {
		return outputDescription;
	}

	public void setOutputDescription(String outputDescription) {
		this.outputDescription = outputDescription;
	}

	public String getInputExample() {
		return inputExample;
	}

	public void setInputExample(String inputExample) {
		this.inputExample = inputExample;
	}

	public String getOutputExample() {
		return outputExample;
	}

	public void setOutputExample(String outputExample) {
		this.outputExample = outputExample;
	}

	public String getAttachedFile() {
		return attachedFile;
	}

	public void setAttachedFile(String attachedFile) {
		this.attachedFile = attachedFile;
	}

	public AuxData getIsPdf() {
		return isPdf;
	}

	public void setIsPdf(AuxData isPdf) {
		this.isPdf = isPdf;
	}

	public AuxData getComplexity() {
		return complexity;
	}

	public void setComplexity(AuxData complexity) {
		this.complexity = complexity;
	}
}
