package application;

import java.util.ArrayList;
import java.util.List;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		
		
		//Account acc1 = new Account(1001, "Lucas", 1000.0);	
		
		List<Account> list = new ArrayList<>();
		
		list.add(new SavingsAccount(1001, "Maria", 10000.0, 0.05));
		list.add(new SavingsAccount(1002, "Lucas", 10.0, 0.05));
		list.add(new SavingsAccount(1003, "Claudio", 10000.0, 0.05));
		
		list.add(new BusinessAccount(1004, "Matheus", 100.0, 500.0));
		list.add(new BusinessAccount(1005, "Lucimara", 110000.0, 6000.0));
		list.add(new BusinessAccount(1006, "Thamires", 1000.0, 0.1));
	
		
		double sum = 0.0;
		for (Account acc : list) {
			sum += acc.getBalance();
		}
		
		System.out.printf("Total balance: %.2f%n", sum);
		
		
		for (Account acc : list) {
			acc.deposit(10);
			System.out.printf("Updated balance for account %d: %.2f%n", acc.getNumber(), acc.getBalance());
		}

		
		
	}

}
