package com.AdressBook;

import java.util.Scanner;

public class RegisterUser {

	public static Scanner scanner = new Scanner(System.in);

	public User register() {
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
		
		System.out.println("You have succesfully registered user " + firstName);
		return user;
	}
}
