package com.anti.hibarnate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.anti.hibarnate.entity.Student;

public class UpdateStudentDemo {
	
	private static void save() {
		Configuration con = null;
		SessionFactory factory = null;
		// create configuration tr
		try {
			con = new Configuration().configure().addAnnotatedClass(Student.class);
			factory = con.buildSessionFactory();
		} catch (Exception e) {
			e.getMessage();
		}
		 
		 
		try {

		
			
			int studentId = 4;		
		
			Session session = factory.openSession();


			// start transaction
			Transaction tx = session.beginTransaction();

		
	
			System.out.println("Get Student with id ");
			
			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Generated id "+ myStudent.toString());
			
			System.out.println("Change Student name !!");
			
			
			myStudent.setFirstName("Goliath");
			
            session.createQuery("update Student set email = 'paul2@anti.com' where id = '1'  ").executeUpdate();
            session.createQuery("update Student set firstName = 'Paul2' where id = '1'  ").executeUpdate();
			
            
			tx.commit();
			session.close();
			
		} finally {
			factory.close();
		}

	}
	
	public static void main(String[] args) {
	   save();
	}

}
