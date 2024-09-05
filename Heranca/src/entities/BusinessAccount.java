package entities;

public class BusinessAccount extends Account{
	
	private Double loanlimit;
	
	
	//CONSTRUCTORS
	
	public BusinessAccount() {
		super();
	}
	
	public BusinessAccount(Integer number, String holder, Double balance, Double loanlimit) {
		super(number, holder, balance);
		this.loanlimit = loanlimit;
	}

	//GETTERS & SETTERS
	
	public Double getLoanlimit() {
		return loanlimit;
	}

	public void setLoanlimit(Double loanlimit) {
		this.loanlimit = loanlimit;
	}

	//METHODS
	
	@Override
	public void withdraw(double amount) {
		super.withdraw(amount);
		balance -= 2.0;
	}
	
	public void loan(double amount) {
		if (amount <= loanlimit) {
			balance += amount - 10.0;
		}
	}
	
	
}
