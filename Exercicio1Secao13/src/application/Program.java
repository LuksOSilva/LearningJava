package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Client Register:");
		System.out.print("Name:");
		String clientName = sc.nextLine();
		System.out.print("Email:");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date *DD/MM/YYYY):");
		String clientBirthDate = sc.nextLine();
		
		Client client = new Client(clientName, clientEmail, sdf.parse(clientBirthDate));
	
		Date moment = new Date();
		
		Order order = new Order(moment, client, OrderStatus.PROCESSING);
		
		System.out.println();
		System.out.print("How many items to this order?");
		int itemsInOrder = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < itemsInOrder; i++) {
			
			System.out.println();
			System.out.println("Enter #"+ (i+1) +" item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			sc.nextLine();
			
			Product product = new Product(productName, productPrice);
			
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
			
			order.addItem(orderItem);
			
		}
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order.toString());
		
		
	}

}
