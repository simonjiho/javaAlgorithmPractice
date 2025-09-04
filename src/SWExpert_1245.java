import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWExpert_1245 {
	

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[] pos = new int[N];
			int[] mass = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pos[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				mass[i] = Integer.parseInt(st.nextToken());
			}
			
			
			double[] ans = new double[N-1];
			for(int i=0; i<N-1;i++) {
				double cnt = 0;
				double left = pos[i];
				double right = pos[i+1];
				double x = left + (right-left)/2;
				while(cnt++ < 100) {
					
					double lp = 0;
					double rp = 0;
					for(int l=0;l<=i;l++) {
						lp += mass[l] / ((x-pos[l]) * (x-pos[l]));
					}
					for(int r=i+1;r<N;r++) {
						rp += mass[r] / ((pos[r]-x) * (pos[r]-x));
					}
					
					if( rp > lp ) {
						right = x;
					} else if ( rp < lp ){
						left = x;
					}
					x = left + (right-left)/2;

				}
				
				ans[i] = x;
				
			}
			
			System.out.printf("#" + test_case);
			for(int i = 0; i < N-1; i++) {
				System.out.printf(" " + "%.10f", ans[i]);
			}
			System.out.printf("\n");
			
			


		}

	}


	
	
}
