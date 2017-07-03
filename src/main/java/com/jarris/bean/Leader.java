package com.jarris.bean;

public class Leader {

	private int id;

	private String staffId;

	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStaffId() {
		return staffId;
	}

	public Leader(int id, String staffId, String name) {
		super();
		this.id = id;
		this.staffId = staffId;
		this.name = name;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Leader() {
		super();
	}

	@Override
	public String toString() {
		return "Leader [id=" + id + ", staffId=" + staffId + ", name=" + name
				+ "]";
	}

}
