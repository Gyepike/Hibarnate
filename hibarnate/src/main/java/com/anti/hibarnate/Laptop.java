package com.anti.hibarnate;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity()  
public class Laptop {
  
	
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", laname=" + laname + "]";
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

