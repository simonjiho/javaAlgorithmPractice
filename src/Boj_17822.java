
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 14:20 시작

public class Boj_17822 {
	
	static int N;
	static int M;

	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] C = new int[N][M];
		
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				C[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		for(int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]), d = Integer.parseInt(s[1]), k = Integer.parseInt(s[2]);
			
			for (int j1 = 0; j1 < N; j1++) {
				int n = j1+1;
				if (n % x != 0) continue;
				
				// if n % x == 0
				// rotate in direction d, with amount of k
				rotate(C, j1, d, k);
				

			}
			
//			debugPrint(C);
			
			boolean changed = false;
			for (int j1 = 0; j1 < N; j1++) {
				for (int j2 = 0; j2 < M; j2++) {
					changed |= dfs(j1, j2, C[j1][j2], C, 1);
				}
			}
			

			
			if(changed) continue;
			
			// if not changed, below code runs
			int sum = 0;
			int cnt = 0;
			for (int j1 = 0; j1 < N; j1++) {
				for (int j2 = 0; j2 < M; j2++) {
					if( C[j1][j2]!=-1 ) { sum += C[j1][j2]; cnt++; } 
				}
			}
			double avg = (double) sum / cnt;
			for (int j1 = 0; j1 < N; j1++) {
				for (int j2 = 0; j2 < M; j2++) {
					if (C[j1][j2] == -1) continue;
					
					if (C[j1][j2] > avg) C[j1][j2]--;
					else if (C[j1][j2] < avg) C[j1][j2]++;
				}
			}
			
		}
		
		int sum = 0;
		for (int j1 = 0; j1 < N; j1++) {
			for (int j2 = 0; j2 < M; j2++) {
				if( C[j1][j2]!=-1 ) sum += C[j1][j2];
			}
		}
		
//		debugPrint(C);

		
		System.out.println(sum);
	
	}
	
	static void rotate(int[][] C, int i, int d, int k) {

		if(d == 0) { // 시계
			for(int k_1 = 0; k_1 < k; k_1++) {
				int tmp = C[i][M-1];
				for (int j = M-1; j >=1; j--) {
					C[i][j] = C[i][j-1];
				}
				C[i][0] = tmp;
			}

		} else { // 반시계
			
			for(int k_1 = 0; k_1 < k; k_1++) {
				int tmp = C[i][0];
				for (int j = 0; j < M-1; j++) {
					C[i][j] = C[i][j+1];
				}
				C[i][M-1] = tmp;
			}

		}
		
		


		
	}
	
	static void debugPrint(int[][] C) {
		for (int j1 = 0; j1 < N; j1++) {

			String test = "";
			for (int j2 = 0; j2 < M; j2++) {
				test += C[j1][j2];
			}
			System.out.println(test);
		
		}
	}
	
	static boolean dfs(int n, int m, int target, int[][] C, int depth) {

		// -1 이면 return
		if (target == -1) return false;
		// 같지 않으면 return
		if (target != C[n][m]) return false;
		
		// -1 이 아니고, 같은 상태
		if (depth != 1) C[n][m] = -1;
		
		boolean childChanged = false;
		
		if (n + 1 < N) childChanged |= dfs(n+1, m, target, C, depth+1);
		if (n - 1 >= 0) childChanged |= dfs(n - 1, m, target, C, depth + 1); // 이거 안넣어서 틀림
		
		if ( m == 0 ) childChanged |= dfs(n, M-1, target, C, depth+1);
		else childChanged |= dfs(n, m-1, target, C, depth+1);
		
		if ( m == M-1 ) childChanged |= dfs(n, 0, target, C, depth+1);
		else childChanged |= dfs(n, m+1, target, C, depth+1);
	
		
		if (depth == 1 && childChanged) { C[n][m] = -1; }

		if (depth != 1) return true;
		else return childChanged;
		
	}
	
//	static void dfs(DFSObj d) {
//		if (d.n - 1 >= 0) {
//			dfs(new DFSObj(d.n-1, d.m, d.target));
//		}
//		
//		if (d.n - 1) {
//			
//		}
//	}
}


