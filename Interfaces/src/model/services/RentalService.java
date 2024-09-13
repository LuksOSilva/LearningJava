package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private Double pricePerHour;
	private Double pricePerDay;
	
	private TaxService taxService;

	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}	

	
	public void processInvoice(CarRental carRental) {
		
		double hours = getDurationInHours(carRental);
		
		double basicPayment = calculateBasicPayment(pricePerHour, pricePerDay, hours);
		
		double tax =  taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
	
	private double getDurationInMinutes(CarRental carRental) {
		return Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
	}
	
	private double getDurationInHours(CarRental carRental) {
		return getDurationInMinutes(carRental) / 60.0;
	}
	
	private double calculateBasicPayment(Double pricePerHour, Double pricePerDay, double durationInHours) {
		if (durationInHours <= 12.0) {
			return pricePerHour * Math.ceil(durationInHours);
		}
		return pricePerDay * Math.ceil(durationInHours / 24.0);
	}
	
}
