package com.anti.laptop_student;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity()  
//@Table(name="Laptop_Munyi") extar tablat csinal Laptop_Munyi neven egyet csinal enity miatt 
public class Laptop_Many {
  
	
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", laname=" + laname + "]";
	}



	public Laptop_Many() {
		super();
	}


	@Id // primary key
	private int lid;
    private  String laname;
    
    @ManyToOne
    private Student_One studentone;
   
    


	public int getLid() {
		return lid;
	}



	public void setLid(int lid) {
		this.lid = lid;
	}



	public Student_One getStudentone() {
		return studentone;
	}



	public void setStudentone(Student_One studentone) {
		this.studentone = studentone;
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

