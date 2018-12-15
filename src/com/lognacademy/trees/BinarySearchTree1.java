package com.lognacademy.trees;

import java.util.Stack;

public class BinarySearchTree1<T extends Comparable<T>> {
	private class Node<T> {
		private Node<T> left;
		private Node<T> right;
		private T data;
		private Node(T data) {
			this.data=data;
		}
	}

	private Node<T> root;
	
	public void insert(T data) {
		Node<T> node = new Node<T>(data);
		if(isEmpty()) {
			root=node;
			return;
		}
		boolean isLeftNode=false;
		Node<T> current = root;
		Node<T> parent = current;
		while(current!=null) {
			parent = current;
			if(node.data.compareTo(current.data)<=0) {
				isLeftNode=true;
				current = current.left;
			}else {
				isLeftNode=false;
				current = current.right;
			}
		}
		
		if(isLeftNode) {
			parent.left = node;
		}else {
			parent.right=node;
		}
	}
	
	public boolean isEmpty() {
		return (root==null);
	}
	
	public void displayTree() {
        Stack<Node<T>> globalStack = new Stack<Node<T>>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        
        while(isRowEmpty==false) {
            Stack<Node<T>> localStack = new Stack<Node<T>>();
            isRowEmpty = true;
            for(int j=0; j<nBlanks; j++) {
                System.out.print(" ");
            }
                
            while(globalStack.isEmpty()==false) {
                Node<T> temp = globalStack.pop(); 
                if(temp != null) {
                    System.out.print(temp.data); 
                    localStack.push(temp.left); 
                    localStack.push(temp.right);
                    if(temp.left != null || temp.right != null) {
                        isRowEmpty = false; 
                    }
                } else {
                    System.out.print("--"); 
                    localStack.push(null); 
                    localStack.push(null);
                }
                
                for(int j=0; j<nBlanks*2-2; j++) {
                    System.out.print(" ");
                }
            }
            
            System.out.println();
            nBlanks = nBlanks/2;
            
            while(localStack.isEmpty()==false)
                globalStack.push(localStack.pop()); 
            }
        System.out.println( "......................................................");
	}
}
