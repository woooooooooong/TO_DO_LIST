package com.javalec.project.dto;

public class Categorylist_dto {
	String cId;
	String cName;

	public Categorylist_dto() {
		// TODO Auto-generated constructor stub
	}

	public Categorylist_dto(String cId, String cName) {
		super();
		this.cId = cId;
		this.cName = cName;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}
	
	

} // Categorylist_dto