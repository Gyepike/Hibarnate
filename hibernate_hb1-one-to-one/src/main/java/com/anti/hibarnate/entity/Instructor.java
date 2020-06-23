package com.anti.hibarnate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//https://www.youtube.com/watch?v=MLsLrj8XFOA&list=PLBgMUB7xGcO0cujAlaeDDEOdZkeNZUScM&index=14
//mapedy by onlz need in bi direction hibarnate cannot link 2 times 

@Entity
@Table(name = "instructor")
public class Instructor {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	// setup link
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_id_munyi" ) // ha nem addunk meg semmit masik tabla PK lesz owner
	private InstructorDetail instruncDetail;
	
	private String email;
	
	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	
	
	public String getFirstName() {
		return firstName;
	}

	public Instructor() {

	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instruncDetail=" + instruncDetail + "]";
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

	public InstructorDetail getInstruncDetail() {
		return instruncDetail;
	}

	public void setInstruncDetail(InstructorDetail instruncDetail) {
		this.instruncDetail = instruncDetail;
	}

	
}
