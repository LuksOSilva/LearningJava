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
import services.CalculationService;

public class Program {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)){
		
			Locale.setDefault(Locale.US);
			System.out.println("Enter csv file folder: ");
			String strSource = sc.nextLine();
			
			File sourceFile = new File(strSource);
			String sourcePath = sourceFile.getParent();
			
			List<Product> products;
		
			products = readInFile(sourceFile);

			generateOutFile(sourcePath, products);
			
			Product mostExpensiveProduct = CalculationService.max(products);
			System.out.println("Most expensive product: " + mostExpensiveProduct);
		
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	

	
	
	private static List<Product> readInFile(File file) throws IOException{
		List<Product> products = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			
			String line = br.readLine();
			
			while (line != null) {
				
				String[] productData = splitLine(line);
				
				String name = productData[0];
				Double price = Double.parseDouble(productData[1]);
						
				addToList(products, name, price);
				
				line = br.readLine();
			}
			
			
			
		}
		catch (IOException e){
			throw new IOException("File not found");
		}
		
		return products;
	}
	
	private static String[] splitLine(String line) {
		return line.split(",");
	}
	
	private static void addToList(List<Product> products, String name, Double price) throws IOException {
		
		products.add(new Product(name, price));
		
	}
	
	
	private static boolean listIsEmpty(List<Product> products) {
		return products.isEmpty();
	}
	
	
	private static void generateOutFile(String sourcePath, List<Product> products) throws IOException {
		
		if (!listIsEmpty(products)) {
			String outFolderPath = createOutFolder(sourcePath);
			
			String outFilePath = createOutFile(outFolderPath);
			
			writeOutFile(outFilePath, products);
			
			return;
		}
		throw new IOException("In file is empty");
		
	}
	
	
	private static String createOutFolder(String sourcePath) {
		String outFolderPath = sourcePath + "\\out";
		new File(outFolderPath).mkdir();
		return outFolderPath;
	}
	
	private static String createOutFile(String outFolderPath) {
		String outFilePath = outFolderPath + "\\out.txt";
		new File(outFilePath);
		return outFilePath;
	}
	
	private static void writeOutFile(String outFilePath, List<Product> products) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFilePath))){
			
			for (Product p : products) {
				
				bw.write(p.toString());
				bw.newLine();
				
			}
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	
}
