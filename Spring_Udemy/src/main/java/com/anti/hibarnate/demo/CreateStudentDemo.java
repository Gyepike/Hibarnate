package com.anti.hibarnate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.anti.hibarnate.entity.Student;

public class CreateStudentDemo {
	
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

			// create session factory

			//  open session hasznald masik configuralni kell es csak egy tread jo
			// Session session = factory.getCurrentSession();
			
			Session session = factory.openSession();

			// use sesion to save

			// create student
	
			
			System.out.println("Create 3 Student objects");
			Student tempStudent = new Student("Paul", "Wall", "paul@anti.com", java.util.Calendar.getInstance().getTime());
			Student tempStudent2 = new Student("Demona", "Eliamarca", "demona@anti.com", java.util.Calendar.getInstance().getTime());
			Student tempStudent3 = new Student("Mary", "Jane", "mary@anti.com", java.util.Calendar.getInstance().getTime());
			Student tempStudent4 = new Student("Apple", "bone", "apple@anti.com", java.util.Calendar.getInstance().getTime());
			
			System.out.println(tempStudent.toString());

			// start transaction
			Transaction tx = session.beginTransaction();

			// save student
			System.out.println("Save Student");
			session.save(tempStudent);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.save(tempStudent4);
			
			
			
			// commit
			tx.commit();
			session.close();
			
			session = factory.openSession();
			Student myStudent = session.get(Student.class, tempStudent3.getId());

			System.out.println("Generated id "+ myStudent.toString());
			
			session.close();
			
		} finally {
			factory.close();
		}

	}
	
	public static void main(String[] args) {
	   save();
	}

}
