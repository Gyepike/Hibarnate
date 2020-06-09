package com.anti.Hibarnate_One_One;

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
		stud.setLaptop(lap);

		stud1.setRollno(2);
		stud1.setName("Munyó");
		stud1.setMarks(104);
		stud1.setLaptop(lap2);

		stud2.setRollno(1);
		stud2.setName("Mama");
		stud2.setMarks(107);
		stud2.setLaptop(lap3);

		System.out.println(lap.toString());
		System.out.println(stud.toString());

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		con.addAnnotatedClass(Laptop.class);

		SessionFactory sef = con.buildSessionFactory();

		Session se = sef.openSession();
		Transaction tx = se.beginTransaction();

		se.save(stud);
		se.save(stud2);
		se.save(stud1);

		se.save(lap);
		se.save(lap1);
		se.save(lap2);
		se.save(lap3);

		tx.commit();

		lap = se.get(Laptop.class, 103);
		stud = se.get(Student.class, 4);

		System.out.println(lap.toString());
		System.out.println(stud.toString());
        System.out.println("One-To-One");
	}

	
}
