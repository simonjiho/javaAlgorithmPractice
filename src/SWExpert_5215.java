import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;



public class SWExpert_5215 {
	
	static final int MAX_SCORE = 20001;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		

		int T = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			String[] input = br.readLine().split(" ");
			
			int N = Integer.parseInt(input[0]);
			int L = Integer.parseInt(input[1]);
//			System.out.println(N + " " + L);
			
			int[] minCal = new int[MAX_SCORE]; // index: score
			Arrays.fill(minCal, Integer.MAX_VALUE);
			minCal[0] = 0;
			
			int[] score = new int[N];
			int[] cal = new int[N];
			
			for(int i = 0; i < N; i++) {
				String[] ing = br.readLine().split(" ");
				score[i] = Integer.parseInt(ing[0]); 
				cal[i] = Integer.parseInt(ing[1]); 
				
			}
			
			
			for(int i = 0; i < N; i++) {
				int s = score[i], c = cal[i];

				for(int j = MAX_SCORE-1; j >= s; j--) {
					if(minCal[j-s] == Integer.MAX_VALUE) continue;
					minCal[j] = Math.min(minCal[j], minCal[j-s]+c);
				}
			}
			
			int ans = 0;
			for(int i = MAX_SCORE-1; i >= 0; i--) {
				if(minCal[i] <= L) {ans = i; break;}
			}
			
			
			
			
			
			System.out.println("#" + test_case + " " + ans);
			
		}			

		
		
	}

}


