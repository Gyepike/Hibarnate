package com.anti.laptop_student;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity()  
//@Table(name="Laptop_Munyi") extar tablat csinal Laptop_Munyi neven egyet csinal enity miatt 
public class Laptop {
  
	
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", laname=" + laname + "]";
	}



	public Laptop() {
		super();
	}


	@Id // primary key
	private int lid;
    private  String laname;
   
    


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

