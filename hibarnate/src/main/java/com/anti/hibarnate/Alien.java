package com.anti.hibarnate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity() // @Entity(name="Alien_Munyi") change entity name it change table name too 
@Table(name="Munyi") // only change table name 3 layer => class enity table 
public class Alien {
    @Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
	}
	
	
	
	public Alien() {
		super();
	}


	@Id // primary key
	private int aid;
	@Transient // not permanat not saved in db
	private int szam = 10;
	@Column(name="alien_name")
    private  AlienName aname;
    private String color;
    
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	
	public AlienName getAname() {
		return aname;
	}
	public void setAname(AlienName aname) {
		this.aname = aname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
