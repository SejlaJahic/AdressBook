package com.AdressBookDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabaseAdressBook {

	public static void main(String[] args)throws SQLException {
		Connection con = null;
		
		String connectionUrl = "jdbc:sqlserver://DESKTOP-Q6E269E\\SQLEXPRESS;database=AdressBook;integratedSecurity=true;";
		con = DriverManager.getConnection(connectionUrl);
		
		String ddl = "CREATE TABLE Users ("
				+ " ID int IDENTITY(1,1),"
				+ "	FirstName nvarchar(30),"
				+ "	LastName nvarchar(30),"
				+ "	Age int,"
				+ "	Number nvarchar(15),"
				+ "	PRIMARY KEY(ID)"
				+ "	)";
		
		
		String ddl2 ="CREATE TABLE AdressBook ("
				+ " ID int IDENTITY(1,1),"
				+ " UserId int,"
				+ "	FirstName int,"
				+ "	LastName int,"
				+ "	Number int,"
				+ " PRIMARY KEY(ID),"
				+ "	FOREIGN KEY(UserId) REFERENCES Users(ID)"
				+ "	)";
		
				Statement st = con.createStatement();
				st.executeUpdate(ddl);
				st.executeUpdate(ddl2);
				System.out.println("Success");
				con.close();

	}

}
