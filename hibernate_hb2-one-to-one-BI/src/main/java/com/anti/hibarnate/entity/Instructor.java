package com.anti.hibarnate.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "instructor")
public class Instructor {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)   // how date saved in db
	private Date idopont;
	
	public Date getIdopont() {
		return idopont;
	}



	public void setIdopont(Date idopont) {
		this.idopont = idopont;
	}

	@Transient     // nem menti az adat bazisba 
	private int id2;
	
	@Column(name="first_name" ,nullable = false)
	private String firstName;
	
	@Column(name="last_name" , nullable = false) // kötelezo nullable
	private String lastName;
	
	// setup link
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_id_munyi" ) // ha nem addunk meg semmit masik tabla PK lesz
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
