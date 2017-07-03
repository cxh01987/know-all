package com.jarris.bean;

import java.util.ArrayList;
import java.util.List;


public class EmpEvLogInResponse extends ServiceStatus {

	private Employee employee;
	
	private List<Project> projects = new ArrayList<Project>();
	
	private List<Employee> leaders = new ArrayList<Employee>();

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Employee> getLeaders() {
		return leaders;
	}

	public void setLeaders(List<Employee> leaders) {
		this.leaders = leaders;
	}

	
	
	
}
