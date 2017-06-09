package com.jarris.bean;

import java.util.List;

public class Organization {
   
	private List<StaffsBean> staffs;
	
	private String team;


	public List<StaffsBean> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<StaffsBean> staffs) {
		this.staffs = staffs;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
}
