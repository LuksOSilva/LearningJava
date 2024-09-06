package entities;

public abstract class Taxpayer {

	private String name;
	private double anualIncome;
	
	
	//CONSTRUCTORS
	
	public Taxpayer() {}
	
	public Taxpayer(String name, double anualIncome) {
		this.name = name;
		this.anualIncome = anualIncome;
	}

	
	//GETS & SETS
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getAnualIncome() {
		return anualIncome;
	}


	public void setAnualIncome(double anualIncome) {
		this.anualIncome = anualIncome;
	}
	
	
	//METHODS
	
	public abstract double taxToPay();

	
}
