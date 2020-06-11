package com.anti.Hibarnate_Many_Many.copy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



//https://vladmihalcea.com/the-best-way-to-map-a-composite-primary-key-with-jpa-and-hibernate/
@Entity
public class Taska {
	
	@Id
	@Column(name="TaskaKey")
	public int taskaNo;
	
	private String Marka;
	
	
	
	public int getTno() {
		return taskaNo;
	}


	public void setTno(int tno) {
		this.taskaNo = tno;
	}


	


	public String getMarka() {
		return Marka;
	}


	public void setMarka(String Marka) {
		this.Marka = Marka;
	}
}
