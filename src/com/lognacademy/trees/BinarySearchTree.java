package com.lognacademy.trees;

import java.util.Comparator;
import java.util.Stack;

public class BinarySearchTree<T> {
	
	private class Node<T>{
		private Node<T> left;
		private T data;
		private Node<T> right;
		private Node(T data) {
			this.data=data;
		}
	}
	
	private Comparator<T> comparator;
	private Node<T> root;
	
	public BinarySearchTree(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	public boolean isEmpty() {
		return (root==null);
	}
	
	public void insert(T data) {
		Node<T> node = new Node<T>(data);
		if(isEmpty()) {
			root=node;
			return;
		}
		boolean isLeftNode=false;
		Node<T> current=root;
		Node<T> parent=current;
		while(current!=null) {
			parent=current;
			if(comparator.compare(node.data, current.data)<=0) {
				isLeftNode=true;
				current=current.left;
			}else {
				isLeftNode=false;
				current=current.right;
			}
		}
		if(isLeftNode) {
			parent.left=node;
		}else {
			parent.right=node;
		}
	}
	
	
	public boolean delete(T data) {
		Node<T> current=root;
		Node<T> parent=root;
		boolean isLeftNode=false;
		//while(comparator.compare(current.data, data)!=0 ) {}
		//Find the node to delete
		while(!current.data.equals(data)) {
			parent=current;
			if(comparator.compare(data, current.data)<=0) {
				isLeftNode=true;
				current=current.left;
			}else {
				isLeftNode=false;
				current=current.right;
			}
			if(current==null) {
				return false;
			}
		}
		
		//Found the node to delete
		Node<T> nodeToDelete = current;
		
		//Case 1: If the node to delete is a leaf node(no children) 
		if(nodeToDelete.left==null && nodeToDelete.right==null) {
			//If the node to delete is a leaf node and root node.
			if(nodeToDelete==root) {
				root=null;
			}else if(isLeftNode){//If the node to delete is a leaf node and it is a left node.
				parent.left=null;
			}else {//If the node to delete is a leaf node and it is a right node.
				parent.right=null;
			}
		} else if(nodeToDelete.right==null) {//Case 2: If the nodeToDelete has only left child.
			if(nodeToDelete==root) {//Case 2: If the nodeToDelete has only left child and nodeToDelete is a root node.
				root = nodeToDelete.left;
			}else if(isLeftNode){//Case 2: If the nodeToDelete has only left child and nodeToDelete is a not a root node and nodeToDelete is a left child to it's parent.
				parent.left=nodeToDelete.left;
			}else {//Case 2: If the nodeToDelete has only left child and nodeToDelete is a not a root node and nodeToDelete is a right child to it's parent.
				parent.right=nodeToDelete.left;
			}
			nodeToDelete.left=null;
		} else if(nodeToDelete.left==null) {//Case 2: If the nodeToDelete has only right child.
			if(nodeToDelete==root) {//Case 2: If the nodeToDelete has only right child and nodeToDelete is a root node.
				root = nodeToDelete.right;
			}else if(isLeftNode) {//Case 2: If the nodeToDelete has only right child and nodeToDelete is a not a root node and nodeToDelete is a left child to it's parent.
				parent.left=nodeToDelete.right;
			}else {//Case 2: If the nodeToDelete has only right child and nodeToDelete is a not a root node and nodeToDelete is a right child to it's parent.
				parent.right=nodeToDelete.right;
			}
			nodeToDelete.right=null;
		} else {//Case 3: If the nodeToDelete has two children.
			
			//get the successor which is minimum value in the rightSubTree of the nodeToDelete
			Node<T> successor = getSuccessor(nodeToDelete);
			
			//connect root to the successor if the nodeToDelete is a root.
			if(nodeToDelete==root) {
				root = successor;
			}else if(isLeftNode) {//connect parent of nodeToDelete to successor
				parent.left = successor;
			}else {//connect parent of nodeToDelete to successor
				parent.right = successor;
			}
			successor.left=nodeToDelete.left;
		}
		return true;
	}
	
	private Node<T> getSuccessor(Node<T> nodeToDelete){
		Node<T> successorParent = nodeToDelete;
		Node<T> successor = nodeToDelete;
		
		//Go to the one level right child.
		Node<T> current = nodeToDelete.right;
		
		//Find the minimum value of the rightSubTreeOfTheNodeToDelete by going left down the tree until node has no left child. 
		while(current!=null) {
			successorParent = successor;
			successor = current;
			current=current.left;
		}
		
		//If successor not a immediate right child of nodeToDelete 
		if(successor!=nodeToDelete.right) {
			successorParent.left=successor.right;
			successor.right=nodeToDelete.right;
		}
		return successor;
	}
	
	public void displayTree() {
        Stack<Node<T>> globalStack = new Stack<Node<T>>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(".......................................................................................................");
        
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
        System.out.println( "......................................................................................................");
	}
}
