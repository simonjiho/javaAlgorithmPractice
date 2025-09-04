import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWExpert_1865 {
	

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = Integer.parseInt(br.readLine());

			double[][] P = new double[N][N];

			for (int i = 0; i < N; i++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					P[i][j] = Double.parseDouble(st.nextToken()) / 100.0;
				}
			}
			

			int totalComb = 1 << N;
			double[][] dp = new double[N][totalComb];
			
			for(int i=0; i<N;i++) {
				dp[0][(1<<i)] = P[0][i];
			}
			
			for(int i=1; i<N; i++) { // person
				for(int j=0; j<totalComb; j++) { // combination of work done
					double prevP = dp[i-1][j];
					if(prevP == 0) continue;
					for(int k=0; k<N; k++) { // work
						if((1<<k & j) != 0) continue; // if work already done continue
						int workDone = 1<<k | j;
						double p1 = dp[i][workDone];
						double p2 = prevP * P[i][k];
						dp[i][workDone] = Math.max(p1, p2);
					}
					
				}
			}
			
			

			System.out.printf("#" + test_case + " " + "%.6f\n", dp[N-1][totalComb-1]*100);

		}

	}


	
	
}
