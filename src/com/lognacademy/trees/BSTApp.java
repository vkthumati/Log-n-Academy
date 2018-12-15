package com.lognacademy.trees;

import java.util.Comparator;

public class BSTApp {
	public static void main(String[] args) {
		Comparator<Employee> empNameComparator = (e1, e2) -> e1.getName().compareTo(e2.getName());
		//Comparator<Employee> empNameComparator = (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName());
		//Comparator<Employee> empNameComparator = Comparator.comparing(Employee::getName);
		Comparator<Employee> empIdComparator = Comparator.comparing(Employee::getId);
		Comparator<Employee> empAgeComparator = Comparator.comparing(Employee::getAge);
		
		BinarySearchTree<Employee> empByNameTree = new BinarySearchTree<Employee>(empIdComparator);
		empByNameTree.insert(new Employee(500, "Vasanth", 38));
		empByNameTree.insert(new Employee(120, "Kumar", 31));
		empByNameTree.insert(new Employee(600, "Thumati", 25));
		empByNameTree.insert(new Employee(550, "Deepika", 9));
		empByNameTree.insert(new Employee(750, "Yashitha", 8));
		empByNameTree.insert(new Employee(640, "Sujatha", 8));
		empByNameTree.insert(new Employee(50, "Balaji", 8));
		empByNameTree.insert(new Employee(150, "Malyadri", 8));
		
		empByNameTree.displayTree();
		
		System.out.println("\n");
		empByNameTree.delete(new Employee(600, "Thumati", 25));
		empByNameTree.displayTree();
	}
}
