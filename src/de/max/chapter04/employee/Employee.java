package de.max.chapter04.employee;

public class Employee {
	private int age;
	private double salary;
	
	public void raiseSalary(double percentage)
	{
		salary *= 1 + percentage * 0.01; 
	}
	public void print()
	{
		System.out.println("Age: " + age);
		System.out.println("Salary: " + salary);
	}
	public Employee()
	{
		
	}
	public Employee(int age, double salary)
	{
		this.age = age;
		this.salary = salary;
	}
}
