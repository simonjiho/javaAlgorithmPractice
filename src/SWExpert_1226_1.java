import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class SWExpert_1226_1 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dy = {0,0,1,-1};
		int[] dx = {1,-1,0,0};
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			int T = Integer.parseInt(br.readLine());
			
			
			Cell[][] maze = new Cell[16][16];
			for(int i = 0; i < 16; i++) {
				String s = br.readLine();
				for(int j = 0; j < 16; j++) {
					maze[i][j] = new Cell(i,j, Integer.parseInt(String.valueOf(s.charAt(j)) ));
				}
			}
			
			Queue<Cell> q = new LinkedList<>();
			q.add(maze[1][1]);
			maze[1][1].val = 1;
			
			int ans = 0;
			outer:while(!q.isEmpty()) {
				
				Cell curCell = q.poll();
//				System.out.println("current cell: ( r=" + curCell.r + ", c=" + curCell.c + ") ");
				
				
				for(int i = 0; i<4; i++) {
					int nextR = curCell.r + dy[i];
					int nextC = curCell.c + dx[i];
					if (isValid(nextR,nextC)) {
						Cell nextCell = maze[nextR][nextC];
						if ( nextCell.val == 0) {q.add(nextCell); nextCell.val = 1;}
						else if (nextCell.val == 3) {ans = 1; break outer;}
					}
				}
				
				
			}
	
			

			System.out.println("#" + test_case + " " + ans);
			
		}			

		
		
	}
	
	static boolean isValid(int r, int c) {
		return r >= 0 && r < 16 && c >= 0 && c < 16;
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
}


