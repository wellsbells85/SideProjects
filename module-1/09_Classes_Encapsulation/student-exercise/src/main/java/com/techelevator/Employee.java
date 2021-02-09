package com.techelevator;

public class Employee {
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String fullName;
	private String department;
	private double annualSalary;
	
	public Employee( int myEmployeeId, String myFirstName, String myLastName, double mySalary) {
		employeeId = myEmployeeId;
		firstName = myFirstName;
		lastName = myLastName;
		annualSalary = mySalary;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFullName() {
		return lastName + ", " + firstName;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public double getAnnualSalary() {
		return annualSalary;
	}
	
	public void setDepartment(String newDepartment) {
		department = newDepartment;
	}
	
	public void setLastName(String newLastName) {
		lastName = newLastName;
	}
	
	public void raiseSalary(double percent) {
		annualSalary *= ( 1 + percent / 100 );
	}
	
	
}
