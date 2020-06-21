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

			//printOut(theStudents);

			String a = "Jane";
			System.out.println("------------------------------");
			/**
			theStudents = session.createQuery("from Student s where s.lastName =  '"+a+"'"
					+ " OR s.lastName ='Wall' "
					).getResultList(); 
			
			// bad partice '"+a+"'
			
			**/
			
			class Lekerdez { 
			
			  

				private String lastname = "Wall";
				private String firstName = "bone";
 
				public String getFirstName() {
					return firstName;
				}

				public void setFirstName(String firstName) {
					this.firstName = firstName;
				}

				public String getlastname() {
					return lastname;
				}

				public void setlastname(String lastName) {
					this.lastname= lastName;
				}
			      
			}
			
			Lekerdez lekerdez = new Lekerdez();
			
			
			String lastname = "Jane";
			String hql = "from Student s where s.lastName = :lastname "
					+ " or s.firstName = :firstName "
					;
			
			//theStudents = session.createQuery(hql).setParameter("lastname", lastname).setParameter("firstName", "Goliath").getResultList(); 
			
			
			String hql2 = "from Student s where s.lastName = :lastname  OR s.lastName = :firstName";
			
			
			System.out.println("lekerdez !!!");
			theStudents = session.createQuery(hql2).setProperties(lekerdez).getResultList();
			
			
			printOut(theStudents);
             
			System.out.println("------------------------------");
			
			//theStudents = session.createQuery("from Student s where s.email like '%Ap%' ").getResultList();
			
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
