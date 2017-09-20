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
@Table(name = "compilation_logs")
@Access(AccessType.FIELD)
public class CompilationLog extends ParentEntity {

	private static final long serialVersionUID = 8969393364362006649L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_problem", nullable = false)
	private Problem problem;

	@Column(name = "algorithms", nullable = false)
	private String algorithm;

	@Column(name = "result_message", nullable = false)
	private String resultMessage;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comp_status")
	private AuxData compStatus;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public AuxData getCompStatus() {
		return compStatus;
	}

	public void setCompStatus(AuxData compStatus) {
		this.compStatus = compStatus;
	}
}
