package com.jarris.bean;

import java.util.Date;

import javax.validation.constraints.Size;

public class Employee {

	private int id;

	/**
	 * HSBC staff id 43742140
	 * {"action":"I","employee":{"staffId":43742140,"ehrId"
	 * :"E100015718","lName":"Duce C Z XIE","chName":"","isOfic":1}}
	 */
	@Size(max = 10)
	private String staffId;

	/**
	 * simple : E100015718
	 */
//	@NotNull
	private String ehrId;

	/**
	 * lotus id Duce C Z XIE
	 */
//	@NotNull
	private String lName;

//	@NotNull
	private String chName;

	private String biLevel;
	private String currtProj;
	
	private int level;

	private Leader aleader = new Leader();


	@Size(min = 6, max = 100)
	private String password;

	/**
	 * a flag to mark an employee whether or not is an active worker 1.
	 * Available 0.Leave
	 */
	@Size(min = 0, max = 1)
	private int isOfic;

	private String nickname;

	// c f
	private String bltype;
	
	private int isassistant;
	private int bugroup;
	
	private String onBoadDay;
	private String releaseDay;
	private String resignReason;
	private int flag;
	private String	subpm;
	
	public String getOnBoadDay() {
		return onBoadDay;
	}

	public void setOnBoadDay(String onBoadDay) {
		this.onBoadDay = onBoadDay;
	}

	public String getReleaseDay() {
		return releaseDay;
	}

	public void setReleaseDay(String releaseDay) {
		this.releaseDay = releaseDay;
	}

	public String getSubpm() {
		return subpm;
	}

	public void setSubpm(String subpm) {
		this.subpm = subpm;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}



	public int getIsassistant() {
		return isassistant;
	}

	public void setIsassistant(int isassistant) {
		this.isassistant = isassistant;
	}

	public int getBugroup() {
		return bugroup;
	}

	public void setBugroup(int bugroup) {
		this.bugroup = bugroup;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBiLevel() {
		return biLevel;
	}

	public void setBiLevel(String biLevel) {
		this.biLevel = biLevel;
	}

	public String getCurrtProj() {
		return currtProj;
	}

	public void setCurrtProj(String currtProj) {
		this.currtProj = currtProj;
	}

	public String getBltype() {
		return bltype;
	}

	public void setBltype(String bltype) {
		this.bltype = bltype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getEhrId() {
		return ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsOfic() {
		return isOfic;
	}

	public void setIsOfic(int isOfic) {
		this.isOfic = isOfic;
	}

	public Employee(String staffId, String ehrId, String lName, String chName,
			int level, String password, int isOfic) {
		super();
		this.staffId = staffId;
		this.ehrId = ehrId;
		this.lName = lName;
		this.chName = chName;
		this.level = level;
		this.password = password;
		this.isOfic = isOfic;
	}
	
	public Employee(String staffId, String ehrId, String lName, String chName,
			int level, int isOfic, String onBoadDay, String resignReason) {
		super();
		this.staffId = staffId;
		this.ehrId = ehrId;
		this.lName = lName;
		this.chName = chName;
		this.level = level;
		this.isOfic = isOfic;
		this.onBoadDay = onBoadDay;
		this.resignReason = resignReason;
	}

	public String getResignReason() {
		return resignReason;
	}

	public void setResignReason(String resignReason) {
		this.resignReason = resignReason;
	}

	public Employee() {
		super();
	}

	public Leader getAleader() {
		return aleader;
	}

	public void setAleader(Leader aleader) {
		this.aleader = aleader;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", staffId=" + staffId + ", ehrId="
				+ ehrId + ", lName=" + lName + ", chName=" + chName
				+ ", biLevel=" + biLevel + ", currtProj=" + currtProj
				+ ", level=" + level + ", aleader=" + aleader + ", password="
				+ password + ", isOfic=" + isOfic + ", nickname=" + nickname
				+ ", bltype=" + bltype + ", isassistant=" + isassistant
				+ ", bugroup=" + bugroup + ", onBoadDay=" + onBoadDay
				+ ", releaseDay=" + releaseDay + ", resignReason="
				+ resignReason + ", flag=" + flag + "]";
	}



}
