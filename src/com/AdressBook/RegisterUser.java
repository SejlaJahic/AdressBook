package com.AdressBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RegisterUser {

	public static Scanner scanner = new Scanner(System.in);

	public static void register() {
		System.out.println("Enter first name:");
		String firstName = scanner.next();

		System.out.println("Enter last name:");
		String lastName = scanner.next();

		System.out.println("Enter age:");
		int age = scanner.nextInt();

		System.out.println("Enter telephone number:");
		String telNum = scanner.next();

		Connection con = null;

		String connectionUrl = "jdbc:sqlserver://DESKTOP-Q6E269E\\SQLEXPRESS;database=AdressBook;integratedSecurity=true;";
		try {
			con = DriverManager.getConnection(connectionUrl);
			Statement st = con.createStatement();

			st.executeUpdate("INSERT INTO Users(FirstName,LastName,Age,Number) VALUES('"
					+ firstName
					+ "','"
					+ lastName
					+ "',"
					+ age + ",'" + telNum + "')");
			System.out.println("You have succesfully registered user "
					+ firstName);

			ResultSet rs = st
					.executeQuery("SELECT ID FROM Users WHERE FirstName='"
							+ firstName + "' AND LastName='"
							+ lastName + "' AND Age=" + age+" AND Number='" + telNum +"' ");

			while (rs.next()) {
				System.out.println("ID Number is: " + rs.getInt(1));
			}

			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
