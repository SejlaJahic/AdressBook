package com.AdressBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RegisterUser {

	public static Scanner scanner = new Scanner(System.in);

	public static User register() {
		System.out.println("Enter first name:");
		String firstName = scanner.next();

		System.out.println("Enter last name:");
		String lastName = scanner.next();

		System.out.println("Enter age:");
		int age = scanner.nextInt();

		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAge(age);

		boolean proceed = true;
		while (proceed) {
			try {
				System.out.println("Enter telephone number:");
				String telNum = scanner.next();
				user.setNumber(telNum);
				proceed = false;
			} catch (Exception e) {
				e.getMessage();
				scanner.nextLine();
			}
		}

		Connection con = null;

		String connectionUrl = "jdbc:sqlserver://DESKTOP-Q6E269E\\SQLEXPRESS;database=AdressBook;integratedSecurity=true;";
		try {
			con = DriverManager.getConnection(connectionUrl);
			Statement st = con.createStatement();

			st.executeUpdate("INSERT INTO Users(FirstName,LastName,Age,Number) VALUES('"
					+ user.getFirstName()
					+ "','"
					+ user.getLastName()
					+ "',"
					+ user.getAge() + ",'" + user.getNumber() + "')");
			System.out.println("You have succesfully registered user "
					+ firstName);

			ResultSet rs = st
					.executeQuery("SELECT ID FROM Users WHERE FirstName='"
							+ user.getFirstName() + "' AND LastName='"
							+ user.getLastName() + "'");

			while (rs.next()) {
				System.out.println("ID Number is: " + rs.getInt(1));
			}

			rs.close();
			con.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
