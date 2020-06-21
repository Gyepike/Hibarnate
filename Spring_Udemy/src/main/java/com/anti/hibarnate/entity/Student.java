package com.anti.hibarnate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student") // mert kisbetus student ezért explicirt megjelelöm
public class Student {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // update hibarnate van allitva, hogy hasznla mysql autot increment = identity 
	private int id;

	@Column(name = "first_name") // first_name
	private String firstName;

	@Column(name = "last_name") // last_name
	private String lastName;

	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date joinedDate;

	public Student(String firstName, String lastName, String email, Date joinedDate) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.joinedDate = joinedDate;
	}


	public Date getJoinedDate() {
		return joinedDate;
	}


	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}


	public Student() {

	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}


	public Student( String firstName, String lastName, String email) {
	
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	
	}

	

}
