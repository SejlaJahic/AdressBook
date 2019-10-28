package com.AdressBook;

public class TestAdressBook {

	public static void main(String[] args) {
		boolean proceed = true;
		User user = null;
		boolean loggedin = false;
		
		while (proceed) {
			System.out.println("WELCOME!");
			System.out.println("Press 0 to login!"
					+ "\nPress 1 for registration "
					+ "\n2 for preview Your adress book"
					+ "\n3 for inserting into Your adress book"
					+ "\n4 to preview Your info" + "\n5 for logout."
					+ "\n6 to exit!");

			int input = RegisterUser.scanner.nextInt();

			if (input == 0) {
				if (user==null&& loggedin==false) {
					user = Login.login();
					loggedin = true;
				} else {
					System.out.println("You are already logged in..");
				}
			}
			if (input == 1) {
				if (user!=null && loggedin==true) {
					System.out.println("You must logout to do this!");
				} else {
					RegisterUser.register();
				}
			}
			if (input == 2) {
				if (user!=null && loggedin==true) {
					System.out.println("Here's Your adress book:");
					PreviewAdressBook.showAdressBook(user.getId());
				} else {
					System.out.println("You must be logged in to do this!");
				}
			}
			if (input == 3) {
				if (user!=null && loggedin==true) {

					try {
						PreviewAdressBook.insertToAdressBook(user.getId());
					} catch (Exception e) {
						System.out.println("Data You've entered is not valid.");
					}
				} else {
					System.out.println("You must be logged in to do this!");
				}
			}
			if (input == 4) {
				if (user!=null && loggedin==true) {
					PreviewAdressBook.previevInfo(user.getId());
				} else {
					System.out.println("You must be logged in to do this!");
				}
			}
			if (input == 5) {
				if (user!=null && loggedin==true) {
					user=null;
					loggedin=false;
				} else {
					System.out.println("You are not logged in!");
				}
			}
			if (input == 6) {
				System.out.println("GOODBYE!");
				proceed = false;
			}
		}

		RegisterUser.scanner.close();

	}

}
