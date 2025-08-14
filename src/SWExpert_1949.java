import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class SWExpert_1949 {

	static int N;
	static int K;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int max_c = 0;
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			K = Integer.parseInt(s[1]);
			map = new int[N][N];
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				String[] row = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(row[j]);
					max_c = Math.max(max_c, map[i][j]);
				}
			}
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
//					if (highestPoint(i,j)) {
					if(max_c == map[i][j]) {
						cnt = Math.max(cnt, dfs(i,j, 1, map[i][j], false));
					}
				}
			}
			
			System.out.println("#" + test_case + " " + cnt);
			
			
		}
			
			
		
	}
	
	static boolean isValid(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < N;
	}
	
	static boolean connect(int i, int j, int dir) {
		int deltaY = dy[dir], deltaX = dx[dir];
		int prevI = i, prevJ = j;
		boolean connectionSucceed = true;
		while (isValid(i,j)) {
			if(map[i][j] == 1) {connectionSucceed = false; break;};
			map[i][j] = 1;
			i += deltaY; j+= deltaX;
		}
		
		if (!connectionSucceed) {
			while(i != prevI || j != prevJ) {
				i -= deltaY; j-= deltaX;
				map[i][j] = 0;
			}
		}
		
		return connectionSucceed;
		
	}
	
	
	
	static int dfs(int i, int j, int cnt, ) {

	}	
	
	
}


