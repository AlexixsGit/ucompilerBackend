package com.itm.ucompiler.util;

import java.util.List;

/**
 * @author Alexis Ortiz
 * @since 2017
 * 
 *        This class is used for getting a list of data and its quantity
 * 
 *
 */
public class QueryResult {
	private int totalRecords;
	private List<Object> list;

	public QueryResult() {
		super();
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

}
