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
@Table(name = "aux_data")
@Access(AccessType.FIELD)
public class AuxData extends ParentEntity {

	private static final long serialVersionUID = -1494112329987460751L;

	@Column(name = "aux_name", nullable = false, length = 25)
	private String auxName;

	@Column(name = "short_name", nullable = false, length = 10)
	private String shortName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_aux_data_group", nullable = false)
	private AuxDataGroup auxDataGroup;

	@Column(name = "aux_order", nullable = false, length = 11)
	private Integer auxOrder;

	public String getAuxName() {
		return auxName;
	}

	public void setAuxName(String auxName) {
		this.auxName = auxName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public AuxDataGroup getAuxDataGroup() {
		return auxDataGroup;
	}

	public void setAuxDataGroup(AuxDataGroup auxDataGroup) {
		this.auxDataGroup = auxDataGroup;
	}

	public Integer getAuxOrder() {
		return auxOrder;
	}

	public void setAuxOrder(Integer auxOrder) {
		this.auxOrder = auxOrder;
	}
}
