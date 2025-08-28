import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class SWExpert_2112 {

	static int D, W, K;
	static int[][] film;
	static int minCnt;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			minCnt = Integer.MAX_VALUE;
			
			String[] input1 = br.readLine().split(" ");
			D = Integer.parseInt(input1[0]);
			W = Integer.parseInt(input1[1]);
			K = Integer.parseInt(input1[2]);
			
			film = new int[D][W];
			System.out.println(W);
			
			for(int i = 0; i < D; i++) {
				String[] input2 = br.readLine().split(" ");
				for(int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(input2[j]);
				}
			}
			

			dfs(0,0); // cnt, d
			
			
			
		
			
			System.out.println("#" + test_case + " " + minCnt);
			
		}
			
			


		
		
	}
	
	static void dfs(int cnt, int d) {
		
		if (d == D) return;
		
		if (check()) {
			minCnt = Math.min(cnt, minCnt);
			return;
		}
			
		dfs(cnt, d+1);
		
		int[] prevRow = film[d];
		int[] zeroRow = new int[D];
		int[] oneRow = new int[D];
		for(int i=0;i<D;i++) oneRow[i]=1;
		
		film[d] = zeroRow;
		dfs(cnt+1, d+1);

		film[d] = oneRow;
		dfs(cnt+1, d+1);
		
		// backtrack
		film[d] = prevRow;
			
	}
	
	
	static boolean check() {
		int cCnt = 0;
		
		for(int c = 0; c < W; c++) {
			int cnt = 1;
			int prevNum = film[0][c];
			for(int r = 1; r < D; r++) {
				System.out.println(r);
				if(prevNum == film[r][c]) cnt += 1;
				else { 
					prevNum = film[r][c]; 
					cnt = 1; 
				}
				if (cnt >= K) {
					cCnt += 1; break;
				}
			}
		}
		
		return cCnt == W;
	}
	
}


