package com.thumati.ds.stacks.infixpostfixprefix;

import java.util.regex.Pattern;

public class InfixConverter {
	
	public static boolean isOperand(String s) {
		try {
			Double.parseDouble(s);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean isOperator(String s) {
		String operatorList="+-*/^";
		return operatorList.contains(s); //indexOf(s)>=0
	}
	
	enum Operator{
		MINUS(1), PLUS(1), MULTIPLY(2), DIVIDE(2), EXPONENT(3);
		
		private final int precedence;
		
		private Operator(int precedence) {
			this.precedence=precedence;
		}
	}
	
	public int getPrecedence(String operator) {
		int operatorPrecedence=0;
		if(operator.equals("+")) {
			operatorPrecedence = Operator.PLUS.precedence;
		}else if(operator.equals("-")) {
			operatorPrecedence = Operator.MINUS.precedence;
		}else if(operator.equals("*")) {
			operatorPrecedence = Operator.MULTIPLY.precedence;
		}else if(operator.equals("/")) {
			operatorPrecedence = Operator.DIVIDE.precedence;
		}
		return operatorPrecedence;
	}
	
	public String convert(String infix) {
		MyStack<String> stack = new MyStack<String>();
		
		String postfix="";
		String space=" ";
		
		String[] tokens = Pattern.compile("\\s").split(infix);
		for(String token : tokens) {
			if(isOperand(token)) {
				postfix+=token+space;
			}else if(isOperator(token)) {
				while(!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(token)) {
					postfix+=stack.pop()+space;
				}
				stack.push(token);
			}else if(token.equals("(")) {
				stack.push(token);
			}else if(token.equals(")")) {
				while(!stack.peek().equals("(")) {
					postfix+=stack.pop()+space;
				}
				stack.pop();//remove opening parenthesis
			}
		}
		
		while(!stack.isEmpty()) {
			postfix+=stack.pop()+space;
		}
		return postfix;
	}
	
	public static void main(String[] args) {
        
        InfixConverter inf = new InfixConverter();
        
        String infix = "2 + 3 * 4";
        System.out.println("Infix : "+ infix);
        System.out.println("Postfix : " + inf.convert(infix));
        System.out.println("");
        
        String infix2 = "2 * ( 6 + 2 * 4 ) * 5 - 8 / 4";
        System.out.println("Infix : "+ infix2);
        System.out.println("Postfix : " + inf.convert(infix2));
        System.out.println("");
        
        String infix3 = "3 * 4 + ( 3 + 2 + 5 ) / 2";
        System.out.println("Infix : "+ infix3);
        System.out.println("Postfix : " + inf.convert(infix3));
        System.out.println("");
        
    }
}
