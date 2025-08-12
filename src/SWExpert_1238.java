import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class SWExpert_1238 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Node[] nodes = new Node[101];
		for(int i = 1; i <= 100; i++) {
			nodes[i] = new Node(i);
		}

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			for(int i = 1; i <= 100; i++) {
				nodes[i].gotCall = false;
				nodes[i].next = new ArrayList<>();
			}

			String[] s = br.readLine().split(" ");
			int edges = Integer.parseInt(s[0]);
			int startNodeVal = Integer.parseInt(s[1]);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < edges/2; i++) {
				nodes[Integer.parseInt(st.nextToken())].next.add(nodes[Integer.parseInt(st.nextToken())]);
			}
			
			Queue<Node> q = new LinkedList<>();
			q.add(nodes[startNodeVal]);
			
			int ans = startNodeVal;
			while(!q.isEmpty()) {
				
				Queue<Node> newQ = new LinkedList<>();
				
				while(!q.isEmpty()) {
					Node curNode = q.poll();
					for(Node nextNode: curNode.next) {
						if (nextNode.gotCall) continue;
						
						nextNode.gotCall = true;
						
						newQ.offer(nextNode);
					}
				}
				
				if (!newQ.isEmpty()) ans = Integer.MIN_VALUE;
				for(Node node: newQ) {
					ans = Math.max(node.val, ans);
				}
				
				
				q = newQ;
				
				
			}
	
			

			System.out.println("#" + test_case + " " + ans);
			
		}			

		
		
	}
	
	
	
	private static class Node {

		int val;
		ArrayList<Node> next = new ArrayList<>();
		boolean gotCall;
		
		Node(int val) {
			this.val = val;
		}
	}
}


