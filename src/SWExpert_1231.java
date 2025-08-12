import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class SWExpert_1231 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			int N = Integer.parseInt(br.readLine());
			Node nodes[] = new Node[N+1];
			
			for(int i = 1; i <= N; i++) {
				nodes[i] = new Node();
			}

			
			
			for(int i = 1; i <= N; i++) {
				String[] s = br.readLine().split(" ");
				nodes[i].val = s[1];
				
				if(s.length > 2) {
					int leftId = Integer.parseInt(s[2]), rightId = Integer.parseInt(s[3]);
					if (leftId <= N) nodes[i].left = nodes[leftId];
					if (rightId <= N) nodes[i].right = nodes[rightId];
				}
				
				
			}
			
			
			
			int ans = dfs(nodes[1]);
			
			System.out.println("#" + test_case + " " + ans);
			
		}
			
			


		
		
	}
	
	private static int dfs(Node node) {
		
		if(node.left != null && node.right != null) {
			int	num1 = dfs(node.left);
			int	num2 = dfs(node.right);
			if (node.val.equals("-")) return num1-num2;
			else if (node.val.equals("/")) return num1/num2;
			else if (node.val.equals("+")) return num1+num2;
			else return num1*num2; // node.val.equals("*")
			
		} else {
			return Integer.parseInt(node.val);
		}
	}
	
	
	private static class Node {
		String val;
		Node left;
		Node right;
		
		Node() {};
		
		Node(String val) {
			this.val = val;
		}
	}
}


