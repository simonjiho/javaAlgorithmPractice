import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class SWExpert_4193 {
	static int N;
	
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		

		int T = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			N = Integer.parseInt(br.readLine());
			
			int[][] sea = new int[N][N];
			boolean[][][] visited = new boolean[N][N][N*N];
			
			for(int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					sea[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			String[] start = br.readLine().split(" ");
			String[] end = br.readLine().split(" ");
//			System.out.println(start[0] + start[1] + end[0] + end[1]);

			
			int startR = Integer.parseInt(start[0]);
			int startC = Integer.parseInt(start[1]);
			int endR = Integer.parseInt(end[0]);
			int endC = Integer.parseInt(end[1]);
			
			Player startPlayer = new Player(startR,startC);
			
			Queue<Player> q = new LinkedList<>();
			q.offer(startPlayer);
			
			
			int time = 0;
			visited[startR][startC][time] = true;
			
			outer:while(time < N*N) {
				
				Queue<Player> newQ = new LinkedList<>();
//				System.out.println(time + "초 때 갈 방향 탐색");
				
				while(!q.isEmpty()) {
					
					Player curPlayer = q.poll();
//					System.out.printf("  (%d, %d)에서\n", curPlayer.r, curPlayer.c);

					
					for(int i=0; i < 4; i++) {
						int nextR = curPlayer.r+dy[i], nextC = curPlayer.c+dx[i];
						if(!isValid(nextR, nextC)) continue;
							
						int nextVal = sea[nextR][nextC];
						if(nextR == endR && nextC == endC) {time++; break outer;}
						if(nextVal == 1) continue;
						if(visited[nextR][nextC][time]) continue;
						if(nextVal == 2 && (time+1) % 3 != 0) {
							newQ.add(curPlayer);
							visited[curPlayer.r][curPlayer.c][time] = true;
						} else {
							Player nextPlayer = new Player(nextR, nextC);
							visited[nextR][nextC][time] = true;
							newQ.offer(nextPlayer);
						}
//						System.out.printf("	(%d,%d)로 이동\n", nextPlayer.r, nextPlayer.c);

					}

						
						
				}
				
				q = newQ;
				time++;
				
				
			}
	
			
			if (time == N*N) time = -1;
			System.out.println("#" + test_case + " " + time);
			
		}			

		
		
	}
	static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	
	private static class Cell {

		int r;
		int c;
		int val;
		
		Cell(int r, int c, int val) {
			this.r = r; this.c = c;
			this.val = val;
		}
	}
	
	private static class Player {
		int r;
		int c;
		Player(int r, int c) {
			this.r = r;this.c = c;
		}
		

		

	}
	
}


