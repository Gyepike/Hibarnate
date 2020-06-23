package com.anti.hibernate_instructor;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.anti.hibarnate.entity.Instructor;
import com.anti.hibarnate.entity.InstructorDetail;

//https://howtoprogramwithjava.com/hibernate-manytoone-unidirectional-tutorial/
//https://www.youtube.com/watch?v=onS9G0zpQwA&list=PLBgMUB7xGcO0cujAlaeDDEOdZkeNZUScM
public class CreateDemo {
	
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

		
			Session session = factory.openSession();

		    Instructor tempInstructor = new Instructor("Chad","Darby","darby@luv2.com");
		    tempInstructor.setIdopont(new Date());
		    InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code/youtube", "luv 2 code");
	       
		    

		    Instructor tempInstructor2 = new Instructor("Munyi","Mano","munyi@anti.com");
		    InstructorDetail tempInstructorDetail2 = new InstructorDetail("http://www.manok/youtube", "gombahaz");
	
		    tempInstructor2.setIdopont(new Date());
		    
		    tempInstructor.setInstruncDetail(tempInstructorDetail);
		    tempInstructor2.setInstruncDetail(tempInstructorDetail2);

			// start transaction
			Transaction tx = session.beginTransaction();
		    
		   	System.out.println("Save :" + tempInstructor2.toString());
			session.save(tempInstructor);
			session.save(tempInstructor2);
			
			tx.commit();
		
		
			System.out.println("Done !!");
			// commit
			
			session.close();
			

			
		} finally {
			factory.close();
		}

	}
	
	public static void main(String[] args) {
	   save();
	}

}
