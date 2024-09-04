package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private OrderStatus status;
	private Client client;
	
	private List<OrderItem> orderItems = new ArrayList<>();

	//CONSTRUCTORS
	
	public Order() {}
	
	public Order(Date moment, Client client, OrderStatus status) {
		this.moment = moment;
		this.client = client;
		this.status = status;
	}
	
	
	//GETTERS & SETTERS
	
	public Date getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	//METHODS
	
	
	public void addItem(OrderItem item) {
		orderItems.add(item);
	}
	public void removeItem(OrderItem item) {
		orderItems.remove(item);
	}
	
	
	public Double total() {
		double sum = 0;
		
		for (OrderItem i : orderItems) {
			sum += i.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Order moment: "+ sdf.format(moment) + "\n");
		sb.append("Order status: "+ status + "\n");
		sb.append("Client: "+ client.toString() + "\n");
		sb.append("Order items: ");
		
		for (OrderItem item : orderItems) {
			
			sb.append(item.toString() + "\n");
			
		}
		sb.append("Total price: $" + total());
		
		return sb.toString();
	}
	
	
}
