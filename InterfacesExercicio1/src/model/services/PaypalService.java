package model.services;

import java.time.LocalDate;


import model.entities.Contract;
import model.entities.Installment;


public class PaypalService implements InstallmentService {

	double feesPercentage = 0.01;
	double taxPercentage = 0.02;
	
	@Override
	public Installment[] generateInstallments(Contract contract, Integer numberOfInstallments) {
		
		Installment[] installments = new Installment[numberOfInstallments];
		
		LocalDate startOfContract = contract.getStartOfContract();
		Double totalValueOfContract = contract.getTotalValue();
		double installmentValueBeforeFee = contract.getTotalValue() / numberOfInstallments;
		
		
		for (int index = 0; index < numberOfInstallments; index++ ) {
			
			double installmentValueBeforeTax = installmentValueBeforeFee + (installmentValueBeforeFee * (feesPercentage * (index+1)));
			double installmentValueAfterTax = installmentValueBeforeTax + (installmentValueBeforeTax * taxPercentage);
			LocalDate dateOfPayment = startOfContract.plusMonths(index +1);
			
			installments[index] = new Installment(contract, dateOfPayment, installmentValueAfterTax);
		}
		
		return installments;
	}
	
	

}
