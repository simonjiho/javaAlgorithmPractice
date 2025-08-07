
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class SWExpert_1210 {
	static int[] dy = {-1, 0, 0};
	static int[] dx = {0, 1, -1};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			int T = Integer.parseInt(br.readLine());
			
			
			int[][] a = new int[100][100];
			for(int i = 0; i < 100; i++) {
				String[] s = br.readLine().split(" ");
				for(int j = 0; j < 100; j++) {
					a[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			
			
			int r = 99, c = 0;
			while(a[r][c] != 2) c++;
			
			

			
			char dir = 'u';
			while(r > 0) {
				if (dir == 'u') r--;
				else if (dir == 'l') c--;
				else c++; // dir == 'r'
				
				if (dir == 'l') {
					if (c == 0) dir = 'u';
					else if (a[r][c-1] == 0) dir = 'u';
				} else if (dir == 'r') {
					if (c == 99) dir = 'u';
					else if (a[r][c+1] == 0) dir = 'u';
				} else { // dir == 'u'
					if (c > 0 && a[r][c-1] == 1) dir = 'l';
					else if ( c < 99 && a[r][c+1] == 1) dir = 'r';
				}
			}
			
			

				
			

			System.out.println("#" + test_case + " " + c);
			
		}			

		
		
	}
	
	static boolean isValid(int n) {
		return 0 <= n && 100 > n;
	}
}
