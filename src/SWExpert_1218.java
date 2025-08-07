import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class SWExpert_1218 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			int N = Integer.parseInt(br.readLine());
			
			Stack<Character> stack = new Stack<>();
			
			String s = br.readLine();
			
			int ans = 1;
			
			for(int i = 0; i < N; i++) {
				char c = s.charAt(i);
								
				if (c == '{' || c == '[' || c == '(' || c == '<') {
					stack.push(c);
				} else {
					if (c == '}' && stack.peek() == '{') {
						stack.pop();
					} else if (c == ']' && stack.peek() == '[') {
						stack.pop();
					} else if (c == ')' && stack.peek() == '(') {
						stack.pop();
					} else if (c == '>' && stack.peek() == '<') {
						stack.pop();
					} else {
						ans = 0;
						break;
					}
				}
			}
				

			

			System.out.println("#" + test_case + " " + ans);
			
		}			

		
		
	}
	
}
