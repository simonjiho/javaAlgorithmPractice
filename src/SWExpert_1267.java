import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class SWExpert_1267 {

	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			String[] input = br.readLine().split(" ");
			int V = Integer.parseInt(input[0]), E = Integer.parseInt(input[1]);
			Node nodes[] = new Node[V+1];
			boolean[] visited = new boolean[V+1];
			for(int i=1; i<=V;i++) nodes[i] = new Node(i);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < E; i++) {
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());

				nodes[n1].next.add(n2);
				nodes[n2].pCnt++;
			}
			
			Queue<Node> q = new ArrayDeque<>();
			ArrayList<Integer> ans = new ArrayList<Integer>();
			for(int i = 1; i <= V; i++) {
				Node node = nodes[i];
				if(node.pCnt == 0) {
					q.offer(node);
					visited[i] = true;
				}
			}
			
			
			while(!q.isEmpty()) {
				
				
				
				while(!q.isEmpty()) {
					Node node = q.poll();
					ans.add(node.id);
					for(int n: node.next) {
						nodes[n].pCnt--;
					}
				}
								
				for(int i = 1; i <= V; i++) {
					Node node = nodes[i];
					if(node.pCnt == 0 && !visited[node.id]) {
						q.offer(node);
						visited[node.id] = true;
					}
				}
			}
			
			System.out.printf("#" + test_case);
			for(int i: ans) {
				System.out.printf(" " + i);
			}			
			System.out.printf("\n");

			
		}
			
			


		
		
	}
	
	
	private static class Node {
		int id;
		ArrayList<Integer> next = new ArrayList<>();
		int pCnt;
		Node(int id) {
			this.id = id;
		}


	}
}


