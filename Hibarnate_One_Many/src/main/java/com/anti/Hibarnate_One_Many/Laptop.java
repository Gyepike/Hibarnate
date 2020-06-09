package com.anti.Hibarnate_One_Many;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity()  
public class Laptop {
  
	
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", laname=" + laname + "]";
	}



	@Id // primary key
	private int lid;
    private  String laname;
    
    @ManyToOne
    private  Student student;
    

	public String getLaname() {
		return laname;
	}



	public void setLaname(String laname) {
		this.laname = laname;
	}



	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	public int getAid() {
		return lid;
	}
	public void setAid(int aid) {
		this.lid = aid;
	}
	
}

