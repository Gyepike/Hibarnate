package com.anti.Hibarnate_Many_Many.copy;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity()  
public class Laptop {
  
	
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", laname=" + laname + "]";
	}



	@Id // primary key
	private int lid;
    private  String laname;
    
    @ManyToMany
    private List <Student>  student = new ArrayList<Student>();
    

	public List<Student> getStudent() {
		return student;
	}



	public void setStudent(List<Student> student) {
		this.student = student;
	}



	public String getLaname() {
		return laname;
	}



	public void setLaname(String laname) {
		this.laname = laname;
	}




	public int getAid() {
		return lid;
	}
	public void setAid(int aid) {
		this.lid = aid;
	}
	
}

