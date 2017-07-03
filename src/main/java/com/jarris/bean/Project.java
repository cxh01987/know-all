package com.jarris.bean;

import java.util.Date;


public class Project {
	//Auto increment
	private int id;
	//Project Description
	private String name;
	//who responsible the project, (data format: LN_staffid)
	private String leader; 
	//anything you want to write about the Project
	private String desc;
	
	//project start date
	private Date startDate;
	
	// project end date
	private Date endDate;
	
	// project status : live, end
	private String status;
	
	//project viewer, they can check projects information, but can't edit
	//(data format: LN_staffid,LN_staffid..)
	private String viewers;
	
	//project Assistant (data format: LN_staffid)
	private String operator;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getViewers() {
		return viewers;
	}
	public void setViewers(String viewers) {
		this.viewers = viewers;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
