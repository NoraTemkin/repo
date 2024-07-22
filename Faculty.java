/*
 * Class: CMSC201 
 * Instructor: Dr. Grinberg
 * Description: Faculty class w/ officeHours & rank fields; subclass of Employee
 * Due: 07/15/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Nora Temkin
*/

import java.util.Scanner;

public class Faculty extends Employee {
	final protected String DEFAULT_OFFICE_HOURS = "5:00 - 6:00 pm, Mon, Wed, & Fri",
						   DEFAULT_RANK = "Adjunct Professor";
	private String officeHours,
				   rank;
	
	// Constructors
	public Faculty() {
		super();	// Employee's no-arg constructor, which in turn calls Person's no-arg constructor
		this.officeHours = DEFAULT_OFFICE_HOURS;
		this.rank = DEFAULT_RANK;
	}
	
	// this constructor does not initialize inherited data fields; attributes inherited from Employee & Person classes
	// can be initialized via overridden initializeFieldsFromKeyboard using super. version of method, or via setters
	// to avoid unreadably long list of parameters for constructor
	public Faculty(String officeHours, String rank) {
		this.officeHours = officeHours;
		this.rank = rank;
	}
	
	// Getters & Setters
	public String getOfficeHours() {
		return this.officeHours;
	}
	
	public String getRank() {
		return this.rank;
	}
	
	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}
	
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	// Other methods:
	// 1. Method to initialize data fields from user's keyboard input; overrides method from superclass
	@Override
	public void initializeFieldsFromKeyboard(Scanner scan) {
		final String OFFICE_HOURS_PROMPT = "Enter office hours: ",
					 RANK_PROMPT = "Enter a rank: ";
		
		super.initializeFieldsFromKeyboard(scan); // Employee version calls Person version so all inherited fields are set

		// Prompt user to enter faculty member's office hours & assign value of input to officeHours data field
		System.out.print(OFFICE_HOURS_PROMPT);
		this.officeHours = scan.nextLine();
		
		// Prompt user to enter faculty member's rank & assign value of input to rank data field
		System.out.print(RANK_PROMPT);
		this.rank = scan.nextLine();
	}	// end initializeFieldsFromKeyboard() method
	
	// 2. Method to return a String describing the Faculty member; overrides method from superclass
	@Override
	public String toString() {
		return "Faculty: " + this.name + 
				"\nRank: " + this.rank + 
				"\nSalary: $" + this.salary +
				"\nDate Hired: " + (this.dateHired).getDate() + 
				"\n" + 
				"\nOffice Hours: " + this.officeHours +
				"\nOffice: " + this.officeNumber +
				"\nAddress: " + this.address +
				"\nPhone number: " + this.phoneNumber + 
				"\nEmail Address: " + this.email;
	}	// end overridden toString() method
	
}	// end Faculty class
