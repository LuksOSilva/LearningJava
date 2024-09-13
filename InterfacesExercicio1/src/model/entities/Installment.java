package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Double value;
	private LocalDate dateOfPayment;
	
	Contract contract;

	public Installment(Contract contract, LocalDate dateOfPayment, Double value) {
		this.contract = contract;
		this.dateOfPayment = dateOfPayment;
		this.value = value;
	}

	public Double getValue() {
		return value;
	}

	public String getDateOfPayment() {
		return dateOfPayment.format(dateFormatter);
	}

	public Contract getContract() {
		return contract;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(getDateOfPayment() + " - ");
		sb.append("Value: " + getValue() + "\n");

		
		return sb.toString();
	}
	
	
}
