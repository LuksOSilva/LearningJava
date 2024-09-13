package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class InstallmentService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public InstallmentService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public Installment[] generateInstallments(Contract contract, Integer numberOfInstallments) {
		
		Installment[] installments = new Installment[numberOfInstallments];
		
		LocalDate startOfContract = contract.getStartOfContract();
		Double totalValueOfContract = contract.getTotalValue();
		double basicQuota = contract.getTotalValue() / numberOfInstallments;
		
		
		for (int index = 0; index < numberOfInstallments; index++ ) {
			
			
			LocalDate dateOfPayment = startOfContract.plusMonths(index +1);
			double interest = onlinePaymentService.interest(basicQuota, (index+1));
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;
			installments[index] = new Installment(contract, dateOfPayment, quota);
		}
		
		return installments;
	}
	
}
