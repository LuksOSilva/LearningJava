package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		
		Vehicle vehicle;
		CarRental carRental;
		RentalService rentalService;
		
		
		System.out.println("Enter rental data:");
		System.out.print("Car Model:");
		String carModel = sc.nextLine();
		System.out.print("start (DD/MM/YYYY hh:mm):");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.println("finish (DD/MM/YYYY hh:mm):");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
		
		System.out.println("Price per hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.println("Price per day: ");
		double pricePerDay = sc.nextDouble();
		
		
		vehicle = new Vehicle(carModel);
		carRental = new CarRental(start, finish, vehicle);
		rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		rentalService.processInvoice(carRental);
		
		
		System.out.println("Invoice: ");
		System.out.println("Basic Payment: " + carRental.getInvoice().getBasicPayment());
		System.out.println("Tax: " + carRental.getInvoice().getTax());
		System.out.println("Total Payment: " + carRental.getInvoice().getTotalPayment());
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();
	}

}
