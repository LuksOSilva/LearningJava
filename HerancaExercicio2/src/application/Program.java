package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Taxpayer;
import entities.NaturalPerson;
import entities.LegalPerson;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Taxpayer> taxpayers = new ArrayList<>();
		
		
		System.out.println("Number of taxpayers");
		int n = sc.nextInt(); sc.nextLine();
		
		
		for (int i = 0; i < n; i++) {
			
			System.out.println("Taxpayer #"+ (i+1) +" data:");
			System.out.print("Natural Person or Legal Person? (N/L): ");
			char type = sc.next().charAt(0); sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual Income: ");
			double anualIncome = sc.nextDouble(); sc.nextLine();
			
			if (type == 'L') {
				
				System.out.print("Number of employees:");
				int numberOfEmployees = sc.nextInt(); sc.nextLine();
				
				taxpayers.add(new LegalPerson(name, anualIncome, numberOfEmployees));
				
			} else {
				
				System.out.print("Health Expenses:");
				double healthExpenses = sc.nextDouble(); sc.nextLine();
				
				taxpayers.add(new NaturalPerson(name, anualIncome, healthExpenses));
				
			}
			
		}
		double sum = 0.0;
		
		System.out.println("TAXPAYERS:");
		for (Taxpayer taxpayer : taxpayers) {
			
			System.out.println("Name:"+ taxpayer.getName());
			System.out.println("Anual Income: "+ taxpayer.getAnualIncome());
			
			if (taxpayer instanceof NaturalPerson) {
				System.out.println("Health Expenses: "+ ((NaturalPerson) taxpayer).getHealthExpenses());
			}else {
				System.out.println("Number of Employees: "+ ((LegalPerson) taxpayer).getNumberOfEmployees());
			}
			System.out.println("TAX:" + taxpayer.taxToPay());
			System.out.println("-----------------------------");
			sum += taxpayer.taxToPay();
		}
		
		System.out.println("TOTAL TAXES: "+ String.format("%.2f", sum));
		
		
		
		
		
	}
}
