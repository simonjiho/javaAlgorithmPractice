import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class SWExpert_1224 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			int N = Integer.parseInt(br.readLine());
			
			
			int[][] a = new int[100][100];
			for(int i = 0; i < 100; i++) {
				String[] s = br.readLine().split(" ");
				for(int j = 0; j < 100; j++) {
					a[i][j] = Integer.parseInt(s[j]);
				}
			}
				
			int cnt = 0; 
			for(int c = 0; c < 100; c++) {
				int prev = 2;
				for(int r = 0; r < 100; r++) {
					if (prev == 1 && a[r][c] == 2) { cnt += 1; prev = 2; }
					else if (prev == 2 && a[r][c] == 1) { prev = 1; }
				}
			}			
			

			System.out.println("#" + test_case + " " + cnt);
			
		}			

		
		
	}
	
}
