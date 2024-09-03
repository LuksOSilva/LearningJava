package Default;

import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		Triangle x, y;
		x = new Triangle();
		y = new Triangle();
		
		System.out.println("Enter the measures of triangle X: ");
		x.a = scan.nextDouble();
		x.b = scan.nextDouble();
		x.c = scan.nextDouble();
		System.out.println("Enter the measures of triangle Y: ");
		y.a = scan.nextDouble();
		y.b = scan.nextDouble();
		y.c = scan.nextDouble();
		
		
		x.area = x.calculateArea();
		y.area = y.calculateArea();
		
		
		
		System.out.printf("Triangle X area: %.4f%n", x.area);
		System.out.printf("Triangle Y area: %.4f%n", y.area);
		
		if (x.area > y.area) {
			System.out.println("Larger area: X");
		}
		else if(y.area > x.area) {
			System.out.println("Larger area: Y");
		}
		else {
			System.out.println("Both have the same area!");
		}
		
		
		scan.close();
	}
	
	
	
}
