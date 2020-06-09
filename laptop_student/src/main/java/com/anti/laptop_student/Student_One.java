package com.anti.laptop_student;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity // az sorba tegye bele mint rekordot ne kulon tablakent kezeleje
public class Student_One {

	@Id 
	public int rollno;
	
	
	private String name;
	private int marks;
	
	@OneToMany(mappedBy = "studentone") // many latop with connect table Student_One_Laptop 2 enity Student_one, laptop
	private List <Laptop_Many> laptops = new ArrayList <Laptop_Many> ();
	
	
	
	public List<Laptop_Many> getLaptops() {
		return laptops;
	}
	public void setLaptops(List<Laptop_Many> laptops) {
		this.laptops = laptops;
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
