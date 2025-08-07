import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;



public class SWExpert_1219 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{

			String[] s = br.readLine().split(" ");
			int T = Integer.parseInt(s[0]);
			int N = Integer.parseInt(s[1]);

//			System.out.println(T + " " + N);
			Node[] nodes = new Node[100];
			for(int i = 0; i < 100; i++) {
				nodes[i] = new Node(i);
			}

			
			StringTokenizer st = new StringTokenizer(br.readLine());
			

			for(int i = 0; i < N; i++) {
				int startId = Integer.parseInt(st.nextToken());
				int endId = Integer.parseInt(st.nextToken());
				nodes[startId].nextNodes.add(nodes[endId]);
//				System.out.println("startId: " + startId + ", endId: " + endId);

			}
			

			boolean[] visited = new boolean[100];
			
			Stack<Node> stack = new Stack<Node>();
			stack.push(nodes[0]);
			visited[0] = true;
			
			int ans = 0;
			
			outer:while(!stack.isEmpty()) {

				Node curNode = stack.pop();
				for(Node node: curNode.nextNodes) {
//					System.out.println("child node 탐색 중: " + node.id);
					if (!visited[node.id]) {
//						System.out.println(curNode.id + "의 다음 노드: " + node.id);
						if (node.id == 99) { ans = 1; break outer; }

						stack.push(node);
						visited[node.id] = true;
					}
				}
			}
			
			
			

			System.out.println("#" + test_case + " " + ans);
			
		}			

		
		
	}
	
	private static class Node {
		int id;
		ArrayList<Node> nextNodes = new ArrayList<>();
		Node(int id) {
			this.id = id;
		}
	}
	
}


