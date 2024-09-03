package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter worker data: ");
		System.out.println("Name: ");
		String workerName = sc.nextLine();
		System.out.println("Level: ");
		String workerLevel = sc.nextLine();
		System.out.println("Base salary: ");
		double workerBaseSalary = sc.nextDouble();
		sc.nextLine();

		Worker worker = new Worker(workerName, workerBaseSalary, WorkerLevel.valueOf(workerLevel), new Department(departmentName));
		
		System.out.println("How many contracts to this worker? ");
		int n = sc.nextInt();
		sc.nextLine();
	
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter contrat #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			
		}
		
		
	}
}
