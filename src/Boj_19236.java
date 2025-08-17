import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 11:25~11:40
// 14:30~

public class Boj_19236 {

	static Fish[][] map = new Fish[4][4];
	static Shark shark;
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
		
		shark = new Shark(map[0][0].score, map[0][0].dir, 0, 0);
		map[0][0] = shark;
		fishes[shark.score] = null;

		dfs();

		System.out.println(maxScore);

	}


	private static void dfs() {
		// 물고기 -> 상어
		// 연속으로 두번 (0,0)에서 먹을 물고기 없으면 return
//		debugPrint();
		
//		debugPrint2();

		boolean[] moved = new boolean[17];
		int[] fishPrevDir = new int[17];
		
		for(int i = 1; i <= 16; i++) {
			Fish fish = fishes[i];
			if (fish == null) continue;

			fishPrevDir[i] = fish.dir;
			moved[i] = fish.findValidDir();
			fish.swapFish();
		}
		
//		String moveS = "";
//		for(int i = 1; i <= 16; i++) {
//			moveS += moved[i] ? " o" : " x";
//		}
//		System.out.println(moveS);


//		System.out.println("after fish moved");
//		debugPrint2();

		ArrayList<Fish> possibleFishes = shark.possibleFishes();
		
		if (possibleFishes.size() == 0) {
			maxScore = Math.max(maxScore, shark.score);
		}

		int prevR = shark.r, prevC = shark.c, prevDir = shark.dir, prevScore = shark.score;
		
		for(Fish fish:possibleFishes) { // 실수2: 없으면 상어가 (0,0)으로 되돌아 가는 줄 알았다.

			shark.eatFish(fish);

			dfs();

			// backTrack
//			System.out.println("shark backTrack");
//			System.out.println(prevScore);
//			System.out.println(fish.r + " " + fish.c);
			shark.backTrack(prevR, prevC, prevScore, prevDir);
			fishes[fish.score] = fish;
			map[fish.r][fish.c] = fish;
		}
		

		
		// backTrack 2
		for(int i = 16; i >= 1; i--) {
			Fish fish = fishes[i];
			if (fish == null || !moved[i]) continue;
//			System.out.println("backtracking fish " + i);
			fish.backTrack(fishPrevDir[i]);
		}
		
//		System.out.println("after fish backtrack");
//		debugPrint2();

		



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

		boolean findValidDir() {
			int nextR = nextR();
			int nextC = nextC();

			int cnt = 0;
			while(!isValid(nextR, nextC) || map[nextR][nextC] == shark) { // 실수1:cnt를 조건에 넣었다 
				dir++;
				if (dir == 9) dir = 1;
				nextR = nextR();
				nextC = nextC();
				cnt++;
				if (cnt == 8) break;
			}
			
			return cnt < 8;
			
		}

		int nextR() {
			return this.r + dy[dir];
		}
		int nextC() {
			return this.c + dx[dir];
		}
		
		int prevR() {
			return this.r - dy[dir];
		}
		int prevC() {
			return this.c - dx[dir];
		}

		void changePos(int nextR, int nextC) {
			this.r = nextR; this.c = nextC;
			map[nextR][nextC] = this;
		}

		void swapFish() {
			int nextR = nextR(), nextC = nextC();
			Fish targetFish = map[nextR][nextC];
			if (targetFish != null) {targetFish.changePos(r, c);}
			else { map[r][c] = null; }
			changePos(nextR, nextC);
		}
		
		void backTrack(int prevDir) {
			int prevR = prevR(), prevC = prevC();
			Fish targetFish = map[prevR][prevC];
			if (targetFish != null) {targetFish.changePos(r, c);}
			else { map[r][c] = null; }
			changePos(prevR, prevC);
			this.dir = prevDir;
		}
		

	}
	
	static class Shark extends Fish {

		
		Shark(int score, int dir, int r, int c) {
			super(score, dir, r, c);
		}
		
		void eatFish(Fish fish) {
			fishes[fish.score] = null; // eatFish
			map[this.r][this.c] = null; // eathFish
			changePos(fish.r, fish.c);
			shark.score += fish.score;
			shark.dir = fish.dir;
		}
		
		
		ArrayList<Fish> possibleFishes() {
			ArrayList<Fish> result = new ArrayList<>();
			int fishR = nextR(); int fishC = nextC();
			int dR = dy[dir]; int dC = dx[dir];
			while(isValid(fishR,fishC)) {
//				System.out.println(fishR + " " + fishC);
				if(map[fishR][fishC] != null) result.add(map[fishR][fishC]);
				fishR += dR ;
				fishC += dC;
			}
//			System.out.println(result.size());
			return result;
		}
		
		
		void backTrack(int prevR, int prevC, int prevScore, int prevDir) {
			changePos(prevR,prevC);
			this.score = prevScore; this.dir = prevDir;
		}
		
	}

}