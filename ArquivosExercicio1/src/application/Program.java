package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Locale.setDefault(Locale.US);
		System.out.println("Enter csv file folder: ");
		String strPath = sc.nextLine();
		
		File filePath = new File(strPath);
		String outFilePath = filePath.getParent() + "\\out.txt";
		
		
		List<Product> products = new ArrayList<>();
		
		//READING FILE
		try (BufferedReader br = new BufferedReader(new FileReader(strPath))){
			
			String line = br.readLine();
			
			while (line != null) {
				
				String[] productData = line.split(",");
				
				String name = productData[0];
				Double price = Double.parseDouble(productData[1]);
				Integer quantity = Integer.parseInt(productData[2]);
						
				products.add(new Product(name, price, quantity));
				
				line = br.readLine();
			}
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
		//WRITING FILE
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFilePath, true))){
			
			for (Product p : products) {
				
				bw.write(p.toString());
				bw.newLine();
				
			}
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
		
		
		sc.close();
	}

}
