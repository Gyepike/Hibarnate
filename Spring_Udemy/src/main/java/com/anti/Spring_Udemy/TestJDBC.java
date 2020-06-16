package com.anti.Spring_Udemy;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?serverTimezone=UTC&useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent"; 
		try {
			
			System.out.println("Connect to db"+ jdbcUrl);
			
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection done");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
