import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


public class SWExpert_1249 {

	static int N;
	
	final static int[] dy = {1, -1, 0, 0};
	final static int[] dx = {0, 0, 1, -1};
	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{

			N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			for(int i = 0;i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j)-'0';
				}
			}
			
			int[][] dijkMap = new int[N][N];
			for(int i = 0; i < N; i++) {
			
				Arrays.fill(dijkMap[i],Integer.MAX_VALUE);
			}
			dijkMap[0][0] = 0;
			
			PriorityQueue<int[]> pq = new PriorityQueue<int[]> ((a,b) -> (dijkMap[a[0]][a[1]] - dijkMap[b[0]][b[1]]) );
			pq.add(new int[]{0,0}); // r, c, sum
			
			while(!pq.isEmpty()) {
				int[] pos = pq.poll();
				int r = pos[0], c = pos[1];
				for(int i = 0; i < 4; i++) {
					int nR = r+dy[i], nC = c+dx[i];
					if(!isValid(nR, nC)) continue;
					int newVal = dijkMap[r][c] + map[nR][nC];
					if(dijkMap[nR][nC] <= newVal) continue;
					dijkMap[nR][nC] = newVal;
					pq.add(new int[] {nR,nC});
				}
			}
			
			
			
			System.out.println("#" + test_case + " " + dijkMap[N-1][N-1]);
			
		}
			
			


		
		
	}
	
	private static boolean isValid(int r, int c) {
		return r < N && r >= 0 && c < N && c >= 0;
	}
	

}

