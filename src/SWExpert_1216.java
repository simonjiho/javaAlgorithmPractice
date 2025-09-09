
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class SWExpert_1216 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		

		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			int T = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[100][100];
			for(int i = 0; i < 100; i++) {
				String s = br.readLine();
				for(int j = 0; j < 100; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			
			int ans = 1;
			outer:for(int len = ans+1; len <= 100; len++) {
				
				for(int r = 0; r < 100; r++) {
					for(int c = 0; c < 100-len+1; c++) {
						boolean isPal = true;
						for(int i = 0; i < len/2; i++) {
							if(arr[r][c+i] != arr[r][c+len-1-i]) {isPal = false; break;}
						}
						if(isPal) {ans = len; continue outer;}
					}
				}
			}
			
			
			outer:for(int len = ans+1; len <= 100; len++) {
				for(int c = 0; c < 100; c++) {
					for(int r = 0; r < 100-len+1; r++) {
						boolean isPal = true;
						for(int i = 0; i < len/2; i++) {
							if(arr[r+i][c] != arr[r+len-1-i][c]) {isPal = false; break;}
						}
						if(isPal) {ans = len; continue outer;}
					}
				}
			}
			

			System.out.println("#" + T + " " + ans);
			
		}			

		
		
	}
	
}
