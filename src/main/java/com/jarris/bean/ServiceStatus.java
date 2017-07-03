package com.jarris.bean;

public class ServiceStatus {

	private String statusCde;
	private String desc;

	public ServiceStatus() {
		super();
	}

	public ServiceStatus(String statusCde, String desc) {
		super();
		this.statusCde = statusCde;
		this.desc = desc;
	}

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

	@Override
	public String toString() {
		return "ServiceStatus [statusCde=" + statusCde + ", desc=" + desc + "]";
	}

}
