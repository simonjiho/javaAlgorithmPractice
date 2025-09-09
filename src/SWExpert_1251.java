import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class SWExpert_1251 {

//	static int N;
//	
//	static long[][] dist;
	
	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{

			int N = Integer.parseInt(br.readLine());
			long[] posX = new long[N];
			long[] posY = new long[N];
			long[][] dist = new long[N][N];
			boolean[] visited = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 0;i < N; i++) {
				posX[i] = Integer.parseInt(st.nextToken());
				posY[i] = Integer.parseInt(st2.nextToken());
			} 
			
			double E = Double.parseDouble(br.readLine());
			
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					long dx = posX[i] - posX[j];
					long dy = posY[i] - posY[j];
					dist[i][j] = dx * dx + dy * dy;
				}
			}
			
			
			
			PriorityQueue<int[]> pq = new PriorityQueue<int[]> ((a,b) -> Long.compare(dist[a[0]][a[1]], dist[b[0]][b[1]]) );
			
			for(int i = 1; i<N;i++) {
				pq.add(new int[]{0,i});
			}
			visited[0] = true;
			
			long ans = 0;
			int cnt = 0;
			while(cnt < N-1) {
				
				int[] edge = pq.poll();
				if(visited[edge[0]] && visited[edge[1]]) continue;
				
				ans += dist[edge[0]][edge[1]];

				
				int from;
				
				if (visited[edge[0]]) {
					from = edge[1];
					
				} else {
					from = edge[0];
				}
				
				
				for(int i=0;i<N;i++) {
					if(i == from) continue;
					if(visited[i]) continue;
					
					int sN, bN;
					if(i < from) { sN = i; bN = from; }
					else { sN = from; bN = i; }
					
					pq.add(new int[]{sN, bN});
				
				}
				
				

				
				visited[from] = true;
				cnt++;
			}
			
			
			
			System.out.println("#" + test_case + " " + Math.round(ans*E));
			
		}
			
			

		
		
		
	}

	

}

