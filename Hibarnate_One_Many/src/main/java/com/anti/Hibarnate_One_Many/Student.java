package com.anti.Hibarnate_One_Many;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity // az sorba tegye bele mint rekordot ne kulon tablakent kezeleje
public class Student {

	@Id 
	public int rollno;
	
	
	private String name;
	private int marks;
	
	@OneToMany(mappedBy = "student") // put sudent_rollno connect filed ha nincs kapcsolo tabla jon letre
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
