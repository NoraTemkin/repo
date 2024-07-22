/*
 * Class: CMSC201 
 * Instructor: Dr. Grinberg
 * Description: Staff class w/ title field; subclass of Employee
 * Due: 07/15/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Nora Temkin
*/

import java.util.Scanner;

public class Staff extends Employee {
	final private int NO_OFFICE = 0;
	final protected String DEFAULT_TITLE = "Grade 25 Non-Management Worker";
	private String title;
	
	// Constructors
	public Staff() {
		super();
		this.title = DEFAULT_TITLE;
	}
	
	// this constructor does not initialize inherited data fields; attributes inherited from Employee & Person classes
	// can be initialized via overridden initializeFieldsFromKeyboard using super. version of method, or via setters
	// to avoid unreadably long list of parameters for constructor
	public Staff(String title) {
			this.title = title;
		}
	
	// Getter & Setter
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	// Other methods:
	// 1. Method to initialize data fields from user's keyboard input; overrides method from superclass
		@Override
		public void initializeFieldsFromKeyboard(Scanner scan) {
			final String TITLE_PROMPT = "Enter a job title: ";
			
			super.initializeFieldsFromKeyboard(scan); // Employee version calls Person version so all inherited fields are set

			// Prompt user to enter staff member's job title & assign value of input to title data field
			System.out.print(TITLE_PROMPT);
			this.title = scan.nextLine();
			
		}	// end initializeFieldsFromKeyboard() method
		
		// 2. Method to return a String describing the Faculty member; overrides method from superclass
		@Override
		public String toString() {
			return "Staff: " + this.name + 
					"\nTitle: " + this.title + 
					"\nSalary: $" + this.salary +
					"\nDate Hired: " + (this.dateHired).getDate() + 
					"\n" + 
					"\nOffice: " + (this.officeNumber == NO_OFFICE ? "No office assigned" : this.officeNumber) +
					"\nAddress: " + this.address +
					"\nPhone number: " + this.phoneNumber + 
					"\nEmail Address: " + this.email;
		}	// end overridden toString() method
		
}	// end Staff class
