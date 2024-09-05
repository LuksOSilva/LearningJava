package entities;

public class Product {

	private String name;
	private Double price;
	
	
	//CONSTRUCTORS
	
	public Product() {}
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	//GETTERS & SETTERS

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}
	
	
	
	
	
}
