package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
	
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		List<Employee> employees = new ArrayList<>();
		
		
		System.out.println("Enter the number of employees: ");
		int n = sc.nextInt(); sc.nextLine();
		
		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Enter #"+ (i+1) +" data:");
			
			System.out.print("Outsourced (y/n)?");
			char ch = sc.next().charAt(0); 	sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Hours worked: ");
			int hours = sc.nextInt(); sc.nextLine();
			
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble(); sc.nextLine();
			
			
			if (ch == 'y') {
				
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				
				employees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
				
			} else {
			
				employees.add(new Employee(name, hours, valuePerHour));

			}
			
		}
		
		System.out.println();
		System.out.println("PAYMENTS:");
		for (Employee emp : employees) {
			System.out.println(emp.getName() + " - $" + String.format("%.2f", emp.payment()));
		}
		
		
		sc.close();
	}
}
