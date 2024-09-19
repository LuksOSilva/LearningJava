package application;

import java.util.Scanner;

import services.PrintService;

public class Program {

	public static void main(String[] args) {
		
		
		PrintService ps = new PrintService();
		
		try (Scanner sc = new Scanner(System.in)) {
		
			System.out.println("How many values?");
			int n = sc.nextInt();
			
			for (int i = 0; i < n; i++) {
				int value = sc.nextInt();
				ps.addValue(value);
			}
			
			System.out.println(ps.print());
			
			System.out.println("First: " + ps.first());
		}
		catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}

}
