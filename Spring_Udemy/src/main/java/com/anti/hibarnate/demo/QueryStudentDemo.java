package com.anti.hibarnate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.anti.hibarnate.entity.Student;

public class QueryStudentDemo {

	private static void save() {
		Configuration con = null;
		SessionFactory factory = null;

		con = new Configuration().configure().addAnnotatedClass(Student.class);
		factory = con.buildSessionFactory();
		Session session = factory.openSession();

		try {

			Transaction tr = session.beginTransaction();

			// query student
			List<Student> theStudents = session.createQuery("from Student s").getResultList();

			// list

			printOut(theStudents);

			System.out.println("------------------------------");
			theStudents = session.createQuery("from Student s where s.lastName = 'Jane' "
					+ " OR s.lastName ='Wall' "
					).getResultList(); // mingi ugy
																											// ahogz
																											// JAVA code
																											// nevezik!!!
			// commit nem last_Name az adatbazis !!!
			
			printOut(theStudents);
             
			System.out.println("------------------------------");
			
			theStudents = session.createQuery("from Student s where s.email like '%Ap%' ").getResultList();
			
			printOut(theStudents);
			System.out.println("------------------------------");
			
			
			tr.commit();
			session.close();

		} finally {
			factory.close();
		}

	}

	private static void printOut(List<Student> theStudents) {
		for (Student student : theStudents) {

			System.out.println(student.toString());
		}
	}

	public static void main(String[] args) {
		save();
	}

}
