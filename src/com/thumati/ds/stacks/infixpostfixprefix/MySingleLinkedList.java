package com.thumati.ds.stacks.infixpostfixprefix;

public class MySingleLinkedList<T> {
	private Node<T> top;
	
	public void insertTop(T data) {
		Node<T> node = new Node<T>(data);
		if(top==null) {
			top=node;
		}else {
			node.next=top;
			top=node;
		}
	}
	
	public T removeTop() {
		if(top!=null) {
			Node<T> temp = top;
			top = top.next;
			temp.next=null;
			return temp.data;
		}
		return null;
	}
	
	public T peekTop() {
		return (top!=null)?top.data:null;
	}
	
	public boolean isEmpty() {
		return (top==null);
	}
}
