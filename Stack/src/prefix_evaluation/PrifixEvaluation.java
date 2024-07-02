package prefix_evaluation;

import java.util.Stack;

public class PrifixEvaluation {

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
		// stack of operands
		Stack<Integer> s = new Stack<>();
		// traverse postfix from left to right
		for (int i =pre.length()-1 ; i>=0; i--) {
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

	public static void main(String[] args) {

		String prefix = "+-+59*4-8/62$1-73";
		int result = solvePrefix(prefix);
		System.out.println(" result :" + result);
	}
}
