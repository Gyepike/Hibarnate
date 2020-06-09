package com.anti.Hibarnate_Many_Many.copy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DataGeneral {

	static Student stud;
	static Student stud1;
	static Student stud2;

	static Laptop lap;
	static Laptop lap1;
	static Laptop lap2;
	static Laptop lap3;
	
	
	
	public static void general() {

		stud = new Student();
		stud1 = new Student();
		stud2 = new Student();

		lap = new Laptop();
		lap1 = new Laptop();
		lap2 = new Laptop();
		lap3 = new Laptop();

		lap.setAid(103);
		lap.setLaname("Toshiba");

		lap1.setAid(104);
		lap1.setLaname("Dell");

		lap2.setAid(106);
		lap2.setLaname("IBM");

		lap3.setAid(107);
		lap3.setLaname("Asus");
		

		stud.setRollno(4);
		stud.setName("Munyi");
		stud.setMarks(50);
		stud.getLaptop().add(lap);
		stud.getLaptop().add(lap1);
		stud.getLaptop().add(lap2);
	
		
		stud1.setRollno(5);
		stud1.setName("Munyo");
		stud1.setMarks(50);
		stud1.getLaptop().add(lap);
		stud1.getLaptop().add(lap1);
		stud1.getLaptop().add(lap2);
	
		
		
        lap3.getStudent().add(stud);
        lap3.getStudent().add(stud1);
        
        lap2.getStudent().add(stud1);


		System.out.println(lap.toString());
		System.out.println(stud.toString());

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		con.addAnnotatedClass(Laptop.class);

		SessionFactory sef = con.buildSessionFactory();

		Session se = sef.openSession();
		Transaction tx = se.beginTransaction();

		se.save(stud);
		se.save(stud1);
		
	    se.save(lap);
	    se.save(lap1);
	    se.save(lap2);
	    se.save(lap3);
	    

		tx.commit();

		System.out.println("Many-Many without extra table");

	}

	
}
