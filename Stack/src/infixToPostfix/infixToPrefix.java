package infixToPostfix;

import java.util.Stack;

public class infixToPrefix {

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

	private static int solvePrefix(String pre) {
		// stack of opera nds
		Stack<Integer> s = new Stack<>();
		// traverse postfix from left to right
		for (int i = pre.length()-1; i>=0 ; i--) {
			// get each sym from expression
			char sym = pre.charAt(i);
			if (Character.isDigit(sym)) {

				String operand = Character.toString(sym);
				s.push(Integer.parseInt(operand));
			} else {
				int a = s.pop();
				int b = s.pop();
				int c = calc(a, b, sym);
				s.push(c);
			}
		}
		return s.pop();
	}

	// ***************************************************************

	public static String infixToPrefix(String infix) {
		Stack<Character> s = new Stack<>();
		StringBuilder pre = new StringBuilder();
		// traverse infix expression from  right to left
		for (int i = infix.length()-1; i >=0 ; i--) {
			char sym = infix.charAt(i);// sym can be operand ,(,) or operator
			// 2. if operand is found , append to postfix .
			if (Character.isDigit(sym)) {
				pre.append(sym);
			} else if (sym == ')') {// 4.if closing )  is found ,y=then push it on stack.
				s.push(sym);
			} else if (sym == '(') {// 5.if opening ( is found ,
				// pop all operators from stack one by one and apend to prefix
				// until closing ) is found
				while (s.peek() != ')')
					pre.append(s.pop());
				// also pop and discard closing (
				s.pop();
			}
			else {//3.if "operator" is found ,push it on stack.
				//if priority of topmost operator from stack >= priority of current operator,
				while(!s.isEmpty() && pri(s.peek()) > pri(sym)) {
					pre.append(s.pop());
				}
				s.push(sym);
			}
		}
		//6.when all syms from infix are done ,pop all operators from stack one by one and append to prefix
			while(!s.isEmpty())
				pre.append(s.pop());
			//7.reverse the prefix and return
		return pre.reverse().toString();
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
		//String postfix = "";
		String prefix = "";
		prefix = infixToPrefix(infix);
		System.out.println(" prefix : "+prefix);
		
		int result = solvePrefix(prefix);
		System.out.println("result : "+result);
	}
}
