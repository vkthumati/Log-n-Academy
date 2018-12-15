package com.lognacademy.trees;

import com.comparator.comparable.Player;

public class BSTApp1 {

	public static void main(String[] args) {
		BinarySearchTree1<Integer> bst = new BinarySearchTree1<>();
		bst.insert(500);
		bst.insert(120);
		bst.insert(50);
		bst.insert(600);
		bst.insert(150);
		bst.insert(750);
		bst.insert(640);
		bst.insert(550);
		
		bst.displayTree();
		

		BinarySearchTree1<Player> playerTree = new BinarySearchTree1<Player>();
		playerTree.insert(new Player(59, "John", 20));
		playerTree.insert(new Player(67, "Roger", 22));
		playerTree.insert(new Player(45, "Steven", 24));
		playerTree.insert(new Player(99, "Dorobot", 31));
		playerTree.insert(new Player(66, "Sue", 45));
		playerTree.insert(new Player(32, "Pamposh", 42));
		playerTree.insert(new Player(19, "Don", 29));
		playerTree.insert(new Player(5, "Mike", 36));
		
		System.out.println("\n");
		playerTree.displayTree();

		
	}

}
