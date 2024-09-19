package services;

import java.util.ArrayList;
import java.util.List;

public class PrintService<Type> {
	
	private List<Type> list;

	
	public PrintService() {
		list = new ArrayList<>();
	}
	
	public PrintService(List<Type> list) {
		this.list = list;
	}
	
	public void addValue(Type value) {
		list.add(value);
	}
	
	public String print() {

		return list.toString();
		
	}
	
	public Type first() {
		if (list.isEmpty()) {
			throw new IllegalStateException("List is empty");
		}
		
		return list.get(0);
	}
}
