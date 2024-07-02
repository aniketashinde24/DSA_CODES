import java.util.Stack;

public class PostfixEvaluation {
	
	public static int calc(int a,int b, char operator) {
		
		switch (operator) {
		
		case '$': return (int)Math.pow(a, b);
		case '*': return a * b;
		case '/': return a / b;
		case '%': return a % b;
		case '+': return a + b;
		case '-': return a - b;
		
		}
		return 0;
	}

	private static int solvePostfix(String post) {
		//stack of operands
		Stack<Integer> s= new Stack<>();
		//traverse postfix from left to right
		for(int i = 0 ; i < post.length() ;i++) {
			//get each sym from expression
			char sym = post.charAt(i);
			if(Character.isDigit(sym)) {
				
				String operand = Character.toString(sym);
				s.push(Integer.parseInt(operand));
			}else {
				int b = s.pop();
				int a = s.pop();
				int c = calc(a,b,sym);
				s.push(c);
			}
		}
		return s.pop();
	}
	public static void main(String[] args) {

		String postfix = "59+4862/-*-173-$+";
		int result = solvePostfix(postfix);
		System.out.println(" result :" + result);
	}

	

}
