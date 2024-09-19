package services;

import java.util.List;

public class CalculationService {

	public static <T extends Comparable<T>> T max(List<T> list) {
		
		T mostExpensiveProduct = list.get(0);
		for (T p : list) {
			
			
			if (p.compareTo(mostExpensiveProduct) > 0) {
				mostExpensiveProduct = p;
			}
			
		}
		return mostExpensiveProduct;
	}
	
}
