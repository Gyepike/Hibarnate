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


public class DeleteDemo {
	
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
			//bad partice '"+a+"'
			// get instructon primary key 
			int  theId = 2;
			String  theId2 = "2";
			
			
			List<Instructor> theInstructors = session.createQuery("from Instructor where id = "+theId2+" ").getResultList();
			for (Instructor instructor : theInstructors) {
				 
			//	System.out.println(instructor.toString());
			}
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
		
			
			
			// start transaction
			Transaction tx = session.beginTransaction();
		    
			// delete cannot use sql delet will not delete another table 
			if (tempInstructor != null) {
				System.out.println("Find delete "+tempInstructor.toString());
				session.delete(tempInstructor);
						
			}
			
			
			
			
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
