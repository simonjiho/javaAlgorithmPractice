import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class SWExpert_1232 {
	
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
				int leftId = i*2, rightId = i*2 + 1;
				if (leftId <= N) nodes[i].left = nodes[leftId];
				if (rightId <= N) nodes[i].right = nodes[rightId];
			}
			
			
			for(int i = 1; i <= N; i++) {
				String[] s = br.readLine().split(" ");
				nodes[i].val = s[1];
			}
			
			
			
			String ans = dfs(nodes[1]);
			
			System.out.println("#" + test_case + " " + ans);
			
		}
			
			


		
		
	}
	
	private static String dfs(Node node) {
		String tmp = "";
		if(node.left != null) {
			tmp += dfs(node.left);
		}
		tmp += node.val;
		if(node.right != null) {
			tmp += dfs(node.right);
		}
		
		
		return tmp;
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


