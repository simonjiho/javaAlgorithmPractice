
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// 15:10 시작

public class Boj_17837 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] firstLine = br.readLine().split(" ");
		int N = Integer.parseInt(firstLine[0]);
		int K = Integer.parseInt(firstLine[1]);

		Info[][] C = new Info[N][N];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				C[i][j] = new Info(Integer.parseInt(s[j]), K);
			}
		}

		Piece[] pieces = new Piece[K];
		for (int i = 0; i < K; i++) {
			String[] s = br.readLine().split(" ");
			int r = Integer.parseInt(s[0]) - 1;
			int c = Integer.parseInt(s[1]) - 1;
			int dir = Integer.parseInt(s[2]);

			pieces[i] = new Piece(r, c, dir);

			C[r][c].addP(new int[] { i });
		}

		int turn = 0;
		while (turn <= 1000) {

			boolean shouldTerminate = false;

			for (int i = 0; i < K; i++) {
				Piece piece = pieces[i];
				int r = piece.r;
				int c = piece.c;
				Info info = C[r][c];

				// 다음 칸 설정
				int nextR = r;
				int nextC = c;
				// 1 2 3 4 -> 오 왼 위 아래
				if (piece.dir == 1)
					nextC += 1;
				else if (piece.dir == 2)
					nextC -= 1;
				else if (piece.dir == 3)
					nextR -= 1;
				else
					nextR += 1; // piece.dir == 4

				// 방향 전환 확인 (벽, 파란색)
				if (nextR == N) {
					nextR = N - 2;
					piece.dir = 3;
				} else if (nextC == N) {
					nextC = N - 2;
					piece.dir = 2;
				} else if (nextR == -1) {
					nextR = 1;
					piece.dir = 4;
				} else if (nextC == -1) {
					nextC = 1;
					piece.dir = 1;
				} else if (C[nextR][nextC].color == 2) {
					if (piece.dir == 1) {
						nextC = c - 1;
						piece.dir = 2;
					} else if (piece.dir == 2) {
						nextC = c + 1;
						piece.dir = 1;
					} else if (piece.dir == 3) {
						nextR = r + 1;
						piece.dir = 4;
					} else {
						nextR = r - 1;
						piece.dir = 3;
					} // piece.dir == 4
				}

				// 실제 이동
				if (nextR == N) {
					nextR = N - 2;
					piece.dir = 3;
				} else if (nextC == N) {
					nextC = N - 2;
					piece.dir = 2;
				} else if (nextR == -1) {
					nextR = 1;
					piece.dir = 4;
				} else if (nextC == -1) {
					nextC = 1;
					piece.dir = 1;
				} else if (C[nextR][nextC].color == 0) {
					int[] move = C[r][c].removeP(i);
					for (int k : move) {
						pieces[k].r = nextR;
						pieces[k].c = nextC;
					}
					C[nextR][nextC].addP(move);
				} else if (C[nextR][nextC].color == 1) {
					int[] move = C[r][c].removeP(i);
					for (int k : move) {
						pieces[k].r = nextR;
						pieces[k].c = nextC;
					}
					int[] move_reverse = new int[move.length];
					for (int j = 0; j < move.length; j++) {
						move_reverse[move.length - 1 - j] = move[j];
					}
					C[nextR][nextC].addP(move_reverse);
				} else { // C[nextR][nextC].color == 2
					// do nothing
				}

				if (C[nextR][nextC].size >= 4) {
					shouldTerminate = true;
					break;
				}

			}

			turn++;

			if (shouldTerminate)
				break;

		}

		if (turn == 1001)
			System.out.println(-1);
		else
			System.out.println(turn);

	}

	private static class Info {
		int color;
		int[] res;
		int size;

		Info(int color, int K) {
			this.color = color;
			this.res = new int[K];
			this.size = 0;
		}

		void addP(int[] arr) {
			System.arraycopy(arr, 0, res, size, arr.length);
			size += arr.length;
		}

		int[] removeP(int k) {

			int idx = -1;

			for (int i = 0; i < size; i++) {
				if (res[i] == k) {
					idx = i;
					break;
				}
			}

			int[] aboveP = new int[size - idx];

			System.arraycopy(res, idx, aboveP, 0, size - idx);

			size = idx;

			return aboveP;

		}
	}

	private static class Piece {
		int r;
		int c;
		int dir;

		Piece(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

	}

}
