
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 11:25~11:40
// 14:30~

public class Boj_19236 {
	
	static Fish[][] map = new Fish[4][4];
	static Fish shark;
	static Fish[] fishes = new Fish[17];
	static int[] dy = {999,-1,-1,0,1,1,1,0,-1};
	static int[] dx = {999,0,-1,-1,-1,0,1,1,1};
	static int maxScore = 0;
	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0 ; i < 4; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < 4; j++) {
				int score = Integer.parseInt(line[j*2]);
				int dir = Integer.parseInt(line[j*2+1]);
				Fish newFish = new Fish(score, dir, i, j);
				map[i][j] = newFish;
				fishes[score] = newFish;
			}
		}
		shark = map[0][0];
		fishes[shark.score] = null;

		dfs(false);
		
		System.out.println(maxScore);

	}


	private static boolean dfs(boolean resetOnLastTurn) {
		// 물고기 -> 상어
		// 연속으로 두번 (0,0)에서 먹을 물고기 없으면 return
		debugPrint();
		debugPrint2();

		for(int i = 1; i <= 16; i++) {
			Fish fish = fishes[i];
			if (fish == null) continue;
			
			fish.findValidDir();
			int nextR = fish.nextR(), nextC = fish.nextC();
			fish.swapFish(nextR, nextC);
		}
		
		debugPrint2();

		ArrayList<Fish> possibleFishes = shark.possibleFishes();
		
		if (possibleFishes.size() == 0 && resetOnLastTurn) {
			maxScore = Math.max(maxScore, shark.score);
			return true;
		}
		
		boolean shouldReset = (possibleFishes.size() == 0) ;
		int prevR = shark.r, prevC = shark.c, prevDir = shark.dir;

		
		if(shouldReset) {
			if(map[0][0] == shark) return true;
			
			else if (map[0][0] == null) {
				shark.changePos(0,0);
				dfs(true);
				// backTrack
				shark.changePos(prevR, prevC);
			} else {
				Fish fish = map[0][0];
				int score = fish.score; int dir = fish.dir;
				int nextR = fish.r, nextC = fish.c;
				
				fishes[score] = null; // eatFish
				map[nextR][nextC] = null; // eatFish
				shark.swapFish(nextR, nextC);
				shark.score += score;
				shark.dir = dir;
				
				dfs(true);
				
				// backTrack
				System.out.println("backTrack");
				shark.backTrackValue(prevR, prevC, shark.score - score, prevDir);
				fishes[score] = fish;
				map[nextR][nextC] = fish;
				map[prevR][prevC] = shark;			
			}
		} else {
			for(Fish fish:possibleFishes) {
				int score = fish.score; int dir = fish.dir;
				int nextR = fish.r, nextC = fish.c;
				
				fishes[score] = null; // eatFish
				map[nextR][nextC] = null; // eatFish
				shark.swapFish(nextR, nextC);
				shark.score += score;
				shark.dir = dir;
				
				dfs(false);
				
				// backTrack
				System.out.println("backTrack");
				shark.backTrackValue(prevR, prevC, shark.score - score, prevDir);
				fishes[score] = fish;
				map[nextR][nextC] = fish;
				map[prevR][prevC] = shark;		
				
			}
		}
		
		
		
		return shouldReset;

		
	}
	

	
	private static void debugPrint() {
		String s = "";
		for(int i = 1; i <= 16; i++) {
			if (fishes[i] == null) s += " null";
			else s += " " + fishes[i].score;
		}
		System.out.println(s);
	}
	
	private static void debugPrint2() {
		for(int i = 0; i < 4; i++) {
			String s = "";
			for(int j = 0; j < 4; j++) {
				if (map[i][j] == null) s += " null";
				else s += " " + map[i][j].score;
			}
			System.out.println(s);

		}
	}
	
	private static boolean isValid(int r, int c) {
		return r >= 0 && r < 4 && c >= 0 && c < 4;
	}

	
	private static class Fish {
		int score;
		int dir;
		int r;
		int c;
		
		Fish(int score, int dir, int r, int c) {
			this.score = score; this.dir = dir; this.r = r; this.c = c;
		}
		
		void findValidDir() {
			int nextR = nextR();
			int nextC = nextC();
			
			int cnt = 0;
			while(!isValid(nextR, nextC) || map[nextR][nextC] == shark || cnt >= 8) {
				dir++;
				if (dir == 9) dir = 1;
				nextR = nextR();
				nextC = nextC();
				cnt++;
			}
		}
		
		int nextR() {
			return this.r + dy[dir];
		}
		int nextC() {
			return this.c + dx[dir];
		}
		
		void changePos(int r, int c) {
			this.r = r; this.c = c;
			map[r][c] = this;
		}
		
		void swapFish(int nextR, int nextC) {
			int prevR = r, prevC = c;
			Fish targetFish = map[nextR][nextC];
			if (targetFish != null) {targetFish.changePos(prevR, prevC);}
			else { map[prevR][prevC] = null; }
			changePos(nextR, nextC);

		}
		
		void backTrackValue(int prevR, int prevC, int prevScore, int prevDir) {
			this.r = prevR; this.c = prevC; this.score = prevScore; this.dir = prevDir;
		}
		
		ArrayList<Fish> possibleFishes() { // only shark use this method
			System.out.println(this == shark);
			System.out.println(this.r + " " + this.c);
			ArrayList<Fish> result = new ArrayList<>();
			int fishR = nextR(); int fishC = nextC();
			System.out.println(fishR + " " + fishC);
			int dR = dy[dir]; int dC = dx[dir];
			while(isValid(fishR,fishC)) {
				System.out.println(fishR + " " + fishC);
				if(map[fishR][fishC] != null) result.add(map[fishR][fishC]);
				fishR += dR ;
				fishC += dC;
			}
			System.out.println(result.size());
			return result;
		}
		

	}

}
