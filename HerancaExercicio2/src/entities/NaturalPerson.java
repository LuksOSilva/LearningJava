package entities;

public class NaturalPerson extends Taxpayer  {

	private double healthExpenses;

	
	//CONSTRUCTORS
	
	public NaturalPerson() {}
	
	public NaturalPerson(String name, double anualIncome, Double healthExpenses) {
		super(name, anualIncome);
		this.healthExpenses = healthExpenses;
	}


	//GETS & SETS
	
	public Double getHealthExpenses() {
		return healthExpenses;
	}

	public void setHealthExpenses(Double healthExpenses) {
		this.healthExpenses = healthExpenses;
	}


	//METHODS

	@Override
	public double taxToPay() {
		double tax = 0;
		double deductions = 0;
		
		if (super.getAnualIncome() < 20000.00) {
			tax = 0.15;
		} else {
			tax = 0.25;
		}
		
		if (healthExpenses > 0) {
			deductions = healthExpenses /2;
		}
		
		
		return (super.getAnualIncome() * tax) - deductions;
	}

}
