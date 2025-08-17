import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class SWExpert_1949 {

	static int N;
	static int K;
	static int[][] map;
	static ArrayList<Integer> procR;
	static ArrayList<Integer> procC;
	static int maxProcCnt;
	static int minLineLength;
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			procR = new ArrayList<>();
			procC = new ArrayList<>();
			K = 0; // number of processor that needs connect
			maxProcCnt = 0;
			minLineLength = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				String[] row = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					int val = Integer.parseInt(row[j]);
					map[i][j] = val;
					boolean isNotOnEdge = i != 0 && i != N-1 && j != 0 && j != N-1;
					if(val == 1 && isNotOnEdge) {
						procR.add(i);
						procC.add(j);
						K++;
					}
				}
			}
			
			dfs(0, 0, 0);
			
			System.out.println("#" + test_case + " " + minLineLength);
			
			
		}
			
			
		
	}
	
	static boolean isValid(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < N;
	}
	
	static void dfs(int k, int lineLength, int cnt) {
		if (maxProcCnt == cnt) {
			minLineLength = Math.min(lineLength, minLineLength);
		} else if( maxProcCnt < cnt) {
			minLineLength = lineLength;
			maxProcCnt = cnt;
		} else { // maxProCnt > cnt
			if(maxProcCnt - cnt > K - k) return;
		}

		
		if(k == K) return;

		
		int r = procR.get(k), c = procC.get(k);
		if(map[r][c] == 0) System.out.println("problem occurred");
		
		
		for(int d = 0; d < 4; d++) {
			if (!connect(r,c,d)) continue;			
			dfs(k+1, lineLength + lengthOf(r,c,d), cnt+1);
			disconnect(r,c,d);
		}
		
		if(map[r][c] == 0) System.out.println("problem occurred");

		dfs(k+1, lineLength, cnt); // no connection

		if(map[r][c] == 0) System.out.println("problem occurred");

	}
	
	static int lengthOf(int r, int c, int d) {
		if( d == 0 ) return N - 1 - r;
		else if( d == 1 )  return r;
		else if( d == 2 )  return N - 1 - c;
		else return c;
	}
	
	static void disconnect(int r, int c, int dir) {
		int deltaY = dy[dir], deltaX = dx[dir];
		while (isValid(r+deltaY,c+deltaX)) {
			r += deltaY; c+= deltaX;
			map[r][c] = 0;
		}
		
	}
	
	static boolean connect(int r, int c, int dir) {
		int deltaY = dy[dir], deltaX = dx[dir];
		int prevR = r, prevC = c;
		boolean connectionSucceed = true;
		while (isValid(r+deltaY,c+deltaX)) {
			r += deltaY; c+= deltaX;
			if(map[r][c] == 1) {connectionSucceed = false; break;};
			map[r][c] = 1;
		}
		
		
		if (!connectionSucceed) {
			r-=deltaY;c-=deltaX;
			while(r != prevR || c != prevC) {
				map[r][c] = 0;
				r -= deltaY; c-= deltaX;
			}
		}
		
		return connectionSucceed;
		
	}
	
	
	

	
	
}


