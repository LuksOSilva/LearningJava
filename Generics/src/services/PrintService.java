package services;

import java.util.ArrayList;
import java.util.List;

public class PrintService {
	
	private List<Integer> list;

	
	public PrintService() {
		list = new ArrayList<>();
	}
	
	public PrintService(List<Integer> list) {
		this.list = list;
	}
	
	public void addValue(int value) {
		list.add(value);
	}
	
	public String print() {

		return list.toString();
		
	}
	
	public Integer first() {
		if (list.isEmpty()) {
			throw new IllegalStateException("List is empty");
		}
		
		return list.get(0);
	}
}
