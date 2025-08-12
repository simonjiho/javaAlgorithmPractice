import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class SWExpert_1952 {

	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] input1 = br.readLine().split(" ");
			int p1 = Integer.parseInt(input1[0]), p30 = Integer.parseInt(input1[1]);
			int p90 = Integer.parseInt(input1[2]), p365 = Integer.parseInt(input1[3]);
			
			String[] input2 = br.readLine().split(" ");
			int[] days = new int[13];
			for(int i = 0; i < 12; i++) {
				days[i+1] = Integer.parseInt(input2[i]);
			}
			
			int[] dp = new int[13];
			
			int m_1_min = Math.min(p30, p90);
			int m_2_min = Math.min(p30*2, p90);
			int m_3_min = Math.min(p30*3, p90);
			
			dp[1] = Math.min(p1*days[1], p30);
			dp[2] = dp[1] + Math.min(p1*days[2], p30);

			for(int i = 3; i <= 11; i++) {
				int days_1 = days[i];
				int days_3 = days[i-2] + days[i-1] + days[i];
				
				int val1 = dp[i-1] + Math.min(p1*days_1, p30);
				int val3 = dp[i-3] + Math.min(p1*days_3, m_3_min);
				
				dp[i] = Math.min(val1, val3);
			}

			int days_1 = days[12];
			int days_2 = days[11] + days_1;
			int days_3 = days[10] + days_2;
			int val1 = dp[11] + Math.min(p1*days_1, m_1_min);
			int val2 = dp[10] + Math.min(p1*days_2, m_2_min);
			int val3 = dp[9] + Math.min(p1*days_3, m_3_min);
			dp[12] = Math.min(val1, Math.min(val2, val3));

			
			int ans = Math.min(p365, dp[12]);
			
			
		
			
			System.out.println("#" + test_case + " " + ans);
			
		}
			
			


		
		
	}
	
	
}


