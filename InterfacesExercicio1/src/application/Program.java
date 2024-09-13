package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.InstallmentService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		
		Contract contract;
		
		
		
		try (Scanner sc = new Scanner(System.in)){
			
			System.out.println("--NEW PURCHASE--");
			System.out.print("Number of Contract: ");
			int numberOfContract = sc.nextInt(); sc.nextLine();
			System.out.print("Date of Start: ");
			LocalDate startOfContract = LocalDate.parse(sc.nextLine(), dateFormatter);
			System.out.print("Value of Contract: ");
			double valueOfContract = sc.nextDouble();
			System.out.print("Number of Installments: ");
			int numberOfInstallments = sc.nextInt();
			
			contract = new Contract(numberOfContract, startOfContract, valueOfContract);
			
			InstallmentService installmentService = new InstallmentService(new PaypalService());
			
			Installment[] installments;
			installments = installmentService.generateInstallments(contract, numberOfInstallments);
			
			contract.setInstallments(installments);
			
			System.out.println(contract);
		}
		catch (InputMismatchException e) {
			
		}
		
		
		
		
	}

}
