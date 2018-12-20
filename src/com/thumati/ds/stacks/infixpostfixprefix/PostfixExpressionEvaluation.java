package com.thumati.ds.stacks.infixpostfixprefix;

import java.util.regex.Pattern;

public class PostfixExpressionEvaluation {
	
	public boolean isOperand(String s) {
		try {
			Double.parseDouble(s);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	

	public double evaluate(String postFixExpression) {
		double result=0;
		String[] tokens = Pattern.compile("\\s").split(postFixExpression);
		MyStack<Double> stack = new MyStack<Double>();
		for(String token : tokens) {
			if(isOperand(token)) {
				stack.push(Double.parseDouble(token));
			}else {
				double operand1 = stack.pop();
				double operand2 = stack.pop();
					switch (token) {
					case "+":
						result=operand2+operand1;
						stack.push(result);
						break;
					case "-":
						result=operand2-operand1;
						stack.push(result);
						break;
					case "*":
						result=operand2*operand1;
						stack.push(result);
						break;
					case "/":
						result=operand2/operand1;
						stack.push(result);
						break;
					case "^":
						result=Math.pow(operand2, operand1);
						//result=(int)operand2^(int)operand1;
						stack.push(result);
						break;
					}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		PostfixExpressionEvaluation pf = new PostfixExpressionEvaluation();
        //String postFix = "6 2 3 + - 3 8 2 / + * 2";
		String postFix = "6 2 3 + - 3 8 2 / + * 2 ^ 3 +";
        System.out.println(pf.evaluate(postFix));
        //System.out.println("Exponentiation : "+ (7^2));
	}

}
