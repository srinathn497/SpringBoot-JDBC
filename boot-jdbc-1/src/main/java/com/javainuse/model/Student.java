package com.javainuse.model;

import org.springframework.stereotype.Component;

@Component
public class Student {

	private String stndno;
	private int no;
	public String getStndno() {
		return stndno;
	}
	public void setStndno(String stndno) {
		this.stndno = stndno;
	}
	public String getStndname() {
		return stndname;
	}
	public void setStndname(String stndname) {
		this.stndname = stndname;
	}
	public String getStndjob() {
		return stndjob;
	}
	public void setStndjob(String stndjob) {
		this.stndjob = stndjob;
	}
	private String stndname;
	private String stndjob;
	
	@Override
	public String toString() {
		return "Student [stndno=" + stndno + ", stndname=" + stndname + ", stndjob=" + stndjob + "]";
	}
	
	
}
