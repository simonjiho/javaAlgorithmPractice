
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Boj_17779 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] A = new int[N][N];
		
		
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int ans = Integer.MAX_VALUE;
		
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N; y++) {
				for(int d1 = 1; (x+d1 < N) && (y-d1 >= 0); d1++) {
					for(int d2 = 1; (x+d1+d2 < N) && (y+d2 < N); d2++) {
						int tmp = calculate(A, N, x,y,d1,d2);
						ans = Math.min(ans, tmp);
					}
				}				
			}
		}
		
		System.out.println(ans);
		

		
		

	
	}

	public static int calculate(int[][] A, int N, int x, int y, int d1, int d2) {
		int[] result = new int[5];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if ( i < y && j <= x+d1 && i+j < y+x) {
					result[0] += A[i][j];
				} else if ( i <= y-d1+d2 && j > x+d1 && j-i > x-y+2*d1) {
					result[1] += A[i][j];
				} else if ( i >= y && j < x+d2 && j-i < x-y) {
					result[2] += A[i][j];
				} else if ( i > y-d1+d2 && j >= x+d2 && i+j > y+x+2*d2) {
					result[3] += A[i][j];
				} else {
					result[4] += A[i][j];
				}
			}


		}
		
		return Arrays.stream(result).max().getAsInt() - Arrays.stream(result).min().getAsInt();

		
	}
	
	

	
	
}


