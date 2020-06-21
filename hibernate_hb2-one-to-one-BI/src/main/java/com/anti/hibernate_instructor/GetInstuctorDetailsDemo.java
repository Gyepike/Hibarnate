package com.anti.hibernate_instructor;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.anti.hibarnate.entity.Instructor;
import com.anti.hibarnate.entity.InstructorDetail;


public class GetInstuctorDetailsDemo {
	
	private static void save() {
		Configuration con = null;
		SessionFactory factory = null;
		// create configuration tr
		try {
			con = new Configuration().configure().addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class);
			factory = con.buildSessionFactory();
		} catch (Exception e) {
			e.getMessage();
		}
		 
		 
		try {

		    // start session
			Session session = factory.openSession();
			int  theId = 2;
			
	
		      
			// start transaction
			Transaction tx = session.beginTransaction();
		    
			
			InstructorDetail  tempInstructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println(tempInstructorDetail.toString());
			
			// print out bi instuctor linked 
			
			System.out.println(tempInstructorDetail.getInstructor().toString());
			
			// commit
			
			tx.commit();
		
		
			System.out.println("Done !!");
			
			// clsoe 
			session.close();
			

			
		} finally {
			factory.close();
		}

	}
	
	public static void main(String[] args) {
	   save();
	}

}
