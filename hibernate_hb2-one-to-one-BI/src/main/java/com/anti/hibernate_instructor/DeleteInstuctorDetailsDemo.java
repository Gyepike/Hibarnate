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

public class DeleteInstuctorDetailsDemo {

	private static void save() {
		Configuration con = null;
		SessionFactory factory = null;
		// create configuration tr
		try {
			con = new Configuration().configure().addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class);
			factory = con.buildSessionFactory();
		} catch (Exception e) {
			System.out.println(e);
		}

		Session session = null;
		try {

			// start session
			session = factory.openSession();
			int theId = 2;

			// start transaction
			Transaction tx = session.beginTransaction();

			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println(tempInstructorDetail.toString());

			// print out bi instuctor linked

			System.out.println(tempInstructorDetail.getInstructor().toString());

			// delete 
			
			session.remove(tempInstructorDetail);
			
			// commit

			tx.commit();

			System.out.println("Done !!");

			// close
			session.close();

		} catch (Exception e) {
			System.out.println("Nem talta meg a instructort : " + e);
		} finally {
			session.close();
			factory.close();
		}

	}

	public static void main(String[] args) {
		save();
	}

}
