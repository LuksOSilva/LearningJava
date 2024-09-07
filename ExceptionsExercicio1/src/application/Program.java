package application;

import java.util.Locale;
import java.util.Scanner;

import modal.entities.Account;
import modal.exceptions.WithdrawRulesViolatedException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("Number: ");
			Integer number = sc.nextInt();  sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Balance: ");
			Double balance = sc.nextDouble();  sc.nextLine();
			System.out.print("Withdraw Limit: ");
			Double withdrawLimit = sc.nextDouble();
			
			Account acc = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter amount to withdraw: ");
			Double amount = sc.nextDouble(); sc.nextLine();
			
			acc.withdraw(amount);
			System.out.print("New balance: $"+ acc.getBalance());
			
		}
		catch (WithdrawRulesViolatedException e) {
			System.out.println("Error: "+ e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected Error: ");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Unexpected Error");
			e.printStackTrace();
		}
		
		
		
		sc.close();
	}
}
