package entities;

public class OrderItem {

	private Integer quantity;
	private Double price;
	
	Product product;
	
	//CONSTRUCTORS
	
	public OrderItem() {}
	
	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	//GETTERS & SETTERS


	public Double getPrice() {
		return price;
	}

	public Product getProduct() {
		return product;
	}
	public
	Integer getQuantity() {
		return quantity;
	}

	//METHODS
	
	public Double subTotal() {
		return price * quantity;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(product.getName() + ", ");
		sb.append("$"+ price + ", ");
		sb.append("Quantity: "+ quantity +", ");
		sb.append("Subtotal: $"+ subTotal() +"");

		
		return sb.toString();
	}
	
	
	
	
}
