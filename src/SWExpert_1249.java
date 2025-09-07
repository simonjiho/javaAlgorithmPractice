//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//
//public class SWExpert_1249 {
//
//	static int N;
//	
//	static int[] dy = {1, -1, 0, 0};
//	static int[] dx = {0, 0, 1, -1};
//	
//	
//	public static void main(String args[]) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	
//		int T = Integer.parseInt(br.readLine());
//		
//		for(int test_case = 1; test_case <= T; test_case++)
//		{
//
//			N = Integer.parseInt(br.readLine());
//			
//			int[][] map = new int[N][N];
//			for(int i = 0;i < N; i++) {
//				String[] input = br.readLine().split(" ");
//				for(int j = 0; j < N; j++) {
//					map[i][j] = Integer.parseInt(input[j]);
//				}
//			}
//			
//			int[][] dijkMap = new int[N][N];
//			Arrays.fill(dijkMap,Integer.MAX_VALUE);
//			dijkMap[0][0] = 0;
//			
//			PriorityQueue pq = new PriorityQueue<int[]> ((a,b) -> (dijkMap[a[0]][a[1]] - dijkMap[b[0]][b[1]]) );
//			pq.add(new int[]{0,0,0}); // r, c, sum
//			
//			while(!pq.isEmpty()) {
//				int[] pos = pq.poll();
//				int r = pos[0], c = pos[1], val = pos[2];
//				for(int i = 0; i < 4; i++) {
//					int nR = r+dy[i], nC = r+dx[i];
//					if(!isValid(nR, nC)) continue;
//					if(dijkMap[r][c] <= val) continue;
//					dijkMap[r][c] = val + map[r][c];
//					pq.add(new int[] {nR,nC,dijkMap[r][c]});
//				}
//			}
//			
//			
//			
//			
//			System.out.println("#" + test_case + " " + luca.id + " " + cnt);
//			
//		}
//			
//			
//
//
//		
//		
//	}
//	
//	private static boolean isValid(int r, int c) {
//		return r < N && r >= 0 && c < N && c >= 0;
//	}
//	
//	private static void calcDepth(Node node, int depth) {
//		if (node == null) return;
//		
//		node.depth = depth;
//		calcDepth(node.left, depth+1);
//		calcDepth(node.right, depth+1);
//	}
//	
//	private static int dfs(Node node) {
//		int cnt = 0;
//		if(node.left != null) {
//			cnt += dfs(node.left);
//		}
//		if(node.right != null) {
//			cnt += dfs(node.right);
//		}
//		
//		return cnt+1;
//	}
//	
//	
//	private static class Node {
//		int id;
//		int depth;
//		Node parent;
//		Node left;
//		Node right;
//			
//		Node(int id) {
//			this.id = id;
//		}
//
//	}
//}
//
//
