package modal.entities;

import modal.exceptions.WithdrawRulesViolatedException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance = (double) 0;
	private Double withdrawLimit = (double) 0;
	
	
	//CONSTRUCTORS
	
	public Account() {}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		deposit(balance);
		this.withdrawLimit = withdrawLimit;
	}
	
	
	//GETS & SETS

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Integer getNumber() {
		return number;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	
	//METHODS
	
	public void deposit(Double amount) {
	
		balance += amount;
		
	}
	
	public void withdraw(Double amount) throws WithdrawRulesViolatedException {
	
		if (amount > withdrawLimit) {
			throw new WithdrawRulesViolatedException("Amount is over withdraw limit");
		}
		if (amount > balance) {
			throw new WithdrawRulesViolatedException("Amount is over available balance");
		}
		
		balance -= amount;
		
	}
	
	
	
	
}
