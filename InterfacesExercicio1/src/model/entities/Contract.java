package model.entities;

import java.time.LocalDate;

import model.services.InstallmentService;

public class Contract {
	
	private Integer number;
	private LocalDate startOfContract;
	private Double totalValue;
	
	private Installment[] installments;
	private InstallmentService installmentService;


	public Contract(Integer number, LocalDate startOfContract, Double totalValue, InstallmentService installmentService) {
		this.number = number;
		this.startOfContract = startOfContract;
		this.totalValue = totalValue;
		this.installmentService = installmentService;
	}
	
	public Integer getNumber() {
		return number;
	}

	public LocalDate getStartOfContract() {
		return startOfContract;
	}

	public Double getTotalValue() {
		return totalValue;
	}
	
	public InstallmentService getInstallmentService() {
		return installmentService;
	}
	
	public void setInstallments(Installment[] installments) {
		this.installments = installments;
	}
	
	public int getNumberOfInstallments() {
		int index = 0;
		for (Installment installment : installments) {
			index++;
		}
		return index;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("--CONTRACT INFO--" + "\n");
		sb.append("Contract: " + getNumber() + "\n");
		sb.append("Start Date: " + getStartOfContract() + "\n");
		sb.append("Number of Installments: " + getNumberOfInstallments() + "\n");
		sb.append("--INSTALLMENTS--" + "\n\n");
		
		int index = 1;
		for (Installment installment : installments) {
			sb.append("Installment #" + index + ": \n");
			sb.append(installment.toString() + "\n");
			index++;
		}
		
		return sb.toString();
	}
	
	
	

	
	
}
