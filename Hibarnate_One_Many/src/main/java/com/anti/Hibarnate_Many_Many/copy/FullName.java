package com.anti.Hibarnate_Many_Many.copy;

import javax.persistence.Embeddable;


@Embeddable
public class FullName {

	
	public FullName() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FullName(String fname, String lname, String mname) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.mname = mname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String fname;
	public String lname;
	public String mname;

}
