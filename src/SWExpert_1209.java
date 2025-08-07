
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class SWExpert_1209 {
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
			
			int[] vSum = new int[100];
			int[] hSum = new int[100];
			int dSum1 = 0;
			int dSum2 = 0;
			for(int i=0; i < 100; i++) {
//				String s = "";
				for(int j = 0; j < 100; j++) {
//					s += " " + a[i][j];
					hSum[i] += a[i][j];
					vSum[j] += a[i][j];
					if (i == j) dSum1 += a[i][j];
					if (i+j == 99) dSum2 += a[i][j];
					
				}			
//				System.out.println(s);
			}
			
			Arrays.sort(vSum); Arrays.sort(hSum);
			
			
			int ans = Math.max(Math.max(vSum[99], hSum[99]), Math.max(dSum1, dSum2));

				
			

			System.out.println("#" + test_case + " " + ans);
			
		}			

		
		
	}
}
