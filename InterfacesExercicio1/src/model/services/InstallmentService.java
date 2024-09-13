package model.services;

import model.entities.Contract;
import model.entities.Installment;


public interface InstallmentService {
	
	Installment[] generateInstallments(Contract contract, Integer numberOfInstallments);
	
}
