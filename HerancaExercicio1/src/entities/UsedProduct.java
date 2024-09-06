package entities;

import java.util.Date;

public class UsedProduct extends Product {

	private String manufactureDate;

	
	//CONSTRUCTORS	
	
	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, String manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	//GETTERS & SETTERS

	public String getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	

	// METHODS
	

	@Override
	public String priceTag() {
		return super.priceTag() + "(Manufacture date: " + manufactureDate + ")";
	}

}
