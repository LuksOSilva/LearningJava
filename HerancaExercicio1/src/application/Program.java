package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		List<Product> products = new ArrayList<>();
		
		
		System.out.print("Enter the number of prodcuts:");
		int n = sc.nextInt(); sc.nextLine();
		
		for (int i = 0; i < n; i++) {
			
			System.out.println();
			System.out.println("Product #"+ (i+1) +" data:");
			
			System.out.println("Common, used or imported (c/u/i)?");
			char type = sc.next().charAt(0); sc.nextLine();
			
			System.out.print("Name:");
			String name = sc.nextLine();
			
			System.out.println("Price:");
			double price = sc.nextDouble(); sc.nextLine();
			
			if (type == 'u') {
			
				System.out.println("Manufacture date (DD/MM/YYYY):");
				String date = sc.nextLine();
				
				products.add(new UsedProduct(name, price, date));
				
			}
			else if (type == 'i') {
				
				System.out.println("Customs fee:");
				double customsFee = sc.nextDouble(); sc.nextLine();
				
				products.add(new ImportedProduct(name, price, customsFee));
				
			} else {
				
				products.add(new Product(name, price));
				
			}

		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product p : products) {
			System.out.println(p.priceTag());
		}
		
		
		sc.close();
	}

}
