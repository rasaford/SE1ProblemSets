package de.max.chapter04.employee;

public class EmployeeDriver {
	public static void main(String[] args)
	{
		Employee jim = new Employee(25, 30_000.0);
		jim.print();
		
		System.out.println("Raising Salary by 2%");
		
		jim.raiseSalary(2);
		//jim.print();
	}
}
