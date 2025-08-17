
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시작: 18:50
/* 
 * gpt 검색 내용: 
 * 	Integer.parseInt()예외
 * 	BufferedReader 사용
 *  split
 */
public class Boj_3190 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int N = Integer.parseInt(br.readLine());
		Cell[][] cells = new Cell[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				cells[i][j] = new Cell(State.blank);
			}
		}
		cells[0][0].state = State.snake;



		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			String[] apple = br.readLine().split(" ");
			cells[Integer.parseInt(apple[0])-1][Integer.parseInt(apple[1])-1].state = State.apple;
		}


		int L = Integer.parseInt(br.readLine());
		Info[] infos = new Info[L];
		for (int i = 0; i < L; i++) {
			String[] info_str = br.readLine().split(" ");
			infos[i] = new Info(Integer.parseInt(info_str[0]), info_str[1].charAt(0));
		}

		Cell curCell = cells[0][0];
		int time = 0; 
		char curDir = 'r';
		int tailR = 0;
		int tailC = 0;
		int curR = 0;
		int curC = 0;
		int prevTime = 0;
		boolean terminated = false;


		for (Info info:infos) {
			for(int t = 0; t < info.time - prevTime; t++) {
				time += 1;

				curCell.next = curDir;


				if (curDir == 'l') {
					if (curC == 0) {terminated = true; break;}
					curC -= 1;
				}
				else if (curDir == 'r') {
					if (curC == N-1) {terminated = true; break;}
					curC += 1;
				}
				else if (curDir == 'u') {
					if (curR == 0) {terminated = true; break;}
					curR -= 1;
				}
				else { // curDir == d
					if (curR == N-1) {terminated = true; break;}
					curR += 1;
				} 


				curCell = cells[curR][curC];

				
				if (curCell.state == State.snake) {
					terminated = true;
					break;
				}

				if (curCell.state != State.apple) {

					char nextTailDir = cells[tailR][tailC].next;
					cells[tailR][tailC].state = State.blank;


					if (nextTailDir == 'l') tailC -= 1;
					else if (nextTailDir == 'r') tailC += 1;
					else if (nextTailDir == 'u') tailR -= 1;
					else tailR += 1; // tailR == d

				}



				curCell.state = State.snake;
				

				
				
			}

			if (terminated) break;





			if(info.direction == 'L') {
				switch (curDir) {
				case 'l': curDir = 'd'; break;
				case 'r': curDir = 'u'; break;
				case 'u': curDir = 'l'; break;
				case 'd': curDir = 'r'; break;
				default: break;
				}
			} else { // info.direction == 'D'
				switch (curDir) {
				case 'l': curDir = 'u'; break;
				case 'r': curDir = 'd'; break;
				case 'u': curDir = 'r'; break;
				case 'd': curDir = 'l'; break;
				default: break;
				}
			}

			prevTime = info.time;


		}
		


		while(!terminated) {
			time += 1;

			curCell.next = curDir;


			if (curDir == 'l') {
				if (curC == 0) {terminated = true; break;}
				curC -= 1;
			}
			else if (curDir == 'r') {
				if (curC == N-1) {terminated = true; break;}
				curC += 1;
			}
			else if (curDir == 'u') {
				if (curR == 0) {terminated = true; break;}
				curR -= 1;
			}
			else { // curDir == d
				if (curR == N-1) {terminated = true; break;}
				curR += 1;
			} 

			curCell = cells[curR][curC];

			if (curCell.state == State.snake) {
				terminated = true;
				break;
			}

			if (curCell.state != State.apple) {

				char nextTailDir = cells[tailR][tailC].next;
				cells[tailR][tailC].state = State.blank;


				if (nextTailDir == 'l') tailC -= 1;
				else if (nextTailDir == 'r') tailC += 1;
				else if (nextTailDir == 'u') tailR -= 1;
				else tailR += 1; // tailR == d

			}

			curCell.state = State.snake;
		}
		
		System.out.println(time);

		
//		for(int i = 0; i < N; i++) {
//			String s = "";
//			for(int j = 0; j < N; j++) {
//				
//				if (cells[i][j].state == State.blank) {
//					s += "O";
//				} else {
//					s += "X";
//				}
//			}
//			System.out.println(s);
//
//		}


	}
	enum State {
		blank, snake, apple
	}

	static class Cell {
		State state;
		char next;

		Cell(State state) {
			this.state = state;
		}

	}

	static class Apple {
		int r;
		int c;

		Apple(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Info {
		int time;
		char direction;

		Info(int time, char direction) {
			this.time = time;
			this.direction = direction;
		}
	}



}

