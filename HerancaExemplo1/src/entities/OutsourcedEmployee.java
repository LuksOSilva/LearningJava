package entities;

public class OutsourcedEmployee extends Employee {

	private Double additionalCharge;

	
	//CONSTRUCTORS
	
	public OutsourcedEmployee() {
		super();
	}
	
	public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
		super(name, hours, valuePerHour);
		this.additionalCharge = additionalCharge;
	}

	//GETTERS & SETTERS
	
	public Double getAdditionalCharge() {
		return additionalCharge;
	}

	public void setAdditionalCharge(Double additionalCharge) {
		this.additionalCharge = additionalCharge;
	}
	
	
	//METHODS
	
	@Override
	public double payment() {
		return super.payment() + (additionalCharge * 1.10);
	}
	
}
