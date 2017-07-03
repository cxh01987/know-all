package com.jarris.bean;

import java.util.List;

public class IclarityLoginBean {

	private String statusCde;
	
	private String desc;
	
	private EmployeeBean employee;
	
	private List<String> projects;
	
	private List<String> leaders;
	
	public String getStatusCde() {
		return statusCde;
	}

	public void setStatusCde(String statusCde) {
		this.statusCde = statusCde;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public EmployeeBean getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeBean employee) {
		this.employee = employee;
	}

	public List<String> getProjects() {
		return projects;
	}

	public void setProjects(List<String> projects) {
		this.projects = projects;
	}

	public List<String> getLeaders() {
		return leaders;
	}

	public void setLeaders(List<String> leaders) {
		this.leaders = leaders;
	}



}
