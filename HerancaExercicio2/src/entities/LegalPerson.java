package entities;

public class LegalPerson extends Taxpayer {

	private int numberOfEmployees;
	
	
	//CONSTRUCTORS
	
	public LegalPerson() {}
	
	public LegalPerson(String name, double anualIncome, int numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	
	//GETS & SETS

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}


	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	
	//METHODS

	@Override
	public double taxToPay() {
		double tax = 0;
		
		if (numberOfEmployees <= 10) {
			tax = 0.16;
		} else {
			tax = 0.14;
		}
		
		
		return super.getAnualIncome() * tax;
	}


}
