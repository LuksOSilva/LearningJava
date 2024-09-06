package entities;

public class ImportedProduct extends Product {

	private Double customsFee;
	
	//CONSTRUCTORS
	
	public ImportedProduct() {
		super();
	}
	
	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	//GETTERS & SETTERS
	
	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	

	// METHODS

	public Double totalPrice() {
		return price + customsFee;
	}
	
	@Override
	public String priceTag() {
		return name
				+ " $"
				+ String.format("%.2f", totalPrice())
				+ " (Customs fee: $"+ String.format("%.2f", customsFee) +")";
	}
	
}
