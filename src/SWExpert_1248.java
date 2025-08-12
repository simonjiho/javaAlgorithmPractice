import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class SWExpert_1248 {

	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{

			
			String[] input = br.readLine().split(" ");
			int V = Integer.parseInt(input[0]), E = Integer.parseInt(input[1]);
			int node1Id = Integer.parseInt(input[2]);
			int node2Id = Integer.parseInt(input[3]);
			
			Node nodes[] = new Node[V+1];
			
			for(int i = 1; i <= V; i++) {
				nodes[i] = new Node(i);
			}
			Node node1 = nodes[node1Id], node2 = nodes[node2Id];
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i <= E; i++) {
				int pNodeId = Integer.parseInt(st.nextToken());
				int cNodeId = Integer.parseInt(st.nextToken());
				Node pNode = nodes[pNodeId], cNode = nodes[cNodeId];
				
				if (pNode.left == null) pNode.left = cNode;
				else pNode.right = cNode;
				
				cNode.parent = pNode;
			}
			
			calcDepth(nodes[1],0);
			
			Node[] node1Parent = new Node[V+1];
			Node[] node2Parent = new Node[V+1];
			
			Node curNode = node1;
			while(curNode.parent != null) {
				curNode = curNode.parent;
				node1Parent[curNode.depth] = curNode;
			}
			curNode = node2;
			while(curNode.parent != null) {
				curNode = curNode.parent;
				node2Parent[curNode.depth] = curNode;
			}
			
			Node luca = null;
			
			for(int v = V; v >= 0; v--) {
				Node parent1 = node1Parent[v], parent2 = node2Parent[v];
				if(parent1 == null || parent2 == null) continue;
				if(parent1.id == parent2.id) {
					luca = parent1; break;
				}
			}
			
			int cnt = dfs(luca);
			
			
			System.out.println("#" + test_case + " " + luca.id + " " + cnt);
			
		}
			
			


		
		
	}
	
	private static void calcDepth(Node node, int depth) {
		if (node == null) return;
		
		node.depth = depth;
		calcDepth(node.left, depth+1);
		calcDepth(node.right, depth+1);
	}
	
	private static int dfs(Node node) {
		int cnt = 0;
		if(node.left != null) {
			cnt += dfs(node.left);
		}
		if(node.right != null) {
			cnt += dfs(node.right);
		}
		
		return cnt+1;
	}
	
	
	private static class Node {
		int id;
		int depth;
		Node parent;
		Node left;
		Node right;
			
		Node(int id) {
			this.id = id;
		}

	}
}


