import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class SWExpert_1220 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			int N = Integer.parseInt(br.readLine());
			
			
			char[] input = new char[N];
			
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			char[] postfix = new char[N]; 

			int cnt = 0;
			for(int i = 0; i < N; i++) {
				char val = s.charAt(i);
				if (val == '(' || val == '*') stack.push(val);
				else if (val == '+') {
					while(stack.peek() == '*') {
						postfix[cnt++] = stack.pop();
					}
					stack.push(val);
				} else if(val == ')') {
					while(stack.peek() != '(') {
						postfix[cnt++] = stack.pop();
					}
					stack.pop();
				} else {
					postfix[cnt++] = val;
				}
			}
			
			Stack<Integer> resultStack = new Stack<>();
			
			for(int i = 0; i < cnt; i++) {
				char val = postfix[i];
				if(val >= '0') {
					resultStack.push(val - '0');
				} else {
					int num2 = resultStack.pop();
					int num1 = resultStack.pop();
					if(val == '*') resultStack.push(num1*num2);
					else resultStack.push(num1+num2);
				}
			}
			
			


			System.out.println("#" + test_case + " " + resultStack.pop());
			

			
		}			

		
		
	}
	
}
