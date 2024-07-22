/*
 * Class: CMSC201 
 * Instructor: Dr. Grinberg
 * Description: Student class w/final classStatus; subclass of Person
 * Due: 07/15/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Nora Temkin
*/

import java.util.Scanner;

public class Student extends Person {
	private final String CLASS_STATUS;
	
	// constructors
	public Student() {
		super();
		CLASS_STATUS = "Freshman";
	}
	
	public Student(String name, String address, String phoneNumber, String email, String classStatus) {
		super(name, address, phoneNumber, email);
		this.CLASS_STATUS = classStatus; 
	}
	
	// Getter method for classStatus (no setter because classStatus is a final data field)
	public String getClassStatus() {
		return this.CLASS_STATUS;
	}
	
	// Method to populate all data fields from user's keyboard input
	// this method does not override Person's initializeFieldsFromKeyboard method because Student's method must be
	// static to be callable from main(), because it calls constructor that initializes final classStatus attribute
	public static Student createFromKeyboard(Scanner scan) {
		final String NAME_PROMPT = "Please enter a name: ";
		
		// variables to hold user input for data fields before calling constructor
		String inputName, inputAddress, inputPhone, inputEmail, inputClassStatus;
		
		// Display prompt for user to enter Person's name
				System.out.print(NAME_PROMPT);
				// Get user input & use it to set Person's name
				inputName = scan.nextLine();
				
				// Personalize additional user prompts w/ Student's name
				String addressPrompt = "Enter " + inputName + "'s address: ",
					   phoneNumberPrompt = "Enter " + inputName + "'s phone number: ",
					   emailPrompt = "Enter " + inputName + "'s email: ",
					   classStatusPrompt = "Enter " + inputName + "'s class status " +
					   			            "(e.g. Freshman, Sophomore, Junior, or Senior): ";
				
				// Display prompt for user to enter Student's address
				System.out.print(addressPrompt);
				// Get user input & use it to set Student's address
				inputAddress = scan.nextLine();
				
				// Display prompt for user to enter Student's phone number
				System.out.print(phoneNumberPrompt);
				// Get user input & use it to set Student's phone number after validating input & formatting it (if necessary)
				inputPhone = (validatePhoneNumber(scan.nextLine(), scan));
				
				// Display prompt for user to enter Student's email
				System.out.print(emailPrompt);
				// Get user input & use it to set Student's email
				inputEmail = scan.nextLine();
				
				// Display prompt for user to enter Student's class status
				System.out.print(classStatusPrompt);
				// Get user input & use it to set Student's class status
				inputClassStatus = scan.nextLine();
		
				// Create & return a Student object
				Student thisStudent = new Student(inputName, inputAddress, inputPhone, inputEmail, inputClassStatus);
				return thisStudent;
	}
	
	// Student-specific overridden toString() method
	@Override
	public String toString() {
		return "Student: " + this.name + "\nStatus: " + this.CLASS_STATUS + "\nAddress: " + this.address +
				"\nPhone number: " + this.phoneNumber + "\nEmail Address: " + this.email;
	}	// end overridden toString() method
	
}	// end class Student
