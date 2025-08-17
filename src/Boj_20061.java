
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시작: 16:45
/* 
 * gpt 검색 내용: 
 * 	무엇을 실수 했는지 -> for문에서 이상한 값을 증가시
 */
public class Boj_20061 {
	
	static boolean[][] green = new boolean[6][4];
	static boolean[][] blue = new boolean[4][6];
	static int score = 0;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		String[] inputs = new String[N];
		for(int i = 0; i < N; i++) {
			inputs[i] = br.readLine();
		}
		
		for(int i = 0; i < N; i++) {
			String[] input = inputs[i].split(" ");
			int t = Integer.parseInt(input[0]);
			int x = Integer.parseInt(input[1]);
			int y = Integer.parseInt(input[2]);
			
			stackUpGreen(t,x,y);
			stackUpBlue(t,x,y);
			
			eraseGreen();
			eraseBlue();
			
			int lGreen = lOfLightGreen();
			int lBlue = lOfLightBlue();
			
			for(int n = 0; n < lGreen; n++) {
				eraseR(5);
			}
			for(int n = 0; n < lBlue; n++) {
				eraseC(5);
			}
			
			
			
		}
		
		// calculate blocks
		int count = bOfGreen() + bOfBlue();
		
		System.out.println(score);
		System.out.println(count);

	}
	
	static int bOfGreen() {
		int cnt = 0;
		for(int r = 2; r < 6; r++) {
			for(int c = 0; c < 4; c++) {
				if(green[r][c]) cnt++;
			}
		}
		return cnt;
	}
	
	static int bOfBlue() {
		int cnt = 0;
		for(int c = 2; c < 6; c++) {
			for(int r = 0; r < 4; r++) {
				if(blue[r][c]) cnt++;
			}
		}
		return cnt;
	}
	
	static int lOfLightGreen() {
		int lines = 0;
		for(int r = 0; r < 2; r++) {
			for(int c = 0; c < 4; c++) {
				if (green[r][c]) { lines++; break; }
			}
		}
		return lines;
	}
	
	static int lOfLightBlue() {
		int lines = 0;
		for(int c = 0; c < 2; c++) {
			for(int r = 0; r < 4; r++) {
				if (blue[r][c]) { lines++; break; }
			}
		}
		return lines;
	}
	
	
	static void eraseGreen() {
		int r = 5;
		while(r >= 0) {
			if(rIsFull(r)) {
				eraseR(r);
				score++;
			}
			else {
				r--;
			}
		}
	}
	static void eraseBlue() {
		int c = 5;
		while(c >= 0) {
			if(cIsFull(c)) {
				eraseC(c);
				score++;
			}
			else {
				c--;
			}
		}
	}
	
	static void eraseR(int r) {
		for(int r_above = r; r_above > 0; r_above--) {
			for(int c = 0; c < 4; c++) {
				green[r_above][c] = green[r_above-1][c];
			}
		}
		for(int c = 0; c < 4; c++) {
			green[0][c] = false;
		}
	}
	
	static void eraseC(int c) {
		for(int c_above = c; c_above > 0; c_above--) {
			for(int r = 0; r < 4; r++) {
				blue[r][c_above] = blue[r][c_above-1];
			}
		}
		for(int r = 0; r < 4; r++) {
			blue[r][0] = false;
		}
	}
	
	static boolean rIsFull(int r) {
		boolean noBlank = true;
		for(int c = 0; c < 4; c++) { // mistake found by gpt: increased r instead of c
			if (!green[r][c]) {noBlank = false; break;}
		}
		return noBlank;
	}
	static boolean cIsFull(int c) {
		boolean noBlank = true;
		for(int r = 0; r < 4; r++) {
			if (!blue[r][c]) {noBlank = false; break;}
		}
		return noBlank;
	}
	
	
	static void stackUpGreen(int t, int x, int y) {
		
		if (t == 1) {
			green[findR(y)][y] = true;
		}
		else if (t == 2) {
			int minR = Math.min(findR(y), findR(y+1));
			green[minR][y] = true;
			green[minR][y+1] = true;
		}
		else {
			int r = findR(y);
			green[r-1][y] = true;
			green[r][y] = true;
		}
	}
	static void stackUpBlue(int t, int x, int y) {
		
		if (t == 1) {
			blue[x][findC(x)] = true;
		}
		else if (t == 2) {
			int c = findC(x);
			blue[x][c-1] = true;
			blue[x][c] = true;
		}
		else {
			int minC = Math.min(findC(x), findC(x+1));
			blue[x][minC] = true;
			blue[x+1][minC] = true;
		}
	}
	

	static int findR(int c) {
		int r = 2;
		while (!green[r][c]) {
			r++;
			if (r == 6) break;
		}
		return r - 1;
	}

	static int findC(int r) {
		int c = 2;
		while (!blue[r][c]) {
			c++;
			if (c == 6) break;
		}
		return c - 1;
	}
	
	
	

}


