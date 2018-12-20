package com.thumati.ds.stacks.infixpostfixprefix;

public class MyStack<T> {
	MySingleLinkedList<T> list;
	
	public MyStack() {
		this.list = new MySingleLinkedList<T>();
	}
	
	public void push(T data) {
		list.insertTop(data);
	}
	
	public T pop(){
		return list.removeTop();
	}
	
	public T peek(){
		return list.peekTop();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
