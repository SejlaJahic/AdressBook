package com.AdressBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreviewAdressBook {

	public static void insertToAdressBook(int id) {
		System.out.println("Enter first name of your contact:");
		String fname = RegisterUser.scanner.next();
		System.out.println("Enter last name of your contact:");
		String lname = RegisterUser.scanner.next();
		System.out.println("Enter telephone number of your contact:");
		String tnum = RegisterUser.scanner.next();

		String connectionUrl = "jdbc:sqlserver://DESKTOP-Q6E269E\\SQLEXPRESS;database=AdressBook;integratedSecurity=true;";
		Connection con;
		try {
			con = DriverManager.getConnection(connectionUrl);
			Statement st = con.createStatement();

			st.executeUpdate("INSERT INTO AdressBook(UserId, FirstName, LastName, Number) VALUES("
					+ id + ",'" + fname + "','" + lname + "','" + tnum + "')");

			System.out.println("You have successfully added new contact.");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void showAdressBook(int id) {

		String connectionUrl = "jdbc:sqlserver://DESKTOP-Q6E269E\\SQLEXPRESS;database=AdressBook;integratedSecurity=true;";
		Connection con;

		try {
			con = DriverManager.getConnection(connectionUrl);
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT ID,FirstName, LastName, Number FROM AdressBook WHERE UserId="
							+ id + "");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
						+ rs.getString(3) + "\t" + rs.getString(4));
			}
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	public static void previevInfo(int id){
		String connectionUrl = "jdbc:sqlserver://DESKTOP-Q6E269E\\SQLEXPRESS;database=AdressBook;integratedSecurity=true;";
		Connection con;

		try {
			con = DriverManager.getConnection(connectionUrl);
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT ID,FirstName, LastName, Number FROM Users WHERE UserId="
							+ id + "");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
						+ rs.getString(3) + "\t" + rs.getString(4));
			}
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
