package com.anti.Hibarnate_Many_Many.copy;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity // az sorba tegye bele mint rekordot ne kulon tablakent kezeleje
public class Student {

	@Id 
	public int rollno;
	
	
	private FullName name;
	public FullName getName() {
		return name;
	}
	public void setName(FullName name) {
		this.name = name;
	}
	private int marks;
	
	@ManyToMany(mappedBy = "student") // put sudent_rollno connect filed ha nincs kapcsolo tabla jon letre
	private List <Laptop> laptop = new ArrayList<Laptop>();
	

	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}
	
	
}
