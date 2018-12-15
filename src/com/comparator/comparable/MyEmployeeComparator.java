package com.comparator.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyEmployeeComparator implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}
	
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Vasanth", 38));
		list.add(new Employee(2, "Kumar", 31));
		list.add(new Employee(3, "Thumati", 25));
		list.add(new Employee(4, "Deepika", 9));
		list.add(new Employee(4, "Yashitha", 8));

		System.out.println("Before Sorting : "+list);
		
		MyEmployeeComparator comparator = new MyEmployeeComparator();
		Collections.sort(list, comparator);
		
		System.out.println("After Sorting : "+list);
	}
}
