package com.AdressBook;

public class TestAdressBook {

	public static void main(String[] args) {
		boolean proceed = true;
		User user = null;		
		while (proceed) {
			System.out.println("WELCOME!");
			System.out.println("Press 1 for registration "
							+ "\n2 for preview Your adress book"
							+ "\n3 for inserting into Your adress book"
							+ "\n4 to preview Your info"
							+ "\n5 for exit.");
			int input = RegisterUser.scanner.nextInt();
				RegisterUser.scanner.nextLine();
			
			if(input==1){
				user = RegisterUser.register();
			}
			if(input==2){
				Login.login();
				PreviewAdressBook.showAdressBook();
			}
			if(input==3){
				PreviewAdressBook.insertToAdressBook();
			}
			if(input==4){
				if(user!=null){
				System.out.println(user.toString());
				}
				else{
					System.out.println("You must log in.");
				}
			}
			if(input==5){
				System.out.println("GOODBYE!");
				proceed=false;
			}
			else{
				System.out.println("Input " + input + " is not valid.");
			}
		}
		
		RegisterUser.scanner.close();
		

	}

}
