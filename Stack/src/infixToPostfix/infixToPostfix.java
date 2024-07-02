package infixToPostfix;

import java.util.Stack;

public class infixToPostfix {

	public static int calc(int a, int b, char operator) {

		switch (operator) {

		case '$':
			return (int) Math.pow(a, b);
		case '*':
			return a * b;
		case '/':
			return a / b;
		case '%':
			return a % b;
		case '+':
			return a + b;
		case '-':
			return a - b;

		}
		return 0;
	}

	private static int solvePostfix(String post) {
		// stack of operands
		Stack<Integer> s = new Stack<>();
		// traverse postfix from left to right
		for (int i = 0; i < post.length(); i++) {
			// get each sym from expression
			char sym = post.charAt(i);
			if (Character.isDigit(sym)) {

				String operand = Character.toString(sym);
				s.push(Integer.parseInt(operand));
			} else {
				int b = s.pop();
				int a = s.pop();
				int c = calc(a, b, sym);
				s.push(c);
			}
		}
		return s.pop();
	}

	// ***************************************************************

	public static String infixToPostfix(String infix) {

		Stack<Character> s = new Stack<>();
		StringBuilder post = new StringBuilder();

		// traverse infix expression from left to right

		for (int i = 0; i < infix.length(); i++) {
			char sym = infix.charAt(i);// sym can be operand ,(,) or operator
			// 2. if operand is found , append to postfix .
			if (Character.isDigit(sym)) {
				post.append(sym);
			} else if (sym == '(') {// 4.if opening ( is found ,y=then push it on stack.
				s.push(sym);
			} else if (sym == ')') {// 5.if closing ) is found ,
				// pop all operators from stack one by one and apend to postfix
				// until opening ( is found
				while (s.peek() != '(')
					post.append(s.pop());

				// also pop and discard opening (
				s.pop();
			}
			else {//3.if "operator" is found ,push it on stack.
				//if priority of topmost operator from stack >= priority of current operator,
				while(!s.isEmpty() && pri(s.peek()) >= pri(sym)) {
					post.append(s.pop());
				}
				s.push(sym);
			}
		}
		//6.when all syms from infix are done ,pop all operators from stack one by one and append to postfix
			while(!s.isEmpty())
				post.append(s.pop());
			
		return post.toString();

	}

	private static int pri(Character operator) {
		
		switch(operator) {
		case '$' : return 3;
		case '*' :return 2;
		case '/' :return 2;
		case '%' :return 2;
		case '+' :return 1;
		case '-' :return 1;
		}
		return 0;
	}

	public static void main(String[] args) {

		String infix = "5+9-4*(8-6/2)+1$(7-3)";

		String postfix = "";
		String prefix = "";
		postfix = infixToPostfix(infix);
		
		System.out.println(" postfix : "+postfix);
		int result = solvePostfix(postfix);
		System.out.println("result : "+result);

	}

}
