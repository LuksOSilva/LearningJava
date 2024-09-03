package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Program {

	public static void main(String[] args) {
		
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());


		
		
		LocalDate d01 = LocalDate.now();
		LocalDateTime d02 = LocalDateTime.now();
		Instant d03 = Instant.now();
		
		LocalDate d04 = LocalDate.parse("2024-07-15");
		LocalDateTime d05 = LocalDateTime.parse("2024-07-15T12:00:25");
		Instant d06 = Instant.parse("2024-07-15T12:00:25Z");
		Instant d07 = Instant.parse("2024-07-15T12:00:25-03:00");

		LocalDate d08 = LocalDate.parse("30/08/2024", fmt1);
		LocalDateTime d09 = LocalDateTime.parse("30/08/2024 09:00", fmt2);
		
		LocalDate d10 = LocalDate.of(2022, 8, 20);
		LocalDateTime d11 = LocalDateTime.of(2022, 7, 20, 1, 30);
		
		//---------------------------\\
		
		System.out.printf("LocalDate: %n"+ d01.format(fmt1) +"%n");
		System.out.printf("%nLocalDateTime: %n"+ fmt2.format(d02) +"%n");
		System.out.printf("%nInstant: %n"+ fmt3.format(d03) +"%n");
		
		System.out.printf("%nLocalDate + parse: %n"+ d04 +"%n");
		System.out.printf("%nLocalDateTime + parse: %n"+ d05 +"%n");
		System.out.printf("%nInstant + parse: %n"+ fmt3.format(d06) +"%n"+ d07 +"%n");
		
		System.out.printf("%nLocalDate + formatter: %n"+ d08 +"%n");
		System.out.printf("%nLocalDateTime + formatter: %n"+ d09 +"%n");
		
		System.out.printf("%nLocalDate + of: %n"+ d10 +"%n");
		System.out.printf("%nLocalDateTime + of: %n"+ d11 +"%n");
		

	}

}
