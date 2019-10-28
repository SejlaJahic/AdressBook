package com.AdressBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

	public static User login(){
		User user = new User();
		System.out.println("Enter Your ID:");
		int id = RegisterUser.scanner.nextInt();
		user.setId(id);
		System.out.println("Enter Your first name:");
		String fName = RegisterUser.scanner.next();
		
		String connectionUrl = "jdbc:sqlserver://DESKTOP-Q6E269E\\SQLEXPRESS;database=AdressBook;integratedSecurity=true;";
		Connection con;
		try {
			con = DriverManager.getConnection(connectionUrl);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Users WHERE ID="+id+" AND FirstName='" + fName+ "'");
			if(rs.next()){
				System.out.println("You have successfully loged in!");
				return user;
			}
			else{
				System.out.println("Account with that ID and first name does not exist.");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	
}
