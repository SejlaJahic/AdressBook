package com.AdressBook;

public class AdressBook {

	private String firstName;
	private String lastName;
	private String number;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "AdressBook [firstName=" + firstName + ", lastName=" + lastName
				+ ", number=" + number + "]";
	}

}
