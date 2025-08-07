import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class SWExpert_1234 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			
			int[] arr = new int[N];
			
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(String.valueOf(input[1].charAt(i)));
			}
			
			Stack<Integer> stack = new Stack<>();
			
			for(int i = 0; i < N; i++) {
				if(!stack.isEmpty()) {
					if (stack.peek() == arr[i]) {
						stack.pop();
					} else {
						stack.push(arr[i]);
					}
				} else {
					stack.push(arr[i]);
				}
			}
			
			String ans = "";
			
			while(!stack.isEmpty()) {
				ans = stack.pop() + ans;
			}
			

			System.out.println("#" + test_case + " " + ans);
			
		}			

		
		
	}
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < 16 && c >= 0 && c < 16;
	}
	
	
	private static class Cell {
		int r;
		int c;
		int val;
		boolean visited = false;
		
		Cell(int r, int c, int val) {
			this.r = r; this.c = c;
			this.val = val;
		}
	}
}


